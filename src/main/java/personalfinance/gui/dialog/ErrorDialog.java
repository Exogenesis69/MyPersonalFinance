package personalfinance.gui.dialog;

import personalfinance.gui.MainFrame;
import personalfinance.settings.Text;

import javax.swing.*;

public class ErrorDialog {//класс для создания диалогового окна об ошибке

    public static void show(MainFrame frame, String text) {
        JOptionPane.showMessageDialog(frame, Text.get(text), Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);//создаем окно:родительский контейнер frame, текст ошибки text, заголовок ошибки и изображение
    }

}//5.1,8_1
