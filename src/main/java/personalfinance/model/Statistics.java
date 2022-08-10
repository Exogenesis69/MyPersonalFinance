package personalfinance.model;

import personalfinance.saveload.SaveData;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class Statistics { //класс для возврата статистических данных

    public static double getBalanceCurrency(Currency currency) { //возвращает сумму со всех счетов с привязкой к валюте
        SaveData ad = SaveData.getInstance(); // получаем экземпляр класса
        double amount = 0;
        for (Account account : ad.getAccounts()) { // для всех счетов
            if (currency.equals(account.getCurrency()))
                amount += account.getAmount(); //при условии, что валюта счета совпадает с передаваемой валютой
        }
        return amount;
    }

    public static double getBalance (Currency currency) { //возвращает общую сумму со всех счетов без привязки к валюте
        SaveData ad = SaveData.getInstance();
        double amount = 0;
        for (Account account : ad.getAccounts()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);

        }
        return amount;
    }

    public static HashMap<String, Double> getDataForChartOnIncomeArticles() { //метод возвращает все статьи доходов
        return getDataForChartOnArticles(true); // значение true для доходов
    }

    public static HashMap<String, Double> getDataForChartOnExpArticles() { //метод возвращает все статьи доходов
        return getDataForChartOnArticles(false); //значение false для расходов
    }

    private static HashMap<String, Double> getDataForChartOnArticles(boolean income) { //данные для построения гистограммы
        List<Transaction> transactions = SaveData.getInstance().getFilterTransactions(); // берем все транзакции
        HashMap <String, Double> data = new HashMap<>();
        for (Transaction t : transactions){
            if ((income && t.getAmount() > 0) || (!income && t.getAmount() < 0 )) { //делаем так, чтобы доходы и расходы не суммировались
                String key = t.getArticle().getTitle(); // переменная, чтобы избежать дублирования кода
                double summa = 0;
                double amount = t.getAmount();
                if (!income) amount *= -1; // если расходы, то умножаем на -1 чтобы не было отрицательных значений
                if (data.containsKey(key)) summa = data.get(key);
                summa += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(summa)); //кладем значение в массив. round()- это метод для округления числа
            }
        }
        return data;
    }
    private static  double round(double value) { // метод округления до двух знаков
        return (double) Math.round(value *100) /100;

    }
}
// Lesson_2_6,7_1
