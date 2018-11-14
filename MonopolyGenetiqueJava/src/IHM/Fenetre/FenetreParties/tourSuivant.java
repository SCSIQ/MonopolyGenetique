package IHM.Fenetre.FenetreParties;

import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class tourSuivant extends Parent {

    public tourSuivant(Stage fenetre_actuelle, Canvas canvas, Automate automate)
    {

//////////////////////////////////////////////////////////////////////////TEXTE
        Text t_tour = new Text("Tour suivant en cours de codage");

        t_tour.setLayoutX(120);
        t_tour.setLayoutY(70);

        t_tour.setScaleX(2);
        t_tour.setScaleY(2);

//////////////////////////////////////////////////////////////////////////BOUTON

        Button bt_ok = new Button("ok");

        bt_ok.setLayoutX(130);
        bt_ok.setLayoutY(120);

        bt_ok.setPrefSize(150, 10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();


            }
        });

  ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(220);
        fenetre_actuelle.setMinWidth(420);

        fenetre_actuelle.setMaxHeight(220);
        fenetre_actuelle.setMaxWidth(420);

        //AJOUT
        this.getChildren().add(t_tour);
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

