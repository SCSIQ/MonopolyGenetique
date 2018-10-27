package IHM.Fenetre;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class Accueil extends Parent {

    public Accueil(){
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

            }
        });

        //ACTION : SI ON APPUIE SUR HumainVShumain
        HumainVShumain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        //ACTION : SI ON APPUIE SUR iaVSia
        iaVSia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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


