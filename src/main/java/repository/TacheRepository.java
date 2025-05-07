package repository;

import database.Database;
import model.Tache;

import java.sql.*;
import java.util.ArrayList;

public class TacheRepository {

    private Connection connection;

    public TacheRepository() {
        connection = Database.getConnexion();
    }

    public void ajouterTache(String nom,int id_liste,int id_type) {
        String sql = "INSERT INTO tache(nom,etat,ref_liste,ref_type) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setInt(2,0);
            ps.setInt(3,id_liste);
            ps.setInt(4,id_type);
            ps.executeUpdate();

            System.out.println("Ajout de la tache "+ nom+" reussi");
        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la tache : " + e.getMessage());
        }
    }
    public ArrayList<Tache> getAllTache(int id) {
        ArrayList<Tache> taches = new ArrayList<>();
        String sql = "SELECT t.id_tache,t.nom as nomTache,t.etat, l.nom as nomListe, type.nom as nomType FROM `tache` as t INNER JOIN liste as l ON l.id_liste = t.ref_liste INNER JOIN type ON type.id_type = t.ref_type WHERE t.ref_liste = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                Tache tache = new Tache(rs.getInt("id_tache"),rs.getString("nomTache"),rs.getInt("etat"),rs.getString("nomListe"),rs.getString("nomType"));
                taches.add(tache);
            }
        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la tache : " + e.getMessage());
        }
        return taches;
    }
    public int getEtat(int id) {
        int etat = 0;
        String sql = "SELECT etat FROM `tache` WHERE id_tache = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                etat = rs.getInt("etat");
            }
        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la tache : " + e.getMessage());
        }
        return etat;
    }
    public void etape (int id,int etat){
        int nextEtat = etat;
        if (etat == 0){
            nextEtat = 1;
        } else if (etat == 1) {
            nextEtat = 2;
        }else if (etat == 2){
            nextEtat = 0;
        }
        String sql = "UPDATE tache SET etat = ? WHERE id_tache = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, nextEtat);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("etat modifier avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }
    public void supprimerTache(int id) {
        String sql = "DELETE FROM tache WHERE id_tache = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("tache supprimer avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }
}