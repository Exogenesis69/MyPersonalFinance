package personalfinance.gui;

import personalfinance.settings.Settings;
import personalfinance.settings.Text;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFileChooser extends JFileChooser {//класс для создания компонента для выбора файла (Открыть или сохранить)

    private final MainFrame frame;

    public MainFileChooser(MainFrame frame) {//создаем свой конструктор
        this.frame = frame;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Program Files", Settings.SAVE_FILE_EXT);//фильтр для формата файла (только .sukhd)
        setFileFilter(filter);//устанавливаем фильтр файлчюсеру
        setAcceptAllFileFilterUsed(false);//запрет на выбор всех файлов
        setCurrentDirectory(Settings.SAVE_DIR);//по умолчанию открывается нужная для сохранения директория

        UIManager.put("FileChooser.saveDialogTitleText", Text.get("FC_SAVE"));//Переводим интерфейс, заменяя английские значения русскими
        UIManager.put("FileChooser.lookInLabelText", Text.get("FC_LOOK"));
        UIManager.put("FileChooser.saveInLabelText", Text.get("FC_LOOK"));
        UIManager.put("FileChooser.openDialogTitleText", Text.get("FC_OPEN"));

        UIManager.put("FileChooser.homeFolderToolTipText", Text.get("FC_HOME"));

        UIManager.put("FileChooser.openButtonText", Text.get("FC_OPEN"));
        UIManager.put("FileChooser.openButtonToolTipText", Text.get("FC_OPEN"));
        UIManager.put("FileChooser.saveButtonText", Text.get("FC_SAVE"));
        UIManager.put("FileChooser.saveButtonToolTipText", Text.get("FC_SAVE"));
        UIManager.put("FileChooser.cancelButtonText", Text.get("FC_CANCEL"));
        UIManager.put("FileChooser.cancelButtonToolTipText", Text.get("FC_CANCEL"));

        UIManager.put("FileChooser.fileNameLabelText", Text.get("FC_NAME_FILE"));
        UIManager.put("FileChooser.filesOfTypeLabelText", Text.get("FC_TYPE_FILE"));

        UIManager.put("FileChooser.upFolderToolTipText", Text.get("FC_UP"));
        UIManager.put("FileChooser.newFolderToolTipText", Text.get("FC_NEW_DIRECTORY"));
        UIManager.put("FileChooser.listViewButtonToolTipText", Text.get("FC_LIST"));
        UIManager.put("FileChooser.detailsViewButtonToolTipText", Text.get("FC_TABLE"));
        UIManager.put("FileChooser.fileNameHeaderText", Text.get("FC_NAME"));
        UIManager.put("FileChooser.fileSizeHeaderText", Text.get("FC_SIZE"));
        UIManager.put("FileChooser.fileTypeHeaderText", Text.get("FC_TYPE"));
        UIManager.put("FileChooser.fileDateHeaderText", Text.get("FC_DATE"));
        UIManager.put("FileChooser.fileAttrHeaderText", Text.get("FC_ATTR"));

        UIManager.put("FileChooser.acceptAllFileFilterText", Text.get("FC_ALL_FILTER"));

        updateUI();//Обновляем, чтобы изменения вступили в силу
    }

    public  int open() {
        return super.showOpenDialog(frame);//возвращает результат того, что сделал пользователь
    }

    public int save() {
        return super.showSaveDialog(frame);
    }
}//4_8
