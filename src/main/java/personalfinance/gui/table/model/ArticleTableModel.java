package personalfinance.gui.table.model;

import personalfinance.model.Article;
import personalfinance.saveload.SaveData;


public class ArticleTableModel extends MainTableModel{//модель для таблицы со статьями


    private static final int TITLE = 0;//Константы, отвечающие за конкретные поля

    public ArticleTableModel(String[] columns){
        super(SaveData.getInstance().getArticles(),columns);
    }


    @Override
    protected void updateData() { //переключение вывода данных
         data = SaveData.getInstance().getArticles();

    }

    @Override
    public Object getValueAt(int row, int column) {
        if (data.isEmpty()) return null;//если данных нет, то возвращаем null
        Article article = (Article) data.get(row);//получаем транзакции по строке
        switch (column) {//возвращаем данные в зависимости от столбца
            case TITLE:
                return article.getTitle();
        }
        return null;
    }
}//6_7
