package personalfinance.gui;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public final class Chart {//final класс для создания гистограммы и возвращении ее в виде панели

    private DefaultPieDataset dataset;//параметр с данными типа DefaultPieDataset для обработки библиотеки JFreeChart
    private final String title;
    private final String currencyTitle;//заголовок валюты

    public Chart(HashMap<String,Double> data, String title, String currencyTitle) {
        setData(data);
        this.title= Text.get(title);//вытаскиваем текст из заголовка
        this.currencyTitle = currencyTitle;
    }

    private void setData(HashMap<String, Double> data) {
        dataset = new DefaultPieDataset();//инициализируем dataset
        for (Map.Entry<String, Double> entry : data.entrySet()) {//перебираем массив
            dataset.setValue(entry.getKey(), entry.getValue());
        }
    }
    public JPanel getPanel() {//метод, возвращающий данные в гистограмме в виде панели
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true , true , false);//создаем 3д гистограмму
        PiePlot plot = (PiePlot) chart.getPlot();//создаем график
        plot.setToolTipGenerator(new StandardPieToolTipGenerator("{0}: {1} " + currencyTitle + " ({2})"));//настраиваем вид всплывающих подсказок(продукты: сумма и название валюты и проценты
        JPanel panel = new ChartPanel((chart));//создаем панель
        panel.setPreferredSize(Style.DIMENSION_CHART);//задаем размер
        if (dataset.getItemCount() == 0) {//если данных за указанный период нет
            panel.setLayout(new GridBagLayout());
            JLabel label = new JLabel(Text.get("CHART_NO_DATA"));//то выводим пустую панель с надписью "нет данных"
            label.setFont(Style.FONT_LABEL_HEADER);//задаем шрифт
            panel.add(label);//добавляем панель
        }
        return panel;//возвращаем готовую панель
    }
}//7_1
