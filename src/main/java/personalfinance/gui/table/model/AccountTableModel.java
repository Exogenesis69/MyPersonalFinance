package personalfinance.gui.table.model;

import personalfinance.model.Account;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;


public class AccountTableModel extends MainTableModel{//модель для таблицы со счетами


    private static final int TITLE = 0;//Константы, отвечающие за конкретные поля
    private static final int AMOUNT = 1;

    public AccountTableModel(String[] columns){
        super(SaveData.getInstance().getAccounts(),columns);
    }


    @Override
    protected void updateData() { //переключение вывода данных
         data = SaveData.getInstance().getAccounts();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if (data.isEmpty()) return null;//если данных нет, то возвращаем null
        Account account = (Account) data.get(row);//получаем транзакции по строке
        switch (column) {//возвращаем данные в зависимости от столбца
            case TITLE:
                return account.getTitle();
            case AMOUNT:
                return Format.amount(account.getAmount(), account.getCurrency());
        }
        return null;
    }
}//6_6
