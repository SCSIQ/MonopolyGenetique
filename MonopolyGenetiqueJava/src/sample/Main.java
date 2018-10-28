package sample;

import IHM.Fenetre.FentreMenuPrincipal.Accueil;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) {


        primaryStage.setTitle("Monopoly Génétique");
        Group root = new Group() ;

        Accueil accueil = new Accueil(primaryStage) ;

        primaryStage.setScene(new Scene(root, 200, 300));

        root.getChildren().add(accueil) ;
        primaryStage.show();

    }



    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
