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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class PossessionAdv extends Parent {

    public PossessionAdv(Stage nouvelle_fenetre_menu, Stage fenetre_actuelle, Canvas canvas, Automate automate,int i)
    {
        Text t_adv1 = new Text("Possession de "+automate.getListeJoueurs().get(i).getNom());
        t_adv1.setScaleX(2);
        t_adv1.setScaleY(2);
        t_adv1.setLayoutX(250);
        t_adv1.setLayoutY(30);
        this.getChildren().add(t_adv1);

        Rectangle rect_possession = new Rectangle();
        //TAILLE DU RECTANGLE ET POSITION

        rect_possession.setHeight(439);
        rect_possession.setWidth(630);
        rect_possession.setX(10);
        rect_possession.setY(70);

        //COULEUR ET CONTOUR
        rect_possession.setFill(Color.TRANSPARENT);
        rect_possession.setStroke(Color.BLACK);
        this.getChildren().add(rect_possession);

        RectangleTerrain();
        RectangleGare();
        RectangleCompagnies();
        RectangleCartePrison();

        Button bt_ok = new Button("revenir au jeu");

        bt_ok.setLayoutX(270);
        bt_ok.setLayoutY(530);

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
////////BLOCAGE REDUCTION

        nouvelle_fenetre_menu.setMinWidth(680);
        nouvelle_fenetre_menu.setMinHeight(630);

        nouvelle_fenetre_menu.setMaxWidth(680);
        nouvelle_fenetre_menu.setMaxHeight(630);

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        nouvelle_fenetre_menu.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

    }

    public void RectangleTerrain(){

        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(115);
        textTerrain.setLayoutY(95);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        this.getChildren().add(textTerrain);

        Rectangle rect_terrain = new Rectangle();
        rect_terrain.setHeight(410);
        rect_terrain.setWidth(305);
        rect_terrain.setX(15);
        rect_terrain.setY(85);

        //COULEUR ET CONTOUR
        rect_terrain.setFill(Color.TRANSPARENT);
        rect_terrain.setStroke(Color.BLACK);

        this.getChildren().add(rect_terrain);
    }

    public void RectangleGare(){

        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(450);
        textGare.setLayoutY(105);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textGare);

        //TAILLE DU RECTANGLE ET POSITION

        Rectangle rect_gare  = new Rectangle();
        rect_gare.setWidth(305);
        rect_gare.setHeight(210);
        rect_gare.setX(330);
        rect_gare.setY(85);

        //COULEUR ET CONTOUR
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);

        this.getChildren().add(rect_gare);

    }


    public void RectangleCompagnies(){

        //Ajout d'un label "COMPAGNIES"
        Label textCompagnies = new Label("COMPAGNIES");
        textCompagnies.setLayoutX(420);
        textCompagnies.setLayoutY(315);
        textCompagnies.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        this.getChildren().add(textCompagnies);
////////////////////CREATION D'UN PANEL POUR LA ZONE GARE

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_compagnie = new Rectangle();
        rect_compagnie.setHeight(130);
        rect_compagnie.setWidth(305);
        rect_compagnie.setX(330);
        rect_compagnie.setY(310);

        //COULEUR ET CONTOUR
        rect_compagnie.setFill(Color.TRANSPARENT);
        rect_compagnie.setStroke(Color.BLACK);
        this.getChildren().add(rect_compagnie);
    }

    public void RectangleCartePrison(){

        //Ajout d'un label "Vous êtes libéré de prison"
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" :");
        textPrison.setLayoutX(400);
        textPrison.setLayoutY(460);
        textPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(textPrison);

////////////////////CREATION D'UN PANEL POUR LA ZONE GARE

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_cartePrison = new Rectangle();
        rect_cartePrison.setHeight(50);
        rect_cartePrison.setWidth(305);
        rect_cartePrison.setX(330);
        rect_cartePrison.setY(445);

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
