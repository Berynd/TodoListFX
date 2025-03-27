package appli.accueil;

import appli.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ChangeMdpController {
    private String emailUser;

    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField confirmMdp;
    @FXML
    void confirmer(){

    }
    @FXML
    void retour() throws IOException {
        StartApplication.changeScene("accueil/Login");
    }

    public void initData(String email){
        this.emailUser = email;
    }
}
