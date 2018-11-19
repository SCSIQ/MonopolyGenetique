package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.Images.DejaLanceDes;
import IHM.Fenetre.FentreMenuPrincipal.MenuJeu;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ArrayList;

public class Jeu extends Parent {

    private Canvas canvas = new Canvas(1275,1275);
    private Automate automate;
    private ArrayList<Pane> listePanel = new ArrayList<>();

    public Jeu(Stage primaryStage, Stage nouvelle_fenetre, Color couleur, Automate automate){

        this.automate = automate;

        automate.getJoueurCourant().getPion().getPosition().getPosition();

        automate.getJoueurCourant().getListeCases();

        //plateauJeu();
        plateauJeu();
        caseDuBas() ;
        caseDeGauche();
        caseDuHaut() ;
        caseDeDroite();

        automate.getNombreJoueur();
        Pion p = new Pion(automate, this);
        System.out.println(automate.getJoueurCourant().getPion());
        // ESSAI POUR PLACER SUR LA CASE DEPART UN PION
      /*  Pane caseDepart = listePanel.get(0) ;
        Circle c = new Circle();
        c.setFill(Color.CHOCOLATE);

        c.setRadius(10);
        c.setLayoutY(20);
        c.setLayoutX(20);
        caseDepart.getChildren().add(c);*/

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


        //APPEL DES FONCTIONS POUR TAILLES, COULEURS ET POSITION
        RectangleInfoJoueur(rect_infosJoueur,couleur);
        RectanglePlateau(rect_plateau);
        RectangleAdversaire(rect_adversaire);
        RectanglePossession(rect_possession);
        RectangleTerrain(rect_terrain);
        RectangleGare( rect_gare);
        RectangleCompagnies(rect_compagnie);
        RectangleCartePrison(rect_cartePrison);
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
                    p.deplacer();

                }else{
                    automate.evoluer("lancerDes");
                    fenetreDejaLancerDe();
                }


            }
        });

        ///ACTION SI BOUTON TOUR SUIVANT
        bt_tourSuivant.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                automate.evoluer("tourSuivant");
                fenetreTour(nouvelle_fenetre, automate);
                automate.getJoueurCourant().setaLanceDes(false);
            }
        });

