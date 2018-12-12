package IHM.Fenetre.FenetreParties.ComposantPlateau;

import IHM.Fenetre.FenetreParties.Jeu;
import IHM.Fenetre.FenetreParties.LancerDe;
import IHM.Fenetre.FenetreParties.Pion;
import Metier.Automate.Automate;
import Metier.Plateau.ListeTaxes.Taxes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetrePrison extends Parent {

    //ATTRIBUTS
    private Canvas canvas ;
    private ZoneInfoJoueur zoneJoueur ;
    private ZoneAdversaires zoneAd;
    private ZonePossessions poss ;
    private Jeu jeu ;

    public FenetrePrison(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur, Jeu jeu,ZonePossessions poss,  ZoneAdversaires zoneAd, Pion pion){

        //INITIALISATION
        this.canvas = canvas ;
        this.zoneJoueur =zoneJoueur;
        this.zoneAd = zoneAd ;
        this.poss = poss ;

        Label l = new Label("Vous êtes sur la case :\n"+plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType()+
                "\n\nVous devez faire un double pour sortir\ndès le prochain tour !" +"Vous avez 3 chances.\n\nPasser ces 3 tours, vous devrez payer 500 €." );
        l.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l.setLayoutX(180);
        l.setLayoutY(60);

        l.setScaleX(2);
        l.setScaleY(2);

        ////////////////////////////BOUTON
        Button bt_payer= new Button("PAYER");

        bt_payer.setLayoutX(50);
        bt_payer.setLayoutY(400);

        bt_payer.setPrefSize(150, 10);

        bt_payer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });
/////////////////////////////////////BOUTON LANCER LES DES
       Button bt_lancerDes = new Button("LANCER LES DES");

        bt_lancerDes.setLayoutX(230);
        bt_lancerDes.setLayoutY(400);

        bt_lancerDes.setPrefSize(150, 10);

        bt_lancerDes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();

                automate.evoluer("lancerDes");
               jeu.fenetreDes(fenetre_actuelle,automate,  plateauJeu, zoneJoueur, poss, zoneAd) ;
                pion.entrerDansCase();

            }
        });
///////////////////////////////////BOUTON CARTE LIBERE
        Button bt_carte = new Button("UTILISER UNE CARTE");

        bt_carte.setLayoutX(400);
        bt_carte.setLayoutY(400);

        bt_carte.setPrefSize(150, 10);

        bt_carte.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });


/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(600);
        fenetre_actuelle.setMinWidth(650);

        fenetre_actuelle.setMaxHeight(600);
        fenetre_actuelle.setMaxWidth(650);

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });


//////////////////////AJOUT
        this.getChildren().add(bt_payer);
        this.getChildren().add(bt_lancerDes);
        this.getChildren().add(bt_carte);
        this.getChildren().add(l);


    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }




}
