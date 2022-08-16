package personalfinance.gui.dialog;

import personalfinance.gui.MainFrame;
import personalfinance.settings.Text;

import javax.swing.*;

public class ConfirmDialog { //класс для создания диалогового окна с подтверждением операции
    public static int show(MainFrame frame, String text, String title){
        String[] options = {Text.get("YES"), Text.get("NO")};//создаем массив со значениями
        int result = JOptionPane.showOptionDialog(frame, Text.get(text), Text.get(title), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1] );//создаем окно:родительский контейнер frame, текст ошибки text, заголовок ошибки, изображение и два варианта ответа, одно из которых выбрано по умолчанию
        return result;
    }
}//5_2,8_1
