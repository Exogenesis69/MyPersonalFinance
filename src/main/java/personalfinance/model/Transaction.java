package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.Date;

public class Transaction extends Common { //класс для создания объекта транзакций, наследуется от Common

    private Account account; //счет
    private Article article; // статья доходы/расходы
    private double amount; // сумма
    private String notice; // примечание
    private Date date; // дата транзакции

    public Transaction() {
    }

    public Transaction(Account account, Article article, double amount, String notice, Date date) throws ModelException {

        if (account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        if (date == null) throw new ModelException(ModelException.DATE_FORMAT);

        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notice = notice;
        this.date = date;
    }

    public Transaction(Account account, Article article, double amount, String notice) throws ModelException { //конструктор без даты
        this(account,article,amount,notice, new Date());
    }

    public Transaction(Account account, Article article, double amount, Date date) throws ModelException { //конструктор без примечания
        this(account,article,amount, "", date);
    }

    public Transaction(Account account, Article article, double amount) throws ModelException { //конструктор без примечания и даты
        this(account,article,amount, "", new Date());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account +
                ", article=" + article +
                ", amount=" + amount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public void postAdd(SaveData sd) {
        setAmounts(sd);
    }

    @Override
    public void postEdit(SaveData sd) {
        setAmounts(sd);
    }

    @Override
    public void postRemove(SaveData sd) {
        setAmounts(sd);
    }

    private void setAmounts(SaveData sd) {
        for(Account a : sd.getAccounts())
            a.setAmountFromTransactionsAndTransfers(sd.getTransactions(), sd.getTransfers());
    }
}//2.4, 3_3,10_3
