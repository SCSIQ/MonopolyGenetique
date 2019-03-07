package IHM.Fenetre.FenetreParties;

import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class PasAssezArgent extends Parent {

    public PasAssezArgent(Automate automate, Stage fenetre_actuelle, Canvas canvas )
    {

        Label l = new Label("Vous n'avez pas assez d'argent !!");
        Button bt_ok = new Button("ok");

        l.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l.setLayoutX(130);
        l.setLayoutY(50);

        l.setScaleX(2);
        l.setScaleY(2);

        Color rouge = Color.RED;
        l.setTextFill(rouge);


        bt_ok.setLayoutX(170);
        bt_ok.setLayoutY(100);

        bt_ok.setPrefSize(150, 10);

        //ACTION BOUTON
        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });

        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(200);
        fenetre_actuelle.setMinWidth(500);

        fenetre_actuelle.setMaxHeight(200);
        fenetre_actuelle.setMaxWidth(500);


        //AJOUT

        this.getChildren().add(l);
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
