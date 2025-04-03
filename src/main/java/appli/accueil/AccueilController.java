package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import session.SessionUtilisateur;


import java.io.IOException;

public class AccueilController {

    @FXML
    private Button Todolist;

    @FXML
    private Label UtilisateurAcc;


    @FXML
    private Button deconnexion;

    @FXML
    void OnActionDeco(ActionEvent event) throws IOException {
            SessionUtilisateur.getInstance().deconnecter();
            System.out.println("Utilisateur déconnecté.");
        StartApplication.changeScene("accueil/Login");
    }

    @FXML
    void OnActionTodoList(ActionEvent event) {

    }


}
