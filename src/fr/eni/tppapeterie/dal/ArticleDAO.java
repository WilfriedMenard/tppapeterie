package fr.eni.tppapeterie.dal;

import fr.eni.tppapeterie.bo.Article;

import java.util.List;

public interface ArticleDAO {
    // Signature des méthodes de la classe ArticleDAOjdbcImpl
    void delete(int id);
    void update(Article article);
    void insert(Article article);
    List selectAll();
    Article selectById(int id);
}