////////BLOCAGE REDUCTION ET AUGMENTATION

        nouvelle_fenetre.setMinWidth(1290);
        nouvelle_fenetre.setMinHeight(750);

        nouvelle_fenetre.setMaxWidth(1290);
        nouvelle_fenetre.setMaxHeight(750);

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

    public ArrayList getListePanel(){
        return listePanel;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //*******************************AFFICHAGE DES RECTANGLES /BOUTONS****************************//


    public void RectangleInfoJoueur(Rectangle rect_infosJoueur, Color couleur){

        //ajout rectangle couleur
        Rectangle r_couleur = new Rectangle();
        r_couleur.setHeight(50);
        r_couleur.setWidth(50);
        r_couleur.setLayoutX(30);
        r_couleur.setLayoutY(35);
        r_couleur.setStroke(Color.BLACK);
        r_couleur.setStrokeWidth(1);
        r_couleur.setFill(automate.getJoueurCourant().getCouleur());
        this.getChildren().add(r_couleur);

        //ajout labels
        Label nom = new Label("JOUEUR "+ automate.getJoueurCourant().getNom());
        Label argent = new Label("ARGENT :");
        Label enPrison = new Label("EN PRISON :");
        Label tour = new Label("TOUR :");


        //NOM
        nom.setLayoutX(90);
        nom.setLayoutY(50);
        nom.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(nom);

        //ARGENT
        argent.setLayoutX(210);
        argent.setLayoutY(50);
        argent.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(argent);

        //EN PRISON
        enPrison.setLayoutX(390);
        enPrison.setLayoutY(50);
        enPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(enPrison);

        //TOUR
        tour.setLayoutX(520);
        tour.setLayoutY(50);
        tour.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(tour);



        //TAILLE DU RECTANGLE ET POSITION

        rect_infosJoueur.setHeight(85);
        rect_infosJoueur.setWidth(1245.4);
        rect_infosJoueur.setX(15);
        rect_infosJoueur.setY(18.3);

        //COULEUR ET CONTOUR
        rect_infosJoueur.setFill(Color.TRANSPARENT);
        rect_infosJoueur.setStroke(Color.BLACK);
    }


    public void RectanglePlateau(Rectangle rect_plateau){

        //TAILLE DU RECTANGLE ET POSITION

        rect_plateau.setHeight(604);
        rect_plateau.setWidth(604);
        rect_plateau.setX(15);
        rect_plateau.setY(110);

        //COULEUR ET CONTOUR
        rect_plateau.setFill(Color.TRANSPARENT);
        rect_plateau.setStroke(Color.BLACK);
    }


    public void RectangleAdversaire(Rectangle rect_adversaire){

        //Ajout label adversaire
        Label adversaire = new Label("ADVERSAIRES");
        adversaire.setLayoutX(1100);
        adversaire.setLayoutY(225);
        adversaire.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(adversaire);


        //TAILLE DU RECTANGLE ET POSITION

        rect_adversaire.setHeight(150);
        rect_adversaire.setWidth(630);
        rect_adversaire.setX(630);
        rect_adversaire.setY(120);

        //COULEUR ET CONTOUR
        rect_adversaire.setFill(Color.TRANSPARENT);
        rect_adversaire.setStroke(Color.BLACK);
    }

    public void RectanglePossession(Rectangle rect_possession){

        //Ajout d'un label "POSSESSION"
        Label textPossession = new Label("VOS POSSESSIONS");
        textPossession.setLayoutX(895);
        textPossession.setLayoutY(285);
        textPossession.setFont(Font.font("Verdana", FontWeight.BOLD, 14));


        this.getChildren().add(textPossession);

        //TAILLE DU RECTANGLE ET POSITION

        rect_possession.setHeight(425);
        rect_possession.setWidth(630);
        rect_possession.setX(630);
        rect_possession.setY(275);

        //COULEUR ET CONTOUR
        rect_possession.setFill(Color.TRANSPARENT);
        rect_possession.setStroke(Color.BLACK);
    }

    public void RectangleTerrain(Rectangle rect_terrain){
        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(750);
        textTerrain.setLayoutY(320);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textTerrain);

        //TAILLE DU RECTANGLE ET POSITION

        rect_terrain.setHeight(370);
        rect_terrain.setWidth(305);
        rect_terrain.setX(635);
        rect_terrain.setY(315);

        //COULEUR ET CONTOUR
        rect_terrain.setFill(Color.TRANSPARENT);
        rect_terrain.setStroke(Color.BLACK);
    }

    public void RectangleGare(Rectangle rect_gare){

        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(1080);
        textGare.setLayoutY(320);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textGare);

        //TAILLE DU RECTANGLE ET POSITION

        rect_gare.setHeight(100);
        rect_gare.setWidth(305);
        rect_gare.setX(950);
        rect_gare.setY(315);

        //COULEUR ET CONTOUR
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);
    }


    public void RectangleCompagnies(Rectangle rect_compagnie){

        //Ajout d'un label "COMPAGNIES"
        Label textCompagnies = new Label("COMPAGNIES");
        textCompagnies.setLayoutX(1050);
        textCompagnies.setLayoutY(435);
        textCompagnies.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textCompagnies);


        //TAILLE DU RECTANGLE ET POSITION

        rect_compagnie.setHeight(100);
        rect_compagnie.setWidth(305);
        rect_compagnie.setX(950);
        rect_compagnie.setY(425);

        //COULEUR ET CONTOUR
        rect_compagnie.setFill(Color.TRANSPARENT);
        rect_compagnie.setStroke(Color.BLACK);
    }

    public void RectangleCartePrison(Rectangle rect_cartePrison){
        //Ajout d'un label "Vous êtes libéré de prison"
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" :");
        textPrison.setLayoutX(995);
        textPrison.setLayoutY(550);
        textPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(textPrison);

        //TAILLE DU RECTANGLE ET POSITION

        rect_cartePrison.setHeight(50);
        rect_cartePrison.setWidth(305);
        rect_cartePrison.setX(950);
        rect_cartePrison.setY(535);

        //COULEUR ET CONTOUR
        rect_cartePrison.setFill(Color.TRANSPARENT);
        rect_cartePrison.setStroke(Color.BLACK);
    }

    public void boutonMenu(Button bt_menu){

        //TAILLE DES BOUTONS
        bt_menu.setPrefSize(150,10);
        bt_menu.setLayoutX(1085);
        bt_menu.setLayoutY(50);

    }

    public void boutonLancerDes(Button bt_lancerDes){

        //TAILLE DES BOUTONS
        bt_lancerDes.setPrefSize(150,10);
        bt_lancerDes.setLayoutX(950);
        bt_lancerDes.setLayoutY(600);

    }

    public void boutonTourSuivant(Button bt_tourSuivant){

        //TAILLE DES BOUTONS
        bt_tourSuivant.setPrefSize(150,10);
        bt_tourSuivant.setLayoutX(1105);
        bt_tourSuivant.setLayoutY(600);

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

        Scene nouvelle_scene = new  Scene(fenetreDe,400,170);

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

    public void fenetreDejaLancerDe()
    {
        fenetreNoire();

        Stage nouvelle_fenetre_erreur = new Stage();
        DejaLanceDes fenetreDe = new DejaLanceDes(nouvelle_fenetre_erreur, canvas);

        Scene nouvelle_scene = new  Scene(fenetreDe,400,170);

        nouvelle_fenetre_erreur.setScene(nouvelle_scene);
        nouvelle_fenetre_erreur.show();
    }

    public void caseDuBas()
    {
        //CASE DEPART

        Pane CaseDepart= new Pane() ;

        CaseDepart.setLayoutX(530);
        CaseDepart.setLayoutY(628);

        URL depart = getClass().getResource("Images/Case_Depart.png");
        Image i_depart = new Image(depart.toExternalForm());
        ImageView c_depart = new ImageView(i_depart);

        c_depart.setFitWidth(90);
        c_depart.setPreserveRatio(true);

        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(CaseDepart);
        CaseDepart.getChildren().add(c_depart);
        listePanel.add(CaseDepart);

        c_depart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                c_depart.setLayoutX(c_depart.getLayoutX()*2);
            }
        });

        //CASE BELLEVILLE
        Pane violetBelleville = new Pane();
        //dimension du panel

        violetBelleville.setLayoutX(482);
        violetBelleville.setLayoutY(628);

        //creation de l'image
        URL belleville = getClass().getResource("Images/Case_Belleville.png");
        Image i_Belleville = new Image(belleville.toExternalForm());
        ImageView c_belleville = new ImageView(i_Belleville);

        //taille de l'image
        c_belleville.setFitWidth(50);
        c_belleville.setPreserveRatio(true);
        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(violetBelleville);
        violetBelleville.getChildren().add(c_belleville);
        listePanel.add(violetBelleville);


        //CASE CAISSE DE COMMUNAUTE
        Pane PiocheCarteCommunaute = new Pane() ;

        PiocheCarteCommunaute.setLayoutX(434);
        PiocheCarteCommunaute.setLayoutY(628);

        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);

        c_com.setFitWidth(50);
        c_com.setPreserveRatio(true);

        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(PiocheCarteCommunaute);
        PiocheCarteCommunaute.getChildren().add(c_com);
        listePanel.add(PiocheCarteCommunaute);


        //CASE LECOURBE
        Pane violetLecourbe = new Pane() ;

        violetLecourbe.setLayoutX(386);
        violetLecourbe.setLayoutY(628);


        URL lecourbe = getClass().getResource("Images/Case_Lecourbe.png");
        Image i_Lecourbe = new Image(lecourbe.toExternalForm());
        ImageView c_Lecourbe = new ImageView(i_Lecourbe);

        c_Lecourbe.setFitWidth(50);
        c_Lecourbe.setPreserveRatio(true);

        this.getChildren().add(violetLecourbe);
        violetLecourbe.getChildren().add(c_Lecourbe);
        listePanel.add(violetLecourbe);


        //CASE IMPOT SUR LE REVENU
        Pane CaseImpotRevenu = new Pane() ;


        CaseImpotRevenu.setLayoutX(338);
        CaseImpotRevenu.setLayoutY(628);

        URL impot = getClass().getResource("Images/Case_Impot.png");
        Image i_impot = new Image(impot.toExternalForm());
        ImageView c_impot = new ImageView(i_impot);

        c_impot.setFitWidth(50);
        c_impot.setPreserveRatio(true);

        this.getChildren().add(CaseImpotRevenu);
        CaseImpotRevenu.getChildren().add(c_impot);
        listePanel.add(CaseImpotRevenu);


        //GARE DE MONTPARNASSE

        Pane gareMontparnasse = new Pane() ;


        gareMontparnasse.setLayoutX(290);
        gareMontparnasse.setLayoutY(628);


        URL gareM = getClass().getResource("Images/Case_GareM.png");
        Image i_gareM = new Image(gareM.toExternalForm());
        ImageView c_gareM = new ImageView(i_gareM);

        c_gareM.setFitWidth(50);
        c_gareM.setPreserveRatio(true);

        this.getChildren().add(gareMontparnasse);
        gareMontparnasse.getChildren().add(c_gareM);
        listePanel.add(gareMontparnasse);


        //CASE RUE DE VAUGIRAD

        Pane CaseVaugirad = new Pane() ;

        CaseVaugirad.setLayoutX(242);
        CaseVaugirad.setLayoutY(628);


        URL vaugirard = getClass().getResource("Images/Case_Vaugirard.png");
        Image i_vaugirard = new Image(vaugirard.toExternalForm());
        ImageView c_vaugirard = new ImageView(i_vaugirard);

        c_vaugirard.setFitWidth(50);
        c_vaugirard.setPreserveRatio(true);

        this.getChildren().add(CaseVaugirad);
        CaseVaugirad.getChildren().add(c_vaugirard);
        listePanel.add(CaseVaugirad);


        //CASE CHANCE
        Pane CaseChance = new Pane() ;

        CaseChance.setLayoutX(194);
        CaseChance.setLayoutY(628);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitWidth(50);
        c_chance.setPreserveRatio(true);

        this.getChildren().add(CaseChance);
        CaseChance.getChildren().add(c_chance);
        listePanel.add(CaseChance);


        //CASE RUE DE COURCELLES

        Pane CaseCourcelle = new Pane() ;


        CaseCourcelle.setLayoutX(146);
        CaseCourcelle.setLayoutY(628);


        URL courcelles = getClass().getResource("Images/Case_Courcelles.png");
        Image i_courcelles = new Image(courcelles.toExternalForm());
        ImageView c_courcelles = new ImageView(i_courcelles);

        c_courcelles.setFitWidth(50);
        c_courcelles.setPreserveRatio(true);

        this.getChildren().add(CaseCourcelle);
        CaseCourcelle.getChildren().add(c_courcelles);
        listePanel.add(CaseCourcelle);

        //CASE RUE REPUBLIQUE
        Pane CaseRepublique = new Pane() ;


        CaseRepublique.setLayoutX(98);
        CaseRepublique.setLayoutY(628);


        URL republique = getClass().getResource("Images/Case_Republique.png");
        Image i_republique = new Image(republique.toExternalForm());
        ImageView c_republique = new ImageView(i_republique);

        c_republique.setFitWidth(50);
        c_republique.setPreserveRatio(true);

        this.getChildren().add(CaseRepublique);
        CaseRepublique.getChildren().add(c_republique);
        listePanel.add(CaseRepublique);

        //CASE PRISON
        Pane CasePrison = new Pane() ;

        CasePrison.setLayoutX(15);
        CasePrison.setLayoutY(628);

        URL prison = getClass().getResource("Images/Case_Prison.png");
        Image i_prison = new Image(prison.toExternalForm());
        ImageView c_prison = new ImageView(i_prison);

        c_prison.setFitWidth(87);
        c_prison.setPreserveRatio(true);

        this.getChildren().add(CasePrison);
        CasePrison.getChildren().add(c_prison);
        listePanel.add(CasePrison);



    }

    public void caseDeGauche() {

///////////////////////////////////////////////////////////////////////////////////GROUPE VIOLET CLAIR
 ///////CASE DE LA VILETTE

        Pane caseVillette = new Pane();

        caseVillette.setLayoutX(15);
        caseVillette.setLayoutY(580);

        URL villette = getClass().getResource("Images/Case_Villette.png");
        Image i_villette = new Image(villette.toExternalForm());
        ImageView c_villette = new ImageView(i_villette);

        c_villette.setFitHeight(48);
        c_villette.setPreserveRatio(true);

        caseVillette.getChildren().add(c_villette);

        //Si on clique sur l'image
        caseVillette.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });

        this.getChildren().add(caseVillette);

