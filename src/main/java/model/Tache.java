package model;

public class Tache {

    private int id_tache;
    private String nom;
    private int etat;
    private int ref_liste;
    private int ref_type;
    private String nomListe;
    private String nomType;

    public Tache(int id_tache, String nom, int etat, int ref_liste, int ref_type) {
        this.id_tache = id_tache;
        this.nom = nom;
        this.etat = etat;
        this.ref_liste = ref_liste;
        this.ref_type = ref_type;
    }

    public Tache(int id_tache,String nom, int etat, String nomListe, String nomType) {
        this.id_tache = id_tache;
        this.nom = nom;
        this.etat = etat;
        this.nomListe = nomListe;
        this.nomType = nomType;
    }

    public Tache(String nom, int etat, int ref_liste, int ref_type) {
        this.nom = nom;
        this.etat = etat;
        this.ref_liste = ref_liste;
        this.ref_type = ref_type;
    }

    public int getId_tache() {
        return id_tache;
    }

    public String getNomListe() {
        return nomListe;
    }

    public void setNomListe(String nomListe) {
        this.nomListe = nomListe;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomtype(String nomtype) {
        this.nomType = nomtype;
    }

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getRef_liste() {
        return ref_liste;
    }

    public void setRef_liste(int ref_liste) {
        this.ref_liste = ref_liste;
    }

    public int getRef_type() {
        return ref_type;
    }

    public void setRef_type(int ref_type) {
        this.ref_type = ref_type;
    }
}
