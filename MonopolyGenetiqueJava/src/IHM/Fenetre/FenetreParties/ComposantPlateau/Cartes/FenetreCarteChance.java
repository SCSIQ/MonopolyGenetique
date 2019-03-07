package IHM.Fenetre.FenetreParties.ComposantPlateau.Cartes;


import IHM.Fenetre.FenetreParties.ComposantPlateau.Cartes.FenetreCarteCommu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Cases.fenetreCaseLibre;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Cases.fenetreCasePossedee;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneInfoJoueur;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZonePossessions;
import IHM.Fenetre.FenetreParties.Jeu;
import IHM.Fenetre.FenetreParties.PasAssezArgent;
import IHM.Fenetre.FenetreParties.Pion;
import Metier.Automate.Automate;
import Metier.Plateau.ListeCartes.CaisseCommune;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetreCarteChance extends Parent {

    //ATTRIBUTS
    private Canvas canvas ;
    private ZoneInfoJoueur zoneJoueur ;
    private ZoneAdversaires zoneAd ;
    private Jeu jeu ;

    public FenetreCarteChance(Stage fenetre_actuelle, Canvas canvas, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd, Pion pion, Jeu jeu)
    {
        //initialisation
        this.canvas = canvas ;
        this.zoneAd= zoneAd ;
        this.zoneJoueur = zoneJoueur ;
        this.jeu = jeu ;

        Button carte_chance = new Button("CARTE CHANCE");

        carte_chance.setLayoutY(10);
        carte_chance.setLayoutX(10);
        carte_chance.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        carte_chance.setTextFill(Color.WHITE);
        carte_chance.setBackground(new Background(new BackgroundFill(Color.rgb(200,27,31), null, null)));
        carte_chance.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        carte_chance.setPrefSize(475,50);


        //CONTENU

        String chance = automate.getContenuCartePiochée();

        Label carteChance = new Label(""+chance);
        carteChance.setLayoutX(125);
        carteChance.setLayoutY(100);
        carteChance.setMaxWidth(250);
        carteChance.setWrapText(true);
        carteChance.setTextAlignment(TextAlignment.CENTER);


        carteChance.setScaleX(1.5);
        carteChance.setScaleY(1.5);


        //RECTANGLE
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



                automate.evoluer("");

                //Met à jour les adversaires :
              /*  zoneAd.SupprimerAdversaire();
                zoneAd.genererAdversaire(automate, fenetre_actuelle);*/

                //on ferme la fenêtre
                fenetre_actuelle.close();
                //si c'est "Rendez_vous rue de la paix"
                if(chance=="Rendez-vous rue de la paix")
                {
                    pion.entrerDansCase();
                }
                if(chance=="Vous reculez de 6 cases")
                {
                    pion.entrerDansCase();
                }

                //on remet à jour l'argent du joueur courant
                zoneJoueur.SupprimerJoueur();
                zoneJoueur.genereInfosJoueur(automate);

                if(automate.getJoueurCourant().getSolde()<0){

                    fenetrePasAssezArgent(fenetre_actuelle,automate, zoneJoueur, zoneAd);
                }


                if(automate.getJoueurCourant().getPion().getCase() instanceof Proprietes) {

                    //si elle n'est pas déjà achetée
                    if (((Proprietes) automate.getJoueurCourant().getPion().getCase()).getProprio() == null) {
                        fenetreVousEtesSur(fenetre_actuelle, automate, zoneJoueur, jeu.getPoss());
                    } else if (((Proprietes) automate.getJoueurCourant().getPion().getCase()).getProprio() != automate.getJoueurCourant()) {
                        fenetreCasePoss(fenetre_actuelle, automate, zoneJoueur, zoneAd);
                    }
                }
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
        this.getChildren().add(bt_ok);
        this.getChildren().add(carte_chance);
        this.getChildren().add(carteChance);


    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }


        //FENETRE APPARAISSANT SI LA CASE EST LIBRE
        public void fenetreVousEtesSur(Stage fenetre_actuelle, Automate automate, ZoneInfoJoueur zoneJoueur, ZonePossessions poss)
        {
            jeu.fenetreNoire();

            Stage nouvelle_fenetre_vousEtesSur = new Stage();
            fenetreCaseLibre fenetreSur = new fenetreCaseLibre(nouvelle_fenetre_vousEtesSur,canvas, automate, jeu.getPl(), zoneJoueur, jeu, poss);

            Scene nouvelle_scene = new  Scene(fenetreSur,650,550);

            nouvelle_fenetre_vousEtesSur.setScene(nouvelle_scene);

            //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
            nouvelle_fenetre_vousEtesSur.initModality(Modality.WINDOW_MODAL);
            nouvelle_fenetre_vousEtesSur.initOwner(fenetre_actuelle);

            //POSITION DE LA FENETRE
            nouvelle_fenetre_vousEtesSur.show();
        }

        //FENETRE APPARAIT SI LE JOUEUR EST SUR UNE CASE APPARTENANT DEJA A QUELQU'UN
        public void fenetreCasePoss(Stage fenetre_actuelle, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
        {
            jeu.fenetreNoire();

            Stage nouvelle_fenetre_poss = new Stage();
            fenetreCasePossedee fenetreposs = new fenetreCasePossedee(nouvelle_fenetre_poss,canvas, automate, jeu.getPl(), zoneJoueur, jeu, zoneAd);

            Scene nouvelle_scene = new  Scene(fenetreposs,650,550);

            nouvelle_fenetre_poss.setScene(nouvelle_scene);

            //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
            nouvelle_fenetre_poss.initModality(Modality.WINDOW_MODAL);
            nouvelle_fenetre_poss.initOwner(fenetre_actuelle);

            //POSITION DE LA FENETRE
            nouvelle_fenetre_poss.show();
        }

        public void fenetrePasAssezArgent(Stage fenetre_actuelle, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
        {
            jeu.fenetreNoire();

            Stage nouvelle_fenetre_pasAssez = new Stage();
            PasAssezArgent fenetreCommu= new PasAssezArgent(automate, nouvelle_fenetre_pasAssez,canvas, zoneJoueur, zoneAd, jeu,true);

            Scene nouvelle_scene = new  Scene(fenetreCommu,650,550);

            nouvelle_fenetre_pasAssez.setScene(nouvelle_scene);

            //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
            nouvelle_fenetre_pasAssez.initModality(Modality.WINDOW_MODAL);
            nouvelle_fenetre_pasAssez.initOwner(jeu.getFenetrePropri());

            //POSITION DE LA FENETRE
            nouvelle_fenetre_pasAssez.show();
        }
}
