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

public class LancerDe extends Parent {

    public LancerDe(Stage fenetre_actuelle, Canvas canvas, Automate automate)
    {
//////////////////////////////////////////////////////////////////////////TEXTE
            //récupération de la valeur des dés

        //System.out.println("VRAI OU FAUX "+automate.getJoueurCourant().getaLanceDes());
            Integer dé = automate.getJoueurCourant().getResLanceDes();

            //System.out.println("Res dès J from IHM : "+dé);

            Text t_nb = new Text("Vous avez fait : \n" + dé.toString());

            t_nb.setLayoutX(25);
            t_nb.setLayoutY(25);

//////////////////////////////////////////////////////////////////////////BOUTON
            Button bt_ok = new Button("Ok");

            bt_ok.setLayoutX(25);
            bt_ok.setLayoutY(50);

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
