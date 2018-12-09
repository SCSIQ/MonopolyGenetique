package IHM.Fenetre.FenetreParties;

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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DetailGare extends Parent {


    private Pane zoneInfos ;
    private int numBouton ;
    private ZonePossessions poss ;

    public DetailGare(Automate automate, Stage fenetre_detail , Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton){

        this.numBouton = numBouton ;
        this.poss = poss ;
        zoneInfos =new Pane() ;


        Label nomGare = new Label(poss.getListeGares().get(numBouton).toString().toUpperCase()+"");

        nomGare.setLayoutY(20);
        nomGare.setLayoutX(80);
        nomGare.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));

        gestion(automate);

        Button bt_ok = new Button("revenir au jeu");

        bt_ok.setLayoutX(180);
        bt_ok.setLayoutY(500);

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
        fenetre_detail.setMinHeight(600);
        fenetre_detail.setMinWidth(500);

        fenetre_detail.setMaxHeight(600);
        fenetre_detail.setMaxWidth(500);

        this.getChildren().add(bt_ok);
        this.getChildren().add(nomGare);

    }

    public void gestion(Automate automate){
        zoneInfos.setLayoutX(10);
        zoneInfos.setLayoutY(130);

        Label gare = new Label("Votre loyer avec une gare : "+poss.getListeGares().get(numBouton).getLoyer()+"\n €"+
                                    "Si vous possédez 2 gares : \n" +
                                    "Si vous possèdez 3 gares : \n"+
                                    "Si vous avez les 4 gares :  ");


        gare.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_gare = new Rectangle();
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);
        rect_gare.setHeight(250);
        rect_gare.setWidth(450);
        rect_gare.setX(0);
        rect_gare.setY(0);

        zoneInfos.getChildren().add(rect_gare);
        zoneInfos.getChildren().add(gare);
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
