package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.*;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
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
            Text t_lancer = new Text("Tour n° "+automate.getNumTour());

            t_lancer.setLayoutX(250);
            t_lancer.setLayoutY(100);

            t_lancer.setScaleX(2);
            t_lancer.setScaleY(2);

            Text t_Joueur = new Text("Début du tour de "+automate.getJoueurCourant().getNom());

            t_Joueur.setLayoutX(220);
            t_Joueur.setLayoutY(150);

            t_Joueur.setScaleY(2);
            t_Joueur.setScaleX(2);

            //AJOUT
            this.getChildren().add(t_lancer);
            this.getChildren().add((t_Joueur));

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

                //Si le joueur est sur la case prison
                if(automate.getJoueurCourant().getPion().getCase().getPosition()==10)
                {
                    //si il n'est pas en visite simple
                    if(automate.getJoueurCourant().getEstEnPrison()==true)
                    {
                        fenetreEnPrison(fenetre_actuelle, automate, zoneJoueur, zoneAd);
                    }
                }




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


    public void fenetreEnPrison(Stage fenetre_actuelle, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
       // jeu.fenetreNoire();

        Stage nouvelle_fenetre_prison = new Stage();
        FenetrePrison fenetrePrison= new FenetrePrison(nouvelle_fenetre_prison,canvas, automate, plateauJeu, zoneJoueur, jeu, poss,  zoneAd, pion);

        Scene nouvelle_scene = new  Scene(fenetrePrison,650,550);

        nouvelle_fenetre_prison.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_prison.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_prison.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_prison.show();
    }

}

