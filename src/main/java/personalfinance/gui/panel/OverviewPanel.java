package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.TransactionTableData;
import personalfinance.settings.Settings;
import personalfinance.settings.Style;

public class OverviewPanel extends RightPanel{//класс для вывода панели обзора

    public OverviewPanel(MainFrame frame) {
        super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS), "LAST_TRANSACTIONS", Style.ICON_PANEL_OVERVIEW);
    }

}//6_5
