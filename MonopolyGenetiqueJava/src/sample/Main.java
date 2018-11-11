package sample;

import Entites.Joueur;
import IHM.Fenetre.FentreMenuPrincipal.Accueil;
import Metier.Automate.Des.LancerDesInitial;
import Metier.Plateau.ListeProprietes.ListeTerrains.Marron.Marron2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose2;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

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

        primaryStage.setScene(new Scene(root, 200, 300));

        root.getChildren().add(accueil) ;
        primaryStage.show();

    }



    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
