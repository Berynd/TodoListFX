package model;

public class Utilisateurs {
    public Utilisateurs(String password, String email) {
        this.password = password;
        this.email = email;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilisateurs(String password, String email, String prenom, String nom) {
        this.password = password;
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
    }

    private String nom;
    private String prenom;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    private String Role;

    @Override
    public String toString() {
        return "Utilisateurs{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    private String email;

    public Utilisateurs(int id, String nom, String prenom, String email, String password, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.Role = Role;
    }

    private String password;
}

