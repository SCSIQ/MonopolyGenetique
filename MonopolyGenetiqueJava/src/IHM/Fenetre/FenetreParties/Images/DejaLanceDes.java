package IHM.Fenetre.FenetreParties.Images;

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


public class DejaLanceDes extends Parent {

    public DejaLanceDes(Stage fenetre_actuelle, Canvas canvas){
//////////////////////////////////////////////////////////////////////////TEXTE
        Color rouge = Color.RED;

        Text t_nb = new Text("VOUS AVEZ DEJA LANCE LES DES !!!" );

        t_nb.setFill(rouge);

        t_nb.setScaleX(2);
        t_nb.setScaleY(2);

        t_nb.setLayoutX(50);
        t_nb.setLayoutY(25);

//////////////////////////////////////////////////////////////////////////BOUTON
        Button bt_ok = new Button("Ok");

        bt_ok.setLayoutX(100);
        bt_ok.setLayoutY(100);

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

        /////////////////////////////////////////////////////////////////////////AJOUT
        this.getChildren().add(t_nb);
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
