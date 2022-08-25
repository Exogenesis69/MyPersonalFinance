package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.panel.StatisticsPanel;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;


public class ChartHandler extends Handler{//класс, реализующий обработку кнопки выбора типа на панели статистики

    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку выбора типа на панели статистики
        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков
            case HandlerCode.TYPE: {// действие при варианте нажатия на кнопку
                ((StatisticsPanel) frame.getRightPanel()).nextType();//получаем доступ к правой панели у фрейма, приводя все к типу StatisticsPanel
            }
        }
            super.actionPerformed(ae);
    }
}//8_8
