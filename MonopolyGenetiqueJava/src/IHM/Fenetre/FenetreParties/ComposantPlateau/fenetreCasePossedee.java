package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Entites.Joueur;
import IHM.Fenetre.FenetreParties.FenetreCarteChance;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeGares.Gare;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.ServicePublic;
import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class fenetreCasePossedee extends Parent  {

    private Canvas canvas ;
    private ZoneInfoJoueur zoneJoueur ;
    private ZoneAdversaires zoneAd;
    private int prixAPayer = 0 ; // représente le prix à payer au propriétaire
    private Jeu jeu ;

    public fenetreCasePossedee(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur, Jeu jeu, ZoneAdversaires zoneAd){

        //INITIALISATION
        this.canvas = canvas ;
        this.zoneJoueur =zoneJoueur;
        this.zoneAd = zoneAd ;
        this.jeu = jeu ; 

        Joueur j=null ; //représente le propriétaire de la case


       //SI C'EST UN TERRAIN
        if(automate.getJoueurCourant().getPion().getCase() instanceof  Terrain){
            //Si il n'y a pas de maison
            if(((Terrain)automate.getJoueurCourant().getPion().getCase()).getNbMaisons()==0){
                prixAPayer =((Terrain)automate.getJoueurCourant().getPion().getCase()).getLoyerSansMaison();

            // si il y a une maison
            }else if(((Terrain)automate.getJoueurCourant().getPion().getCase()).getNbMaisons()==1){
                prixAPayer =((Terrain)automate.getJoueurCourant().getPion().getCase()).getLoyer1Maison();

            //si il y a 2 maisons
            }else if(((Terrain)automate.getJoueurCourant().getPion().getCase()).getNbMaisons()==2) {
                prixAPayer = ((Terrain) automate.getJoueurCourant().getPion().getCase()).getLoyer2Maison();
            }
            //Si il y a 3 maisons
            else if(((Terrain)automate.getJoueurCourant().getPion().getCase()).getNbMaisons()==3){
                prixAPayer =((Terrain)automate.getJoueurCourant().getPion().getCase()).getLoyer3Maison();

            //si il y a 4 maisons
            }else if(((Terrain)automate.getJoueurCourant().getPion().getCase()).getNbMaisons()==4){
                prixAPayer =((Terrain)automate.getJoueurCourant().getPion().getCase()).getLoyer4Maison();
            }
            //si il y a un hôtel
            else if(((Terrain)automate.getJoueurCourant().getPion().getCase()).getNbMaisons()==5){
                prixAPayer =((Terrain)automate.getJoueurCourant().getPion().getCase()).getLoyerHotel();
            }

                j =((Terrain)automate.getJoueurCourant().getPion().getCase()).getProprio();

        // SI C'EST UNE COMPAGNIE
        }else if(automate.getJoueurCourant().getPion().getCase() instanceof ServicePublic){
            prixAPayer =((ServicePublic)automate.getJoueurCourant().getPion().getCase()).getLoyer(automate.getJoueurCourant().getResLanceDes());
            j =((ServicePublic)automate.getJoueurCourant().getPion().getCase()).getProprio();
        }else if(automate.getJoueurCourant().getPion().getCase() instanceof Gare)
        {
            prixAPayer =((Gare)automate.getJoueurCourant().getPion().getCase()).getLoyer();
            j =((Gare)automate.getJoueurCourant().getPion().getCase()).getProprio();
        }

        //TEXTE
        Label l = new Label(plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType());
        l.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l.setLayoutX(170);
        l.setLayoutY(27);

        l.setScaleX(2);
        l.setScaleY(2);


        Label l_contenu = new Label("\nElle appartient au joueur "+j.getNom()+".\n        Vous lui devez "+prixAPayer+" € ");
        l_contenu.setLayoutX(150);
        l_contenu.setLayoutY(80);
        l_contenu.setScaleX(1.5);
        l_contenu.setScaleY(1.5);


        ///COULEUR DE LA CASE
        Color couleurTerrain=Color.WHITE;

        if(automate.getJoueurCourant().getPion().getCase() instanceof Terrain) {
            CouleurMétier s = ((Terrain) automate.getJoueurCourant().getPion().getCase()).getCouleur();

            switch (s) {
                case Rose:
                    couleurTerrain = Color.rgb(189, 91, 163);
                    break;
                case Vert:
                    couleurTerrain = Color.rgb(28, 137, 67);
                    break;
                case Orange:
                    couleurTerrain = Color.rgb(234, 157, 34);
                    break;
                case Jaune:
                    couleurTerrain = Color.rgb(239, 233, 50);
                    break;
                case Rouge:
                    couleurTerrain = Color.rgb(224, 30, 37);
                    break;
                case Marron:
                    couleurTerrain = Color.rgb(122, 57, 149);
                    break;
                case BleuFonce:
                    couleurTerrain = Color.rgb(68, 77, 160);
                    break;
                case BleuCiel:
                    couleurTerrain = Color.rgb(9, 172, 227);
                    break;

                default:
                    couleurTerrain = Color.BLACK;
            }
            l.setTextFill(Color.WHITE);
        }

        //RECTANGLE
        Rectangle r_chance = new Rectangle();
        r_chance.setHeight(50);
        r_chance.setWidth(475);
        r_chance.setLayoutX(10);
        r_chance.setLayoutY(10);
        r_chance.setStroke(Color.BLACK);
        r_chance.setStrokeWidth(1);
        r_chance.setFill(couleurTerrain);

        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        ////////////////////////////BOUTON
        //ACTION PAYER
        Button bt_payer= new Button("PAYER");

        bt_payer.setLayoutX(175);
        bt_payer.setLayoutY(190);

        bt_payer.setPrefSize(150, 10);

        bt_payer.setOnAction(new EventHandler<ActionEvent>() {
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

                //si le joueur n'a pas assez d'argent pour payer
                if(automate.getJoueurCourant().getSolde()< prixAPayer)
                {
                    fenetreFaillite(fenetre_actuelle, automate,  zoneJoueur, zoneAd) ;
                }


            }
        });

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);

//////////////////////AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(r_chance);
        this.getChildren().add(bt_payer);
        this.getChildren().add(l);
        this.getChildren().add(l_contenu);

    }



    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }


    public void fenetreFaillite(Stage fenetre_actuelle, Automate automate,  ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_faillite = new Stage();

        FenetreFaillite_1 fenetreFaillite= new FenetreFaillite_1(nouvelle_fenetre_faillite,canvas, automate, zoneJoueur, zoneAd);

        Scene nouvelle_scene = new  Scene(fenetreFaillite,650,550);

        nouvelle_fenetre_faillite.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_faillite.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_faillite.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_faillite.show();
    }

}
