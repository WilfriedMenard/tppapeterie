package fr.eni.tppapeterie.dal;

import java.util.Properties;

/*
Méthode pour récupérer les paramètres d'une connection dans un fichier texte *.properties
Dans ce cas on récupère l'url de ce fichier texte
 */
public class Settings {
        private static Properties propriete;

        static {
            // Creation d'un instance de Properties afin de récuperer le fichier "settings.properties"
            try {
                propriete = new Properties();
                propriete.load(Settings.class.getResourceAsStream("settings.properties"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // Méthode pour récupérer la valeur que l'on souhaite dans le fichier
        public static String getPropriete(String cle) {
            String parametre = propriete.getProperty(cle, null);
            return parametre;
        }
}