///////CASE NEUILLY

        Pane caseNeuilly = new Pane();

        caseNeuilly.setLayoutX(15);
        caseNeuilly.setLayoutY(484);

        URL neuilly = getClass().getResource("Images/Case_Neuilly.png");
        Image i_neuilly = new Image(neuilly.toExternalForm());
        ImageView c_neuilly = new ImageView(i_neuilly);

        c_neuilly.setFitHeight(48);
        c_neuilly.setPreserveRatio(true);

        caseNeuilly.getChildren().add(c_neuilly);
        this.getChildren().add(caseNeuilly);

///////CASE PARADIS

        Pane caseParadis = new Pane();

        caseParadis.setLayoutX(15);
        caseParadis.setLayoutY(436);

        URL paradis = getClass().getResource("Images/Case_Paradis.png");
        Image i_paradis = new Image(paradis.toExternalForm());
        ImageView c_paradis = new ImageView(i_paradis);

        c_paradis.setFitHeight(48);
        c_paradis.setPreserveRatio(true);

        caseParadis.getChildren().add(c_paradis);
        this.getChildren().add(caseParadis);

///////////////////////////////////////////////////////////////////////////////////COMPAGNIE ELECTRICITE

        Pane caseCElectr = new Pane();

        caseCElectr.setLayoutX(15);
        caseCElectr.setLayoutY(532);

        URL celectr = getClass().getResource("Images/Case_CElect-15.png");
        Image i_celectr = new Image(celectr.toExternalForm());
        ImageView c_celectr = new ImageView(i_celectr);

        c_celectr.setFitHeight(48);
        c_celectr.setPreserveRatio(true);

        caseCElectr.getChildren().add(c_celectr);
        this.getChildren().add(caseCElectr);

