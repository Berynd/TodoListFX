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
        if (!utilisateurRepository.connexion(textEmail.getText(), textMdp.getText())) {
            System.out.println("Erreur connexion");
            erreur.setText("Erreur connexion");
        }else{
            System.out.println("Connexion Réussi");
            erreur.setText("Connexion Réussi");
            StartApplication.changeScene("accueil/accueil");
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
