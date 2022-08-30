package personalfinance.gui.handler;

import personalfinance.gui.MainFileChooser;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.gui.dialog.ErrorDialog;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MenuFileHandler extends Handler{//класс, реализующий обработку кнопок меню Файл

    private final MainFileChooser fc;

    public MenuFileHandler(MainFrame frame) {
        super(frame);
        fc = new MainFileChooser(frame);//поле для интеграции опций MainFileChooser
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//метод присвоения действий при нажатии на кнопку меню Файл
        switch (ae.getActionCommand()) {//перечисляем константы кодов-обработчиков
            case HandlerCode.MENU_FILE_NEW: {// действия при варианте нажатия на кнопку "Новый"
                Settings.setFileSave(null);// создаем новый файл для сохранения данных, не указанный пользователем
                SaveData.getInstance().clear();//Отчищаем все поля файла от старых данных
                break;
            }
            case HandlerCode.MENU_FILE_OPEN: {// действия при варианте нажатия на кнопку "Открыть"
                int result = fc.open();//определяем, что выбрал пользователь
                if (result == JFileChooser.APPROVE_OPTION) {//если вдруг он что-то выбрал,какой-то файл
                    Settings.setFileSave(fc.getSelectedFile());//то назначаем файл, который выбрал пользователь
                    SaveData.getInstance().clear();
                    SaveData.getInstance().load();//и загружаем выбранный файл со свежими данными в SaveData
                }
                break;
            }
            case HandlerCode.MENU_FILE_SAVE: {// действия при варианте нажатия на кнопку "Сохранить"
                if (Settings.getFileSave() == null) {//если нет файла, куда надо сохранять данные
                    int result = fc.save();//показываем пользователю fileChooser
                    if (result == JFileChooser.APPROVE_OPTION) {//если пользователь указал файл подтвердил
                        String path = fc.getSelectedFile().getAbsolutePath();//Получаем путь к этому файлу
                        String ext = path.substring(path.lastIndexOf("." + 1));//К имени файла прибавляем расширение
                        if (ext.equals(Settings.SAVE_FILE_EXT)) Settings.setFileSave(new File(path));//если полученное расширение эквивалентно нашему, то этот файл и указываем
                        else Settings.setFileSave(new File(path + "." + Settings.SAVE_FILE_EXT));//иначе устанавливаем програмное расширение
                    }
                }
                  if (Settings.getFileSave() != null) SaveData.getInstance().save();//если файл уже был выбран, то сохраняем
                break;
            }
            case HandlerCode.MENU_FILE_UPDATE_CURRENCIES: {// действия при варианте нажатия на кнопку "Обновить курс валют"
                try {
                    SaveData.getInstance().updateCurrencies();
                } catch (Exception e) {
                    ErrorDialog.show(frame, "ERROR_UPDATE_CURRENCIES");
                }
                break;
            }
            case HandlerCode.MENU_FILE_EXIT: {// действия при варианте нажатия на кнопку "Выход"
                if (SaveData.getInstance().isSaved()) System.exit(0);//если файл с данными сохранен, то закрываем программу
                else {
                   int result = ConfirmDialog.show(frame, "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");//иначе выводим диалоговое окно с предупреждением
                   if (result == JOptionPane.YES_OPTION) System.exit(0);//Если пользователь не хочет сохранять данные, то закрываем программу
                }
            }
        }
        super.actionPerformed(ae);
    }
}//8_1
