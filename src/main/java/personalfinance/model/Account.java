package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.Objects;
import java.util.List;

public class Account extends Common { //класс для создания объекта счета, наследуется от Common

    private String title;
    private Currency currency;
    private double startAmount; //стартовая сумма
    private double amount; // сумма в данный момент

    public Account() {
    }

    public Account(String title, Currency currency, double startAmount) throws ModelException {

        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);

        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Objects.equals(title, account.title);
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String getValueFromComboBox() {
        return title;
    }

    public void setAmountFromTransactionsAndTransfers(List<Transaction> transactions, List<Transfer> transfers) { //настройка суммы
        this.amount = startAmount;
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().equals(this)) {
                this.amount += transaction.getAmount();
            }
        }
        for (Transfer transfer : transfers) {
            if (transfer.getFromAccount().equals(this)) {
                this.amount -= transfer.getFromAmount();
            }
            if (transfer.getToAccount().equals(this)) {
                this.amount += transfer.getToAmount();
            }
        }
    }

    @Override
    public void postAdd(SaveData sd) {//Когда добавляется статья, то выполняется следующее:
        setAmountFromTransactionsAndTransfers(sd.getTransactions(), sd.getTransfers());//Когда добавляется статья, то выполняется следующее:
    }

    @Override
    public void postEdit(SaveData sd) {//Когда редактируется статья, то выполняется следующее:
        for (Transaction t : sd.getTransactions())
            if (t.getAccount().equals(sd.getOldCommon())) t.setAccount(this);
        for (Transfer t : sd.getTransfers()) {
            if (t.getFromAccount().equals(sd.getOldCommon())) t.setFromAccount(this);
            if (t.getToAccount().equals(sd.getOldCommon())) t.setToAccount(this);
        }
        setAmountFromTransactionsAndTransfers(sd.getTransactions(), sd.getTransfers());
    }

    @Override
    public String toString() {
        return "Account{" +
                "title='" + title + '\'' +
                ", currency=" + currency +
                ", startAmount=" + startAmount +
                ", amount=" + amount +
                '}';
    }
}//2.4,3_3,3_4
