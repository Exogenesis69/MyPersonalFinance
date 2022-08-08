package personalfinance.gui.table.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MainTableCellRenderer extends DefaultTableCellRenderer {//класс-рендерер для реализации выравнивания ячеек таблицы

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
        setBorder(noFocusBorder); //убираем рамку
        setHorizontalAlignment(SwingConstants.CENTER);//делаем выравнивание по горизонтали
        return this;
    }
}//6_4
