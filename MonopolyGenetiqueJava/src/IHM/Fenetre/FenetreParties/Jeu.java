package IHM.Fenetre.FenetreParties;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
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


        //APPEL DES FONCTIONS POUR TAILLES, COULEURS ET POSITION
        RectangleInfoJoueur(rect_infosJoueur);
        RectanglePlateau(rect_plateau);
        RectangleAdversaire(rect_adversaire);


        //TAILLE DES BOUTONS
        bt_menu.setPrefSize(150,10);
        bt_lancerDes.setPrefSize(150,10);
        bt_tourSuivant.setPrefSize(150,10);




        // AJOUT A L'ECRAN
        this.getChildren().add(rect_infosJoueur);
        this.getChildren().add(rect_plateau);
        this.getChildren().add(rect_adversaire);
       /* this.getChildren().add(rect_possession);
        this.getChildren().add(rect_terrain);
        this.getChildren().add(rect_gare);
        this.getChildren().add(rect_compagnie);
        this.getChildren().add(bt_menu);
        this.getChildren().add(bt_lancerDes);
        this.getChildren().add(bt_tourSuivant);*/

    }

    public void RectangleInfoJoueur(Rectangle rect_infosJoueur){

        //TAILLE DU RECTANGLE ET POSITION

        rect_infosJoueur.setHeight(85);
        rect_infosJoueur.setWidth(1210.4);
        rect_infosJoueur.setX(55);
        rect_infosJoueur.setY(18.3);

        //COULEUR ET CONTOUR
        rect_infosJoueur.setFill(Color.TRANSPARENT);
        rect_infosJoueur.setStroke(Color.BLACK);
    }


    public void RectanglePlateau(Rectangle rect_plateau){

        //TAILLE DU RECTANGLE ET POSITION

        rect_plateau.setHeight(550);
        rect_plateau.setWidth(550);
        rect_plateau.setX(55);
        rect_plateau.setY(130);

        //COULEUR ET CONTOUR
        rect_plateau.setFill(Color.TRANSPARENT);
        rect_plateau.setStroke(Color.BLACK);
    }


    public void RectangleAdversaire(Rectangle rect_adversaire){

        //TAILLE DU RECTANGLE ET POSITION

        rect_adversaire.setHeight(200);
        rect_adversaire.setWidth(630);
        rect_adversaire.setX(630);
        rect_adversaire.setY(130);

        //COULEUR ET CONTOUR
        rect_adversaire.setFill(Color.TRANSPARENT);
        rect_adversaire.setStroke(Color.BLACK);
    }

}
