package sample;

import Entites.Joueur;
import IHM.Fenetre.FentreMenuPrincipal.Accueil;
import Metier.Automate.Des.LancerDesInitial;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) {

        //appels des etats de l'automates pour phases de test
        Joueur j = new Joueur();
        LancerDesInitial l1 = new LancerDesInitial();
        l1.LancerDes();
        //fin des appels des etats

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