///////////////////////////////////////////////////////////////////////////////////GARE DE LYON

        Pane caseGareL = new Pane();

        caseGareL.setLayoutX(15);
        caseGareL.setLayoutY(388);


        URL gareL = getClass().getResource("Images/Case_GareL.png");
        Image i_gareL = new Image(gareL.toExternalForm());
        ImageView c_gareL = new ImageView(i_gareL);

        caseGareL.setBackground(new Background(new BackgroundImage(i_gareL,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));

        c_gareL.setFitHeight(48);
        c_gareL.setPreserveRatio(true);


        caseGareL.getChildren().add(c_gareL);
        this.getChildren().add(caseGareL);
///////////////////////////////////////////////////////////////////////////////////GROUPE ORANGE
///////CASE Mozart

        Pane caseMozart = new Pane();

        caseMozart.setLayoutX(15);
        caseMozart.setLayoutY(340);

        URL mozart = getClass().getResource("Images/Case_Mozart.png");
        Image i_mozart = new Image(mozart.toExternalForm());
        ImageView c_mozart = new ImageView(i_mozart);

        c_mozart.setFitHeight(48);
        c_mozart.setPreserveRatio(true);

        caseMozart.getChildren().add(c_mozart);
        this.getChildren().add(caseMozart);

///////CASE SAINT MICHELLE

        Pane caseSaintM = new Pane();

        caseSaintM.setLayoutX(15);
        caseSaintM.setLayoutY(244);

        URL saintM = getClass().getResource("Images/Case_SaintM.png");
        Image i_saintM = new Image(saintM.toExternalForm());
        ImageView c_saintM = new ImageView(i_saintM);

        c_saintM.setFitHeight(48);
        c_saintM.setPreserveRatio(true);

        caseSaintM.getChildren().add(c_saintM);
        this.getChildren().add(caseSaintM);

///////CASE PIGALLE

        Pane casePigalle = new Pane();

        casePigalle.setLayoutX(15);
        casePigalle.setLayoutY(196);

        URL pigalle = getClass().getResource("Images/Case_Pigalle.png");
        Image i_pigalle = new Image(pigalle.toExternalForm());
        ImageView c_pigalle = new ImageView(i_pigalle);

        c_pigalle.setFitHeight(48);
        c_pigalle.setPreserveRatio(true);

        casePigalle.getChildren().add(c_pigalle);
        this.getChildren().add(casePigalle);

///////////////////////////////////////////////////////////////////////////////////CAISSE COMMUNAUTEE

        Pane caseCommunautee = new Pane();

        caseCommunautee.setLayoutX(35);
        caseCommunautee.setLayoutY(272);

        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);

        c_com.setRotate(90);
        c_com.setFitWidth(48);
        c_com.setPreserveRatio(true);

        caseCommunautee.getChildren().add(c_com);
        this.getChildren().add(caseCommunautee);

