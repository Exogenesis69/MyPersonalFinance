package personalfinance.saveload;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import personalfinance.settings.Settings;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveLoad { // класс отвечает за механизм сохранения и загрузки данных

    public static void load(SaveData sd) {//загрузка
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller um = context.createUnmarshaller();//денмаршелизируем, т.е. данные из файла преобразуем в объекты
           Wrapper wrapper =  (Wrapper) um.unmarshal(Settings.getFileSave()); //демаршелизируем в объект типа wrapper
            sd.setAccounts(wrapper.getAccounts());
            sd.setArticles(wrapper.getArticles());
            sd.setTransactions(wrapper.getTransactions());
            sd.setTransfers(wrapper.getTransfers());
            sd.setCurrencies(wrapper.getCurrencies());
        } catch (JAXBException ex) {
            System.out.println("Файл не существует!");
        }
    }

    public static void save(SaveData sd) { //сохранение
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller m = context.createMarshaller(); //маршализируем т.е. превращаем объекты, находящиеся здесь в строки, которые можно записать в файл
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);//настраиваем формат маршаллера

            Wrapper wrapper = new Wrapper(); //создаем объект класса-обертки Wrapper

            wrapper.setAccounts(sd.getAccounts());//перечисляем данные, которые нужно сохранять
            wrapper.setArticles(sd.getArticles());
            wrapper.setTransactions(sd.getTransactions());
            wrapper.setTransfers(sd.getTransfers());
            wrapper.setCurrencies(sd.getCurrencies());

            m.marshal(wrapper, Settings.getFileSave());//Сохраняем в xml-file, указывая оболочку и куда сохранять


        } catch (JAXBException ex) {
            Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}//3_2,3_3
