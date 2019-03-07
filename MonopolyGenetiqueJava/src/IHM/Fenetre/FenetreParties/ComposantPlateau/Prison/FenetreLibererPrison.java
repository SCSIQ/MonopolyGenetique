package IHM.Fenetre.FenetreParties.ComposantPlateau.Prison;

import IHM.Fenetre.FenetreParties.Jeu;
import IHM.Fenetre.FenetreParties.Pion;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class FenetreLibererPrison extends  Parent {

    //ATTRIBUTS
    private Canvas canvas ;

    public FenetreLibererPrison(Stage fenetre_actuelle, Canvas canvas, Automate automate){
        //initialisation
        this.canvas = canvas ;

//////////////////////////LABEL
        Label l_prison = new Label("  Vous avez fait un double, \nVous êtes libéré de prison !") ;


        l_prison.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l_prison.setLayoutX(110);
        l_prison.setLayoutY(45);

        l_prison.setScaleX(2);
        l_prison.setScaleY(2);

/////////////////////////BOUTON
        Button bt_ok = new Button("OK");
        bt_ok.setLayoutX(135);
        bt_ok.setLayoutY(110);

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
        fenetre_actuelle.setMinHeight(200);
        fenetre_actuelle.setMinWidth(420);

        fenetre_actuelle.setMaxHeight(200);
        fenetre_actuelle.setMaxWidth(420);

        //Ajout
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
