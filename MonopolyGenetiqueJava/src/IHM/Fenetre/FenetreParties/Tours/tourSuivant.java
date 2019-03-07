package IHM.Fenetre.FenetreParties.Tours;

import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.PlateauJeu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneInfoJoueur;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZonePossessions;
import IHM.Fenetre.FenetreParties.Jeu;
import IHM.Fenetre.FenetreParties.Pion;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class tourSuivant extends Parent {

    private Canvas canvas ;
    private Jeu jeu ;
    private ZonePossessions poss ;
    private PlateauJeu plateauJeu ;
    private ZoneAdversaires zoneAd ;
    private ZoneInfoJoueur zoneJoueur ;
    private Pion pion ;

    public tourSuivant(Stage fenetre_actuelle, Canvas canvas, Automate automate, Jeu jeu, PlateauJeu plateauJeu, ZonePossessions poss, ZoneAdversaires zonAd, ZoneInfoJoueur zoneJoueur, Pion pion)
    {
        //INITIATION
        this.canvas = canvas ;
        this.jeu = jeu ;
        this.plateauJeu =plateauJeu;
        this.poss = poss ;
        this.zoneAd =zoneAd ;
        this.zoneJoueur= zoneJoueur ;
        this.pion = pion ;

 ////////////////////////////////////////////////////////////////////TEXTE
        //TITRE
        Button l = new Button("TOUR N°"+automate.getNumTour());
        l.setLayoutY(10);
        l.setLayoutX(10);
        l.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        l.setPrefSize(475,50);
        l.setTextFill(Color.WHITE);
        l.setBackground(new Background(new BackgroundFill(Color.rgb(9,172,227), null, null)));

        //RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //CONTENU


            Text t_Joueur = new Text("Début du tour de "+automate.getJoueurCourant().getNom());

            t_Joueur.setLayoutX(140);
            t_Joueur.setLayoutY(130);

            t_Joueur.setScaleY(2);
            t_Joueur.setScaleX(2);
            t_Joueur.setText(t_Joueur.getText().toUpperCase());

            //AJOUT
            this.getChildren().add(r_fond);
            this.getChildren().add(l);
            this.getChildren().add((t_Joueur));

//////////////////////////////////////////////////////////////////BOUTON
        Button bt_ok = new Button("OK");

        bt_ok.setLayoutX(170);
        bt_ok.setLayoutY(190);

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
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);

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

