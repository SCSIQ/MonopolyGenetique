package IHM.Fenetre.FenetreParties.Des;

import IHM.Fenetre.FenetreParties.ComposantPlateau.Cartes.FenetreCarteChance;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Cartes.FenetreCarteCommu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Cases.*;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Prison.FenetreLibererPrison;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Prison.FenetrePrison;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Prison.VousEtesSurPrison;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.PlateauJeu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneInfoJoueur;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZonePossessions;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeCartes.CaisseCommune;
import Metier.Plateau.ListeCartes.Chance;
import Metier.Plateau.ListeProprietes.Proprietes;
import Metier.Plateau.ListeTaxes.Taxes;
import Metier.Plateau.ParcGratuit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;

public class LancerDe extends Parent {

    private Jeu jeu ;
    private Canvas canvas;
    private PlateauJeu plateauJeu ;
    private ZonePossessions poss ;

    public LancerDe(Stage fenetre_actuelle, Canvas canvas, Automate automate, Jeu jeu, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur, ZonePossessions poss, ZoneAdversaires zoneAd)
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

            //images dés
            URL des ;
            URL des2;
            URL scoreDe;

            switch (dé1)
            {
                case 1 :    des = getClass().getResource("images/un.png");
                            break;
                case 2 :    des = getClass().getResource("images/deux.png");
                            break;
                case 3 :    des = getClass().getResource("images/trois.png");
                    break;
                case 4 :    des = getClass().getResource("images/quatre.png");
                    break;
                case 5 :    des = getClass().getResource("images/cinq.png");
                    break;
                case 6 :    des = getClass().getResource("images/six.png");
                    break;

                    default: des=getClass().getResource("images/un.png");
                        break;
            }

            Image i_des = new Image(des.toExternalForm());
            ImageView imageDe1 = new ImageView(i_des);

            imageDe1.setFitWidth(80);
            imageDe1.setFitHeight(80);
            imageDe1.setLayoutX(70);
            imageDe1.setLayoutY(130);

            switch (dé2)
            {
                case 1 :    des2 = getClass().getResource("images/un.png");
                    break;
                case 2 :    des2 = getClass().getResource("images/deux.png");
                    break;
                case 3 :    des2 = getClass().getResource("images/trois.png");
                    break;
                case 4 :    des2 = getClass().getResource("images/quatre.png");
                    break;
                case 5 :    des2 = getClass().getResource("images/cinq.png");
                    break;
                case 6 :    des2 = getClass().getResource("images/six.png");
                    break;

                default: des2=getClass().getResource("images/un.png");
                    break;
            }

            Image i_des2 = new Image(des2.toExternalForm());
            ImageView imageDe2 = new ImageView(i_des2);

            imageDe2.setFitWidth(80);
            imageDe2.setFitHeight(80);
            imageDe2.setLayoutX(190);
            imageDe2.setLayoutY(130);

            switch(score)
            {
                case 2 :    scoreDe = getClass().getResource("images/2.png");
                    break;
                case 3 :    scoreDe = getClass().getResource("images/3.png");
                    break;
                case 4 :    scoreDe = getClass().getResource("images/4.png");
                    break;
                case 5 :    scoreDe = getClass().getResource("images/5.png");
                    break;
                case 6 :    scoreDe = getClass().getResource("images/6.png");
                    break;
                case 7 :    scoreDe = getClass().getResource("images/7.png");
                    break;
                case 8 :    scoreDe = getClass().getResource("images/8.png");
                    break;
                case 9 :    scoreDe = getClass().getResource("images/9.png");
                    break;
                case 10 :    scoreDe = getClass().getResource("images/10.png");
                    break;
                case 11 :    scoreDe = getClass().getResource("images/11.png");
                    break;
                case 12 :    scoreDe = getClass().getResource("images/12.png");
                    break;

                default: scoreDe=getClass().getResource("images/1.png");
                    break;
            }

            Image i_score = new Image(scoreDe.toExternalForm());
            ImageView imageScore = new ImageView(i_score);
            imageScore.setFitHeight(100);
            imageScore.setFitWidth(100);
            imageScore.setLayoutX(330);
            imageScore.setLayoutY(115);


            //TEXTE

            Text t_nb = new Text(automate.getJoueurCourant().getNom()+" a fait : ");
            Label l_score = new Label("+            = ");

            t_nb.setLayoutX(200);
            t_nb.setLayoutY(90);

            t_nb.setScaleX(2);
            t_nb.setScaleY(2);

            l_score.setLayoutX(200);
            l_score.setLayoutY(155);

            l_score.setScaleY(2);
            l_score.setScaleX(2);


            //TITRE
            Button l = new Button("LANCER Dés");
            l.setLayoutY(10);
            l.setLayoutX(10);
            l.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
            l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
            l.setPrefSize(475,50);
            l.setText(l.getText().toUpperCase());
            l.setTextFill(Color.WHITE);
            l.setBackground(new Background(new BackgroundFill(Color.rgb(9,172,227), null, null)));

            //RECTANGLE
            Rectangle r_fond = new Rectangle();
            r_fond.setHeight(280);
            r_fond.setWidth(475);
            r_fond.setLayoutX(10);
            r_fond.setLayoutY(10);
            r_fond.setStroke(Color.BLACK);
            r_fond.setStrokeWidth(1);
            r_fond.setFill(Color.TRANSPARENT);

//////////////////////////////////////////////////////////////////////////BOUTON
            Button bt_ok = new Button("Ok");

