package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ArticleAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.ArticleTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

public class ArticlePanel extends RightPanel{//класс для вывода панели счетов

    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))),
                "ARTICLES", Style.ICON_PANEL_ARTICLES,
                new FunctionsToolBar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))));
    }
}//6_7,8_2
