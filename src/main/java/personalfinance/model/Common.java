package personalfinance.model;

import personalfinance.saveload.SaveData;

abstract public class Common { //абстрактный класс с методами, отвечающими за то, что делать после добавления, редактирования или удаления валюты
    public Common() {}//  Это ДЕФОЛТНЫЙ КОНСТРУКТОР. проверить, будет ли инспользовать программа дефолтный конструктор именно в родительском классе Common

    public String getValueFromComboBox() {
        return null; // возвращаем строку для выпадающего списка
    } // Значения для комбобоксов. Реализация в дочерних классах

    public void postAdd(SaveData sd) {} //Метод отвечающий за то, что делать после добавления валюты
    public void postEdit(SaveData sd) {} // Метод отвечающий за то, что делать после редактирования валюты
    public void postRemove(SaveData sd) {} //Метод отвечающий за то, что делать после удаления валюты
}//2.3,3_3

