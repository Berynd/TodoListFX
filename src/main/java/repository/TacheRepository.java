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

    public void ajouterTache(Tache tache) {
        String sql = "INSERT INTO taches(nom,etat,ref_liste,ref_type) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, tache.getNom());
            ps.setInt(2,tache.getEtat());
            ps.setInt(3,tache.getRef_liste());
            ps.setInt(4,tache.getRef_type());
            ps.executeUpdate();

            System.out.println("Ajout de la tache "+ tache.getNom()+" reussi");
        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la tache : " + e.getMessage());
        }
    }
    public ArrayList<Tache> getAllTache() {
        ArrayList<Tache> taches = new ArrayList<>();
        String sql = "SELECT t.id_tache,t.nom as nomTache,t.etat, l.nom as nomListe, type.nom as nomType FROM `tache` as t INNER JOIN liste as l ON l.id_liste = t.ref_liste INNER JOIN type ON type.id_type = t.ref_type";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
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
}