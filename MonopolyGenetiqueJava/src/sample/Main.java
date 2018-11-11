package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import IHM.Fenetre.FentreMenuPrincipal.Accueil;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        //appels des etats de l'automates pour phases de test

        //Proprietes r = new Rose2();
        //System.out.println("Rose1 -> position : "+r.getPosition()+", nom : "+r.toString()+", prix : "+r.getPrix());

        //fin des appels des etats

        primaryStage.setTitle("Monopoly Génétique");
        Group root = new Group() ;

        Accueil accueil = new Accueil(primaryStage) ;

        primaryStage.setScene(new Scene(root, 350, 450));

        root.getChildren().add(accueil) ;
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
