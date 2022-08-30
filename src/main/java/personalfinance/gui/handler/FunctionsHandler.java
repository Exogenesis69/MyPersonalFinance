package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AddEditDialog;
import personalfinance.gui.dialog.ConfirmDialog;
import personalfinance.gui.table.TableData;
import personalfinance.gui.table.model.MainTableModel;
import personalfinance.model.Common;
import personalfinance.saveload.SaveData;
import personalfinance.settings.HandlerCode;

import javax.swing.*;
import java.awt.event.*;

public class FunctionsHandler extends Handler implements MouseListener, KeyListener {//класс-обработчик для удаления строк и вывода диалоговых окон на добавление/редактирование

    private final AddEditDialog dialog;//добавляем переменную AddEditDialog

    public FunctionsHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;//устанавливаем значение dialog
    }

    @Override
    public void actionPerformed(ActionEvent ae) {//переопределяем метод
        switch (ae.getActionCommand()) {//анализируем, что за кнопка была нажата
            case HandlerCode.ADD://если кнопка "добавить"
                add();//то реализовываем метод "add"
                break;
            case HandlerCode.EDIT://если кнопка "изменить"
                edit();//то реализовываем метод "edit"
                break;
            case HandlerCode.DELETE://если кнопка "удалить"
                delete();//то реализовываем метод "delete"
        }
        super.actionPerformed(ae);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() instanceof TableData) {//Если был клик по таблице
            if (me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1)//при этом клик был двойной по ЛКМ
                showAddEditDialog(getSelectedCommon());//то редактируем выделенную сущность
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getSource() instanceof TableData) {//Если был клик по таблице
            if (me.getButton()==MouseEvent.BUTTON3) {//при этом клик был по ПКМ
                TableData td = frame.getRightPanel().getTableData();
                int row = td.rowAtPoint(me.getPoint());
                td.setRowSelectionInterval(row,row);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_DELETE) delete();
        frame.refresh();
    }

    public void add() {
        showAddEditDialog(null);
    }

    public void edit() {
        showAddEditDialog(getSelectedCommon());
    }

    public void delete() {
        Common c = getSelectedCommon();
        if (c != null) {
            int result = ConfirmDialog.show(frame, "CONFIRM_DELETE_TEXT", "CONFIRM_DELETE_TITLE");
            if (result == JOptionPane.YES_OPTION) { //если пользователь выбрал "да", то удаляем данный объект из SaveData
                SaveData.getInstance().remove(c);//то удаляем данный объект из SaveData
            }
        }
    }

    private Common getSelectedCommon() {//получить выделенную сущность типа Common
        TableData td = frame.getRightPanel().getTableData();//получаем таблицу
        Common c = ((MainTableModel) td.getModel()).getCommonByRow(td.getSelectedRow());//получаем выделенную строку, на ее основе получаем объект и записываем в "c".
        return c;
    }

    private void showAddEditDialog(Common c) {
        dialog.setCommon(c);//переносим объект типа Common в диалог
        dialog.showDialog();//показываем диалоговое окно
    }//данный класс определит добавление это или редактирование в зависимости от того null или нет
}//8_2,8_3
