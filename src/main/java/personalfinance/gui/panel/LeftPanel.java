package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.model.Currency;
import personalfinance.model.Statistics;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public final class LeftPanel extends AbstractPanel { //класс, реализующий левую панель

    public LeftPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));//расположение ячеек с выравниванием по вертикали
        setBorder(Style.BORDER_LEFT_PANEL);
        JLabel headerBC = new JLabel(Text.get("BALANCE_CURRENCIES"));//выводим заголовок
        headerBC.setFont(Style.FONT_LABEL_HEADER);//шрифт заголовка
        headerBC.setIcon(Style.ICON_LEFT_PANEL_BALANCE_CURRENCIES);//иконка заголовка
        headerBC.setAlignmentX(JComponent.CENTER_ALIGNMENT);//выравнивание заголовка по центру
        add(headerBC);//добавляем на панель

        addBalanceCurrency();

        add(Box.createVerticalStrut(Style.PADDING_PANEL_BIG));

        JLabel headerB = new JLabel(Text.get("BALANCE"));
        headerB.setFont(Style.FONT_LABEL_HEADER);
        headerB.setIcon(Style.ICON_LEFT_PANEL_BALANCE);
        headerB.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerB);

        addBalance();
    }



    private void addBalanceCurrency() {
        for (Currency currency : SaveData.getInstance().getEnableCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));//
            add(new PanelBalanceCurrency(currency, Statistics.getBalanceCurrency(currency)));
        }
    }

    private void addBalance() {
        for (Currency currency : SaveData.getInstance().getCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalance(currency)));
        }
    }

    private class PanelBalanceCurrency extends JPanel {//внутренний класс для панели с горизонтальным выравниванием

        public PanelBalanceCurrency(Currency currency, double amount) {
            super();
            setLayout(new BorderLayout());//расположение ячеек с выравниванием в одну строку
            setBackground(Style.COLOR_LEFTPANEL_BALANCE);//настраиваем задний фон
            setBorder(Style.BORDER_PANEL);//добавляем отступы
            JLabel currencyLabel = new JLabel(currency.getTitle());//выводим метки
            JLabel amountLabel = new JLabel(Format.amount(amount,currency));

            currencyLabel.setFont(Style.FONT_LABEL_LEFT_PANEL_CURRENCY);//задаем шрифты
            amountLabel.setFont(Style.FONT_LABEL_LEFT_PANEL_AMOUNT);

            add(currencyLabel, BorderLayout.WEST);//добавляем метки с выравниваем
            add(Box.createRigidArea(Style.DIMENSION_PADDING_BALANCE));//добавляем отступы между метками
            add(amountLabel, BorderLayout.EAST);


        }
    }
}//6_1,8_11
