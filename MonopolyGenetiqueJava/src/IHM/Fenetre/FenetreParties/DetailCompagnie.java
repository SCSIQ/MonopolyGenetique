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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DetailCompagnie extends Parent {

    private PossessionAdv possAd ;

    public DetailCompagnie(Automate automate, Stage fenetre_detail , Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton, PossessionAdv possAd, boolean joueurCourant)
    {

        this.possAd = possAd ;

        //si il s'agit d'une possession du joueur courant
        if(joueurCourant==true) {
            Label nomCompagnie = new Label(poss.getListeCompagnies().get(numBouton).toString().toUpperCase() + "");

            nomCompagnie.setLayoutY(20);
            nomCompagnie.setLayoutX(80);
            nomCompagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));

            Button bt_ok = new Button("revenir au jeu");

            bt_ok.setLayoutX(180);
            bt_ok.setLayoutY(530);

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
            Label nomCompagnie = new Label(possAd.getListeCompagnies().get(numBouton).toString().toUpperCase() + "");

            nomCompagnie.setLayoutY(20);
            nomCompagnie.setLayoutX(80);
            nomCompagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));

            Button bt_ok = new Button("revenir au jeu");

            bt_ok.setLayoutX(180);
            bt_ok.setLayoutY(530);

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

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
