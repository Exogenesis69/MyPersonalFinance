package personalfinance.gui.dialog;


import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainButton;
import personalfinance.gui.MainFrame;
import personalfinance.gui.handler.AddEditDialogHandler;
import personalfinance.model.Common;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

abstract public class AddEditDialog extends JDialog {//Абстрактный класс-шаблон, реализующий окно редактирования/добавления данных и являющийся основой для других окон

    private final MainFrame frame;
    protected LinkedHashMap<String,JComponent> components = new LinkedHashMap();//создаем массив, отвечающие за компоненты HashMap, где ключ-String text, значение-объект JComponent(текстовое поле, выпадающий список, чек-бокс и т.д.)
    protected LinkedHashMap<String,ImageIcon> icons = new LinkedHashMap();//массив иконок
    protected LinkedHashMap<String,Object> values = new LinkedHashMap();// массив объектов
    protected Common c;//класс основа

    public AddEditDialog(MainFrame frame){
        super(frame, Text.get("ADD"),true);//обращаемся к родительскому классу и передаем форму добавления и делам окно модальным(пока не закроем данное окно, все остальные окна не будут активными)
        this.frame = frame;
        addWindowListener(new AddEditDialogHandler(frame, this));
        setResizable(false);//запрещаем редактировать размер окна

    }

    public Common getCommon() {
        return c;
    }

    public void setCommon(Common c) {
        this.c = c;
    }

    public final void showDialog(){ //final метод показать окно
        setDialog();
        setVisible(true);//делаем окно видимым
    }

    public final void closeDialog() {//final метод закрыть диалог
        setVisible(false);//убираем видимость окна
        this.c = null;//убираем возможность использовать эти данные при открытии другого окна
        components.clear();//отчищаем массивы
        icons.clear();
        values.clear();
        dispose();//отчищаем место в оперативной памяти
    }


    public boolean isAdd() { //метод определяющий добавляем мы или редактируем
        return c ==null;// если объект == null, то это операция добавления, если нет, то редактирования
    }

    abstract public Common getCommonFromForm() throws ModelException;//метод, возвращающий конкретный объект Common, на основании заполненной формы

    abstract protected void init();//Абстрактный методы, которые дочерние классы обязаны будут реализовать. Инициализация(заполняются components и icons)

    abstract protected void setValues();//Абстрактный метод, где заполняется values

    private void setDialog() {//метод для создания интерфейса самого окна
        init(); //инициализируем окно и заполняем массивы

        if (isAdd()){
            setTitle(Text.get("ADD"));//Заголовок у окна. Определяем, если у нас форма добавления(isAdd), то ставим заголовок "Добавить"
            setIconImage(Style.ICON_ADD.getImage());
        }
        else {
            setValues();//Если это не добавление, то устанавливаем значения
            setTitle(Text.get("EDIT"));//и делаем заголовок "Изменить"
            setIconImage(Style.ICON_EDIT.getImage());
        }
        getContentPane().removeAll();//получаем панель JDialog и стираем из неё все (на случай, если пользователь закроет окно и откроет заново)

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));//устанавливаем положение элементов в окне (в данном случае с выравниванием по вертикали)

        ((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);//устанавливаем рамку, чтобы элементы не прижимались к границам окна

        for (Map.Entry<String, JComponent> entry : components.entrySet()) { //Перебираем массив с компонентами

            String key = entry.getKey();//Будут использоваться языковые константы
            JLabel label  =new JLabel(Text.get(key));
            label.setIcon(icons.get(key));//устанавливаем иконку
            label.setFont(Style.FONT_DIALOG_LABEL);//устанавливаем шрифт


            JComponent component = entry.getValue(); // устанавливаем значения в зависимости от типа компонента
            if(component instanceof JTextField) {//Если component унаследован от текстового поля
                component.setPreferredSize(Style.DIMENSION_DIALOG_TEXTFIELD_SIZE);//устанавливаем размер поля
                if (values.containsKey(key)) ((JTextField) component).setText(""+ values.get(key));
            }
            else if (component instanceof JComboBox) {//Если component унаследован от комбо-бокса
                if (values.containsKey(key)) ((JComboBox) component).setSelectedItem(values.get(key));
            }
            else if (component instanceof JDatePickerImpl) {//Если component унаследован от ДатаПикера
                if (values.containsKey(key)) ((UtilDateModel)((JDatePickerImpl) component).getModel()).setValue((Date) values.get(key));
            }
            component.addKeyListener(new AddEditDialogHandler(frame, this));//Добавляем горячую клавишу
            component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add(label);//Устанавливаем метку
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));//Добавляем отступы у метки
            add(component);//Добавляем компонент
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));//Добавляем отступы у компонента
        }

        MainButton ok = new MainButton(Text.get("ADD"), Style.ICON_OK, new AddEditDialogHandler(frame, this), HandlerCode.ADD);//Создаём копку добавить/изменить
        if(!isAdd()) {//Если это не "добавить", то делаем кнопку под "изменить"
            ok.setActionCommand(HandlerCode.EDIT);
            ok.setText(Text.get("EDIT"));
        }

        MainButton cancel = new MainButton(Text.get("CANCEL"), Style.ICON_CANCEL, new AddEditDialogHandler(frame, this), HandlerCode.CANCEL);//Создаём копку "отмена"

        JPanel panelButtons = new JPanel();//размещаем кнопки
        panelButtons.setLayout(new BorderLayout());
        panelButtons.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        panelButtons.add(ok, BorderLayout.WEST);//добавляем кнопку "добавить" и делаем выравнивание кнопки слева
        panelButtons.add(Box.createRigidArea(Style.DIMENSION_DIALOG_PADDING_BUTTON), BorderLayout.CENTER); //Добавляем пустую кнопку
        panelButtons.add(cancel, BorderLayout.EAST);//добавляем кнопку "добавить" и делаем выравнивание кнопки справа

        add(panelButtons);//добавляем в окно панель с кнопками
        pack();
        setLocationRelativeTo(null);
    }
    protected class CommonComboBox extends JComboBox {//создаем внутренний класс для форматирования вывода объектов(чтобы объекты не выводились приведенными к toString

        public CommonComboBox(Object[] objs) { //создаем свой собственный элемент КомбоБокс
            super(objs);//вызываем родительский конструктор, передавая в него объект в виде массива
            setRenderer(new DefaultListCellRenderer() {//переопределяем рендерер по умолчанию
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellMasFocus) {//переопределяем рендерер по умолчанию, отвечающий за то, как выглядит конкретный элемент списка(список, значение, индекс, выделен или нет, находится ли элемент в фокусе
                    DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list,value,index, isSelected, cellMasFocus);
                    Common c = (Common) value;//приводим value к типу common
                    if (c !=null) renderer.setText(c.getValueFromComboBox());
                    return renderer;
                }
            });
        }
    }

}//5_4,5_5,8_11
