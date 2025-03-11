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

    }

}
