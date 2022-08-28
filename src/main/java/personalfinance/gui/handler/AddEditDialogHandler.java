package personalfinance.gui.handler;

import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AddEditDialog;
import personalfinance.gui.dialog.ErrorDialog;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;

import java.awt.event.*;

public class AddEditDialogHandler extends Handler implements WindowListener, KeyListener {//класс, реализующий обработку диалоговых окон редактирования и добавления

    private final AddEditDialog dialog;//создаем поле для диалогового окна

    public AddEditDialogHandler(MainFrame frame, AddEditDialog dialog ) {//создаем конструктор с родительскими методами и диалоговыми окнами
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//переопределяем метод
            switch (ae.getActionCommand()) {//анализируем, что за кнопка была нажата
                case HandlerCode.ADD://если кнопка "добавить"
                    addEdit(true);
                    break;
                case HandlerCode.EDIT://если кнопка "изменить"
                    addEdit(false);
                    break;
                case HandlerCode.CANCEL:
                    closeDialog();
            }
            super.actionPerformed(ae);
    }

    private void addEdit(boolean add) {
        try {
            if (add) SaveData.getInstance().add(dialog.getCommonFromForm());// реализовываем метод "add"
            else
                SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());//реализовываем метод "edit"
            closeDialog();//реализовываем метод "сloseDialog"
        }
        catch (ModelException ex) {
            ErrorDialog.show(frame, ex.getMessage());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            addEdit(dialog.isAdd());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {//при закрытии окна "крестиком"
        closeDialog();//вызывается метод
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

    private void closeDialog() {//при нажатии на крестик должен вызываться не базовый метод закрытия, а метод из AddEditDialog
        dialog.closeDialog();
    }
}//8_11
