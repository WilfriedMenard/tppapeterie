package fr.eni.tppapeterie.bo;

public class Ligne extends Article {
    protected int qte;
    protected Article article;

    public Ligne() {
    }

    public Ligne(Article article, int qte) {
        this.article = article;
        this.qte = qte;
    }

    public Article getArticle() {
        return article;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public float getPrix(){
        return this.article.getPrixUnitaire();
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "qte=" + qte +
                ", article=" + article +
                '}';
    }
}
