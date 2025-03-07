package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.SQLOutput;


public class InscriptionController {

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField email;

    @FXML
    private TextField mdp;

    @FXML
    private TextField confirmation;

    @FXML
    void onInscription(ActionEvent event) {
        UtilisateurRepository verif = new UtilisateurRepository();
        if (!nom.getText().isEmpty() && !prenom.getText().isEmpty()  && !email.getText().isEmpty() && !mdp.getText().isEmpty() && !confirmation.getText().isEmpty()) {
            if (confirmation.getText().equals(mdp.getText())) {
                if (!verif.verifEmail(email.getText())){
                    System.out.println("compte existe deja");
                }else{
                    Utilisateur user = new Utilisateur(nom.getText(), prenom.getText(),email.getText(),mdp.getText());
                    UtilisateurRepository ajouter = new UtilisateurRepository();
                    ajouter.ajouterUtilisateur(user);
                }
            }else {
                System.out.println("Erreur de confirmation");
            }
        }else {
            System.out.println("Erreur champ vide");
        }
    }

    @FXML
    void onRetour(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login");
    }

}

