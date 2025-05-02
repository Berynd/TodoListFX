package repository;

import database.Database;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeRepository {
    private Connection connexion;

    public TypeRepository() {
        connexion = Database.getConnexion();
    }

    public void ajouterType(Type type) {
        String query = "INSERT INTO type(nom,code_couleur) VALUES (?,?)";
        try {
            PreparedStatement ps = connexion.prepareStatement(query);
            ps.setString(1, type.getNom());
            ps.setString(2, type.getCodeCouleur());
            ps.executeUpdate();

            System.out.println("Ajout du type "+type.getNom()+" reussi");
        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du type : "+e.getMessage());
        }
    }
    public ArrayList<Type> getAllTypes() {
        ArrayList<Type> types = new ArrayList<>();
        String sql = "SELECT * FROM type";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                Type type = new Type(rs.getString("nom"));
                types.add(type);
            }
        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la tache : " + e.getMessage());
        }
        return types;
    }
    public ArrayList<Type> getAllTypesAndColor() {
        ArrayList<Type> types = new ArrayList<>();
        String sql = "SELECT * FROM type";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                Type type = new Type(rs.getString("nom"),rs.getString("code_couleur"));
                types.add(type);
            }
        }catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la tache : " + e.getMessage());
        }
        return types;
    }
    public boolean veriftypeExiste(String nom) {
        String sql = "SELECT * FROM type WHERE nom = ?";
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            if(rs.next()) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de l'utilisateur : " + e.getMessage());
            return true;
        }
    }
    public int getTypeByNom(String nom) {
        String sql = "SELECT * FROM type WHERE nom = ?";
        int idType = 0;
        try {
            PreparedStatement stmt = connexion.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                idType = rs.getInt("id_type");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de l'utilisateur : " + e.getMessage());
        }
        return idType;
    }
}