package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;


public class MenuEditHandler extends Handler{//класс, реализующий обработку кнопок меню Правка

    public MenuEditHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку меню Правка
        FunctionsHandler handler = frame.getRightPanel().getTableData().getFunctionsHandler();
        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков
            case HandlerCode.MENU_EDIT_ADD: {// действия при варианте нажатия на кнопку "Добавить"
                handler.add();
                break;
            }
            case HandlerCode.MENU_EDIT_EDIT: {// действия при варианте нажатия на кнопку "Изменить"
                handler.edit();
                break;
            }
            case HandlerCode.MENU_EDIT_DELETE: {// действия при варианте нажатия на кнопку "Удалить"
                handler.delete();
            }
        }
        super.actionPerformed(ae);
    }
}//8_3
