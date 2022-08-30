package personalfinance.gui.table;

import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.AccountTableModel;
import personalfinance.settings.Style;

import javax.swing.*;

public class AccountTableData extends TableData {//класс, отвечающий за демонстрацию таблицы с использованием модели счетов

    private static final String[] columns = new String[]{"TITLE","AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_AMOUNT};

    public AccountTableData(FunctionsHandler handler) {
        super(new AccountTableModel(columns), handler, columns, icons);
    }
}//6_6,8_2
