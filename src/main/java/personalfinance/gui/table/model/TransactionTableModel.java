package personalfinance.gui.table.model;

import personalfinance.model.Transaction;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;

import java.util.ArrayList;
import java.util.Arrays;

public class TransactionTableModel  extends MainTableModel{//модель для таблицы с транзакциями


    private static final int DATE = 0;//Константы, отвечающие за конкретные поля
    private static final int ACCOUNT = 1;
    private static final int ARTICLE = 2;
    private static final int AMOUNT = 3;
    private static final int NOTICE = 4;
    private int count = - 1;//поле для переключения вывода(по умолчанию - по фильтру)

    public TransactionTableModel(String[] columns){
        super(SaveData.getInstance().getFilterTransactions(),columns);//выводится по фильтру
        this.columns = new ArrayList(Arrays.asList(columns));
    }

    public TransactionTableModel(String[] columns, int count) {
        super(SaveData.getInstance().getTransactionsOnCount(count), columns);//выводится по количеству
        this.count = count;// поле

    }


    @Override
    protected void updateData() { //переключение вывода данных
        if (count == -1) data = SaveData.getInstance().getFilterTransactions();
        else data = SaveData.getInstance().getTransactionsOnCount(count);

    }

    @Override
    public Object getValueAt(int row, int column) {
        if (data.isEmpty()) return null;//если данных нет, то возвращаем null
        Transaction transaction = (Transaction) data.get(row);//получаем транзакции по строке
        switch (column) {//возвращаем данные в зависимости от столбца
            case DATE:
                return Format.date(transaction.getDate());
            case ACCOUNT:
                return transaction.getAccount().getTitle();
            case ARTICLE:
                return transaction.getArticle().getTitle();
            case AMOUNT:
                return Format.amount(transaction.getAmount(),transaction.getAccount().getCurrency());
            case NOTICE:
                return transaction.getNotice();
        }
        return null;
    }
}//6_5
