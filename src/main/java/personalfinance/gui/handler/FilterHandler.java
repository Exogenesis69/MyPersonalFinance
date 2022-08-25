package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;


public class FilterHandler extends Handler{//класс, реализующий обработку кнопок фильтра по дате

    public FilterHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку фильтра по дате
        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков
            case HandlerCode.LEFT: {// действия при варианте нажатия на кнопку "Лево"
                SaveData.getInstance().getFilter().prev();//получаем доступ к фильтру и вызываем метод prev(предыдущий временной интервал)
                break;
            }
            case HandlerCode.RIGHT: {// действия при варианте нажатия на кнопку "Право"
                SaveData.getInstance().getFilter().next();//получаем доступ к фильтру и вызываем метод next(следующий временной интервал)
                break;
            }
            case HandlerCode.STEP: {// действия при варианте нажатия на кнопку "Шаг"
                SaveData.getInstance().getFilter().nextPeriod();//получаем доступ к фильтру и вызываем метод nextPeriod(следующий временной период)
            }
        }
        super.actionPerformed(ae);
    }
}//8_7
