package appli.accueil;

import appli.StartApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import model.Liste;
import model.Tache;
import model.Type;
import model.Utilisateur;
import repository.ListeRepository;
import repository.TacheRepository;
import repository.TypeRepository;
import repository.UtilisateurRepository;
import session.SessionUtilisateur;
import javafx.scene.paint.Color;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListeController implements Initializable{
    public TextField nomListe;
    public TextField nomType;
    public ComboBox allType;
    public TextField nomTache;
    private Liste maliste;
    private TacheRepository tache = new TacheRepository();
    private ListeRepository liste = new ListeRepository();
    private TypeRepository type = new TypeRepository();
    @FXML
    private TableView<Tache> tableView;
    @FXML
    private TextField couleur;

    public void initData(Liste maListe) {
        this.nomListe.setText(maListe.getNom());
        this.maliste = maListe;
        System.out.println("--- LC");
        System.out.println("id : "+maListe.getId_liste());
        System.out.println("nom : "+maListe.getNom());
        System.out.println("---");
        tableView.getItems().addAll(tache.getAllTache(maliste.getId_liste()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Type> types = type.getAllTypes();
        this.allType.getItems().addAll(types);

        couleur.setTextFormatter(new TextFormatter<String>(change -> {
            if (change.getControlNewText().length() <= 7) {
                return change;
            } else {
                return null;
            }
        }));
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
    }
    public void modifListe(ActionEvent actionEvent) throws IOException {
        liste.modifierListe(nomListe.getText(), maliste.getId_liste());
        StartApplication.changeScene("accueil/Liste");
        ListeController controler = (ListeController) StartApplication.getControllerFromStage();
        controler.initData(maliste);
    }

    public void addTache(ActionEvent actionEvent) throws IOException {
        if (nomTache.getText().isEmpty()||allType.getSelectionModel().getSelectedItem()==null) {
            System.out.println("champ vide");
        }else {
            tache.ajouterTache(nomTache.getText(),maliste.getId_liste(),type.getTypeByNom(allType.getSelectionModel().getSelectedItem().toString()));
            StartApplication.changeScene("accueil/Liste");
            ListeController controler = (ListeController) StartApplication.getControllerFromStage();
            controler.initData(maliste);
        }
    }


    public void retour(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("accueil/Accueil");
    }

    public void invite(ActionEvent actionEvent) throws IOException {
        StartApplication.changeScene("accueil/Invite");
        InviteController controler = (InviteController) StartApplication.getControllerFromStage();
        controler.initData(maliste);
    }

    public void addType(ActionEvent actionEvent) throws IOException {
        if (nomType.getText().isEmpty()||couleur.getText().isEmpty()) {
            System.out.println("champ vide");
        }else {
            if (!type.veriftypeExiste(nomType.getText())) {
                Type newType = new Type(nomType.getText(), couleur.getText());
                type.ajouterType(newType);
                StartApplication.changeScene("accueil/Liste");
                ListeController controler = (ListeController) StartApplication.getControllerFromStage();
                controler.initData(maliste);
            }else {
                System.out.println("le type existe déjà");
            }

        }

    }
}
