package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.Liste;
import model.Utilisateur;

import java.io.IOException;

public class InviteController {
    @FXML
    public Button confirm;
    @FXML
    public ComboBox<Utilisateur> allUser;
    public Liste maliste;

    public void initData(Liste maListe) {
        this.maliste = maListe;
    }

    @FXML
    public void retour(ActionEvent mouseEvent) throws IOException {
        StartApplication.changeScene("accueil/Liste");
        ListeController controler = (ListeController) StartApplication.getControllerFromStage();
        controler.initData(maliste);
    }
}
