package fr.eni.tppapeterie.dal;

import fr.eni.tppapeterie.bo.Article;
import fr.eni.tppapeterie.bo.Ramette;
import fr.eni.tppapeterie.bo.Stylo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOjdbcImpl implements ArticleDAO {
    private final String URL = Settings.getPropriete("url");
    private final String SQL_DELETE = "DELETE FROM Articles WHERE idArticle =?;"; // Requête SQL afin de supprimer un article dans la BDD
    private final String SQL_UPDATE = "UPDATE Articles SET reference=?, marque=?, designation=?, prixUnitaire=?, qteStock=?, grammage=?, couleur=?" +
                                        "WHERE idArticle=?"; // Requête SQL afin de modifier un article dans la BDD
    private final String SQL_INSERT = "INSERT INTO Articles (reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type)" +
                                        "VALUES (?,?,?,?,?,?,?,?);"; // Requête SQL afin d'insérer un article dans la BDD
    private String sql;
    private ResultSet rs;

    /*
    Méthode afin de créer une liste de tous les articles
     */
    @Override
    public List<Article> selectAll(){
        List<Article> articles = new ArrayList<>();
        sql = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type FROM Articles;";

        try (Connection connection = JdbcTools.recupConnection();
             Statement etat = connection.createStatement())
        {
             // Creation de la requete SQL
            rs = etat.executeQuery(sql); // Execution du SELECT et récupération des données
            while (rs.next()) {
                // Si c'est une ramette
                if (rs.getString("type").trim().equalsIgnoreCase("RAMETTE")) {
                    articles.add(new Ramette(rs.getInt("idArticle"), rs.getString("reference"), rs.getString("marque"),
                            rs.getString("designation"), rs.getInt("prixUnitaire"), rs.getInt("qteStock"), rs.getInt("grammage")));
                // Sinon si c'est un stylo
                }
                if (rs.getString("type").trim().equalsIgnoreCase("STYLO")) {
                    articles.add(new Stylo(rs.getInt("idArticle"), rs.getString("reference"), rs.getString("marque"),
                            rs.getString("designation"), rs.getInt("prixUnitaire"), rs.getInt("qteStock"), rs.getString("couleur")));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return articles;
    }

    /*
    Méthode afin de sélectionner un article par son identifiant
     */
    @Override
    public Article selectById(int id){
        Article articleById = null;

        // Connection à la BDD et création d'un état pour interagir avec la BDD
        // On le met dans le try afin de fermer la connection et l'état à la fin de l'UPDATE
        try (Connection connection = JdbcTools.recupConnection();
             Statement etat = connection.createStatement())
        {
            // Requête SQL afin de sélectionner un article dans la BDD
            sql = "SELECT idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type FROM Articles WHERE idArticle = " +id+ ";";
            // Execution du SELECT...
            rs = etat.executeQuery(sql);
            // ...A chaque ligne
            if (rs.next()) {
                // Si c'est un stylo
                if (rs.getString("type").trim().equalsIgnoreCase("Ramette")) {
                    articleById = new Ramette(
                            rs.getInt("idArticle"),
                            rs.getString("reference"),
                            rs.getString("marque"),
                            rs.getString("designation"),
                            rs.getFloat("prixUnitaire"),
                            rs.getInt("qteStock"),
                            rs.getInt("grammage")
                    );
                    // Si c'est une ramette
                } if (rs.getString("type").trim().equalsIgnoreCase("Stylo")) {
                    articleById = new Stylo(
                            rs.getInt("idArticle"),
                            rs.getString("reference"),
                            rs.getString("marque"),
                            rs.getString("designation"),
                            rs.getFloat("prixUnitaire"),
                            rs.getInt("qteStock"),
                            rs.getString("couleur")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return articleById;
    }

    /*
    Méthode a fin de mettre à jour les données d'un article (sa ref, sa marque, sa designation...etc)
     */
    @Override
    public void update(Article article) {
        // Connection à la BDD et création d'un état pour interagir avec la BDD
        // On le met dans le try afin de fermer la connection et l'état à la fin de l'UPDATE
        try (Connection connection = JdbcTools.recupConnection();
             PreparedStatement etat = connection.prepareStatement(this.SQL_UPDATE))
        {
            etat.setString(1, article.getReference());
            etat.setString(2, article.getMarque());
            etat.setString(3, article.getDesignation());
            etat.setFloat(4, article.getPrixUnitaire());
            etat.setInt(5, article.getQteStock());
            etat.setInt(8, article.getIdArticle());

            // Si c'est un Stylo on modifie les colonnes qui lui corresponde
            if (article instanceof Stylo) {
                etat.setString(7, ((Stylo) article).getCouleur());
            }
            // Si c'est une Ramette on modifie les colonnes qui lui corresponde
            if (article instanceof Ramette) {
                etat.setInt(6, ((Ramette) article).getGrammage());
            }
            // Exécution de l'UPDATE
            etat.executeUpdate();

        // Exception si la requête SQL est erronée
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }

    /*
    Méthode afin d'insérer un article dans la BDD
     */
    @Override
    public void insert(Article article) {
        // Connection à la BDD et création d'un état pour interagir avec la BDD
        // On le met dans le try afin de fermer la connection et l'état à la fin de l'INSERT
        try (Connection connection = JdbcTools.recupConnection();
             PreparedStatement etat = connection.prepareStatement(this.SQL_INSERT))
        {
            etat.setString(1, article.getReference());
            etat.setString(2, article.getMarque());
            etat.setString(3, article.getDesignation());
            etat.setFloat(4, article.getPrixUnitaire());
            etat.setInt(5, article.getQteStock());

            // Si c'est un Stylo on insère les colonnes qui lui corresponde
            if (article instanceof Stylo) {
                etat.setString(7, ((Stylo) article).getCouleur());
                etat.setString(8, "Stylo");
            }
            // Si c'est une Ramette on insère les colonnes qui lui corresponde
            if (article instanceof Ramette) {
                etat.setInt(6, ((Ramette) article).getGrammage());
                etat.setString(8, "Ramette");
            }
            // Exécution de l'INSERT
            etat.executeUpdate();

            // Sert à incrémenter automatiquement l'idArticle de 1 à chaque intégration d'un article à la BDD
            ResultSet rs = etat.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                article.setIdArticle(id);
            }
        // Exception si la requête SQL est erronée
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    Méthode afin de supprimer un article dans la BDD
     */
    @Override
    public void delete(int id) {
        try (Connection connection = JdbcTools.recupConnection()) {
            PreparedStatement reqPreparee = connection.prepareStatement(this.SQL_DELETE);
            reqPreparee.setInt(1, id);
            reqPreparee.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
