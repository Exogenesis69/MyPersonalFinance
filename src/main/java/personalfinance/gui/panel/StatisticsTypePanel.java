package personalfinance.gui.panel;

import personalfinance.gui.MainButton;
import personalfinance.gui.MainFrame;
import personalfinance.gui.handler.ChartHandler;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Text;

public final class StatisticsTypePanel extends AbstractPanel{//класс для выбора типа на панели статистики

    final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = Text.get(title);
        init();
    }

    @Override
    protected void init() {
        MainButton type = new MainButton(title, new ChartHandler(frame), HandlerCode.TYPE);
        add(type);


    }
}//7_3,8_8
