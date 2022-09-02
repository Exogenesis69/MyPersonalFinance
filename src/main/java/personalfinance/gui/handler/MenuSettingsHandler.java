package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Settings;
import personalfinance.settings.Text;

import java.awt.event.ActionEvent;


public class MenuSettingsHandler extends Handler{//класс, реализующий обработку кнопок меню Настройки языка

    public MenuSettingsHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку меню Настройки языка
        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков
            case HandlerCode.MENU_SETTINGS_LANGUAGE_RUSSIAN: {// действия при варианте нажатия на кнопку "Русский"
                Settings.setLanguage("ru");
                break;
            }
            case HandlerCode.MENU_SETTINGS_LANGUAGE_ENGLISH: {// действия при варианте нажатия на кнопку "Английский"
                Settings.setLanguage("en");
                break;
            }
            case HandlerCode.MENU_SETTINGS_LANGUAGE_ITALIAN: {// действия при варианте нажатия на кнопку "Итальянский"
                Settings.setLanguage("it");
            }
        }
        Text.init();
        frame.getMenu().refresh();
        super.actionPerformed(ae);
    }
}//10_3
