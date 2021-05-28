package fr.eni.tppapeterie.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Méthode afin de récupérer l'url de Settings et créer la connection
 */
public class JdbcTools {
    private final static String url = Settings.getPropriete("url");

    public static Connection recupConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(JdbcTools.url);
        return connection;
    }
}
