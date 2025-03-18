package repository;

import model.Utilisateurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilisateurRepositorye{
        private Connection cnx;
        public UtilisateurRepositorye(Connection cnx){
            this.cnx = cnx;
        }

    public void ajouterUtilisateur(Utilisateurs utilisateur) {
        String sql = "INSERT INTO utilisateurs (nom, prenom, email, password, Role) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connexion;
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getPassword());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }

    }

}
