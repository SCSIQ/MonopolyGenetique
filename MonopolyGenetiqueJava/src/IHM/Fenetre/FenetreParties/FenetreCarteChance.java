package IHM.Fenetre.FenetreParties;


import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneInfoJoueur;
import Metier.Automate.Automate;
import Metier.Plateau.ListeCartes.Chance;
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
import javafx.stage.WindowEvent;

public class FenetreCarteChance extends Parent {

    //ATTRIBUTS
    private Canvas canvas ;
    private ZoneInfoJoueur zoneJoueur ;
    private ZoneAdversaires zoneAd ;

    public FenetreCarteChance(Stage fenetre_actuelle, Canvas canvas, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        //initialisation
        this.canvas = canvas ;
        this.zoneAd= zoneAd ;
        this.zoneJoueur = zoneJoueur ;

        //LABEL CARTE CHANCE :
        Label carte_chance = new Label("Carte Chance");

        carte_chance.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        carte_chance.setLayoutX(205);
        carte_chance.setLayoutY(20);

        carte_chance.setScaleX(2);
        carte_chance.setScaleY(2);

        //BOUTON OK
        Button bt_ok= new Button("OK");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(210);

        bt_ok.setPrefSize(150, 10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on remet à jour l'argent du joueur courant
                zoneJoueur.SupprimerJoueur();
                zoneJoueur.genereInfosJoueur(automate);

                //Met à jour les adversaires :
                zoneAd.SupprimerAdversaire();
                zoneAd.genererAdversaire(automate, fenetre_actuelle);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });



        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(520);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(520);

        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        //AJOUT
        this.getChildren().add(bt_ok);
        this.getChildren().add(carte_chance);


    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
