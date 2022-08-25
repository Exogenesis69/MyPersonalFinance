package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.saveload.SaveData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHandler extends WindowAdapter {//класс, реализующий закрытие программы из главного окна

    @Override
    public void windowClosing(WindowEvent we) {
        if (SaveData.getInstance().isSaved()) System.exit(0);//если файл с данными сохранен, то закрываем программу
        else {
            int result = ConfirmDialog.show((MainFrame) we.getWindow(), "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");//иначе выводим диалоговое окно с предупреждением
            if (result == JOptionPane.YES_OPTION) System.exit(0);//Если пользователь не хочет сохранять данные, то закрываем программу
        }
    }

}//8_9