            bt_ok.setLayoutX(170);
            bt_ok.setLayoutY(240);

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
                        if(((Proprietes) automate.getJoueurCourant().getPion().getCase()).getProprio() == null ){
                            fenetreVousEtesSur(fenetre_actuelle, automate, zoneJoueur, poss);
                        } else if (((Proprietes) automate.getJoueurCourant().getPion().getCase()).getProprio()!=automate.getJoueurCourant() ) {
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
                        //si le joueur n'est pas en visite simple que ça qu'il a
                        if(automate.getJoueurCourant().getEstEnPrison()==true && automate.getJoueurCourant().getEssaiesPourSortirDePrison()!=0)
                        {
                            if(automate.getJoueurCourant().getResDes2()==automate.getJoueurCourant().getResDes1())
                            {
                                fenetreLiberePrison(fenetre_actuelle, automate) ;
                            }else {
                                fenetreEnPrisonEssai(fenetre_actuelle, automate, zoneJoueur, zoneAd);

                            }
                         }
                    }

                    //Si tombe sur le parc gratuit
                    if(automate.getJoueurCourant().getPion().getCase().getPosition()==20)
                    {
                        int cagnotte=((ParcGratuit)automate.getJoueurCourant().getPion().getCase()).recupererArgent() ;
                        automate.getJoueurCourant().IncrementerSolde(cagnotte);
                        //on remet à jour l'argent du joueur courant
                        zoneJoueur.SupprimerJoueur();
                        zoneJoueur.genereInfosJoueur(automate);

                        //Met à jour les adversaires :
                        zoneAd.SupprimerAdversaire();
                        zoneAd.genererAdversaire(automate, fenetre_actuelle);
                    }

                    //Si la case est une case Chance
                    if(automate.getJoueurCourant().getPion().getCase() instanceof Chance )
                    {
                        fenetreChance(fenetre_actuelle, automate, zoneJoueur, zoneAd) ; 
                    }

                    //si la case est une case Caisse de communauté
                    if(automate.getJoueurCourant().getPion().getCase() instanceof CaisseCommune)
                    {
                        fenetreCommu(fenetre_actuelle, automate, zoneJoueur, zoneAd);
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
        fenetre_actuelle.setMinHeight(350);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(350);
        fenetre_actuelle.setMaxWidth(515);

 /////////////////////////////////////////////////////////////////////////AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(l);
        this.getChildren().add(t_nb);

        this.getChildren().add(imageDe1);
        this.getChildren().add(imageDe2);
        this.getChildren().add(imageScore);
        this.getChildren().add(bt_ok);
        this.getChildren().add(l_score);

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
        nouvelle_fenetre_vousEtesSur.initOwner(jeu.getFenetrePropri());

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
        nouvelle_fenetre_poss.initOwner(jeu.getFenetrePropri());

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
        nouvelle_fenetre_taxe.initOwner(jeu.getFenetrePropri());

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
        nouvelle_fenetre_prison.initOwner(jeu.getFenetrePropri());

        //POSITION DE LA FENETRE
        nouvelle_fenetre_prison.show();
    }

    public void fenetreChance(Stage fenetre_actuelle, Automate automate,  ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_chance = new Stage();
        FenetreCarteChance fenetrePrison= new FenetreCarteChance(nouvelle_fenetre_chance,canvas, automate, zoneJoueur, zoneAd, jeu.getPion(), jeu);

        Scene nouvelle_scene = new  Scene(fenetrePrison,650,550);

        nouvelle_fenetre_chance.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_chance.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_chance.initOwner(jeu.getFenetrePropri());

        //POSITION DE LA FENETRE
        nouvelle_fenetre_chance.show();
    }

    public void fenetreCommu(Stage fenetre_actuelle, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_commu = new Stage();
        FenetreCarteCommu fenetreCommu= new FenetreCarteCommu(nouvelle_fenetre_commu,canvas, automate, zoneJoueur, zoneAd, jeu.getPion());

        Scene nouvelle_scene = new  Scene(fenetreCommu,650,550);

        nouvelle_fenetre_commu.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_commu.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_commu.initOwner(jeu.getFenetrePropri());

        //POSITION DE LA FENETRE
        nouvelle_fenetre_commu.show();
    }

    public void fenetreEnPrisonEssai(Stage fenetre_actuelle, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_prison = new Stage();
        FenetrePrison fenetrePrison= new FenetrePrison(nouvelle_fenetre_prison,canvas, automate, plateauJeu, zoneJoueur, jeu, poss,  zoneAd, jeu.getPion());

        Scene nouvelle_scene = new  Scene(fenetrePrison,650,550);

        nouvelle_fenetre_prison.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_prison.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_prison.initOwner(jeu.getFenetrePropri());

        //POSITION DE LA FENETRE
        nouvelle_fenetre_prison.show();
    }

    public void fenetreLiberePrison(Stage fenetre_actuelle, Automate automate)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_liberer = new Stage();
        FenetreLibererPrison fenetrePrison= new FenetreLibererPrison(nouvelle_fenetre_liberer,canvas, automate);

        Scene nouvelle_scene = new  Scene(fenetrePrison,650,550);

        nouvelle_fenetre_liberer.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_liberer.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_liberer.initOwner(jeu.getFenetrePropri());

        //POSITION DE LA FENETRE
        nouvelle_fenetre_liberer.show();
    }

}
