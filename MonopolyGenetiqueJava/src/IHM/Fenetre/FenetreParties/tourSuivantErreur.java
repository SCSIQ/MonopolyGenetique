package IHM.Fenetre.FenetreParties;

import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class tourSuivantErreur extends Parent {

    public tourSuivantErreur(Stage fenetre_actuelle, Canvas canvas, Automate automate) {


        //////////////////////////////////////////////////////////////////////////TEXTE
        Color rouge = Color.RED;
        Text t_lancerDeFalse = new Text("VOUS DEVEZ LANCER LES DÉS.");

        t_lancerDeFalse.setFill(rouge);
        t_lancerDeFalse.setLayoutX(220);
        t_lancerDeFalse.setLayoutY(100);

        t_lancerDeFalse.setScaleX(2);
        t_lancerDeFalse.setScaleY(2);
        t_lancerDeFalse.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        //AJOUT
        this.getChildren().add(t_lancerDeFalse);

        //////////////////////////////////////////////////////////////////BOUTON
        Button bt_ok = new Button("OK");

        bt_ok.setLayoutX(230);
        bt_ok.setLayoutY(220);

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
        fenetre_actuelle.setMinHeight(320);
        fenetre_actuelle.setMinWidth(620);

        fenetre_actuelle.setMaxHeight(320);
        fenetre_actuelle.setMaxWidth(620);

        //AJOUT

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
