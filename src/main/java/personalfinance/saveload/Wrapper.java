package personalfinance.saveload;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import personalfinance.model.*;
import java.util.List;


@XmlRootElement(name= "data")//директива, добавляющая библиотеку из скаченного файла

public class Wrapper { //класс-оболочка для данных, сохраняемых в xml-файл

    private List<Article> articles;// данные для сохранения
    private List<Account> accounts;
    private List<Transaction> transactions;
    private List<Transfer> transfers;
    private List<Currency> currencies;

    @XmlElement(name = "articles")
    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @XmlElement(name = "accounts")
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @XmlElement(name = "transactions")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @XmlElement(name = "transfers")
    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    @XmlElement(name = "currencies")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}//3_1
