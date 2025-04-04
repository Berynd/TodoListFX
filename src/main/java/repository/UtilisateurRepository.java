package repository;

import database.Database;
import model.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurRepository {
    private Connection connection;

    public UtilisateurRepository() {
        connection = Database.getConnexion();
    }


    public void ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mdp, role) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.setRole("Role_Users"));
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());

        }
    }

    public Utilisateur getUtilisateurParEmail(String email) {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement rsql = connection.prepareStatement(sql);
            rsql.setString(1, email);
            ResultSet resultat = rsql.executeQuery();

            if (resultat.next()) {
                return new Utilisateur(
                        resultat.getInt("id_utilisateur"),
                        resultat.getString("nom"),
                        resultat.getString("prenom"),
                        resultat.getString("email"),
                        resultat.getString("mdp"));
            }
        } catch (SQLException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        return null;
    }

    public void supprimerUtilisateurParEmail(String email) {
        String sql = "DELETE FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement rsql = connection.prepareStatement(sql);
            rsql.setString(1, email);
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public List<Utilisateur> mettreAJourUtilisateur(Utilisateur utilisateur) {
        String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, mdp = ?, role = ? WHERE email = ?";
        try {
            PreparedStatement rsql = connection.prepareStatement(sql);
            rsql.setString(1, utilisateur.getNom());
            rsql.setString(2, utilisateur.getPrenom());
            rsql.setString(3, utilisateur.getMdp());
            rsql.setString(4, utilisateur.setRole("Role_User"));
            rsql.executeUpdate();
            System.out.println("l'utilisateur à bien été modifié !");
        } catch (SQLException e) {
            System.out.println("Erreur, les modifications n'ont pas été faites : " + e.getMessage());
        }
        public List<Utilisateur> findAll(){
            List<Utilisateur> User = new ArrayList<>();
            sql = "SELECT id_user, nom, prenom, email, mdp, role FROM utilisateur";

            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Utilisateur user = new Utilisateur(
                            rs.getInt("id_utilisateur"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("mdp")
                    );
                    user.setRole(rs.getString("role")); // Ajout du rôle
                    User.add(user);
                }
            } catch (SQLException e) {
                System.out.println("Erreur : " + e.getMessage());
            }

            return User;
        }
    }
}
