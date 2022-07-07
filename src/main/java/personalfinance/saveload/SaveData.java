package personalfinance.saveload;

import personalfinance.exception.ModelException;
import personalfinance.model.*; // импорт всех классов из model

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public final class SaveData { // final класс для создания объекта-хранилища всех данных. Понадобится много где, так что создаем паттерн singleton(класс нельзя создать более чем 1 раз)

    private static SaveData instance;

    private List<Article> articles = new ArrayList<>(); //статьи
    private List<Currency> currencies = new ArrayList<>(); // валюты
    private List<Account> accounts = new ArrayList<>(); //  счета
    private List<Transaction> transactions = new ArrayList<>(); // транзакции
    private List<Transfer> transfers = new ArrayList<>(); // переводы

    private final Filter filter;//создаем фильтр
    private Common oldCommon;//переменная для временного хранилища старых данных
    private boolean saved = true;// переменная проверки данных после сохранения

    private SaveData() {
        load();//инициализируем отдельный метод load()(сортировка)
        this.filter = new Filter();//инициализируем фильтр
    }

    public void load() {//создаем отдельный метод load() с дополнительными фишками(сортировка)
        SaveLoad.load(this);
        sort();
        for (Account a : accounts){
            a.setAmountFromTransactionsAndTransfers(transactions,transfers);
        }
    }

    private void sort() { // создаем метод сортировки для каждого из элементов
        this.articles.sort((Article a, Article a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle())); //статьи сортируем по алфавиту
        //обращаемся к листу с помощью лямбда выражения(есть два объекта: a и a1. Сравниваем getTitle(первую букву), игнорируя при этом регистр

        this.accounts.sort((Account a, Account a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));//для счетов делаем точно также

        this.transactions.sort((Transaction t, Transaction t1) -> (int) (t1.getDate().compareTo(t.getDate())));//транзакции сортируем по дате (самые последние транзакции будут находиться вверху) и приводим к типу (int)

        this.transfers.sort((Transfer t, Transfer t1) -> (int) (t1.getDate().compareTo(t.getDate())));//для переводов делаем точно также

        this.currencies.sort(new Comparator<Currency>() {
            @Override
            public int compare(Currency c, Currency c1) {//валюту сравниваем и возвращаем число
                if (c.isBase())
                    return -1;//валюта, являющаяся базовой, будет стоять всегда в самом вверху
                if (c1.isBase())
                    return 1;
                if (c.isOn() ^ c1.isOn()) { //ниже будут находиться валюты, которые "включены", а еще ниже валюта, которая не включена
                    if (c1.isOn()) return 1;
                    else return -1;
                }
                return c.getTitle().compareToIgnoreCase(c1.getTitle());//если обе включены или обе выключены, то сравниваем по алфавиту
            }
        });
    }

    public void save() {
        SaveLoad.save(this);
        saved = true;
    }

    public boolean isSaved() {
        return saved;
    }

    public static SaveData getInstance() {
        if (instance == null)
            instance = new SaveData();//если объект не создан-создаем тут
        return instance;// если создан-возвращаем этот объект
    }

    public Filter getFilter() {
        return filter;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Currency getBaseCurrency() { // создаем "общую"(базовую) валюту
        for (Currency c : currencies)
            if (c.isBase()) // если валюта базовая
                return c; // то возвращаем ее
        return new Currency(); //если ничего не найдено, то возвращаем пустую валюту, но не через null, а то будет ошибка
    }

    public ArrayList<Currency> getEnableCurrencies() { //метод, возвращающий все включенные валюты
        ArrayList<Currency> list = new ArrayList();
        for (Currency c : currencies)
            if (c.isOn()) list.add(c);
        return list;
    }

    public List<Transaction> getFilterTransactions() { //Метод, позволяющий получать отфильтрованные данные(транзакции)
        ArrayList<Transaction> list = new ArrayList();
        for (Transaction t : transactions) //перебираем все транзакции
            if (filter.check(t.getDate())) // вызываем фильтр и проверяем по дате
                list.add(t);// если проходит, то добавляем в результирующий список
        return list;
    }

    public List<Transfer> getFilterTransfers() {//Метод, позволяющий получать отфильтрованные данные(переводы)
        ArrayList<Transfer> list = new ArrayList();
        for (Transfer t : transfers)
            if (filter.check(t.getDate()))
                list.add(t);
        return list;
    }

    public List<Transaction> getTransactionsOnCount(int count) { //Метод, позволяющий получать последние 10 транзакций
        return new ArrayList(transactions.subList(0, Math.min(count, transactions.size())));//Возвращаем лист от нуля до значения count
    }

    public Common getOldCommon() {// метод для временного хранилища старых данных
        return oldCommon;
    }

    public void add(Common c) throws ModelException { //метод для добавления данных
        List ref = getRef(c);
        if (ref.contains(c))
            throw new ModelException(ModelException.IS_EXISTS); // если элемент уже содержится, то выбрасываем исключение, что такая запись уже есть
        ref.add(c);// добавляем элемент в список
        c.postAdd(this);// если у объекта будет что-то написано, то оно будет выполнено
        sort(); // заново проводим сортировку после добавления элемента в список
        saved = false;//показываем, что новые данные не сохранены
    }

    public void edit(Common oldC, Common newC) throws ModelException { //метод для редактирования данных
        List ref = getRef(oldC);
        if (ref.contains(newC) && oldC != ref.get(ref.indexOf(newC)))
            throw new ModelException(ModelException.IS_EXISTS);
        //выбрасываем исключение только когда новый объект не равен старому
        ref.set(ref.indexOf(oldC), newC);// заменяем старый объект новым объектом
        oldCommon = oldC;
        newC.postEdit(this);
        sort(); // заново проводим сортировку
        saved = false;//показываем, что новые данные не сохранены
    }

    public void remove(Common c) { //метод для удаления данных
        getRef(c).remove(c); //получаем объект и сразу же его удаляем
        c.postRemove(this);
        saved = false; //показываем, что новые данные не сохранены
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "articles=" + articles +
                ", currencies=" + currencies +
                ", accounts=" + accounts +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                '}';
    }
    public void updateCurrencies() throws Exception { //метод для обновления курса валюты
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for (Currency c : currencies) //перебираем все валюты
            c.setRate(rates.get(c.getCode())); //и обновляем всю информацию по их курсу
        for (Account a : accounts)//обновляем курсы валют в счетах
            a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
    }

    private List getRef(Common c) { //метод, для получения ссылки на массив в зависимости от типа данного элемента
        if (c instanceof Account) return accounts; // если с принадлежит Account, то возвращаем accounts
        else if (c instanceof Article) return articles;
        else if (c instanceof Currency) return currencies;
        else if (c instanceof Transaction) return transactions;
        else if (c instanceof Transfer) return transfers;
        return null;
    }


}//2.6,3_2,3_3, 3_5,6_1
