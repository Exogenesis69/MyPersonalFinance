package personalfinance.gui.dialog;

import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class AboutDialog extends JDialog {// класс, реализующий диалоговое окно "О программе"

    public AboutDialog() {
        super();
        init();
        setTitle(Text.get("DIALOG_ABOUT_TITLE"));//задаём заголовок
        setIconImage(Style.ICON_ABOUT.getImage());//меняем иконку окна со стандартной
        setResizable(false);//запрещаем каким-либо образом масштабировать окно
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", Text.get("ABOUT"));
        pane.setEditable(false);//запрещаем редактировать
        pane.setOpaque(false);//запрещаем стандартный фон

        pane.addHyperlinkListener(new HyperlinkListener() {//реализуем механизм гиперссылки
            @Override
            public void hyperlinkUpdate(HyperlinkEvent he) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(he.getEventType())) {//если совершен клик по ссылке
                    try {
                        Desktop.getDesktop().browse(he.getURL().toURI());//то совершается переход по ссылке
                    } catch (URISyntaxException | IOException ex) {

                    }
                }
            }
        });

        add(pane);//добавляем на наше диалоговое окно
        pack(); //масштабируем окно, чтобы там поместилась вся информация
        setLocationRelativeTo(null);//расположение окна по центру(null) рабочего стола
    }
}//5_3
