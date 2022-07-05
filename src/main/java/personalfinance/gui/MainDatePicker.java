package personalfinance.gui;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.util.Date;
import java.util.Properties;

public class MainDatePicker {//класс для дейтпикера(календаря с выбором даты). подключаем зависимость jdatepicker

    private final JDatePickerImpl datePicker;

    public MainDatePicker() {
        UtilDateModel model = new UtilDateModel();//инициализируем модель т.е. внутреннюю структуру у дейтпикера
        Properties p = new Properties(); // создаем пропертис
        p.put("text.today", Text.get("TODAY"));// исправляем null в параметре today
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p); //указываем панель и настройки

        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());//создаем дейтпикер, передаем панель и формат
        model.setValue(new Date());// в модели указываем начальную дату(сегодняшнюю)

        JButton button = (JButton) datePicker.getComponent(1);
        button.setIcon(Style.ICON_DATE);//меняем кнопку на картинку
        button.setText("");//избавляемся от символов. заменяем "..." по умолчанию на пустую строку
    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public void setValue(Date date) {
        ((UtilDateModel) datePicker.getModel()).setValue(date);

    }

}//4_7
