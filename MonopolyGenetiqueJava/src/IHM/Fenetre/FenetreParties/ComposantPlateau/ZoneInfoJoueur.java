package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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
        Label argent = new Label("ARGENT : "+automate.getJoueurCourant().getSolde()+" €");
        Label enPrison = new Label("EN PRISON :");
        Label tour = new Label("TOUR :");


        //NOM
        nom.setLayoutX(90);
        nom.setLayoutY(55);
        nom.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //ARGENT
        argent.setLayoutX(210);
        argent.setLayoutY(55);
        argent.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //EN PRISON
        enPrison.setLayoutX(390);
        enPrison.setLayoutY(55);
        enPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //TOUR
        tour.setLayoutX(520);
        tour.setLayoutY(55);
        tour.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

        //PANEL INFOS JOUEUR
        infosJoueur = new Pane();

        /*int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        infosJoueur.setLayoutX(15);
        infosJoueur.setLayoutY(15);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        infosJoueur.setPrefSize(width*0.91,height*0.07);
        infosJoueur.setBorder(border1);*/

        infosJoueur.getChildren().add(enPrison);
        infosJoueur.getChildren().add(argent);
        infosJoueur.getChildren().add(tour);
        infosJoueur.getChildren().add(r_couleur);
        infosJoueur.getChildren().add(nom);



        Rectangle rect_infosJoueur = new Rectangle() ;

        //TAILLE DU RECTANGLE ET POSITION
        rect_infosJoueur.setHeight(85);
        rect_infosJoueur.setWidth(1245.4);
        rect_infosJoueur.setX(15);
        rect_infosJoueur.setY(18.3);

        //COULEUR ET CONTOUR
        rect_infosJoueur.setFill(Color.TRANSPARENT);
        rect_infosJoueur.setStroke(Color.BLACK);

        infosJoueur.getChildren().add(rect_infosJoueur);
        this.getChildren().add(infosJoueur);
    }
}
