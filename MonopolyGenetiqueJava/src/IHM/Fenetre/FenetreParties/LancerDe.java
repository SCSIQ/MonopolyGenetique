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

            Integer score = automate.getJoueurCourant().getResLanceDes();
            Integer dé1 = automate.getJoueurCourant().getResDes1();
            Integer dé2 = automate.getJoueurCourant().getResDes2();
            Text t_nb = new Text("Vous avez fait : \n" +"     "+ dé1.toString()+" + "+dé2.toString()+" = "+score.toString());

            t_nb.setLayoutX(160);
            t_nb.setLayoutY(70);

            t_nb.setScaleX(2);
            t_nb.setScaleY(2);

//////////////////////////////////////////////////////////////////////////BOUTON
            Button bt_ok = new Button("Ok");

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
