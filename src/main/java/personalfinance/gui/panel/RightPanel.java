package personalfinance.gui.panel;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;
import personalfinance.gui.table.TableData;
import personalfinance.gui.toolbar.AbstractToolBar;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

abstract public class RightPanel extends AbstractPanel {//абстрактный класс для правой панели

    protected TableData td;

    private String title;
    private ImageIcon icon;
    private JPanel[] panels;//массив панелей

    public RightPanel(MainFrame frame, TableData td,String title,ImageIcon icon, JPanel[] panels) {
        super(frame);
        this.td = td;
        this.title = title;
        this.icon = icon;
        this.panels = panels;
        init();
    }

    public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon, AbstractToolBar tb) {
        this(frame,td,title,icon,new JPanel[]{tb});//перегрузка конструктора когда будет 1 тулбар
    }

    public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon) {
        this(frame,td,title,icon,new JPanel[]{});//перегрузка конструктора с отсутствием каких-либо панелей
    }

    protected void setPanels(JPanel[] panels) { //метод для изменения панелей
        this.panels = panels;
    }

    @Override
    public void refresh() {//переопределение метода refresh
        super.refresh();
        if (td != null) td.refresh();//если td инициализирован, то применяем к нему refresh()
        for (JPanel panel : panels) {//для каждой панели
            if (panel instanceof Refresh) ((Refresh)panel).refresh();//если панели поддерживают интерфейс Refresh, то тогда вызываем метод
        }
    }

    private void enableEditDelete() {//метод, отвечающий за доступность пунктов в меню
        for (JPanel panel : panels) {
            if (panel instanceof EnableEditDelete) ((EnableEditDelete) panel).setEnableEditDelete(false);//если панели поддерживают интерфейс EnableEditDelete, то тогда вызываем метод и ставим у него false
        }
        frame.getMenu().setEnableEditDelete(false);


        //проверяем таблицу на то, выделен ли элемент или нет
        if (td != null) {//если элементы не равны нулю, то проверяем таблицу на то, выделен ли элемент или нет
            if (td.getSelectedRow() != -1) {//getSelectedRow() показывает, какую строку выбрал пользователь и возвращает её номер (если -1, то значит пользователь не выбрал никакую строку)
                for (JPanel panel : panels) {
                if (panel instanceof EnableEditDelete) ((EnableEditDelete) panel).setEnableEditDelete(true);//если панели поддерживают интерфейс EnableEditDelete, то тогда вызываем метод и ставим у него true
            }
                frame.getMenu().setEnableEditDelete(true);
            }
        }
    }

    @Override
    protected final void init() {
        enableEditDelete();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel header = new JLabel(Text.get(title));
        header.setFont(Style.FONT_LABEL_HEADER);
        header.setIcon(icon);
        header.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(header);

        if (panels.length == 0) add(Box.createVerticalStrut(Style.PADDING_PANEL_EMPTY));//если длинна панели равна нулю, то добавляем небольшой отступ

        for (JPanel panel: panels) {//добавляем все панели
            add(panel);
            add(Box.createVerticalStrut(Style.PADDING_PANEL));
        }

        if (td != null) {//Если есть таблица, то тогда выводим её
            JScrollPane scroll =new JScrollPane(td);
            add(scroll);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//всегда показывать скроллбар
            ListSelectionModel selectionModel = td.getSelectionModel();//При выделении соответствующих пунктов запускаем обработку
            selectionModel.addListSelectionListener(new ListSelectionListener() {//добавляем обработчик
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    enableEditDelete();
                }
            });
        }
    }

    public TableData getTableData() {
        return td;
    }
}//6_2,7_2,8_2
