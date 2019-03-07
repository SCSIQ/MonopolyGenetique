package IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu;

import Metier.Automate.Automate;
import Metier.Plateau.ParcGratuit;
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

    public void genereInfosJoueur(Automate automate){

        infosJoueur = new Pane();
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
        Label nom = new Label(automate.getJoueurCourant().getNom());
        Label argent = new Label("ARGENT : "+automate.getJoueurCourant().getSolde()+" €");
        Label cagnotte = new Label("CAGNOTTE : "+((ParcGratuit)automate.getJoueurCourant().getListeCases().get(20)).getArgantDansParc()+" €");
        Label tour = new Label("TOUR : "+automate.getNumTour());


        //NOM
        nom.setLayoutX(90);
        nom.setLayoutY(55);
        nom.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
        nom.setText(nom.getText().toUpperCase());

        //ARGENT
        argent.setLayoutX(190);
        argent.setLayoutY(55);
        argent.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));

        //Cagnotte
        cagnotte.setLayoutX(360);
        cagnotte.setLayoutY(55);
        cagnotte.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));

        //TOUR
        tour.setLayoutX(530);
        tour.setLayoutY(55);
        tour.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));

        infosJoueur.getChildren().add(cagnotte);
        infosJoueur.getChildren().add(argent);
        infosJoueur.getChildren().add(tour);
        infosJoueur.getChildren().add(r_couleur);
        infosJoueur.getChildren().add(nom);
        this.getChildren().add(infosJoueur);

    }

    public void SupprimerJoueur()
    {
        this.getChildren().removeAll(infosJoueur);
    }
}