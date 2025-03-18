package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Utilisateur;
import session.SessionUtilisateur;

import java.io.IOException;

public class AccueilController {

    @FXML
    private Button deconnecter;

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
}
