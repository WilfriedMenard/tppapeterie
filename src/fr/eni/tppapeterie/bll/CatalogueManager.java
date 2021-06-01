package fr.eni.tppapeterie.bll;

import fr.eni.tppapeterie.bo.Article;
import fr.eni.tppapeterie.bo.Ramette;
import fr.eni.tppapeterie.bo.Stylo;
import fr.eni.tppapeterie.dal.DALException;
import fr.eni.tppapeterie.dal.DAOFactory;
import fr.eni.tppapeterie.dal.jdbc.ArticleDAO;

import java.util.List;
import java.util.regex.Pattern;

public class CatalogueManager {
    private ArticleDAO articleDAO = DAOFactory.recupArticleDAO();

    // Creation d'un singleton
    private static CatalogueManager instance;

    private CatalogueManager(){
    }
    public static CatalogueManager getInstance() {
        if (instance == null) {
            instance = new CatalogueManager();
        }
        return instance;
    }

    // Lister tous les articles du catalogue
    public List<Article> getCatalogue() throws BLLException {
        return this.articleDAO.selectAll();
    }

    // Récupérer un article avec son id
    public Article getArticle(int index) throws BLLException {
        return this.articleDAO.selectById(index);
    }

    // Ajouter un article au catalogue
    public void addArticle(Article a) throws BLLException {
        this.validerArticle(a);
        this.articleDAO.insert(a);
    }

    // Modifier un article du catalogue
    public void updateArticle(Article a) throws BLLException {
        this.articleDAO.update(a);
    }

    // Supprimer un article du catalogue
    public void removeArticle(int index) throws BLLException {
        try {
            this.articleDAO.delete(index);
        } catch (DALException e) {
            throw new BLLException(e.getMessage());
        }
    }

    // Verifier si l'article est valide
    private void validerArticle(Article a) throws BLLException  {
        if (a == null) {
            throw new BLLException("L'article est vide");
        }
        if (a instanceof Ramette && ((Ramette) a).getGrammage() <= 0) {
            throw new BLLException("Le grammage doit être supérieur à 0 pour que l'article soit valide");
        }
        if (a instanceof Stylo && (((Stylo) a).getCouleur() == null || ((Stylo) a).getCouleur().trim().length()==0)) {
            throw new BLLException("Pas de couleur. Erreur innattendue.");
        }
        if (a.getReference() == null) {
            throw new BLLException("La référence est obligatoire.");
        }
    }
}