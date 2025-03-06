package appli;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    static Stage mainStage;
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("accueil/LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        mainStage.setTitle("Connexion");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    public static void changeScene(String nomDuFichierFxml ) throws IOException {
        FXMLLoader fxmlLoader = new
                FXMLLoader(StartApplication.class.getResource(nomDuFichierFxml + "View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setScene(scene);
    }

}