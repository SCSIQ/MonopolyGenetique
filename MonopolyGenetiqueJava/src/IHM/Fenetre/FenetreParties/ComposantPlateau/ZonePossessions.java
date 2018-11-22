package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.*;


public class ZonePossessions extends Parent {

    private GraphicsDevice ecran = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice() ;

    public ZonePossessions(Automate automate)
    {
        //Ajout d'un label "POSSESSION"
        Label textPossession = new Label("VOS POSSESSIONS");
        textPossession.setLayoutX(250);
        textPossession.setLayoutY(15);
        textPossession.setFont(Font.font("Verdana", FontWeight.BOLD, 14));


        ////////////////////CREATION D'UN PANEL POUR LA ZONE POSSESSION
        Pane zonePoss = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

       // zonePoss.setLayoutX(630);
       // zonePoss.setLayoutY(275);

        zonePoss.setLayoutX(width*0.46);
        zonePoss.setLayoutY(height*0.35);

        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zonePoss.setPrefSize(width*0.46,height*0.6);
        zonePoss.setBorder(border1);

        zonePoss.getChildren().add(textPossession);
        this.getChildren().add(zonePoss);

    }

    public void RectangleTerrain(){

        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(120);
        textTerrain.setLayoutY(15);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        ////////////////////CREATION D'UN PANEL POUR LA ZONE TERRAIN
        Pane zoneTerrain = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

       //zoneTerrain.setLayoutX(635);
        //zoneTerrain.setLayoutY(315);

        zoneTerrain.setLayoutX(width*0.47);
        zoneTerrain.setLayoutY(height*0.4);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zoneTerrain.setPrefSize(width*0.22,height*0.5);
        zoneTerrain.setBorder(border1);

        zoneTerrain.getChildren().add(textTerrain);
        this.getChildren().add(zoneTerrain);

    }

    public void RectangleGare(){

        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(120);
        textGare.setLayoutY(15);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textGare);



        ////////////////////CREATION D'UN PANEL POUR LA ZONE GARE
        Pane zoneGare = new Pane() ;
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
        this.getChildren().add(zoneGare);
        //TAILLE DU RECTANGLE ET POSITION

  /*      rect_gare.setWidth(305);
        rect_gare.setX(950);
        rect_gare.setY(315);

        //COULEUR ET CONTOUR
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);

        this.getChildren().add(rect_gare);*/
    }


    public void RectangleCompagnies(){

        //Ajout d'un label "COMPAGNIES"
        Label textCompagnies = new Label("COMPAGNIES");
        textCompagnies.setLayoutX(100);
        textCompagnies.setLayoutY(15);
        textCompagnies.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

////////////////////CREATION D'UN PANEL POUR LA ZONE GARE
        Pane zoneCompa = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        zoneCompa.setLayoutX(950);
        zoneCompa.setLayoutY(435);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zoneCompa.setPrefSize(width*0.22,height*0.15);
        zoneCompa.setBorder(border1);

        zoneCompa.getChildren().add(textCompagnies);
        this.getChildren().add(zoneCompa);

    }

    public void RectangleCartePrison(){

        //Ajout d'un label "Vous êtes libéré de prison"
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" :");
        textPrison.setLayoutX(20);
        textPrison.setLayoutY(20);
        textPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));


////////////////////CREATION D'UN PANEL POUR LA ZONE GARE
        Pane zonePrison = new Pane() ;
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
        this.getChildren().add(zonePrison);


        //TAILLE DU RECTANGLE ET POSITION
/*
        rect_cartePrison.setHeight(50);
        rect_cartePrison.setWidth(305);
        rect_cartePrison.setX(950);
        rect_cartePrison.setY(535);

        //COULEUR ET CONTOUR
        rect_cartePrison.setFill(Color.TRANSPARENT);
        rect_cartePrison.setStroke(Color.BLACK);
        this.getChildren().add(rect_cartePrison);*/
}

}
