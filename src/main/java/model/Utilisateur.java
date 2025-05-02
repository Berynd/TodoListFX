package model;

public class Utilisateur {

    private int id_user;
    private String nom;
    private String prenom;
    private String email;
    private String mot_de_passe;

    public Utilisateur(int id_user, String nom, String prenom, String email, String mdp) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mdp;
    }

    public Utilisateur(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mot_de_passe = mdp;
    }
    public Utilisateur(int id_user, String nom, String prenom, String email) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    public Utilisateur(String email, String mdp) {
        this.email = email;
        this.mot_de_passe = mdp;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mot_de_passe;
    }

    public void setMdp(String mdp) {
        this.mot_de_passe = mdp;
    }


    @Override
    public String toString() {
        return nom+" "+prenom;
    }
}
