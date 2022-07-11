package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.AccountTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

public class AccountPanel extends RightPanel{

    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableData(), "ACCOUNTS", Style.ICON_PANEL_ACCOUNTS, new FunctionsToolBar());
    }

}//6_6
