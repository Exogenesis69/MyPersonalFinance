package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.panel.*;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuViewHandler extends Handler {//класс, реализующий обработку кнопок меню Вид

    public MenuViewHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку меню Вид

        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков

            case HandlerCode.MENU_VIEW_OVERVIEW: {// действия при варианте нажатия на кнопку "Обзор"
                showOverviewPanel();//вызываем метод с панелью
                break;
            }
            case HandlerCode.MENU_VIEW_ACCOUNTS: {// действия при варианте нажатия на кнопку "Счета"
                showAccountPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_ARTICLES: {// действия при варианте нажатия на кнопку "Статьи"
                showArticlePanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSACTIONS: {// действия при варианте нажатия на кнопку "Транзакции"
                showTransactionPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSFERS: {// действия при варианте нажатия на кнопку "Переводы"
                showTransferPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_CURRENCIES: {// действия при варианте нажатия на кнопку "Валюта"
                showCurrencyPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_STATISTICS: {// действия при варианте нажатия на кнопку "Статистика"
                showStatisticsPanel();
            }
        }
        super.actionPerformed(ae);
    }
    protected void showOverviewPanel() {//метод для подстановки нужной панели
        frame.setRightPanel(new OverviewPanel(frame));
    }

    protected void showAccountPanel() {
        frame.setRightPanel(new AccountPanel(frame));
    }

    protected void showArticlePanel() {
        frame.setRightPanel(new ArticlePanel(frame));
    }

    protected void showTransactionPanel() {
        frame.setRightPanel(new TransactionPanel(frame));
    }

    protected void showTransferPanel() {
        frame.setRightPanel(new TransferPanel(frame));
    }
    protected void showCurrencyPanel() {
        frame.setRightPanel(new CurrencyPanel(frame));
    }
    protected void showStatisticsPanel() {
        frame.setRightPanel(new StatisticsPanel(frame));
    }
}//8_4
