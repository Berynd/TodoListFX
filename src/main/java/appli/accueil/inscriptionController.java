package appli.accueil;

import appli.StartApplication;
import com.mysql.cj.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import repository.UtilisateurRepository;
import model.Utilisateur;


public class InscriptionController {
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @FXML
    private Button connexion;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

    @FXML
    private PasswordField confirmationmdp;

    @FXML
    private Button inscription;

    @FXML
    private Label erreur;


    @FXML
    void boutonConnexion(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login");

    }

    @FXML
    void boutonInscription(ActionEvent event) {

        Utilisateur utilisateur = new Utilisateur(nom.getText(), prenom.getText(), email.getText(), mdp.getText(), confirmationmdp.getText());
                utilisateurRepository.ajouterUtilisateur(utilisateur);

        if (nom.getText().isEmpty()
                || prenom.getText().isEmpty()
                || email.getText().isEmpty()
                || mdp.getText().isEmpty()
                || confirmationmdp.getText().isEmpty()) {
            erreur.setText("tout les champs doivent etre rempli");

        }
        else if (utilisateurRepository.getUtilisateurParEmail(email.getText()) != null) {
            erreur.setText("Email Déja utilisé");

        }
        else if (!mdp.getText().equals(confirmationmdp.getText())) {
            erreur.setText("mdp don't match just swipe");
        }
        else {
            erreur.setText(" ");
            System.out.println("Inscription réussis");
            System.out.println("- " + nom.getText());
            System.out.println("- " + prenom.getText());
            System.out.println("- " + email.getText());
            System.out.println("- " + mdp.getText());
            System.out.println("- " + confirmationmdp.getText());
        }
    }

}

