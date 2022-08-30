package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MainToolBarHandler extends MenuViewHandler {//класс, реализующий обработку кнопок тулбара

    public MainToolBarHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку тулбара
        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков

            case HandlerCode.TOOLBAR_OVERVIEW: {// действия при варианте нажатия на кнопку "Обзор"
                showOverviewPanel();//вызываем метод с панелью
                break;
            }
            case HandlerCode.TOOLBAR_ACCOUNTS: {// действия при варианте нажатия на кнопку "Счета"
                showAccountPanel();
                break;
            }
            case HandlerCode.TOOLBAR_ARTICLES: {// действия при варианте нажатия на кнопку "Статьи"
                showArticlePanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSACTIONS: {// действия при варианте нажатия на кнопку "Транзакции"
                showTransactionPanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSFERS: {// действия при варианте нажатия на кнопку "Переводы"
                showTransferPanel();
                break;
            }
            case HandlerCode.TOOLBAR_CURRENCIES: {// действия при варианте нажатия на кнопку "Валюта"
                showCurrencyPanel();
                break;
            }
            case HandlerCode.TOOLBAR_STATISTICS: {// действия при варианте нажатия на кнопку "Статистика"
                showStatisticsPanel();
            }
        }
        super.actionPerformed(ae);
    }
}//8_6
