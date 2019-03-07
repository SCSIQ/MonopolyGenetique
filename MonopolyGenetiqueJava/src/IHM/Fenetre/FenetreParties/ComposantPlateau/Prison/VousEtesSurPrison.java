package IHM.Fenetre.FenetreParties.ComposantPlateau.Prison;

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



public class VousEtesSurPrison extends Parent {

    //ATTRIBUTS
    private Canvas canvas ;

    public VousEtesSurPrison(Stage fenetre_actuelle, Canvas canvas, Automate automate)
    {
        //initialisation
        this.canvas = canvas ;

//////////////////////////////////////////////////////////////////////////TITRE ET RECTANGLE
        Button bt_lance = new Button("ATTENTION");

        bt_lance.setLayoutY(10);
        bt_lance.setLayoutX(10);
        bt_lance.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_lance.setTextFill(Color.WHITE);
        bt_lance.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        bt_lance.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));

        //RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);
        bt_lance.setPrefSize(475,50);


//////////////////////////LABEL
        Label l_prison = new Label("Vous êtes en prison !") ;

        l_prison.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l_prison.setLayoutX(180);
        l_prison.setLayoutY(120);

        l_prison.setTextFill(Color.RED);

        l_prison.setScaleX(2);
        l_prison.setScaleY(2);

/////////////////////////BOUTON
        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

        bt_ok.setPrefSize(120, 10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });


///////////////////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);

        //Ajout
        this.getChildren().add(r_fond);
        this.getChildren().add(bt_lance);
        this.getChildren().add(bt_ok);
        this.getChildren().add(l_prison);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
