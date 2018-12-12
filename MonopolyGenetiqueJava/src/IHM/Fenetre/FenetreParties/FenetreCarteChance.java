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
import javafx.scene.shape.Rectangle;
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
        Label carte_chance = new Label("CARTE CHANCE");
        carte_chance.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        carte_chance.setLayoutX(205);
        carte_chance.setLayoutY(27);
        carte_chance.setScaleX(2);
        carte_chance.setScaleY(2);
        carte_chance.setTextFill(Color.WHITE);

        //CONTENU
        Label l_contenu = new Label("Cette case n'a pour l'instant aucun effet.");
        l_contenu.setLayoutX(100);
        l_contenu.setLayoutY(100);

        l_contenu.setScaleX(1.5);
        l_contenu.setScaleY(1.5);

        //RECTANGLE
        Rectangle r_chance = new Rectangle();
        r_chance.setHeight(50);
        r_chance.setWidth(475);
        r_chance.setLayoutX(10);
        r_chance.setLayoutY(10);
        r_chance.setStroke(Color.BLACK);
        r_chance.setStrokeWidth(1);
        r_chance.setFill(Color.rgb(200, 27, 31));

        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //BOUTON OK
        Button bt_ok= new Button("OK");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

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
              /*  zoneAd.SupprimerAdversaire();
                zoneAd.genererAdversaire(automate, fenetre_actuelle);*/

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });



        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);

        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        //AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(r_chance);
        this.getChildren().add(bt_ok);
        this.getChildren().add(carte_chance);
        this.getChildren().add(l_contenu);


    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
