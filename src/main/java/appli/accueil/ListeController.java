package appli.accueil;

import appli.StartApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;
import model.Tache;
import model.Utilisateur;
import repository.ListeRepository;
import repository.TacheRepository;
import repository.UtilisateurRepository;
import session.SessionUtilisateur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListeController implements Initializable{
    public TextField nomListe;
    private int idListe;
    private TacheRepository tache = new TacheRepository();
    private ListeRepository liste = new ListeRepository();
    @FXML
    private TableView<Tache> tableView;

    public void initData(String nomListe, int idListe) {
        this.nomListe.setText(nomListe);
        this.idListe = idListe;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        String [][] colonnes = {
                { "Id Tâche","id_tache" },
                { "Nom","nom" },
                { "état","etat" },
                { "Liste","nomListe" },
                { "Type","nomType" }
        };

        for ( int i = 0 ; i < colonnes.length ; i ++ ){

//Création de la colonne avec le titre
            TableColumn<Tache, String> maCol = new TableColumn<>(colonnes[i][0]);

//Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(new PropertyValueFactory<Tache, String>(colonnes[i][1]));

//Ajout de la colonne dans notre tableau
            tableView.getColumns().add(maCol);
        }
        tableView.getItems().addAll(tache.getAllTache());

    }
    public void modifListe(ActionEvent actionEvent) {
        liste.modifierListe(nomListe.getText(), idListe);
    }

    public void addTache(ActionEvent actionEvent) {
    }

    public void addType(ActionEvent actionEvent) {
    }

    public void retour(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("accueil/Accueil");
    }
}
