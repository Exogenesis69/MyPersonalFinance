package personalfinance.settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

final public class Style { //Final класс: не будем создавать от него дочерние классы. Класс содержит стилевые настройки

    public static final Color COLOR_BUTTON_BG_NORMAL = new Color(240,240,240); //цвет для фона кнопки(серый) в нормальном состоянии
    public static final Color COLOR_LEFTPANEL_BALANCE = Color.WHITE;
    public static final Color COLOR_BUTTON_BG_HOVER = new Color(255,168,18);//цвет для фона кнопки в нажатом состоянии (желтый)
    public static final Color COLOR_INCOME = new Color(0,100,0);
    public static final Color COLOR_EXP = new Color(200,0,0);
    public static final Color COLOR_ON = Color.black;
    public static final Color COLOR_OFF = new Color(170,170,170);

    public static final Font FONT_BUTTON_TOOLBAR = new Font("GothamPro", Font.BOLD, 14); //настройка шрифта для кнопок в тулбаре: наименование, жирный, размер
    public static final Font FONT_MAIN_BUTTON = new Font("GothamPro", Font.BOLD, 14);
    public static final Font FONT_DIALOG_LABEL = new Font("GothamPro", Font.BOLD, 12);
    public static final Font FONT_LABEL_HEADER = new Font("GothamPro", Font.BOLD, 16);
    public static final Font FONT_LABEL_LEFT_PANEL_CURRENCY = new Font("GothamPro", Font.BOLD, 14);
    public static final Font FONT_LABEL_LEFT_PANEL_AMOUNT = new Font("GothamPro", Font.PLAIN, 14);
    public static final Font FONT_TABLE = new Font("GothamPro", Font.PLAIN, 14);
    public static final Font FONT_TABLE_HEADER = new Font("GothamPro", Font.BOLD, 16);
    public static final Font FONT_BUTTON_FILTER = new Font("GothamPro", Font.BOLD, 14);

    public static final EmptyBorder BORDER_PANEL = new EmptyBorder(10, 10, 10, 10); //настройка отступов для панелей с помощью класса EmptyBorder (рамка которую не видно)
    public static final EmptyBorder BORDER_LEFT_PANEL = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_MAIN_TOOLBAR = new EmptyBorder(10,10,10,10);
    public static final EmptyBorder BORDER_FUNCTIONS_TOOLBAR = new EmptyBorder(5,5,5,5);
    public static final EmptyBorder BORDER_DIALOG = new EmptyBorder(10, 10, 10, 10);
    public static final EmptyBorder BORDER_FILTER_PANEL = new EmptyBorder(5, 0, 7, 0);

    public static final Dimension DIMENSION_DIALOG_TEXTFIELD_SIZE = new Dimension(200,25);
    public static final Dimension DIMENSION_DIALOG_PADDING_BUTTON = new Dimension(10,0);
    public static final Dimension DIMENSION_PADDING_BALANCE = new Dimension(10,0);
    public static final Dimension DIMENSION_TABLE_SHOW_SIZE = new Dimension(850,450);
    public static final Dimension DIMENSION_CHART = new Dimension(868,550);

    public static final int PADDING_DIALOG = 10;
    public static final int PADDING_BALANCE = 3;
    public static final int PADDING_PANEL = 3;
    public static final int PADDING_PANEL_BIG = 20;
    public static final int PADDING_PANEL_EMPTY = 5;
    public static final int TABLE_ADD_ROW_HEIGHT = 18;
    public static final int WIDTH_FILTER_BUTTON = 200;

    public static final ImageIcon ICON_MENU_FILE = new ImageIcon("images/menu_file.png");
    public static final ImageIcon ICON_MENU_EDIT = new ImageIcon("images/menu_edit.png");
    public static final ImageIcon ICON_MENU_VIEW = new ImageIcon("images/menu_view.png");
    public static final ImageIcon ICON_MENU_SETTINGS = new ImageIcon("images/menu_settings.png");
    public static final ImageIcon ICON_MENU_HELP = new ImageIcon("images/menu_help.png");

    public static final ImageIcon ICON_MENU_FILE_NEW = new ImageIcon("images/menu_file_new.png");
    public static final ImageIcon ICON_MENU_FILE_OPEN = new ImageIcon("images/menu_file_open.png");
    public static final ImageIcon ICON_MENU_FILE_SAVE = new ImageIcon("images/menu_file_save.png");
    public static final ImageIcon ICON_MENU_FILE_UPDATE_CURRENCIES = new ImageIcon("images/menu_file_update_currencies.png");
    public static final ImageIcon ICON_MENU_FILE_EXIT = new ImageIcon("images/menu_file_exit.png");

    public static final ImageIcon ICON_MENU_EDIT_ADD = new ImageIcon("images/menu_edit_add.png");
    public static final ImageIcon ICON_MENU_EDIT_EDIT = new ImageIcon("images/menu_edit_edit.png");
    public static final ImageIcon ICON_MENU_EDIT_DELETE = new ImageIcon("images/menu_edit_delete.png");

