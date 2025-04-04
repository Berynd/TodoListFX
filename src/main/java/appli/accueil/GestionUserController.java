package appli.accueil;

import eu.hansolo.toolbox.observables.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Utilisateur;
import org.springframework.security.core.userdetails.User;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GestionUserController {
    public class gestionUserController implements Initializable {
        @FXML
        private TableView<User> tableauUser;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            String[][] colonnes = {
                    {"ID Utilisateur", "id_user"},
                    {"Nom", "nom"},
                    {"Prénom", "prenom"},
                    {"Email", "email"},
                    {"Rôle", "role"}
            };
            for (int i = 0; i < colonnes.length; i++) {
                TableColumn<User, String> maCol = new TableColumn<>(colonnes[i][0]);
                maCol.setCellValueFactory(
                        new PropertyValueFactory<User, String>(colonnes[i][1]));
                tableauUser.getColumns().add(maCol);
            }
            List<Utilisateur> lesUtilisateurs = userRepo.findAll();

            // Conversion en ObservableList et ajout au tableau
            ObservableList<Utilisateur> data = FXCollections.observableArrayList(lesUtilisateurs);
            tableauUser.setItems(data);
        }
        }

    }
}
