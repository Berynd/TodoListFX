package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Liste;
import model.Utilisateur;
import session.SessionUtilisateur;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class AccueilController {

    @FXML
    private Button deconnecter;

    @FXML
    private ListView<Liste> listeView;

    @FXML
    private TextField nomList;

    @FXML
    private Label welcome;

    public void initialize() {
        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateur();
        if (utilisateurActuel != null) {
            System.out.println("Utilisateur connecté : " + utilisateurActuel.getNom());
            welcome.setText("Bienvenue, "+utilisateurActuel.getNom());
        }
    }
    @FXML
    protected void disconnect() throws IOException {
        SessionUtilisateur.getInstance().deconnecter();
        System.out.println("Utilisateur déconnecté.");
        StartApplication.changeScene("accueil/Login");
    }
    @FXML
    void table() throws IOException {
        StartApplication.changeScene("accueil/TableauUser");
    }
    @FXML
    void modifProfil(ActionEvent event) {

    }

    @FXML
    void newList(ActionEvent event) {

    }
}
