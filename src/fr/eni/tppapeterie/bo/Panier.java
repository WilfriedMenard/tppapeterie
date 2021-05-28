package fr.eni.tppapeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Ligne> lignesPanier = new ArrayList<>();
    private float montant;

    public Panier() {
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    // Getter qui servira à obternir des informations de toute la liste
    public List<Ligne> getLignesPanier() {
        return lignesPanier;
    }

    // Méthode servant a retourner l'index d'une ligne du panier
    public Ligne getLigne(int index) {
        return lignesPanier.get(index);
    }
    // Ajoute une ligne au panier
    public void addLigne(Article article, int qte){
        lignesPanier.add(new Ligne (article, qte));
    }
    // Méthode servant a supprimer une ligne du panier
    public void removeLigne(int index){
        this.lignesPanier.remove(index);
    }
    // Méthode servant à mettre à jour la quantité d'un article du panier en utilisant le Setter setQte de la classe Ligne
    public void updateLigne(int index, int newQte){
        this.getLigne(index).setQte(newQte);
    }

    @Override
    public String toString() {
        return "Panier{" +
                "lignesPanier=" + lignesPanier +
                ", montant=" + montant +
                '}';
    }
}
