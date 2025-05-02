package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;
import model.Tache;
import model.Type;
import model.Utilisateur;
import repository.ListeRepository;
import repository.UtilisateurRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InviteController implements Initializable{
    @FXML
    public Button confirm;
    @FXML
    public ComboBox<Utilisateur> allUser;
    public ListeRepository listeRepo = new ListeRepository();
    public UtilisateurRepository utilRepo = new UtilisateurRepository();
    public Liste maliste;

    public void initData(Liste maListe) {
        this.maliste = maListe;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Utilisateur> users = utilRepo.getTousLesUtilisateurs();
        this.allUser.getItems().addAll(users);
    }

    @FXML
    public void retour(ActionEvent mouseEvent) throws IOException {
        StartApplication.changeScene("accueil/Liste");
        ListeController controler = (ListeController) StartApplication.getControllerFromStage();
        controler.initData(maliste);
    }

    public void confirmer(ActionEvent actionEvent) throws IOException {
        listeRepo.inviteUser(allUser.getSelectionModel().getSelectedItem().getId_user(),maliste.getId_liste());
        StartApplication.changeScene("accueil/Liste");
        ListeController controler = (ListeController) StartApplication.getControllerFromStage();
        controler.initData(maliste);
    }
}
