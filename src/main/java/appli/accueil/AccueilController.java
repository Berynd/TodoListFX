package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Liste;
import model.Utilisateur;
import repository.ListeRepository;
import session.SessionUtilisateur;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {


    @FXML
    private TableView<Liste> tableView;
    @FXML
    private ListeRepository listeRepository = new ListeRepository();
    @FXML
    private Button admin;
    @FXML
    private TextField nomList;
    @FXML
    private Label welcome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateur();
        if (utilisateurActuel != null) {
            System.out.println("Utilisateur connecté : " + utilisateurActuel.getNom());
            welcome.setText("Bienvenue, "+utilisateurActuel.getNom());
        }
        if (utilisateurActuel.getId_user() == 6) {
            admin.setVisible(true);
            admin.setDisable(false);
        }else {
            admin.setVisible(false);
            admin.setDisable(true);
        }
        String [][] colonnes = {
                { "Id Liste","id_liste" },
                { "Nom","nom" },
        };

        for ( int i = 0 ; i < colonnes.length ; i ++ ){

//Création de la colonne avec le titre
            TableColumn<Liste, String> maCol = new TableColumn<>(colonnes[i][0]);

//Ligne permettant la liaison automatique de la cellule avec la propriété
            maCol.setCellValueFactory(new PropertyValueFactory<Liste, String>(colonnes[i][1]));

//Ajout de la colonne dans notre tableau
            tableView.getColumns().add(maCol);
        }
        tableView.getItems().addAll(listeRepository.recupererListes());
    }

    @FXML
    void disconnect(ActionEvent event) throws IOException {
        SessionUtilisateur.getInstance().deconnecter();
        StartApplication.changeScene("accueil/Login");
    }

    @FXML
    void modifProfil() throws IOException {
        StartApplication.changeScene("accueil/ModifProfil");
    }

    @FXML
    void newList(ActionEvent event) {
        Liste liste = new Liste(nomList.getText());
        ListeRepository listeRepository = new ListeRepository();
        liste = listeRepository.ajouterListe(liste);
        if (liste.getId_liste() == 0){
            System.out.println("oups...");
        }else {
            tableView.getItems().add(liste);
        }


    }
    @FXML
    void table() throws IOException {
        Utilisateur utilisateurActuel = SessionUtilisateur.getInstance().getUtilisateur();
        if (utilisateurActuel.getId_user() == 6) {
            StartApplication.changeScene("accueil/TableauUser");
        }else {
            System.out.println("Vous n'avez pas les droits d'acceder a cette page");
        }

    }
    @FXML
    void OnTableViewPressed(javafx.scene.input.MouseEvent event) throws IOException {
        int nbrClick = event.getClickCount();
        if (nbrClick == 2) {
            StartApplication.changeScene("accueil/Liste");

        }
    }
    @FXML
    void OnSupprimerListeClick(ActionEvent event) {
        listeRepository.supprimerListe(tableView.getSelectionModel().getSelectedItem());
        tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
    }
    @FXML
    void onModifierListeClick(ActionEvent event) {

    }


}