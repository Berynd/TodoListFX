package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class loginController {

    @FXML
    private Button BouttonConnexion;

    @FXML
    private Button BouttonIsci;

    @FXML
    private Button BouttonMDPoublie;

    @FXML
    private Label EmailText;

    @FXML
    private Label MDPtexte;

    @FXML
    private Label TItre;

    @FXML
    private Label labelErreur;



    @FXML
    private TextField textEmail;

    @FXML
    private PasswordField textMDP;

    @FXML
    void onConnexionButtonClick(ActionEvent event) {
        labelErreur.setVisible(false);
        System.out.println(textEmail.getText()+""+""+textMDP.getText());
        if(textEmail.getText().equals("az@az") && textMDP.getText().equals("azerty123") ){
            labelErreur.setText("Connexion reussi");
        }
        else {
            labelErreur.setVisible(true);
            labelErreur.setText("t nul ff15 ?");
        }
    }

    @FXML
    void onInscriptionButtonClick(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/inscription");
    }

    @FXML
    void onMdpOublieButtonClick(ActionEvent event) {
        System.out.println(MDPtexte.getText());
    }

}
