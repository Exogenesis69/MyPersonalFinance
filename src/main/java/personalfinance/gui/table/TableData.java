package personalfinance.gui.table;

import personalfinance.gui.Refresh;
import personalfinance.gui.menu.TablePopupMenu;
import personalfinance.gui.table.model.MainTableModel;
import personalfinance.gui.table.renderer.MainTableCellRenderer;
import personalfinance.gui.table.renderer.TableHeaderIconRenderer;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

abstract public class TableData extends JTable implements Refresh {//класс отвечающий за демонстрацию модели

    private final TablePopupMenu popup;
    private final ImageIcon[] icons;
    private final String[] columns;//массив с языковыми константами для столбцов

    public TableData(MainTableModel model, String[] columns, ImageIcon[] icons) {
        super(model);
        this.popup = new TablePopupMenu();
        this.columns = columns;
        this.icons = icons;

        getTableHeader().setFont(Style.FONT_TABLE_HEADER);//Шрифт заголовков
        setFont(Style.FONT_TABLE);//Шрифт таблицы
        setRowHeight(getRowHeight() + Style.TABLE_ADD_ROW_HEIGHT);//задаем добавочную высоту ячейки в дополнение к основной (текущее содержимое + константа)

        setAutoCreateRowSorter(true);//сортировка данных столбца
        setPreferredScrollableViewportSize(Style.DIMENSION_TABLE_SHOW_SIZE);//размер таблицы
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Только одиночное выделение строки в таблице

        for (int i = 0; i<columns.length; i++) {
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }

        MainTableCellRenderer renderer = new MainTableCellRenderer();
        setDefaultRenderer(String.class,renderer);
        setComponentPopupMenu(popup);
    }

    @Override
    public JPopupMenu getComponentPopupMenu() {
        Point p = getMousePosition();
        int row = rowAtPoint(p);
        if (p != null && row !=-1) setRowSelectionInterval(row,row);
        return super.getComponentPopupMenu();
    }

    @Override
    public void refresh() {
        int selectedRow = getSelectedRow();//получаем выделенную строку
        ((MainTableModel)getModel()).refresh();
        /*for (int i = 0; i<columns.length; i++) {
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }*/
        if (selectedRow != -1 && selectedRow < getRowCount()) setRowSelectionInterval(selectedRow,selectedRow);
        init();
    }

    protected void init() {

    }

}//6_2,6_4,6_10,6_11