    public static final ImageIcon ICON_MENU_VIEW_OVERVIEW = new ImageIcon("images/menu_view_overview.png");
    public static final ImageIcon ICON_MENU_VIEW_ACCOUNTS = new ImageIcon("images/menu_view_accounts.png");
    public static final ImageIcon ICON_MENU_VIEW_ARTICLES = new ImageIcon("images/menu_view_articles.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSACTIONS = new ImageIcon("images/menu_view_transactions.png");
    public static final ImageIcon ICON_MENU_VIEW_TRANSFERS = new ImageIcon("images/menu_view_transfers.png");
    public static final ImageIcon ICON_MENU_VIEW_CURRENCIES = new ImageIcon("images/menu_view_currencies.png");
    public static final ImageIcon ICON_MENU_VIEW_STATISTICS = new ImageIcon("images/menu_view_statistics.png");

    public static final ImageIcon ICON_MENU_SETTINGS_LANGUAGE = new ImageIcon("images/menu_settings_language.png");
    public static final ImageIcon ICON_MENU_SETTINGS_LANGUAGE_RUSSIAN = new ImageIcon("images/menu_settings_language_russian.png");
    public static final ImageIcon ICON_MENU_SETTINGS_LANGUAGE_ENGLISH = new ImageIcon("images/menu_settings_language_english.png");

    public static final ImageIcon ICON_MENU_HELP_ABOUT = new ImageIcon("images/menu_view_help.png");

    public static final Icon ICON_MENU_POPUP_EDIT = new ImageIcon("images/menu_popup_edit.png");
    public static final Icon ICON_MENU_POPUP_DELETE = new ImageIcon("images/menu_popup_delete.png");

    public static final ImageIcon ICON_MAIN = new ImageIcon("images/main.png");//настройки для маленькой иконки в окне программы
    public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/overview.png");
    public static final ImageIcon ICON_TOOLBAR_ACCOUNTS = new ImageIcon("images/accounts.png");
    public static final ImageIcon ICON_TOOLBAR_ARTICLES = new ImageIcon("images/articles.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSACTIONS = new ImageIcon("images/transactions.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSFERS = new ImageIcon("images/transfers.png");
    public static final ImageIcon ICON_TOOLBAR_CURRENCIES = new ImageIcon("images/currencies.png");
    public static final ImageIcon ICON_TOOLBAR_STATISTICS = new ImageIcon("images/statistics.png");

    public static final ImageIcon ICON_ADD = new ImageIcon("images/add.png");
    public static final ImageIcon ICON_EDIT = new ImageIcon("images/edit.png");
    public static final ImageIcon ICON_DELETE = new ImageIcon("images/delete.png");

    public static final ImageIcon ICON_DATE = new ImageIcon("images/date.png");

    public static final ImageIcon ICON_ABOUT = new ImageIcon("images/menu_view_help.png");

    public static final ImageIcon ICON_OK = new ImageIcon("images/ok.png");
    public static final ImageIcon ICON_CANCEL = new ImageIcon("images/cancel.png");

    public static final ImageIcon ICON_TITLE = new ImageIcon("images/title.png");
    public static final ImageIcon ICON_CURRENCY = new ImageIcon("images/currency.png");
    public static final ImageIcon ICON_AMOUNT = new ImageIcon("images/amount.png");
    public static final ImageIcon ICON_ACCOUNT = new ImageIcon("images/account.png");
    public static final ImageIcon ICON_ARTICLE = new ImageIcon("images/article.png");
    public static final ImageIcon ICON_NOTICE = new ImageIcon("images/notice.png");
    public static final ImageIcon ICON_CODE = new ImageIcon("images/code.png");
    public static final ImageIcon ICON_RATE = new ImageIcon("images/rate.png");
    public static final ImageIcon ICON_ON = new ImageIcon("images/on.png");
    public static final ImageIcon ICON_BASE = new ImageIcon("images/base.png");

    public static final ImageIcon ICON_LEFT_PANEL_BALANCE_CURRENCIES = new ImageIcon("images/balance_currencies.png");
    public static final ImageIcon ICON_LEFT_PANEL_BALANCE = new ImageIcon("images/balance.png");

    public static final ImageIcon ICON_LEFT = new ImageIcon("images/left.png");
    public static final ImageIcon ICON_RIGHT = new ImageIcon("images/right.png");

    public static final ImageIcon ICON_PANEL_OVERVIEW = new ImageIcon("images/overview_panel.png");
    public static final ImageIcon ICON_PANEL_TRANSACTIONS = new ImageIcon("images/transactions_panel.png");
    public static final ImageIcon ICON_PANEL_ACCOUNTS = new ImageIcon("images/accounts_panel.png");
    public static final ImageIcon ICON_PANEL_ARTICLES = new ImageIcon("images/articles_panel.png");
    public static final ImageIcon ICON_PANEL_TRANSFERS = new ImageIcon("images/transfers_panel.png");
    public static final ImageIcon ICON_PANEL_CURRENCIES = new ImageIcon("images/currencies_panel.png");
    public static final ImageIcon ICON_PANEL_STATISTICS = new ImageIcon("images/statistics_panel.png");
}//2_8,4_3,4_5,4_6,4_7,5_3,5_4,5_5,6_1,6_4,6_5,6_6,6_7,6_9,6_10,6_12,7_1,7,2,10_2
