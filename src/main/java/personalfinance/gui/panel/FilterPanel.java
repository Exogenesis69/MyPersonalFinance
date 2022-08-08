package personalfinance.gui.panel;

import personalfinance.gui.MainButton;
import personalfinance.gui.MainFrame;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Format;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;

import java.awt.*;

public final class FilterPanel extends AbstractPanel {//Final класс для вывода панели фильтра

    public FilterPanel(MainFrame frame) {
        super(frame);
        init();//вызываем метод инициализации
    }

    @Override
    protected void init() {//метод инициализации

        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        setLayout(layout);

        MainButton left = new MainButton(Style.ICON_LEFT,null, HandlerCode.LEFT);//создаем кнопки
        MainButton step = new MainButton(Format.getTitleFilter(SaveData.getInstance().getFilter()),null, HandlerCode.STEP);
        MainButton right = new MainButton(Style.ICON_RIGHT,null, HandlerCode.RIGHT);

        setBorder(Style.BORDER_FILTER_PANEL);

        step.setFont(Style.FONT_BUTTON_FILTER);
        step.setPreferredSize(new Dimension(Style.WIDTH_FILTER_BUTTON, left.getPreferredSize().height));//задаем размер кнопок

        add(left);//добавляем
        add(step);
        add(right);
    }
}//6_12
