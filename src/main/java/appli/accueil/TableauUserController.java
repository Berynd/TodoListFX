package appli.accueil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import session.SessionUtilisateur;

import java.net.URL;
import java.util.ResourceBundle;

public class TableauUserController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableView;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[][] colonnes = {
                { "Nom", "nom" },
                { "Prénom", "prenom" },
                { "Email", "mail" },
        };

        for (String[] colonne : colonnes) {
            TableColumn<Utilisateur, String> maCol = new TableColumn<>(colonne[0]);
            maCol.setCellValueFactory(new PropertyValueFactory<>(colonne[1]));
            this.tableView.getColumns().add(maCol);

        }

    }
}