///////////////////////////////////////////////////////////////////////////////////PARC GRATUIT

        Pane caseParc = new Pane();

        caseParc.setLayoutX(15);
        caseParc.setLayoutY(110);

        URL parc = getClass().getResource("Images/Case_Parc.png");
        Image i_parc = new Image(parc.toExternalForm());
        ImageView c_parc = new ImageView(i_parc);

        c_parc.setFitWidth(87);
        c_parc.setPreserveRatio(true);

        caseParc.getChildren().add(c_parc);
        this.getChildren().add(caseParc);

    }

    public void caseDuHaut()
    {
        //CASE MATIGNON
        Pane CaseMatignon = new Pane();
        CaseMatignon.setLayoutX(100);
        CaseMatignon.setLayoutY(110);

        URL matignon = getClass().getResource("Images/Case_Matignon.png");
        Image i_matignon = new Image(matignon.toExternalForm());
        ImageView c_matignon = new ImageView(i_matignon);

        c_matignon.setFitWidth(48);
        c_matignon.setPreserveRatio(true);

        this.getChildren().add(CaseMatignon);
        CaseMatignon.getChildren().add(c_matignon); 

        //CASE CHANCE
        Pane CaseChance = new Pane();
        CaseChance.setLayoutX(148);
        CaseChance.setLayoutY(110);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);
        c_chance.setRotate(180);

        this.getChildren().add(CaseChance);
        CaseChance.getChildren().add(c_chance);

        //CASE MALSHERBES
        Pane CaseMalesherbes = new Pane() ;

        CaseMalesherbes.setLayoutX(196);
        CaseMalesherbes.setLayoutY(110);

        URL malesherbes = getClass().getResource("Images/Case_Malesherbes.png");
        Image i_malesherbes = new Image(malesherbes.toExternalForm());
        ImageView c_malesherbes = new ImageView(i_malesherbes);

        c_malesherbes.setFitWidth(48);
        c_malesherbes.setPreserveRatio(true);

        this.getChildren().add(CaseMalesherbes);
        CaseMalesherbes.getChildren().add(c_malesherbes);

        //CASE HENRI MARTIN
        Pane CaseHenri = new Pane() ;

        CaseHenri.setLayoutX(244);
        CaseHenri.setLayoutY(110);

        URL henriM = getClass().getResource("Images/Case_HenriM.png");
        Image i_henriM = new Image(henriM.toExternalForm());
        ImageView c_henriM = new ImageView(i_henriM);

        c_henriM.setFitWidth(48);
        c_henriM.setPreserveRatio(true);

        this.getChildren().add(CaseHenri);
        CaseHenri.getChildren().add(c_henriM);

        //GARE DU NORD
        Pane gareNord = new Pane() ;
        gareNord.setLayoutX(292);
        gareNord.setLayoutY(110);

        URL gareN = getClass().getResource("Images/Case_GareN.png");
        Image i_gareN = new Image(gareN.toExternalForm());
        ImageView c_gareN = new ImageView(i_gareN);

        c_gareN.setFitWidth(48);
        c_gareN.setPreserveRatio(true);

        this.getChildren().add(gareNord);
        gareNord.getChildren().add(c_gareN);

        //CASE SAINT HONORE
        Pane CaseHonore = new Pane() ;
        CaseHonore.setLayoutX(340);
        CaseHonore.setLayoutY(110);

        URL faubourgSH = getClass().getResource("Images/Case_FaubourgSH.png");
        Image i_faubourgSH = new Image(faubourgSH.toExternalForm());
        ImageView c_faubourgSH = new ImageView(i_faubourgSH);

        c_faubourgSH.setFitWidth(48);
        c_faubourgSH.setPreserveRatio(true);

        this.getChildren().add(CaseHonore);
        CaseHonore.getChildren().add(c_faubourgSH);

        //CASE PLACE DE LA BOURSE
        Pane CaseBourse = new Pane() ;
        CaseBourse.setLayoutX(388);
        CaseBourse.setLayoutY(110);

        URL bourse = getClass().getResource("Images/Case_Bourse.png");
        Image i_bourse = new Image(bourse.toExternalForm());
        ImageView c_bourse = new ImageView(i_bourse);

        c_bourse.setFitWidth(48);
        c_bourse.setPreserveRatio(true);

        this.getChildren().add(CaseBourse);
        CaseBourse.getChildren().add(c_bourse);

        //CASE DE COMPAGNIE DES EAUX
        Pane CaseEau = new Pane() ;
        CaseEau.setLayoutX(436);
        CaseEau.setLayoutY(110);

        URL ceaux = getClass().getResource("Images/Case_CEaux.png");
        Image i_ceaux = new Image(ceaux.toExternalForm());
        ImageView c_ceaux = new ImageView(i_ceaux);

        c_ceaux.setFitWidth(48);
        c_ceaux.setPreserveRatio(true);

        this.getChildren().add(CaseEau);
        CaseEau.getChildren().add(c_ceaux);

        //CASE LA FAYETTE
        Pane CaseFayette = new Pane() ;
        CaseFayette.setLayoutX(484);
        CaseFayette.setLayoutY(110);

        URL lafayette = getClass().getResource("Images/Case_Lafayette.png");
        Image i_lafayette = new Image(lafayette.toExternalForm());
        ImageView c_lafayette = new ImageView(i_lafayette);

        c_lafayette.setFitWidth(48);
        c_lafayette.setPreserveRatio(true);

        this.getChildren().add(CaseFayette);
        CaseFayette.getChildren().add(c_lafayette);


    }

    public void caseDeDroite()
    {
///////////////////////////////////////////////////////////////////////////////////ALLER PRISON
        Pane caseAPrison = new Pane();

        caseAPrison.setLayoutX(532);
        caseAPrison.setLayoutY(110);

        URL allez_prison = getClass().getResource("Images/Case_Allez_Prison.png");
        Image i_aprison = new Image(allez_prison.toExternalForm());
        ImageView c_aprison = new ImageView(i_aprison);

        c_aprison.setFitHeight(87);
        c_aprison.setPreserveRatio(true);

        caseAPrison.getChildren().add(c_aprison);
        this.getChildren().add(caseAPrison);
///////////////////////////////////////////////////////////////////////////////////GROUPE VERT
        ///////CASE DE BRETEUIL
        Pane caseBreteuil = new Pane();

        caseBreteuil.setLayoutX(532);
        caseBreteuil.setLayoutY(196);

        URL breteuil = getClass().getResource("Images/Case_Breteuil.png");
        Image i_breteuil = new Image(breteuil.toExternalForm());
        ImageView c_breteuil = new ImageView(i_breteuil);

        c_breteuil.setFitHeight(48);
        c_breteuil.setPreserveRatio(true);

        caseBreteuil.getChildren().add(c_breteuil);
        this.getChildren().add(caseBreteuil);

        ///////CASE DE FOCH
        Pane caseFoch = new Pane();

        caseFoch.setLayoutX(532);
        caseFoch.setLayoutY(244);

        URL foch = getClass().getResource("Images/Case_Foch.png");
        Image i_foch = new Image(foch.toExternalForm());
        ImageView c_foch = new ImageView(i_foch);

        c_foch.setFitHeight(48);
        c_foch.setPreserveRatio(true);

        caseFoch.getChildren().add(c_foch);
        this.getChildren().add(caseFoch);

        ///////CASE DE CAPUCINES
        Pane caseCapucine = new Pane();

        caseCapucine.setLayoutX(532);
        caseCapucine.setLayoutY(340);

        URL capucines = getClass().getResource("Images/Case_Capucines.png");
        Image i_capucines = new Image(capucines.toExternalForm());
        ImageView c_capucines = new ImageView(i_capucines);

        c_capucines.setFitHeight(48);
        c_capucines.setPreserveRatio(true);

        caseCapucine.getChildren().add(c_capucines);
        this.getChildren().add(caseCapucine);

///////////////////////////////////////////////////////////////////////////////////CAISSE DE COMMUNAUTEE
        Pane caseCommunautee = new Pane();

        caseCommunautee.setLayoutX(552);
        caseCommunautee.setLayoutY(272);

        URL commu3 = getClass().getResource("Images/Case_Communaute.png");
        Image i_commu3 = new Image(commu3.toExternalForm());
        ImageView c_commu3 = new ImageView(i_commu3);

        c_commu3.setFitWidth(48);
        c_commu3.setPreserveRatio(true);
        c_commu3.setRotate(-90);

        caseCommunautee.getChildren().add(c_commu3);
        this.getChildren().add(caseCommunautee);


///////////////////////////////////////////////////////////////////////////////////GARE
        Pane caseGareSL = new Pane();

        caseGareSL.setLayoutX(532);
        caseGareSL.setLayoutY(388);

        URL gareSL = getClass().getResource("Images/Case_GareSL.png");
        Image i_gareSL = new Image(gareSL.toExternalForm());
        ImageView c_gareSL = new ImageView(i_gareSL);

        c_gareSL.setFitHeight(48);
        c_gareSL.setPreserveRatio(true);

        caseGareSL.getChildren().add(c_gareSL);
        this.getChildren().add(caseGareSL);
///////////////////////////////////////////////////////////////////////////////////CHANCE
        Pane caseChance = new Pane();

        caseChance.setLayoutX(552);
        caseChance.setLayoutY(416);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setRotate(-90);
        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);

        caseChance.getChildren().add(c_chance);
        this.getChildren().add(caseChance);
