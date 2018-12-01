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

        Label l = new Label("Vous êtes sur la case :\n"+plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType()+
                                    "\n\nElle n'appartient à personne.\n\nElle coûte X");
        l.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l.setLayoutX(170);
        l.setLayoutY(50);

        l.setScaleX(2);
        l.setScaleY(2);

//////////////////////////////////////////////////////////////////////////BOUTON
        Button bt_acheter= new Button("ACHETER");

        bt_acheter.setLayoutX(50);
        bt_acheter.setLayoutY(210);

        bt_acheter.setPrefSize(150, 10);

        bt_acheter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });

        Button bt_rien= new Button("NE RIEN FAIRE");

        bt_rien.setLayoutX(300);
        bt_rien.setLayoutY(210);

        bt_rien.setPrefSize(150, 10);

        bt_rien.setOnAction(new EventHandler<ActionEvent>() {
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
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(500);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(500);

        /////////////////////////////////////////////////////////////////////////AJOUT
        this.getChildren().add(l);
        this.getChildren().add(bt_acheter);
        this.getChildren().add(bt_rien);


    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
