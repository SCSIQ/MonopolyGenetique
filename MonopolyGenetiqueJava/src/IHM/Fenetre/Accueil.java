package IHM.Fenetre;

import javafx.scene.Parent;
import javafx.scene.control.Button;


public class Accueil extends Parent {

    public Accueil(){
        Button solo = new Button("Solo") ;
        Button HumainVShumain = new Button("Humain VS Humain");
        Button iaVSia = new Button("IA VS IA");

        solo.setLayoutX(50);
        solo.setLayoutY(20);

        HumainVShumain.setLayoutX(50);
        HumainVShumain.setLayoutY(50);

        iaVSia.setLayoutX(50);
        iaVSia.setLayoutY(80);

        this.setTranslateX(20);
        this.setTranslateY(20);

        this.getChildren().add(solo);
        this.getChildren().add(HumainVShumain);
        this.getChildren().add(iaVSia);
    }



}


