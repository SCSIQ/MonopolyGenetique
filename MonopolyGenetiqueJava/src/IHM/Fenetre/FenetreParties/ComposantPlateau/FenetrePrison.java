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

        Label l_Joueur = new Label(automate.getJoueurCourant().getNom());

        l_Joueur.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l_Joueur.setLayoutX(50);
        l_Joueur.setLayoutY(15);

        l_Joueur.setScaleX(1.5);
        l_Joueur.setScaleY(1.5);

        int tour = automate.getJoueurCourant().getEssaiesPourSortirDePrison()+1;

        Label l_Tour = new Label("TOUR : "+tour+"/3");

        l_Tour.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l_Tour.setLayoutX(500);
        l_Tour.setLayoutY(15);

        l_Tour.setScaleX(1.5);
        l_Tour.setScaleY(1.5);


        Label l = new Label("VOUS ETES EN PRISON");

        l.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l.setLayoutX(230);
        l.setLayoutY(70);

        l.setScaleX(3);
        l.setScaleY(3);


        Label l_2 = new Label("POUS SORTIR, VOUS AVEZ PLUSIEURS CHOIX" );
        l_2.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l_2.setLayoutX(180);
        l_2.setLayoutY(120);

        l_2.setScaleX(2);
        l_2.setScaleY(2);

        Label l_Paye = new Label("         PAYEZ \n500 € IMMEDIATEMENT");
        l_Paye.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l_Paye.setLayoutX(50);
        l_Paye.setLayoutY(180);

        l_Paye.setScaleX(1.2);
        l_Paye.setScaleY(1.2);

        Label l_Double = new Label("ESSAYEZ DE FAIRE \n     UN DOUBLE");
        l_Double.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l_Double.setLayoutX(260);
        l_Double.setLayoutY(180);

        l_Double.setScaleX(1.2);
        l_Double.setScaleY(1.2);

        Label l_Carte = new Label("       UTILISEZ \n      UNE CARTE \n'SORTEZ DE PRISON'");
        l_Carte.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l_Carte.setLayoutX(450);
        l_Carte.setLayoutY(180);

        l_Carte.setScaleX(1.2);
        l_Carte.setScaleY(1.2);

        Label l_Note = new Label(" Note : Au bout de trois tours, vous sortez obligatoirement et vous payez 500 €");
        l_Note.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l_Note.setLayoutX(70);
        l_Note.setLayoutY(330);

        l_Note.setScaleX(1.1);
        l_Note.setScaleY(1.1);

        ////////////////////////////BOUTON
        Button bt_payer= new Button("PAYER 500");

        bt_payer.setLayoutX(25);
        bt_payer.setLayoutY(250);

        bt_payer.setPrefSize(180, 10);

        bt_payer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);
                automate.getJoueurCourant().DecrementerSolde(500);
                automate.getJoueurCourant().setEstEnPrison(false);
                //on remet à jour l'argent du joueur courant
                zoneJoueur.SupprimerJoueur();
                zoneJoueur.genereInfosJoueur(automate);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });
/////////////////////////////////////BOUTON LANCER LES DES
       Button bt_lancerDes = new Button("LANCER LES DES");

        bt_lancerDes.setLayoutX(225);
        bt_lancerDes.setLayoutY(250);

        bt_lancerDes.setPrefSize(180, 10);

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
        Button bt_carte = new Button("'SORTIR DE PRISON'");

        bt_carte.setLayoutX(425);
        bt_carte.setLayoutY(250);

        bt_carte.setPrefSize(180, 10);

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
        fenetre_actuelle.setMinHeight(450);
        fenetre_actuelle.setMinWidth(650);

        fenetre_actuelle.setMaxHeight(450);
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
        this.getChildren().add(l_2);
        this.getChildren().add(l_Paye);
        this.getChildren().add(l_Double);
        this.getChildren().add(l_Carte);
        this.getChildren().add(l_Note);
        this.getChildren().add(l_Tour);
        this.getChildren().add(l_Joueur);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }




}