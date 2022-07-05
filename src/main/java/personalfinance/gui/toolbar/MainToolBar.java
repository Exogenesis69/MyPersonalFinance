package personalfinance.gui.toolbar;

import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

public final class MainToolBar extends AbstractToolBar { //final класс для создания главного тулбара

    public MainToolBar() {
        super(Style.BORDER_MAIN_TOOLBAR);//вызываем родительский конструктор и добавляем отступы с помощью пустой рамки
        init();
    }

    @Override
    protected void init() {//добавляем кнопки на тулбар
        addButton(Text.get("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, true);
        addButton(Text.get("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, true);
        addButton(Text.get("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, true);
        addButton(Text.get("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, true);
        addButton(Text.get("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONS, HandlerCode.TOOLBAR_TRANSACTIONS, true);
        addButton(Text.get("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCIES, HandlerCode.TOOLBAR_CURRENCIES, true);
        addButton(Text.get("TOOLBAR_STATISTICS"), Style.ICON_TOOLBAR_STATISTICS, HandlerCode.TOOLBAR_STATISTICS, true);
    }


}//4_5,4_6
