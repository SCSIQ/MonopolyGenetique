package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class PossessionAdv extends Parent {

    public PossessionAdv(Stage primaryStage, Stage nouvelle_fenetre_menu, Stage fenetre_actuelle, Canvas canvas, Automate automate)
    {
        Rectangle rect_possession = new Rectangle();
        //TAILLE DU RECTANGLE ET POSITION

        rect_possession.setHeight(429);
        rect_possession.setWidth(630);
        rect_possession.setX(10);
        rect_possession.setY(10);

        //COULEUR ET CONTOUR
        rect_possession.setFill(Color.TRANSPARENT);
        rect_possession.setStroke(Color.BLACK);
        this.getChildren().add(rect_possession);

        RectangleTerrain();
        RectangleGare();
        RectangleCompagnies();
        RectangleCartePrison();

        Button bt_ok = new Button("Ok");

        bt_ok.setLayoutX(270);
        bt_ok.setLayoutY(550);

        bt_ok.setPrefSize(150, 10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                nouvelle_fenetre_menu.close();
            }
        });

        this.getChildren().add(bt_ok);

    }

    public void RectangleTerrain(){

        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(55);
        textTerrain.setLayoutY(15);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        this.getChildren().add(textTerrain);

        Rectangle rect_terrain = new Rectangle();
        rect_terrain.setHeight(390);
        rect_terrain.setWidth(305);
        rect_terrain.setX(10);
        rect_terrain.setY(10);

        //COULEUR ET CONTOUR
        rect_terrain.setFill(Color.TRANSPARENT);
        rect_terrain.setStroke(Color.BLACK);

        this.getChildren().add(rect_terrain);
    }

    public void RectangleGare(){

        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(100);
        textGare.setLayoutY(325);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textGare);

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

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
