package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.Objects;

public class Currency extends Common{ //класс, для создания объекта валюты, наследуется Common

    private String title; //название валюты
    private String code;  //код валюты
    private double rate;  //курс валюты
    private boolean on; // включена валюта или нет
    private boolean base; // валюта базовая или нет

    public Currency() {} // дефолтный конструктор

    public Currency(String title, String code, double rate, boolean on, boolean isBase ) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (code.length() == 0) throw new ModelException(ModelException.CODE_EMPTY);
        if (rate <=0) throw new ModelException(ModelException.RATE_INCORRECT);

        this.title = title;
        this.code = code;
        this.rate = rate;
        this.on = on;
        this.base = isBase;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", isOn=" + on +
                ", isBase=" + base +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Currency currency = (Currency) o;

        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
    @Override
    public String getValueFromComboBox() {
        return title;
    }

    public double getRateByCurrency(Currency currency) { //множитель относительно двух валют при переводе из одной в другую
        return rate / currency.rate;
    } //выпадающий список

    @Override
    public void postAdd(SaveData sd) {
        clearBase(sd); // "отчищаем" базовую валюту
    }
    @Override
    public void postEdit(SaveData sd){
        clearBase(sd);
        for (Account a : sd.getAccounts())
            if (a.getCurrency().equals(sd.getOldCommon())) a.setCurrency(this);
    }

    private void clearBase(SaveData sd) {
        if (base) {
            rate = 1;
            Currency old = (Currency) sd.getOldCommon();
            for (Currency c : sd.getCurrencies()) {
                if (!this.equals(c)) { //Если эта валюта не эквивалентна данной, значит мы должны ее обновлять
                    c.setBase(false);
                    if (old != null) c.setRate(c.rate / old.rate); // пересчитываем коэффициент
                }
            }
        }
    }
}//2.4,2.6,3_3
