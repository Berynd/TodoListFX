package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;
import repository.UtilisateurRepository;
import model.Utilisateur;
import session.SessionUtilisateur;

import java.io.IOException;

public class LoginController {

    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();


    @FXML
    private TextField textEmail;

    @FXML
    private TextField textMdp;

    @FXML
    private Label erreur;

    @FXML
    void connexion(ActionEvent event) throws IOException {
        Utilisateur utilisateur = utilisateurRepository.connexionUser(textEmail.getText(), textMdp.getText());
        if (utilisateur != null) {
            System.out.println("Connexion réussie pour : " + utilisateur.getNom());
            SessionUtilisateur.getInstance().sauvegardeSession(utilisateur);
            erreur.setVisible(false);
            StartApplication.changeScene("accueil/Accueil");
        }else{
            System.out.println("Échec de la connexion. Email ou mot de passe incorrect.");
            erreur.setText("Email ou mot de passe incorrect.");
            erreur.setVisible(true);

        }
    }

    @FXML
    void forgotMdp(ActionEvent event) {

    }
    @FXML
    void inscription(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Inscription");
    }
}
