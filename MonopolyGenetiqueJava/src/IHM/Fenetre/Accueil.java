package IHM.Fenetre;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Accueil extends Parent {
    Solo solo_fenetre;
    HumainVShumain humain_fenetre ;


    public Accueil(Stage primaryStage){

        Button solo = new Button("Solo") ;
        Button HumainVShumain = new Button("Humain VS Humain");
        Button iaVSia = new Button("IA VS IA");

        //POSITION DES BOUTONS
        solo.setLayoutX(50);
        solo.setLayoutY(20);

        HumainVShumain.setLayoutX(50);
        HumainVShumain.setLayoutY(50);

        iaVSia.setLayoutX(50);
        iaVSia.setLayoutY(80);

        //ACTION : SI ON APPUIE SUR SOLO
        solo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //création d'une fenetre solo, d'une nouvelle fenêtre et nouvelle scene avec les dimensions
                Solo solo_fenetre = new Solo();
                Scene nouvelle_scene = new Scene(solo_fenetre,500,300);
                Stage nouvelle_fenetre = new Stage();
                nouvelle_fenetre.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre.show();
                primaryStage.close() ;
            }
        });

        //ACTION : SI ON APPUIE SUR HumainVShumain
        HumainVShumain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               //création d'une fenetre solo, d'une nouvelle fenêtre et nouvelle scene avec les dimensions
                HumainVShumain humain_fenetre = new HumainVShumain();
                Scene nouvelle_scene = new Scene(humain_fenetre,500,300);
                Stage nouvelle_fenetre = new Stage();
                nouvelle_fenetre.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre.show();
                primaryStage.close() ;
            }
        });

        //ACTION : SI ON APPUIE SUR iaVSia
        iaVSia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                IaVSia MenuIa = new IaVSia() ;
                primaryStage.close();
            }
        });

        this.setTranslateX(20);
        this.setTranslateY(20);


        // AJOUT A L'ECRAN
        this.getChildren().add(solo);
        this.getChildren().add(HumainVShumain);
        this.getChildren().add(iaVSia);
    }



}


