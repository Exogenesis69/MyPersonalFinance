package personalfinance.gui.menu;

import personalfinance.gui.Refresh;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;

public class TablePopupMenu  extends JPopupMenu implements Refresh {//класс для создания всплывающего меню
    private final FunctionsHandler handler;

    public TablePopupMenu(FunctionsHandler handler) {
        super();//вызываем родительский конструктор
        this.handler = handler;
        init();//вызываем метод инициализации
    }

    @Override
    public void refresh() {}
    private void init() {//метод инициализации
        JMenuItem editItem = new JMenuItem(Text.get("EDIT"));//создаем пункты меню
        JMenuItem deleteItem = new JMenuItem(Text.get("DELETE"));

        editItem.setActionCommand(HandlerCode.EDIT);//устанавливаем коды обработок
        deleteItem.setActionCommand(HandlerCode.DELETE);

        editItem.addActionListener(handler);//добавляем лисенер к этим элементам
        deleteItem.addActionListener(handler);

        editItem.setIcon(Style.ICON_MENU_POPUP_EDIT);//добавляем иконки
        deleteItem.setIcon(Style.ICON_MENU_POPUP_DELETE);

        add(editItem);//добавляем в само меню
        add(deleteItem);
    }
}//6_11,8_10
