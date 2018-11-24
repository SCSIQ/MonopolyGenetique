package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.PlateauJeu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneInfoJoueur;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZonePossessions;
import IHM.Fenetre.FentreMenuPrincipal.MenuJeu;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Jeu extends Parent {

    private Canvas canvas = new Canvas(1275,1275);
    private Automate automate;

    public Jeu(Stage primaryStage, Stage nouvelle_fenetre, Color couleur, Automate automate){

        this.automate = automate;

////////DEFINITIONS DES RECTANGLES DANS LE JEU
        Rectangle rect_infosJoueur = new Rectangle() ;
        Rectangle rect_plateau = new Rectangle();
        Rectangle rect_adversaire = new Rectangle() ;
        Rectangle rect_possession = new Rectangle() ;
        Rectangle rect_terrain = new Rectangle();
        Rectangle rect_gare = new Rectangle();
        Rectangle rect_compagnie = new Rectangle();
        Rectangle rect_cartePrison = new Rectangle() ;

        //BOUTONS
        Button bt_menu = new Button("Menu") ;
        Button bt_lancerDes = new Button("Lancer les dés") ;
        Button bt_tourSuivant = new Button("Tour suivant") ;


        //APPEL INFOS JOUEUR
        ZoneInfoJoueur zoneJoueur = new ZoneInfoJoueur(automate);
        this.getChildren().add(zoneJoueur);

        //APPEL ZONE ADVERSAIRE

        //Je ne sais pas pourquoi ça ne marche pas mais ça m'empeche de travailler...
        //Du coup je l'ai désactivé poiur pouvoir avancer
        //Aurian

        ZoneAdversaires zoneAd = new ZoneAdversaires(primaryStage,nouvelle_fenetre,automate, canvas);
        this.getChildren().add(zoneAd);

        //APPEL ZONE POSSESSION
        ZonePossessions poss = new ZonePossessions(automate);
        poss.RectangleCartePrison();
        poss.RectangleCompagnies();
        poss.RectangleGare();
        poss.RectangleTerrain();
        this.getChildren().add(poss);

        //APPEL PLATEAU JEU
        PlateauJeu pl = new PlateauJeu(automate);

        pl.caseDuBas();
        pl.caseDeGauche();
        pl.caseDuHaut();
        pl.caseDeDroite();
        pl.plateauJeu();
        this.getChildren().add(pl);

/////////////PION
        Pion pion = new Pion(automate, pl);
        System.out.println(automate.getJoueurCourant().getPion());


        boutonMenu(bt_menu);
        boutonLancerDes(bt_lancerDes);
        boutonTourSuivant(bt_tourSuivant);

        ///ACTION SI BOUTON MENU
        bt_menu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                choixMenu(primaryStage, nouvelle_fenetre, couleur);

            }
        });

        ///ACTION SI BOUTON LANCER DES
        bt_lancerDes.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                if(automate.getJoueurCourant().getaLanceDes()==false) {
                    automate.evoluer("lancerDes");
                    fenetreDes(nouvelle_fenetre, automate);
                    pion.entrerDansCase();
                    //automate.getJoueurCourant().setaLanceDes(true); //cette ligne empeche les lancés après un double... je l'ai donc désactivée, aurian

                }else{
                    automate.evoluer("lancerDes");
                    fenetreDejaLancerDe(nouvelle_fenetre);
                }


            }
        });

        ///ACTION SI BOUTON TOUR SUIVANT
        bt_tourSuivant.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                fenetreTour(nouvelle_fenetre, automate);
            }
        });

////////BLOCAGE REDUCTION ET AUGMENTATION

        nouvelle_fenetre.setMinWidth(1290);
        nouvelle_fenetre.setMinHeight(780);

        nouvelle_fenetre.setMaxWidth(1290);
        nouvelle_fenetre.setMaxHeight(780);

        // AJOUT A L'ECRAN

        this.getChildren().add(rect_infosJoueur);
        this.getChildren().add(rect_plateau);
        this.getChildren().add(rect_adversaire);
        this.getChildren().add(rect_possession);
        this.getChildren().add(rect_terrain);
        this.getChildren().add(rect_gare);
        this.getChildren().add(rect_compagnie);
        this.getChildren().add(rect_cartePrison);
        this.getChildren().add(bt_menu);
        this.getChildren().add(bt_lancerDes);
        this.getChildren().add(bt_tourSuivant);

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    //*******************************AFFICHAGE DES RECTANGLES /BOUTONS****************************//



    public void boutonMenu(Button bt_menu){

        //TAILLE DES BOUTONS
        bt_menu.setPrefSize(150,10);
        bt_menu.setLayoutX(1085);
        bt_menu.setLayoutY(45);

    }

    public void boutonLancerDes(Button bt_lancerDes){

        //TAILLE DES BOUTONS
        bt_lancerDes.setPrefSize(150,10);
        bt_lancerDes.setLayoutX(950);
        bt_lancerDes.setLayoutY(665);

    }

    public void boutonTourSuivant(Button bt_tourSuivant){

        //TAILLE DES BOUTONS
        bt_tourSuivant.setPrefSize(150,10);
        bt_tourSuivant.setLayoutX(1105);
        bt_tourSuivant.setLayoutY(665);

    }

    public void fenetreNoire()
    {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        canvas.setOpacity(0.5);
        gc.fillRect(0,0, 1600,1600);
        this.getChildren().add(canvas);
    }

    public void choixMenu(Stage primaryStage, Stage fenetre_actuelle, Color couleur) {
        fenetreNoire();

        Stage nouvelle_fenetre_menu = new Stage();
        MenuJeu fenetre_menu = new MenuJeu(primaryStage, nouvelle_fenetre_menu, fenetre_actuelle, couleur, canvas);

        Scene nouvelle_scene = new Scene(fenetre_menu,320,370);

        nouvelle_fenetre_menu.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_menu.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_menu.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
       /* nouvelle_fenetre_menu.setX(fenetre_actuelle.getX() + 610);
        nouvelle_fenetre_menu.setY(fenetre_actuelle.getY() + 200);*/

        nouvelle_fenetre_menu.show();
    }

    public void fenetreTour(Stage fenetre_actuelle, Automate automate)
    {
        fenetreNoire();

        Stage nouvelle_fenetre_des = new Stage();
        tourSuivant fenetreDe = new tourSuivant(nouvelle_fenetre_des, canvas, automate);

        Scene nouvelle_scene = new  Scene(fenetreDe,600,300);

        nouvelle_fenetre_des.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_des.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_des.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_des.show();
    }

    public void fenetreDes(Stage fenetre_actuelle, Automate automate)
    {
        fenetreNoire();

        Stage nouvelle_fenetre_des = new Stage();
        LancerDe fenetreDe = new LancerDe(nouvelle_fenetre_des, canvas, automate);

        Scene nouvelle_scene = new  Scene(fenetreDe,400,170);

        nouvelle_fenetre_des.setScene(nouvelle_scene);
        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_des.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_des.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_des.show();
    }

    public void fenetreDejaLancerDe(Stage fenetre_actuelle)
    {
        fenetreNoire();

        Stage nouvelle_fenetre_erreur = new Stage();
        DejaLanceDes fenetreDe = new DejaLanceDes(nouvelle_fenetre_erreur, canvas);

        Scene nouvelle_scene = new  Scene(fenetreDe,500,270);

        nouvelle_fenetre_erreur.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_erreur.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_erreur.initOwner(fenetre_actuelle);

        nouvelle_fenetre_erreur.show();
    }


}
