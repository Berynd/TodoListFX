package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;
import model.Utilisateur;
import repository.UtilisateurRepository;
import session.SessionUtilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModifProfilController {
    private Utilisateur utilisateur;
    private int id;
    @FXML
    private TextField email;

    @FXML
    private Label label;

    @FXML
    private Label succes;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private UtilisateurRepository modif = new UtilisateurRepository();

    public void initData(String email, String nom, String prenom, int idUser) {
        this.email.setText(email);
        this.nom.setText(nom);
        this.prenom.setText(prenom);
        this.id= idUser;
    }

    public void initialize() {
        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateur();
        if (utilisateurActuel != null) {
            System.out.println(utilisateurActuel);
            this.id = utilisateurActuel.getId_user();
            nom.setText(utilisateurActuel.getNom());
            prenom.setText(utilisateurActuel.getPrenom());
            email.setText(utilisateurActuel.getEmail());
        }

    }

    @FXML
    void confirmer(ActionEvent event) {
        Utilisateur utilisateur = new Utilisateur(this.id,nom.getText(),prenom.getText(),email.getText());
        modif.mettreAJourUtilisateur(utilisateur);
        succes.setText("Modification prise en compte");
    }

    @FXML
    void retour(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Accueil");
    }

}

