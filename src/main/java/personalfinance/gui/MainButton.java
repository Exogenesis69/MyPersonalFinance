package personalfinance.gui;

import personalfinance.settings.Style;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainButton extends JButton {//Класс, реализующий шаблон-образец для кнопок

    public MainButton(String title, ImageIcon icon, ActionListener listener, String action) { //конструктор для кнопки
        super(title);
        setIcon(icon);
        setActionCommand(action);
        addActionListener(listener);
        addMouseListener(new HoverButton());

        setFont(Style.FONT_MAIN_BUTTON);//Устанавливаем шрифт
        setFocusPainted(false);//убираем рамку фокуса на кнопке
        setBackground(Style.COLOR_BUTTON_BG_NORMAL);//устанавливаем цвет кнопки в нормальном состоянии
    }

    public MainButton(String title, ActionListener listener, String action) { //перегружаем конструктор для кнопки, где нет иконки
        this(title,null,listener,action);
    }

    public MainButton(ImageIcon icon, ActionListener listener, String action) { //перегружаем конструктор для кнопки, где нет текста
        this("",icon,listener,action);
    }


    private class HoverButton implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {

        }

        @Override
        public void mousePressed(MouseEvent me) {

        }

        @Override
        public void mouseReleased(MouseEvent me) {

        }

        @Override
        public void mouseEntered(MouseEvent me) {
            ((MainButton) me.getSource()).setBackground(Style.COLOR_BUTTON_BG_HOVER);//устанавливаем цвет кнопки, когда наведен курсор

        }

        @Override
        public void mouseExited(MouseEvent me) {
            ((MainButton) me.getSource()).setBackground(Style.COLOR_BUTTON_BG_NORMAL);
        }


    }
}//4_4, 4_5
