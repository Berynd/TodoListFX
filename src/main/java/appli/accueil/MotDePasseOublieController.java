package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import repository.UtilisateurRepository;
import service.EmailService;

import java.io.IOException;
//import util.EmailService;

public class MotDePasseOublieController {

    private String verifCode;

    public Button valider;

    private UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField code;
    @FXML
    private Label erreur;

    @FXML
    private void envoyerCode() {
        String email = emailField.getText();
        if (email.isEmpty()) {
            System.out.println("Veuillez entrer une adresse e-mail.");
            erreur.setText("Veuillez entrer une adresse e-mail.");
            erreur.setTextFill(Paint.valueOf("#ff4200#ff4200"));
            return;
        }
        if (!utilisateurRepository.verifEmail(email)) {
            System.out.println("Email ne correspond à aucun utilisateur");
            erreur.setText("Email ne correspond à aucun utilisateur");
            erreur.setTextFill(Paint.valueOf("#ff4200"));
            return;
        }
        erreur.setText("Email envoyer");
        erreur.setTextFill(Paint.valueOf("#18ff00"));
        valider.setVisible(true);
        code.setVisible(true);
        String code = EmailService.genererCode();
        setVerifCode(code);
        EmailService.envoyerEmail(email, "Réinitialisation de mot de passe", "Votre code de réinitialisation est :" + code);
        System.out.println("Code envoyé à : " + email);
    }
    @FXML
    void retour(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login");
    }
    @FXML
    void confirmer(ActionEvent event){
        envoyerCode();
    }
    @FXML
    void validerCode(ActionEvent event) throws IOException {
        String textCode = getVerifCode();
        if (textCode.equals(code.getText())) {
            StartApplication.changeScene("accueil/ChangeMdp");
            ChangeMdpController controler = (ChangeMdpController) StartApplication.getControllerFromStage();
            controler.initData(emailField.getText());
        }else {
            System.out.println("Le code ne correspond pas");
            erreur.setText("Le code ne correspond pas");
            erreur.setTextFill(Paint.valueOf("#ff4200"));
        }
    }

    public String getVerifCode() {
        return verifCode;
    }

    public void setVerifCode(String verifCode) {
        this.verifCode = verifCode;
    }
}
