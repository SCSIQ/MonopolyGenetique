package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.PossessionAdv;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZonePossessions;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DetailCompagnie extends Parent {

    private PossessionAdv possAd ;
    private Pane zoneInfos;
    private int numBouton;
    private ZonePossessions poss ;


    public DetailCompagnie(Automate automate, Stage fenetre_detail , Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton, PossessionAdv possAd, boolean joueurCourant)
    {

        this.possAd = possAd ;
        this.poss=poss;
        zoneInfos = new Pane();
        this.numBouton=numBouton;

        //si il s'agit d'une possession du joueur courant
        if(joueurCourant==true) {

            Button nomCompagnie = new Button(poss.getListeCompagnies().get(numBouton).toString().toUpperCase());

            nomCompagnie.setLayoutY(10);
            nomCompagnie.setLayoutX(10);
            nomCompagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));
            nomCompagnie.setBackground(new Background(new BackgroundFill(Color.rgb(247,247,247), null, null)));
            nomCompagnie.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,null)));
            nomCompagnie.setPrefSize(455,50);

            gestion(automate, true);


            ///BOUTON
            Button bt_ok = new Button("revenir au jeu");

            bt_ok.setLayoutX(160);
            bt_ok.setLayoutY(290);

            bt_ok.setPrefSize(150, 10);

            bt_ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //on rend la bonne opacité à la fenêtre
                    detruireCanvas(canvas);

                    //on ferme la fenêtre
                    fenetre_detail.close();
                }
            });

            /////////TAILLE MIN ET MAX DE LA FENETRE
            fenetre_detail.setMinHeight(400);
            fenetre_detail.setMinWidth(500);

            fenetre_detail.setMaxHeight(400);
            fenetre_detail.setMaxWidth(500);
            ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
            fenetre_detail.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    event.consume();
                }
            });

            this.getChildren().add(bt_ok);
            this.getChildren().add(nomCompagnie);
        } else {

            Button nomCompagnie = new Button(possAd.getListeCompagnies().get(numBouton).toString().toUpperCase());

            nomCompagnie.setLayoutY(10);
            nomCompagnie.setLayoutX(10);
            nomCompagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));
            nomCompagnie.setBackground(new Background(new BackgroundFill(Color.rgb(247,247,247), null, null)));
            nomCompagnie.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,null)));
            nomCompagnie.setPrefSize(455,50);

            gestion(automate, false);

            //BOUTON
            Button bt_ok = new Button("revenir au jeu");

            bt_ok.setLayoutX(160);
            bt_ok.setLayoutY(290);

            bt_ok.setPrefSize(150, 10);

            bt_ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //on rend la bonne opacité à la fenêtre
                    detruireCanvas(canvas);

                    //on ferme la fenêtre
                    fenetre_detail.close();
                }
            });

            ///////////TAILLE FENETRE
            /////////TAILLE MIN ET MAX DE LA FENETRE
            fenetre_detail.setMinHeight(400);
            fenetre_detail.setMinWidth(500);

            fenetre_detail.setMaxHeight(400);
            fenetre_detail.setMaxWidth(500);
            ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
            fenetre_detail.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    event.consume();
                }
            });

            this.getChildren().add(bt_ok);
            this.getChildren().add(nomCompagnie);
        }

    }

    public void gestion(Automate automate, boolean joueurCourant) {
        zoneInfos.setLayoutX(10);
        zoneInfos.setLayoutY(80);

        if (joueurCourant == true) {
            Label compagnie = new Label("Votre loyer :\n\n"+
                    "      Si vous possédez 1 compagnie  : \n                       100*montant des dés\n\n" +
                    "      Si vous possédez 2 compagnies : \n                       200*montant des dés");

            compagnie.setLayoutX(20);
            compagnie.setLayoutY(20);

            compagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

            zoneInfos.getChildren().add(compagnie);
        }
        else {
            Label compagnie = new Label("Loyer :\n\n"+
                    "      Si ce joueur possède 1 compagnie  : \n                       100*montant des dés\n\n"+
                    "      Si ce joueur possède 2 compagnies : \n                       200*montant des dés\n\n");

            compagnie.setLayoutX(20);
            compagnie.setLayoutY(20);

            compagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

            zoneInfos.getChildren().add(compagnie);
        }

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_comp = new Rectangle();
        rect_comp.setFill(Color.TRANSPARENT);
        rect_comp.setStroke(Color.BLACK);
        rect_comp.setHeight(200);
        rect_comp.setWidth(455);
        rect_comp.setX(0);
        rect_comp.setY(0);

        zoneInfos.getChildren().add(rect_comp);
        this.getChildren().add(zoneInfos);
    }


    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
