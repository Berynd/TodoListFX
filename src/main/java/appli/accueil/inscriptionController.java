package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class inscriptionController {

    @FXML
    private Button Connexion;


    @FXML
    private Button Inscription;

    @FXML
    private Label erreurMDPconf;

    @FXML
    private Label erreurmdp;

    @FXML
    private Label error;

    @FXML
    private PasswordField textConfMdp;

    @FXML
    private PasswordField textEmail;

    @FXML
    private TextField textMdp;

    @FXML
    private TextField textNom;

    @FXML
    private TextField textPrenom;

    @FXML
    private Label titre;

    @FXML
    void OnActionConnexion(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/login");

    }

    @FXML
    void OnActionInscription(ActionEvent event) {
    if(textEmail.getText().isEmpty() &&
            textNom.getText().isEmpty() &&
            textPrenom.getText().isEmpty() &&
            textMdp.getText().isEmpty() &&
            textConfMdp.getText().isEmpty()
    ){
        erreurmdp.setText("Veuillez remplir tous les champs");
        erreurMDPconf.setText("Veuillez remplir tous les champs");

    }
    if (textEmail.getText().equals("az@az")

            && textNom.getText().equals("az")
            && textPrenom.getText().equals("az")
            && textMdp.getText().equals("az")
            &&  textConfMdp.getText().equals(textMdp.getText())) {

        error.setText("bienvenu au blue lock !!!");
        erreurMDPconf.setText("validation!!!!!");
        System.out.println(textEmail.getText()+textNom.getText()+textPrenom.getText()+textMdp.getText());
    }
    else {
        System.out.println(textEmail.getText()+textNom.getText()+textPrenom.getText()+textMdp.getText());
        System.out.println(textEmail.getText()+textNom.getText()+textPrenom.getText()+textMdp.getText()+textConfMdp.getText());
    }
    }

}
