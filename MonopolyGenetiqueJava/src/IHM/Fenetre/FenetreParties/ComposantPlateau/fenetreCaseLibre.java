package IHM.Fenetre.FenetreParties.ComposantPlateau;

//importation mise par Jérémy
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
import javafx.stage.WindowEvent;

//PERMET DE PROPOSER QUE L'UTILISATEUR ACHETE LA CASE SI ELLE EST LIBRE
public class fenetreCaseLibre extends Parent {

    public fenetreCaseLibre(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu)
    {


        Label l = new Label("Vous êtes sur la case :\n"+plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType());

        l.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        l.setLayoutX(170);
        l.setLayoutY(50);

        l.setScaleX(2);
        l.setScaleY(2);

//////////////////////////////////////////////////////////////////////////BOUTON
        Button bt_ok = new Button("Ok");

        bt_ok.setLayoutX(200);
        bt_ok.setLayoutY(160);

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
        fenetre_actuelle.setMinHeight(250);
        fenetre_actuelle.setMinWidth(550);

        fenetre_actuelle.setMaxHeight(250);
        fenetre_actuelle.setMaxWidth(550);

        /////////////////////////////////////////////////////////////////////////AJOUT
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
