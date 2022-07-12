package personalfinance.gui.table.model;

import personalfinance.model.Currency;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;


public class CurrencyTableModel extends MainTableModel{//модель для таблицы со


    private static final int TITLE = 0;//Константы, отвечающие за конкретные поля
    private static final int CODE = 1;
    private static final int RATE = 2;
    private static final int ON = 3;
    private static final int BASE = 4;

    public CurrencyTableModel(String[] columns){
        super(SaveData.getInstance().getCurrencies(),columns);
    }


    @Override
    protected void updateData() { //переключение вывода данных
         data = SaveData.getInstance().getCurrencies();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if (data.isEmpty()) return null;//если данных нет, то возвращаем null
        Currency currency = (Currency) data.get(row);//получаем транзакции по строке
        switch (column) {//возвращаем данные в зависимости от столбца
            case TITLE:
                return currency.getTitle();
            case CODE:
                return currency.getCode();
            case RATE:
                return Format.rate(currency.getRate(), SaveData.getInstance().getBaseCurrency() );
            case ON:
                return Format.yesNo(currency.isOn());
            case BASE:
                return Format.yesNo(currency.isBase());
        }
        return null;
    }
}//6_10
