package personalfinance.gui.table;

import personalfinance.gui.table.model.CurrencyTableModel;
import personalfinance.gui.table.renderer.MainTableCellRenderer;
import personalfinance.model.Currency;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class CurrencyTableData extends TableData {

    private static final String[] columns = new String[]{"TITLE","CODE","RATE","ON","BASE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_CODE, Style.ICON_RATE, Style.ICON_ON, Style.ICON_BASE};

    public CurrencyTableData() {
        super(new CurrencyTableModel(columns), columns, icons);
        init();
    }
    @Override
    protected final void init() {
        for (String column : columns) {
            getColumn(Text.get(column)).setCellRenderer(new TableCellOnOffRenderer());
        }

    }

    private class TableCellOnOffRenderer extends MainTableCellRenderer {//создаем вложенный класс для рендеринга
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
            if (((Currency) ((CurrencyTableModel) table.getModel()).getObjectByRow(row)).isOn())
            renderer.setForeground(Style.COLOR_ON);
            else renderer.setForeground(Style.COLOR_OFF);
            return renderer;
        }
    }


}//6_10
