package personalfinance.gui.table;

import personalfinance.gui.table.model.TransactionTableModel;
import personalfinance.gui.table.renderer.MainTableCellRenderer;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class TransactionTableData extends TableData {//класс, отвечающий за демонстрацию модели транзакций

    private static final String[] columns = new String[]{"DATE","ACCOUNT", "ARTICLE","AMOUNT","NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE, Style.ICON_ACCOUNT, Style.ICON_ARTICLE, Style.ICON_AMOUNT, Style.ICON_NOTICE};

    public TransactionTableData() {
        super(new TransactionTableModel(columns), columns, icons);
        init();
    }

    public TransactionTableData(int count) {
        super(new TransactionTableModel(columns, count), columns, icons);
        init();
    }
    @Override
    protected final void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new TableCellAmountRenderer());//подключаем рендеринг к столбцу amount

    }

    private  class TableCellAmountRenderer extends MainTableCellRenderer {//создаем вложенный класс для рендеринга
         @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
             if ((value.toString()).contains("-")) renderer.setForeground(Style.COLOR_EXP);//Если значение отрендеренного компонента отрицательное(содержит минус), то изменяем цвет значения на красный
            else renderer.setForeground(Style.COLOR_INCOME);//Если значение положительное, то изменяем цвет значения на зеленый
            return renderer;
        }
    }
}//6.5
