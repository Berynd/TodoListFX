package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textMdp;

    @FXML
    void connexion(ActionEvent event) {
        if (textEmail.getText().equals("a") && textMdp.getText().equals("a")) {
            System.out.println(textEmail.getText());
            System.out.println(textMdp.getText());
        }else {
            System.out.println("Erreur de connexion");
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
