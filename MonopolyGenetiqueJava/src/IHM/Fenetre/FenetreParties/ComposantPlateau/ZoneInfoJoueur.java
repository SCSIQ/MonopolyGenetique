package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;


//CLASSE QUI S'OCCUPE DES CARACTERISTIQUES DU JOUEUR COURANT
public class ZoneInfoJoueur extends Parent {

    //ATTRIBUTS
    private Pane infosJoueur;
    private GraphicsDevice ecran = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice() ;

    public ZoneInfoJoueur(Automate automate){
        //ajout Couleur du joueur
        Rectangle r_couleur = new Rectangle();
        r_couleur.setHeight(50);
        r_couleur.setWidth(50);
        r_couleur.setLayoutX(30);
        r_couleur.setLayoutY(35);
        r_couleur.setStroke(Color.BLACK);
        r_couleur.setStrokeWidth(1);
        r_couleur.setFill(automate.getJoueurCourant().getCouleur());

        //ajout labels
        Label nom = new Label("JOUEUR "+automate.getJoueurCourant().getNom());
        Label argent = new Label("ARGENT :");
        Label enPrison = new Label("EN PRISON :");
        Label tour = new Label("TOUR :");


        //NOM
        nom.setLayoutX(90);
        nom.setLayoutY(50);
        nom.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //ARGENT
        argent.setLayoutX(210);
        argent.setLayoutY(50);
        argent.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //EN PRISON
        enPrison.setLayoutX(390);
        enPrison.setLayoutY(50);
        enPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //TOUR
        tour.setLayoutX(520);
        tour.setLayoutY(50);
        tour.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //PANEL INFOS JOUEUR
        infosJoueur = new Pane();

        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        Text test = new Text( "height : "+height*0.3+" | width : "+width+" | get scale"+infosJoueur.getScaleX());

        infosJoueur.getChildren().add(test);
        /*infosJoueur.setScaleX((int) height*0.3);
        infosJoueur.setScaleY((int)width*0.2);*/
        infosJoueur.setLayoutX(15);
        infosJoueur.setLayoutY(15);
       //infosJoueur.setStyle("-fx-border-style : solid inside;"+"-fx-border-width : 1;"+"-fx-border-color : black;");

        infosJoueur.getChildren().add(enPrison);
        infosJoueur.getChildren().add(argent);
        infosJoueur.getChildren().add(tour);
        infosJoueur.getChildren().add(r_couleur);
        infosJoueur.getChildren().add(nom);

        this.getChildren().add(infosJoueur);

        //TAILLE DU RECTANGLE ET POSITION
        //rect_infosJoueur.setHeight(85);
       // rect_infosJoueur.setWidth(1245.4);
        //rect_infosJoueur.setX(15);
        //rect_infosJoueur.setY(18.3);

        //COULEUR ET CONTOUR
        //rect_infosJoueur.setFill(Color.TRANSPARENT);
        //rect_infosJoueur.setStroke(Color.BLACK);
    }
}
