package personalfinance.settings;

import personalfinance.model.Currency;
import personalfinance.model.Filter;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

final public class Format { // final класс отвечает за форматирование данных

    public static String amount(double amount) {
        return String.format(Settings.FORMAT_AMOUNT, amount); //возвращает строку в формате суммы
    }

    public static String amount(double amount, Currency currency) { //перегружаем метод
        return amount(amount) + " " + currency.getCode();// возвращаем строку в формате + код валюты
    }

    public static String rate(double rate) {
        return String.format(Settings.FORMAT_RATE, rate);//возвращает строку в формате курса валют
    }
    public static String rate(double rate, Currency currency) { //перегружаем метод
        return amount(rate) + " " + currency.getCode();// возвращаем строку в формате + код валюты
    }


    public static String date(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE);
    }

    public static String dateMonth(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_MONTH);
    }

    public static String dateYear(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_YEAR);
    }

    private static String dateFormat(Date date, String format) { //обработка трех методов date
        SimpleDateFormat sdf = new SimpleDateFormat(format, new MainDateFormatSymbols());
        return sdf.format(date);
    }

    public static double fromAmountToNumber(String amount) throws NumberFormatException { //перевод строки с суммой в тип double
        amount = amount.replaceAll(",", ".");
        return Double.parseDouble(amount);
    }

    public static String yesNo (boolean yes) {
        if (yes) return Text.get("YES");
        return Text.get("NO");
    }

    public static String getTitleFilter(Filter filter) {
        Date time = filter.getTo();
        switch (filter.getStep()){
            case Filter.STEP_DAY:
                return date(time);
            case Filter.STEP_MONTH:
                return dateMonth(time);
            case Filter.STEP_YEAR:
                return dateYear(time);
        }
        return null;
    }

    private static class MainDateFormatSymbols extends DateFormatSymbols { //переопределить название всех месяцев
        @Override
        public String[] getMonths() {
            return Text.getMonths();
        }
    }
}//2_9