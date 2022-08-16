package personalfinance.gui.handler;

import personalfinance.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Handler implements ActionListener { //вспомогательный abstract класс-основа для обработки кнопок

    protected final MainFrame frame;

    public Handler(MainFrame frame) { //передаем переменную frame
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.refresh();
    }

}//8_1
