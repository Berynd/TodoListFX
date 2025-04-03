package appli.accueil;

import appli.StartApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import repository.UtilisateurRepository;
import session.SessionUtilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableauUserController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableView;

    @FXML
    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [][] colonnes = {
                { "Id Utilisateur","id_user" },
                { "Nom","nom" },
                { "Prénom","prenom" },
                { "Email","email" },
                // { "Rôle","role" },
        };

        for ( int i = 0 ; i < colonnes.length ; i ++ ){

//Création de la colonne avec le titre
            TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonnes[i][0]);

//Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>(colonnes[i][1]));

//Ajout de la colonne dans notre tableau
            tableView.getColumns().add(maCol);
        }
        System.out.println(utilisateurRepository.getTousLesUtilisateurs());
        tableView.getItems().addAll(utilisateurRepository.getTousLesUtilisateurs());
    }
    @FXML
    void retour() throws IOException {
        StartApplication.changeScene("accueil/Accueil");
    }
    @FXML
    void OnTableViewPressed(javafx.scene.input.MouseEvent event) throws IOException {
        int nbrClick = event.getClickCount();
    }
    public void modifier(javafx.event.ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("accueil/ModifProfil");
        ModifProfilController controler = (ModifProfilController) StartApplication.getControllerFromStage();
        controler.initData(tableView.getSelectionModel().getSelectedItem().getEmail(),tableView.getSelectionModel().getSelectedItem().getNom(),tableView.getSelectionModel().getSelectedItem().getPrenom(),tableView.getSelectionModel().getSelectedItem().getId_user());
    }

    public void supprimer(ActionEvent actionEvent) {
        utilisateurRepository.supprimerUtilisateurParEmail(tableView.getSelectionModel().getSelectedItem().getEmail());
        tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
    }
}


