package personalfinance.gui.toolbar;

import personalfinance.gui.EnableEditDelete;
import personalfinance.gui.MainButton;
import personalfinance.gui.handler.Handler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

public final class FunctionsToolBar extends AbstractToolBar implements EnableEditDelete { //final класс для создания тулбара с функциями "Добавить,изменить и удалить"

    private MainButton editButton;
    private MainButton deleteButton;

    public FunctionsToolBar(Handler handler) {
        super(Style.BORDER_FUNCTIONS_TOOLBAR, handler);//вызываем родительский конструктор и добавляем отступы с помощью пустой рамки
        init();
    }

    @Override
    protected void init() { // инициализируем кнопки
        addButton(Text.get("ADD"), Style.ICON_ADD, HandlerCode.ADD, false);//добавляем кнопку "добавить"
        editButton = addButton(Text.get("EDIT"), Style.ICON_EDIT, HandlerCode.EDIT, false);
        deleteButton = addButton(Text.get("DELETE"), Style.ICON_DELETE, HandlerCode.DELETE, false);

    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editButton.setEnabled(enable);
        deleteButton.setEnabled(enable);

    }


}//4_6,8_2
