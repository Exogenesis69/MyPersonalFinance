package personalfinance.gui;


import personalfinance.gui.dialog.CurrencyAddEditDialog;
import personalfinance.gui.menu.MainMenu;
import personalfinance.gui.panel.*;
import personalfinance.gui.toolbar.MainToolBar;

import personalfinance.settings.Style;
import personalfinance.settings.Text;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh { //Класс, реализующий графический интерфейс главного окна, наследуется от JFrame

    private final GridBagConstraints constraints;
    private final MainMenu mb;//инициализируем меню
    private final LeftPanel leftPanel;//инициализируем левую панель

    private RightPanel rightPanel;//инициализируем правую панель
    private final MainToolBar tb;//инициализируем тулбар

    public MainFrame() {
        super(Text.get("PROGRAM_NAME"));

        //new CurrencyAddEditDialog(this).showDialog();

        setResizable(false); //Запрещаем пользователю менять размер окна, чтобы не плыла вся верстка
        setIconImage(Style.ICON_MAIN.getImage());//Заменяем иконку программы со стандартной
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Остановка программы при нажатии пользователем на крестик(временный вариант)

        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridBagLayout());//Настраиваем компоновщик (GridBagLayout позволяет размещать компоненты (кнопки, панели и т.д.) в виде таблицы)


        constraints = new GridBagConstraints();// инициализируем

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; //растянут на два столбца

        tb = new MainToolBar();
        add(tb, constraints);//создаем новый тулбар со значениями


        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH; //делаем привязку к верху, а не посередине


        //add(new MainDatePicker().getDatePicker(), constraints);

        //add(new FunctionsToolBar(), constraints);

        leftPanel = new LeftPanel(this);//инициализируем левую панель
        add(leftPanel,constraints);//добавляем левую панель

        setRightPanel(new TransactionPanel(this));//Добавляем правую панель


        pack();
        setLocationRelativeTo(null); // окно программы будет появляться по центру
    }


    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this); //обновляем фрейм, чтобы он перерисовался заново
        mb.refresh();
        leftPanel.refresh();
        rightPanel.refresh();
        pack();
    }

    public MainMenu getMenu() {
        return mb;
    }

    private void setRightPanel(RightPanel panel) {
        if (rightPanel != null) remove(rightPanel);// удаляем старую панель чтобы не произошло накладки
        constraints.gridy = 1;//
        constraints.gridx = 1;
        rightPanel = panel;
        panel.setBorder(Style.BORDER_PANEL);
        add(rightPanel,constraints);
        pack();
    }
}//4_1,4_2,4_3,4_5,6_1,6_2,6_5
