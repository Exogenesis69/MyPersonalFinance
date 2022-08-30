package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.Objects;

public class Article extends Common { // класс для создания объекта статьи, наследуемся от Common

    private String title; // должен быть заголовок

    public Article() {} // Пустой конструктор для каждого объекта, чтобы программа корректно работала. Класс, который сохраняет и загружает объекты в файл требует наличие пустого конструктора.

    public Article (String title) throws ModelException {
        if (title.length() == 0)
            throw new ModelException(ModelException.TITLE_EMPTY);
        this.title = title; // выбросить исключение если оно есть
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" + "title='" + title + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Article article = (Article) o;

        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }


    @Override
    public String getValueFromComboBox() {
        return title;
    }

    @Override
    public void postEdit(SaveData sd){
        for (Transaction t : sd.getTransactions())
            if (t.getArticle().equals(sd.getOldCommon())) t.setArticle(this);
    }
} //2.4, 3_3