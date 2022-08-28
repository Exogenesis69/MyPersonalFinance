package personalfinance.gui.dialog;

import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.Article;
import personalfinance.model.Common;
import personalfinance.settings.Style;

import javax.swing.*;

public class ArticleAddEditDialog extends AddEditDialog{//диалоговое окно для управления статьи расходов

    public ArticleAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {//инициализируем диалоговое окно
        components.put("LABEL_TITLE", new JTextField());
        icons.put("LABEL_TITLE", Style.ICON_TITLE);
    }

    @Override
    protected void setValues() {
        Article article = (Article) c;
        values.put("LABEL_TITLE", article.getTitle());
    }

    @Override
    public Common getCommonFromForm() throws ModelException { //Метод возвращает
            String title = ((JTextField) components.get("LABEL_TITLE")).getText();
            return new Article(title);
    }
}//5_6
