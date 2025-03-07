package repository;

import database.Database;
import model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtilisateurRepository {

    private Connection connexion;

    public UtilisateurRepository() {
        Connection connexion = Database.getConnexion();
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO user (nom, prenom, email, mdp, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }
    public Object getUtilisateurParEmail(String email) {
        Utilisateur user = null;
        String sql = "SELECT * FROM user WHERE email = ?";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                user = new Utilisateur(rs.getInt("id_user"),rs.getString("nom"), rs.getString("prenom"),rs.getString("email"),rs.getString("mdp"),rs.getString("role"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return user;
    }
    public ArrayList<Utilisateur> getTousLesUtilisateurs() {
        ArrayList<Utilisateur> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.executeUpdate();
            ResultSet rs = stmt.getResultSet();

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return users;
    }
}
