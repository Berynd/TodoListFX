package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import model.Utilisateur;
import repository.UtilisateurRepository;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChangeMdpController {
    private String emailUser;
     private UtilisateurRepository utilisateur = new UtilisateurRepository() ;

    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField confirmMdp;
    @FXML
    void confirmer() throws IOException {
        if (mdp.getText().isEmpty() || confirmMdp.getText().isEmpty()) {
            System.out.printf("veuillez remplir les champs");
        }else{
            if (mdp.getText().equals(confirmMdp.getText())) {
                utilisateur.changeMdp(mdp.getText(), this.emailUser);
                StartApplication.changeScene("accueil/Login");
            }
        }
    }
    @FXML
    void retour() throws IOException {
        StartApplication.changeScene("accueil/Login");
    }

    public void initData(String email){
        this.emailUser = email;
    }
}
