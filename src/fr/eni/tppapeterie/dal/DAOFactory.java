package fr.eni.tppapeterie.dal;

/*
Méthode afin de créer une instance dans le main et l'utiliser pour soit prendre en compte le SQLite, soit le SQL Server...etc etc

Déclaration et instanciation dans le main (AppliTestDAL) : ArticleDAO articleDAO = DAOFactory.recupArticleDAO(); (Pour le SQLite)
Rien pour le SQL Server car j'ai utilisé que la BBD SQLite
 */
public class DAOFactory {
    public static ArticleDAO recupArticleDAO() {
        ArticleDAO articleDAO = new ArticleDAOjdbcImpl();
        return articleDAO;
    }
}