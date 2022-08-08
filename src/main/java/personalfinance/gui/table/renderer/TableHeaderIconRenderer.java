package personalfinance.gui.table.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableHeaderIconRenderer extends DefaultTableCellRenderer { //класс-рендер для реализации заголовка таблицы

    private final JLabel label;//создаем метку. Текст заголовка будет реализовываться как метка

    public TableHeaderIconRenderer(ImageIcon icon) { // к метке устанавливаем иконку
        super();
        label = new JLabel(icon);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {//метод возвращает компонент, использующийся для заголовков таблицы
        TableCellRenderer tcr = table.getTableHeader().getDefaultRenderer();//получаем от таблицы заголовок и ее дефолтный рендерер
        Component renderer = tcr.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);//получаем компонент, исходя из данного рендеринга
        label.setFont(renderer.getFont());//устанавливаем в новой метке с иконкой шрифт по-умолчанию
        label.setForeground(renderer.getForeground());//устанавливаем в новой метке с иконкой задний фон по-умолчанию
        label.setBorder(((JComponent) renderer).getBorder());//устанавливаем
        label.setText(""+ value);
        return label;
    }
}//6_4