///////////////////////////////////////////////////////////////////////////////////GROUPE BLEU FONCE
        ///////CASE DES CHAMPS ELYSEES
        Pane caseChampE = new Pane();

        caseChampE.setLayoutX(532);
        caseChampE.setLayoutY(484);

        URL champsE = getClass().getResource("Images/Case_ChampsE.png");
        Image i_champsE = new Image(champsE.toExternalForm());
        ImageView c_champsE = new ImageView(i_champsE);

        c_champsE.setFitHeight(48);
        c_champsE.setPreserveRatio(true);

        caseChampE.getChildren().add(c_champsE);
        this.getChildren().add(caseChampE);

        ///////CASE DE LA PAIX
        Pane casePaix = new Pane();

        casePaix.setLayoutX(532);
        casePaix.setLayoutY(580);

        URL paix = getClass().getResource("Images/Case_Paix.png");
        Image i_paix = new Image(paix.toExternalForm());
        ImageView c_paix = new ImageView(i_paix);

        c_paix.setFitHeight(48);
        c_paix.setPreserveRatio(true);

        casePaix.getChildren().add(c_paix);
        this.getChildren().add(casePaix);

///////////////////////////////////////////////////////////////////////////////////TAXE DE LUXE
        Pane caseTaxe = new Pane();

        caseTaxe.setLayoutX(532);
        caseTaxe.setLayoutY(532);

        URL taxe = getClass().getResource("Images/Case_Taxe.png");
        Image i_taxe = new Image(taxe.toExternalForm());
        ImageView c_taxe = new ImageView(i_taxe);

        c_taxe.setFitHeight(48);
        c_taxe.setPreserveRatio(true);

        caseTaxe.getChildren().add(c_taxe);
        this.getChildren().add(caseTaxe);
    }

    public void plateauJeu(){

////////IMAGES
        URL logo_centre = getClass().getResource("Images/logo-centre.png");
        Image image = new Image(logo_centre.toExternalForm());
        ImageView imageView = new ImageView(image);

/////////TAILLE DES IMAGES
        //logo centre
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);

/////////POSITION IMAGE
        //logo centre
        imageView.setX(145);
        imageView.setY(235);
////////AJOUT
        this.getChildren().add(imageView);

    }
}
