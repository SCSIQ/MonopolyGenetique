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

        Pane zonePoss = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

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
        this.getChildren().add(zonePoss);

      /*  Rectangle rect_possession = new Rectangle();
        //TAILLE DU RECTANGLE ET POSITION

        rect_possession.setHeight(425);
        rect_possession.setWidth(630);
        rect_possession.setX(630);
        rect_possession.setY(275);

        //COULEUR ET CONTOUR
        rect_possession.setFill(Color.TRANSPARENT);
        rect_possession.setStroke(Color.BLACK);

        this.getChildren().add(rect_possession);*/
    }

    public void RectangleTerrain(){

        Rectangle rect_terrain = new Rectangle();
        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(750);
        textTerrain.setLayoutY(320);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textTerrain);

        //TAILLE DU RECTANGLE ET POSITION

        rect_terrain.setHeight(370);
        rect_terrain.setWidth(305);
        rect_terrain.setX(635);
        rect_terrain.setY(315);

        //COULEUR ET CONTOUR
        rect_terrain.setFill(Color.TRANSPARENT);
        rect_terrain.setStroke(Color.BLACK);

        this.getChildren().add(rect_terrain);
    }

    public void RectangleGare(){

        Rectangle rect_gare = new Rectangle();
        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(1080);
        textGare.setLayoutY(320);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textGare);

        //TAILLE DU RECTANGLE ET POSITION

        rect_gare.setHeight(100);
        rect_gare.setWidth(305);
        rect_gare.setX(950);
        rect_gare.setY(315);

        //COULEUR ET CONTOUR
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);

        this.getChildren().add(rect_gare);
    }


    public void RectangleCompagnies(){
        Rectangle rect_compagnie = new Rectangle();

        //Ajout d'un label "COMPAGNIES"
        Label textCompagnies = new Label("COMPAGNIES");
        textCompagnies.setLayoutX(1050);
        textCompagnies.setLayoutY(435);
        textCompagnies.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textCompagnies);


        //TAILLE DU RECTANGLE ET POSITION

        rect_compagnie.setHeight(100);
        rect_compagnie.setWidth(305);
        rect_compagnie.setX(950);
        rect_compagnie.setY(425);

        //COULEUR ET CONTOUR
        rect_compagnie.setFill(Color.TRANSPARENT);
        rect_compagnie.setStroke(Color.BLACK);
        this.getChildren().add(rect_compagnie);
    }

    public void RectangleCartePrison(){

        Rectangle rect_cartePrison = new Rectangle();
        //Ajout d'un label "Vous êtes libéré de prison"
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" :");
        textPrison.setLayoutX(995);
        textPrison.setLayoutY(550);
        textPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(textPrison);

        //TAILLE DU RECTANGLE ET POSITION

        rect_cartePrison.setHeight(50);
        rect_cartePrison.setWidth(305);
        rect_cartePrison.setX(950);
        rect_cartePrison.setY(535);

        //COULEUR ET CONTOUR
        rect_cartePrison.setFill(Color.TRANSPARENT);
        rect_cartePrison.setStroke(Color.BLACK);
        this.getChildren().add(rect_cartePrison);
}

}
