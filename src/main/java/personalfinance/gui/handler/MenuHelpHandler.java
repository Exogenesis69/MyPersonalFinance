package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AboutDialog;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuHelpHandler extends Handler {//класс, реализующий обработку кнопок меню Помощь

    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку меню Помощь

        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков
            case HandlerCode.MENU_HELP_ABOUT: {// действия при варианте нажатия на кнопку "О программе"
                new AboutDialog().setVisible(true);//Создаем диалоговое окно AboutDialog и делаем его видимым
            }
        }
        super.actionPerformed(ae);
    }
}//8_5
