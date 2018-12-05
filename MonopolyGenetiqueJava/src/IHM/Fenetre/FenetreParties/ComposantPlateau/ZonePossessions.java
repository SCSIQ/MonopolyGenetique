package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;


public class ZonePossessions extends Parent {

    private GraphicsDevice ecran = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice() ;

    public ZonePossessions(Automate automate)
    {
        //Ajout d'un label "POSSESSION"
        Label textPossession = new Label("VOS POSSESSIONS");
        textPossession.setLayoutX(860);
        textPossession.setLayoutY(290);
        textPossession.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textPossession);

        ////////////////////CREATION D'UN PANEL POUR LA ZONE POSSESSION
        /*Pane zonePoss = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

       // zonePoss.setLayoutX(630);
       // zonePoss.setLayoutY(275);

        zonePoss.setLayoutX(630);
        zonePoss.setLayoutY(275);

        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zonePoss.setPrefSize(width*0.46,height*0.6);
        zonePoss.setBorder(border1);

        zonePoss.getChildren().add(textPossession);
        this.getChildren().add(zonePoss);*/

        Rectangle rect_possession = new Rectangle();
        //TAILLE DU RECTANGLE ET POSITION

        rect_possession.setHeight(429);
        rect_possession.setWidth(630);
        rect_possession.setX(630);
        rect_possession.setY(285);

        //COULEUR ET CONTOUR
        rect_possession.setFill(Color.TRANSPARENT);
        rect_possession.setStroke(Color.BLACK);
        this.getChildren().add(rect_possession);
    }

    public void RectangleTerrain(Automate automate){

        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(745);
        textTerrain.setLayoutY(325);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));


        ////////////////////CREATION D'UN PANEL POUR LA ZONE TERRAIN
        /*Pane zoneTerrain = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        zoneTerrain.setLayoutX(635);
        zoneTerrain.setLayoutY(315);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zoneTerrain.setPrefSize(width*0.22,height*0.5);
        zoneTerrain.setBorder(border1);

        zoneTerrain.getChildren().add(textTerrain);
        this.getChildren().add(zoneTerrain);*/

        Rectangle rect_terrain = new Rectangle();
        rect_terrain.setHeight(390);
        rect_terrain.setWidth(305);
        rect_terrain.setX(635);
        rect_terrain.setY(315);

        //COULEUR ET CONTOUR
        rect_terrain.setFill(Color.TRANSPARENT);
        rect_terrain.setStroke(Color.BLACK);

        this.getChildren().add(rect_terrain);
    }

    public void RectangleGare(Automate automate){

        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(1070);
        textGare.setLayoutY(325);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textGare);



        ////////////////////CREATION D'UN PANEL POUR LA ZONE GARE
        /*Pane zoneGare = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        zoneGare.setLayoutX(950);
        zoneGare.setLayoutY(315);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zoneGare.setPrefSize(width*0.22,height*0.15);
        zoneGare.setBorder(border1);

        zoneGare.getChildren().add(textGare);
        this.getChildren().add(zoneGare);*/
        //TAILLE DU RECTANGLE ET POSITION

        Rectangle rect_gare  = new Rectangle();
        rect_gare.setWidth(305);
        rect_gare.setHeight(160);
        rect_gare.setX(950);
        rect_gare.setY(315);

        //COULEUR ET CONTOUR
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);

        this.getChildren().add(rect_gare);
    }


    public void RectangleCompagnies(){

        //Ajout d'un label "COMPAGNIES"
        Label textCompagnies = new Label("COMPAGNIES");
        textCompagnies.setLayoutX(1050);
        textCompagnies.setLayoutY(495);
        textCompagnies.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        this.getChildren().add(textCompagnies);
////////////////////CREATION D'UN PANEL POUR LA ZONE GARE
       /* Pane zoneCompa = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        zoneCompa.setLayoutX(950);
        zoneCompa.setLayoutY(445);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zoneCompa.setPrefSize(width*0.22,height*0.15);
        zoneCompa.setBorder(border1);

        zoneCompa.getChildren().add(textCompagnies);
        this.getChildren().add(zoneCompa);*/

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_compagnie = new Rectangle();
        rect_compagnie.setHeight(110);
        rect_compagnie.setWidth(305);
        rect_compagnie.setX(950);
        rect_compagnie.setY(485);

        //COULEUR ET CONTOUR
        rect_compagnie.setFill(Color.TRANSPARENT);
        rect_compagnie.setStroke(Color.BLACK);
        this.getChildren().add(rect_compagnie);
    }

    public void RectangleCartePrison(){

        //Ajout d'un label "Vous êtes libéré de prison"
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" :");
        textPrison.setLayoutX(1000);
        textPrison.setLayoutY(610);
        textPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(textPrison);

////////////////////CREATION D'UN PANEL POUR LA ZONE GARE
        /*Pane zonePrison = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        zonePrison.setLayoutX(950);
        zonePrison.setLayoutY(545);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zonePrison.setPrefSize(width*0.22,height*0.1);
        zonePrison.setBorder(border1);

        zonePrison.getChildren().add(textPrison);
        this.getChildren().add(zonePrison);*/


        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_cartePrison = new Rectangle();
        rect_cartePrison.setHeight(50);
        rect_cartePrison.setWidth(305);
        rect_cartePrison.setX(950);
        rect_cartePrison.setY(605);

        //COULEUR ET CONTOUR
        rect_cartePrison.setFill(Color.TRANSPARENT);
        rect_cartePrison.setStroke(Color.BLACK);
        this.getChildren().add(rect_cartePrison);
}

    public void afficherPropriete(Automate automate)
    {

        for(int i =0 ; i<automate.getJoueurCourant().getListePropietes().size(); i++)
        {
            System.out.println(("coucou"));
           Label Proprietes = new Label(""+automate.getJoueurCourant().getListePropietes().get(i).toString()+"\n");
           Button bt_details = new Button("détails");

           bt_details.setLayoutX(50);
           this.getChildren().add(bt_details);
           this.getChildren().add(Proprietes);

        }
    }
}
