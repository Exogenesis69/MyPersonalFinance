package personalfinance.gui.panel;

import personalfinance.gui.Chart;
import personalfinance.gui.MainFrame;
import personalfinance.model.Statistics;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Style;

import javax.swing.*;

public class StatisticsPanel extends RightPanel { //класс для вывода панели статистики

    public static final int TYPE_INCOME  = 0;//Поле для типа статистики доходов по статьям
    public static final int TYPE_EXP  = 1;//Поле для типа статистики расходов по статьям
    private int type = TYPE_INCOME;//тип по умолчанию, который выбирает пользователь


    public StatisticsPanel(MainFrame frame) {
        super(frame, null, "STATISTICS", Style.ICON_PANEL_STATISTICS,
                new JPanel[]{//создаем массив
                   new FilterPanel(frame),//где доступен выбор периода
                        new Chart(Statistics.getDataForChartOnIncomeArticles(), "CHART_INCOME", SaveData.getInstance().getBaseCurrency().getCode()).getPanel()//график
                });
    }

    public void nextType() {
        type++;
        if (type > TYPE_EXP) type = TYPE_INCOME;
    }

    public  void refresh() {
        Chart chart = null;
        String title = null;
        if (type == TYPE_INCOME) {
            title = "CHART_INCOME";
            chart = new Chart(Statistics.getDataForChartOnIncomeArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        else if (type == TYPE_EXP) {
            title = "CHART_EXP";
            chart = new Chart(Statistics.getDataForChartOnExpArticles(), title, SaveData.getInstance().getBaseCurrency().getCode());
        }
        setPanels(new JPanel[]{//создаем массив
                new FilterPanel(frame),//где доступен выбор периода
                chart.getPanel()
        });
        super.refresh();//вызываем родительскую версию метода refresh
    }
}//7_3
