package personalfinance.gui.table.model;

import personalfinance.model.Transaction;
import personalfinance.model.Transfer;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;

import java.util.ArrayList;
import java.util.Arrays;

public class TransferTableModel extends MainTableModel{//модель для таблицы с переводами


    private static final int DATE = 0;//Константы, отвечающие за конкретные поля
    private static final int FROM_ACCOUNT = 1;
    private static final int TO_ACCOUNT = 2;
    private static final int FROM_AMOUNT = 3;
    private static final int TO_AMOUNT = 4;
    private static final int NOTICE = 5;


    public TransferTableModel(String[] columns){
        super(SaveData.getInstance().getFilterTransfers(),columns);//выводится по фильтру
        this.columns = new ArrayList(Arrays.asList(columns));
    }


    @Override
    protected void updateData() { //переключение вывода данных
         data = SaveData.getInstance().getFilterTransfers();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if (data.isEmpty()) return null;//если данных нет, то возвращаем null
        Transfer transfer = (Transfer) data.get(row);//получаем транзакции по строке
        switch (column) {//возвращаем данные в зависимости от столбца
            case DATE:
                return Format.date(transfer.getDate());
            case FROM_ACCOUNT:
                return transfer.getFromAccount().getTitle();
            case TO_ACCOUNT:
                return transfer.getToAccount().getTitle();
            case FROM_AMOUNT:
                return Format.amount(transfer.getFromAmount(), transfer.getFromAccount().getCurrency());
            case TO_AMOUNT:
                return Format.amount(transfer.getToAmount(), transfer.getToAccount().getCurrency());
            case NOTICE:
                return transfer.getNotice();
        }
        return null;
    }
}//6_9
