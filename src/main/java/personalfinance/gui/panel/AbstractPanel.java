package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;

import javax.swing.*;

abstract public class AbstractPanel extends JPanel implements Refresh {//Абстрактный класс для панели, реализующий интерфейс refresh

    protected final MainFrame frame;

    public AbstractPanel(MainFrame frame) {//создаем конструктор
        this.frame = frame;
    }



    @Override
    public void refresh() {//переопределяем и реализовываем интерфейс refresh
        removeAll();
        init();//стираем все и создаем панель заново
    }

    abstract protected void init();

}//6_1
