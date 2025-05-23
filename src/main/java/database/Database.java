package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
    private static final String SERVEUR = "localhost:8889";
    private static final String NOM_BDD = "SLAM1_todolist";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "root";
    private static String getUrl() {
        return "jdbc:mysql://" + SERVEUR + "/" + NOM_BDD + "?serverTimezone=UTC";
    }
    public static Connection getConnexion() {
        Connection cnx = null;
        try {
            cnx = DriverManager.getConnection(getUrl(), UTILISATEUR, MOT_DE_PASSE);
            System.out.println("Connexion réussie à la base de données !");
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        }
        return cnx;
    }
}



