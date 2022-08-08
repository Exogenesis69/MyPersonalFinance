package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.ArticleTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

public class ArticlePanel extends RightPanel{//класс для вывода панели счетов

    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(), "ARTICLES", Style.ICON_PANEL_ARTICLES, new FunctionsToolBar());
    }

}//6_7
