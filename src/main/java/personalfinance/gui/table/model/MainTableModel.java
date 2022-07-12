package personalfinance.gui.table.model;

import personalfinance.gui.Refresh;
import personalfinance.model.Common;
import personalfinance.settings.Text;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class MainTableModel extends AbstractTableModel implements Refresh { //абстрактный класс для модели таблицы

    protected List<? extends Common> data;//массив листов, с конструкцией "любой класс, который является дочерним для Common'а
    protected List<String> columns = new ArrayList();//массив заголовков таблиц

    public MainTableModel(List data, String[] columns){//создаем конструктор, который принимает данные
        this.data = data;
        this.columns = new ArrayList(Arrays.asList(columns));
    }



    @Override
    public int getRowCount() { //строк в таблице столько, сколько элементов содержится в ней
        return data.size();
    }

    @Override
    public int getColumnCount() {//кол-во столбцов столько, сколько элементов содержится в ней
        return columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {//получение названия столбца по его индексу
        return Text.get(columns.get(columnIndex));//возвращает языковую константу, которую вытащим из массива
    }

    public Class<?> getColumnClass(int columnIndex) {//метод, который получает класс по данному столбцу
        Object obj = getValueAt(0,columnIndex);
        if (obj == null) return Object.class;

        return obj.getClass();
    }

    @Override
    public void refresh() {
        updateData();//обновляем данные
        fireTableStructureChanged();//перерисовываем таблицу
        fireTableDataChanged();
    }

    public Object getObjectByRow(int row) {
        return data.get(row);
    }

   abstract protected void updateData();


}//6_3,6_10
