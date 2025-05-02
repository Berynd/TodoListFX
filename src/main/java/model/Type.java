package model;

public class Type {
    private int id_type;
    private String nom;
    private String codeCouleur;

    public Type(int id_type, String nom, String codeCouleur) {
        this.id_type = id_type;
        this.nom = nom;
        this.codeCouleur = codeCouleur;
    }

    public Type(int id_type, String nom) {
        this.id_type = id_type;
        this.nom = nom;

    }

    public Type(String codeCouleur, String nom) {
        this.codeCouleur = codeCouleur;
        this.nom = nom;
    }

    public Type(String nom) {
        this.nom = nom;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getCodeCouleur() {
        return codeCouleur;
    }

    public void setCodeCouleur(String codeCouleur) {
        this.codeCouleur = codeCouleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Override
    public String toString() {
        return nom;
    }
}
