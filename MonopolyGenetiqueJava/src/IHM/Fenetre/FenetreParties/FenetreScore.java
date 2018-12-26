package IHM.Fenetre.FenetreParties;

import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetreScore extends Parent {

    private Canvas canvas ;

    public FenetreScore(Stage fenetre, Canvas canvas, Jeu jeu, Automate automate)
    {
        //initialisation
        this.canvas = canvas ;

        //Label (avec bouton pour centrer le texte)
        Button bt_Score= new Button("SCORE");
        bt_Score.setLayoutY(10);
        bt_Score.setLayoutX(10);
        bt_Score.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        bt_Score.setBackground(new Background(new BackgroundFill( Color.rgb(9,172,227),null, null)));
        bt_Score.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        bt_Score.setTextFill(Color.WHITE);
        bt_Score.setPrefSize(465,50);

        //RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(545);
        r_fond.setWidth(465);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //Bouton
        Button bt_ok = new Button("REVENIR AU JEU");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(515);

        bt_ok.setPrefSize(150, 10);


        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);


                //on ferme la fenêtre
                fenetre.close();
            }
        });

        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre.setMinHeight(600);
        fenetre.setMinWidth(500);

        fenetre.setMaxHeight(600);
        fenetre.setMaxWidth(500);

        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        //Ajout
        this.getChildren().add(bt_Score);
        this.getChildren().add(r_fond) ;
        this.getChildren().add(bt_ok);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

}
