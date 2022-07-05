package personalfinance.saveload;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import personalfinance.model.Currency;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RateCurrency { // класс для получения курса валют онлайн

    public static HashMap<String, Double> getRates(Currency base) throws Exception { // Метод, возвращающий hashmap где String - код валюты, а double- курс относительно базовой
        HashMap<String, NodeList> result = new HashMap(); //вспомогательный hashmap, принимающий узлы(Nodelist)

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //форматируем дату
        String url = "https://cbr.ru/scripts/XML_daily.asp?date_req=" + dateFormat.format(new Date());//Указываем URL + нынешнюю дату

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(new URL(url).openStream());// парсим XML документ

        NodeList nl = doc.getElementsByTagName("Valute");//получаем главный элемент для списка узлов
        for (int i = 0; i < nl.getLength(); i++) { // перебираем все узлы
            Node node = nl.item(i);// получаем узел
            NodeList nlChilds = node.getChildNodes();// получаем дочерние элементы узла
            for (int j = 0; j < nlChilds.getLength(); j++) {// перебираем все дочерние элементы
                if (nlChilds.item(j).getNodeName().equals("CharCode"))
                    result.put(nlChilds.item(j).getTextContent(), nlChilds);
            }
        }

        HashMap<String, Double> rates = new HashMap();//создаем результирующий массив, который будем возвращать

        for (Map.Entry<String, NodeList> entry : result.entrySet()) { //перебираем HashMap
            NodeList temp = entry.getValue(); //и формируем NodeList из 5 элементов(название, код, номинал, курс и т.д.)
            double value = 0;//инициализируем переменные
            int nominal = 0;
            for (int i = 0; i < temp.getLength(); i++) { //перебираем NodeList
                if (temp.item(i).getNodeName().equals("Value"))
                    value = Double.parseDouble(temp.item(i).getTextContent().replace(',', '.')); //распарсим значение value из текста в тип double и меняем запятые на точки
                else if (temp.item(i).getNodeName().equals("Nominal")) //если эквивалентно Номиналу
                    nominal = Integer.parseInt(temp.item(i).getTextContent());//то инициализируем переменную nominal
            }
            double amount = value / nominal;//Считаем стоимость относительно рубля
            rates.put(entry.getKey(), ((double) Math.round(amount * 10000)) / 10000);// кладем в результирующий массив и округляем до 4 знаков после запятой
        }
        rates.put("RUB", 1.0);//добавляем рубль
        double div = rates.get(base.getCode()); //коэффициент пересчета с рубля на базовую валюту
        for (Map.Entry<String, Double> entry : rates.entrySet()) {
            entry.setValue(entry.getValue() / div);
        }
        return rates;
    }
} //3_5
