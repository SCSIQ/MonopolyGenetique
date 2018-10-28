package IHM.Fenetre.FenetreParties;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Jeu extends Parent {

    public Jeu(){

        //DEFINITIONS DES RECTANGLES DANS LE JEU
        Rectangle rect_infosJoueur = new Rectangle() ;
        Rectangle rect_plateau = new Rectangle();
        Rectangle rect_adversaire = new Rectangle() ;
        Rectangle rect_possession = new Rectangle() ;
        Rectangle rect_terrain = new Rectangle();
        Rectangle rect_gare = new Rectangle();
        Rectangle rect_compagnie = new Rectangle();

        //BOUTONS
        Button bt_menu = new Button() ;
        Button bt_lancerDes = new Button() ;
        Button bt_tourSuivant = new Button() ;






        // AJOUT A L'ECRAN
        this.getChildren().add(rect_infosJoueur);
        this.getChildren().add(rect_plateau);
        this.getChildren().add(rect_adversaire);
        this.getChildren().add(rect_possession);
        this.getChildren().add(rect_terrain);
        this.getChildren().add(rect_gare);
        this.getChildren().add(rect_compagnie);
        this.getChildren().add(bt_menu);
        this.getChildren().add(bt_lancerDes);
        this.getChildren().add(bt_tourSuivant);

    }


}
