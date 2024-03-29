package personalfinance.settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

final public class Settings { //final класс, где содержатся настройки и путь к последнему открытому файлу (мы не будем создавать дочерние классы от него)

    public static final File FONT_GOTHAMPRO = new File("fonts/GothamPro.ttf");// путь к шрифту
    public static final File SAVE_DIR = new File("saves/"); // сохранение файлов по умолчанию
    public static final String SAVE_FILE_EXT = "sukhd"; //расширение для сейвфайлов


    // форматирование данных
    public static final String FORMAT_AMOUNT = "%.2f"; //формат суммы (%.2f - вся целая часть + два знака после запятой
    public static final String FORMAT_RATE = "%.4f"; // формат курса валют (%.4f - вся целая часть + четыре знака после запятой
    public static final String FORMAT_DATE = "dd.MM.yyyy"; //формат даты
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy"; // формат даты месяца
    public static final String FORMAT_DATE_YEAR = "yyyy"; // формат даты года

    public static final int COUNT_OVERVIEW_ROWS = 10; //количество строк, которое будет показываться на главном экране

    public static final String[] CURRENCIES_CODE = new String[]{"RUB", "USD", "EUR", "BYN", "UAH"}; // код валют

    private static final File FILE_SETTINGS = new File("saves/settings.ini"); // путь, куда сохраняется файл настройки
    private static File FILE_SAVE = new File("saves/default.sukhd"); //путь к последнему открытому файлу. Если нету, то ставим default.sukhd

    private static String LANGUAGE = "ru";//Настройка языка(по умолчанию-русский)

    public static void init(){
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences prefs = new IniPreferences(ini); //доступ к настройкам
            String file = prefs.node("Settings").get("FILE_SAVE",null);
            if (file != null) FILE_SAVE = new File(file);
            String language = prefs.node("Settings").get("LANGUAGE",null);//если удается считать настройку из .ini файла
            if (language != null) LANGUAGE = language;//то берем и сохраняем её в данном классе
            setLocale();
        } catch (IOException ex) {
            save();
        }
    }

    public static File getFileSave() {
        return FILE_SAVE;
    }

    public static void setFileSave(File file) {
        FILE_SAVE = file;
        save();
    }

    public static String getLanguage() {
        return LANGUAGE;
    }

    public static void setLanguage(String language) {
        LANGUAGE = language;
        setLocale();
        save();
    }

    private static void setLocale() { //устанавливаем язык
        if (LANGUAGE.equals("ru")) Locale.setDefault(new Locale("ru"));
        else if (LANGUAGE.equals("en")) Locale.setDefault(new Locale("en"));
        else Locale.setDefault(new Locale("it"));
    }

    private static void save() { //сохраняет данные в ini.file с новыми настройками

        try {
            Wini ini = new Wini(FILE_SETTINGS); // чтобы записать данные
            if (FILE_SAVE != null) ini.put("Settings","FILE_SAVE", FILE_SAVE.getAbsolutePath().replace("\\","\\\\"));
            ini.store();
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
//2_7,10_1