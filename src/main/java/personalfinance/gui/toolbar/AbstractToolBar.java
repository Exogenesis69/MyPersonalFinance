package personalfinance.gui.toolbar;

import personalfinance.gui.MainButton;
import personalfinance.gui.Refresh;
import personalfinance.gui.handler.Handler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

abstract public class AbstractToolBar extends JPanel implements Refresh {//абстрактный класс для  шаблона тулбаров
    private final Handler handler;
    public AbstractToolBar(EmptyBorder border, Handler handler) {
       super();
       this.handler = handler;
       setBorder(border);
    }

    abstract protected void init();//абстрактный метод, который будет реализовываться в дочерних классах

    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {//реализация добавления кнопки на панель тулбара
        MainButton button = new MainButton(title, icon, handler, action);
        if (topIcon) {//позиционируем текст и картинку если изображение сверху
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setVerticalTextPosition(SwingConstants.BOTTOM);
        }
        else {//позиционируем текст и картинку если изображение слева
            button.setHorizontalTextPosition(SwingConstants.RIGHT);
            button.setVerticalTextPosition(SwingConstants.CENTER);
        }
        add(button);//добавляем кнопку на панель
        return button;//возвращаем ее для сохранения
    }

    @Override
    public void refresh() {//метод для обновления данных
        removeAll();
        init();
    }
}//4_5,4_6,8_2
