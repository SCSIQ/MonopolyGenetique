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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenetreFaillite_1 extends Parent {

    public FenetreFaillite_1(Stage nouvelle_fenetre_faillite, Canvas canvas, Automate automate, ZoneInfoJoueur zoneJoueur,ZoneAdversaires zoneAd) {
        automate.evoluer("Faillite");

        /////////////////////////////LABELS

        Label l_faille = new Label("Vous n'avez pas assez d'argent pour payer ! ");
        Label l_perdu = new Label("PERDU...");


        l_faille.setFont(Font.font("Verdana", FontWeight.BOLD, 19));

        l_faille.setLayoutX(20);
        l_faille.setLayoutY(60);



        Color rouge = Color.RED;
        l_perdu.setTextFill(rouge);
        l_perdu.setFont(Font.font("Verdana", FontWeight.BOLD, 30));

        l_perdu.setLayoutY(120);
        l_perdu.setLayoutX(160);

        //BOUTON OK
        Button bt_ok = new Button("OK");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

        bt_ok.setPrefSize(150, 10);


        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);


                //on ferme la fenêtre
                nouvelle_fenetre_faillite.close();
            }
        });


        /////////TAILLE MIN ET MAX DE LA FENETRE
        nouvelle_fenetre_faillite.setMinHeight(300);
        nouvelle_fenetre_faillite.setMinWidth(515);

        nouvelle_fenetre_faillite.setMaxHeight(300);
        nouvelle_fenetre_faillite.setMaxWidth(515);


        //AJOUT
        this.getChildren().add(l_faille);
        this.getChildren().add(l_perdu);
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
