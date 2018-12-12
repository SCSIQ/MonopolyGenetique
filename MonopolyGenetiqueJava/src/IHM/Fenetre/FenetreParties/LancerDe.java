package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.*;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.Proprietes;
import Metier.Plateau.ListeTaxes.Taxes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class LancerDe extends Parent {

    private Jeu jeu ;
    private Canvas canvas;
    private PlateauJeu plateauJeu ;
    private ZonePossessions poss ;

    public LancerDe(Stage fenetre_actuelle, Canvas canvas, Automate automate, Jeu jeu, PlateauJeu plateauJeu,ZoneInfoJoueur zoneJoueur,  ZonePossessions poss, ZoneAdversaires zoneAd)
    {
        this.jeu=jeu;
        this.canvas=canvas ;
        this.plateauJeu=plateauJeu;
        this.poss = poss ;

//////////////////////////////////////////////////////////////////////////TEXTE
            //récupération de la valeur des dés

            Integer score = automate.getJoueurCourant().getResLanceDes();
            Integer dé1 = automate.getJoueurCourant().getResDes1();
            Integer dé2 = automate.getJoueurCourant().getResDes2();

            Text t_nb = new Text(automate.getJoueurCourant().getNom()+" a fait : \n" +"    "+ dé1.toString()+" + "+dé2.toString()+" = "+score.toString());

            t_nb.setLayoutX(170);
            t_nb.setLayoutY(50);

            t_nb.setScaleX(2);
            t_nb.setScaleY(2);

//////////////////////////////////////////////////////////////////////////BOUTON
            Button bt_ok = new Button("Ok");

            bt_ok.setLayoutX(130);
            bt_ok.setLayoutY(120);

            bt_ok.setPrefSize(150, 10);

            bt_ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //on rend la bonne opacité à la fenêtre
                    detruireCanvas(canvas);

                    //on ferme la fenêtre
                    fenetre_actuelle.close();

                    //si la case est bien une propriété
                    if(automate.getJoueurCourant().getPion().getCase() instanceof Proprietes){

                        //si elle n'est pas déjà achetée
                        if(((Proprietes) automate.getJoueurCourant().getPion().getCase()).getProprio() == null){
                            fenetreVousEtesSur(fenetre_actuelle, automate, zoneJoueur, poss);
                        } else {
                            fenetreCasePoss(fenetre_actuelle, automate, zoneJoueur, zoneAd);
                        }
                    }

                    //Si la case est une taxe
                    if(automate.getJoueurCourant().getPion().getCase() instanceof Taxes)
                    {
                        fenetreEstSurTaxe(fenetre_actuelle, automate, zoneJoueur, zoneAd);
                    }

                    //Si le joueur est sur la case prison
                    if(automate.getJoueurCourant().getPion().getCase().getPosition()==10)
                    {
                        //Si le joueur n'st pas qu'en visite simple, et si c'est la première fois
                        if(automate.getJoueurCourant().getEstEnPrison()==true && automate.getJoueurCourant().getEssaiesPourSortirDePrison()==0)
                        {
                            fenetreEnPrison(fenetre_actuelle, automate);
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
        fenetre_actuelle.setMinHeight(220);
        fenetre_actuelle.setMinWidth(420);

        fenetre_actuelle.setMaxHeight(220);
        fenetre_actuelle.setMaxWidth(420);

 /////////////////////////////////////////////////////////////////////////AJOUT
        this.getChildren().add(t_nb);
        this.getChildren().add(bt_ok);

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
        fenetreCaseLibre fenetreSur = new fenetreCaseLibre(nouvelle_fenetre_vousEtesSur,canvas, automate, plateauJeu, zoneJoueur, jeu, poss);

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
        fenetreCasePossedee fenetreposs = new fenetreCasePossedee(nouvelle_fenetre_poss,canvas, automate, plateauJeu, zoneJoueur, jeu, zoneAd);

        Scene nouvelle_scene = new  Scene(fenetreposs,650,550);

        nouvelle_fenetre_poss.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_poss.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_poss.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_poss.show();
    }

    //FENETRE APPARAIT SI LE JOUEUR EST SUR UNE CASE TAXE
    public void fenetreEstSurTaxe(Stage fenetre_actuelle, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_taxe = new Stage();
        FenetreTaxe fenetreTaxe= new FenetreTaxe(nouvelle_fenetre_taxe,canvas, automate, plateauJeu, zoneJoueur, jeu, zoneAd);

        Scene nouvelle_scene = new  Scene(fenetreTaxe,650,550);

        nouvelle_fenetre_taxe.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_taxe.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_taxe.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_taxe.show();
    }

    //Permet d'afficher la fenêtre vous êtes en prison
    public void fenetreEnPrison(Stage fenetre_actuelle, Automate automate)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_prison = new Stage();
        VousEtesSurPrison fenetrePrison= new VousEtesSurPrison(nouvelle_fenetre_prison,canvas, automate);

        Scene nouvelle_scene = new  Scene(fenetrePrison,650,550);

        nouvelle_fenetre_prison.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_prison.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_prison.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_prison.show();
    }

}
