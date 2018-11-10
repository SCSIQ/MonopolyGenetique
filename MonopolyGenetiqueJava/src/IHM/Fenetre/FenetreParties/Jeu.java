package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FentreMenuPrincipal.MenuJeu;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.net.URL;

public class Jeu extends Parent {

    private Canvas canvas = new Canvas(1275,1275);
    private Automate automate;

    public Jeu(Stage primaryStage, Stage nouvelle_fenetre, Color couleur, Automate automate){

        this.automate = automate;

        //plateauJeau();
        caseDuBas() ;
        caseDeGauche();

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

                /*Stage nouvelle_fenetre_menu = new Stage();
                MenuJeu fenetre_menu = new MenuJeu(primaryStage, nouvelle_fenetre_menu, nouvelle_fenetre, couleur);

                Scene nouvelle_scene = new Scene(fenetre_menu,200,270);

                nouvelle_fenetre_menu.setScene(nouvelle_scene);
                nouvelle_fenetre_menu.show();*/

                //opacité fenetre du plateau
               // nouvelle_fenetre.setOpacity(0.5);

                choixMenu(primaryStage, nouvelle_fenetre, couleur);

            }
        });

////////BLOCAGE REDUCTION

        nouvelle_fenetre.setMinWidth(1290);
        nouvelle_fenetre.setMinHeight(750);

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

    public void RectangleInfoJoueur(Rectangle rect_infosJoueur, Color couleur){

        //ajout rectangle couleur
        Rectangle r_couleur = new Rectangle();
        r_couleur.setHeight(50);
        r_couleur.setWidth(50);
        r_couleur.setLayoutX(30);
        r_couleur.setLayoutY(35);
        r_couleur.setStroke(Color.BLACK);
        r_couleur.setStrokeWidth(1);
        r_couleur.setFill(Paint.valueOf(couleur.toString()));
        this.getChildren().add(r_couleur);

        //ajout labels
        Label nom = new Label("JOUEUR ");
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
        gc.fillRect(0,0, 1275,1275);
        this.getChildren().add(canvas);
    }

    public void choixMenu(Stage primaryStage, Stage fenetre_actuelle, Color couleur) {
        fenetreNoire();

        Stage nouvelle_fenetre_menu = new Stage();
        MenuJeu fenetre_menu = new MenuJeu(primaryStage, nouvelle_fenetre_menu, fenetre_actuelle, couleur, canvas);

        Scene nouvelle_scene = new Scene(fenetre_menu,200,270);

        nouvelle_fenetre_menu.setScene(nouvelle_scene);
        nouvelle_fenetre_menu.show();
    }

    public void caseDuBas()
    {
        //CASE DEPART

        Pane CaseDepart= new Pane() ;

        CaseDepart.setLayoutX(530);
        CaseDepart.setLayoutY(620);

        URL depart = getClass().getResource("Images/Case_Depart.png");
        Image i_depart = new Image(depart.toExternalForm());
        ImageView c_depart = new ImageView(i_depart);

        c_depart.setFitWidth(90);
        c_depart.setPreserveRatio(true);

        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(CaseDepart);
        CaseDepart.getChildren().add(c_depart);


        //CASE BELLEVILLE
        Pane violetBelleville = new Pane();
        //dimension du panel

        violetBelleville.setLayoutX(482);
        violetBelleville.setLayoutY(620);

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

        //CASE CAISSE DE COMMUNAUTE
        Pane PiocheCarteCommunaute = new Pane() ;

        PiocheCarteCommunaute.setLayoutX(434);
        PiocheCarteCommunaute.setLayoutY(620);

        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);

        c_com.setFitWidth(50);
        c_com.setPreserveRatio(true);

        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(PiocheCarteCommunaute);
        PiocheCarteCommunaute.getChildren().add(c_com);

        //CASE LECOURBE
        Pane violetLecourbe = new Pane() ;

        violetLecourbe.setLayoutX(386);
        violetLecourbe.setLayoutY(620);


        URL lecourbe = getClass().getResource("Images/Case_Lecourbe.png");
        Image i_Lecourbe = new Image(lecourbe.toExternalForm());
        ImageView c_Lecourbe = new ImageView(i_Lecourbe);

        c_Lecourbe.setFitWidth(50);
        c_Lecourbe.setPreserveRatio(true);

        this.getChildren().add(violetLecourbe);
        violetLecourbe.getChildren().add(c_Lecourbe);

        //CASE IMPOT SUR LE REVENU
        Pane CaseImpotRevenu = new Pane() ;


        CaseImpotRevenu.setLayoutX(338);
        CaseImpotRevenu.setLayoutY(620);

        URL impot = getClass().getResource("Images/Case_Impot.png");
        Image i_impot = new Image(impot.toExternalForm());
        ImageView c_impot = new ImageView(i_impot);

        c_impot.setFitWidth(50);
        c_impot.setPreserveRatio(true);

        this.getChildren().add(CaseImpotRevenu);
        CaseImpotRevenu.getChildren().add(c_impot);

        //GARE DE MONTPARNASSE

        Pane gareMontparnasse = new Pane() ;


        gareMontparnasse.setLayoutX(290);
        gareMontparnasse.setLayoutY(620);


        URL gareM = getClass().getResource("Images/Case_GareM.png");
        Image i_gareM = new Image(gareM.toExternalForm());
        ImageView c_gareM = new ImageView(i_gareM);

        c_gareM.setFitWidth(50);
        c_gareM.setPreserveRatio(true);

        this.getChildren().add(gareMontparnasse);
        gareMontparnasse.getChildren().add(c_gareM);

        //CASE RUE DE VAUGIRAD

        Pane CaseVaugirad = new Pane() ;

        CaseVaugirad.setLayoutX(242);
        CaseVaugirad.setLayoutY(620);


        URL vaugirard = getClass().getResource("Images/Case_Vaugirard.png");
        Image i_vaugirard = new Image(vaugirard.toExternalForm());
        ImageView c_vaugirard = new ImageView(i_vaugirard);

        c_vaugirard.setFitWidth(50);
        c_vaugirard.setPreserveRatio(true);

        this.getChildren().add(CaseVaugirad);
        CaseVaugirad.getChildren().add(c_vaugirard);

        //CASE CHANCE
        Pane CaseChance = new Pane() ;

        CaseChance.setLayoutX(194);
        CaseChance.setLayoutY(620);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitWidth(50);
        c_chance.setPreserveRatio(true);

        this.getChildren().add(CaseChance);
        CaseChance.getChildren().add(c_chance);

        //CASE RUE DE COURCELLES

        Pane CaseCourcelle = new Pane() ;


        CaseCourcelle.setLayoutX(146);
        CaseCourcelle.setLayoutY(620);


        URL courcelles = getClass().getResource("Images/Case_Courcelles.png");
        Image i_courcelles = new Image(courcelles.toExternalForm());
        ImageView c_courcelles = new ImageView(i_courcelles);

        c_courcelles.setFitWidth(50);
        c_courcelles.setPreserveRatio(true);

        this.getChildren().add(CaseCourcelle);
        CaseCourcelle.getChildren().add(c_courcelles);

        //CASE RUE REPUBLIQUE
        Pane CaseRepublique = new Pane() ;


        CaseRepublique.setLayoutX(98);
        CaseRepublique.setLayoutY(620);


        URL republique = getClass().getResource("Images/Case_Republique.png");
        Image i_republique = new Image(republique.toExternalForm());
        ImageView c_republique = new ImageView(i_republique);

        c_republique.setFitWidth(50);
        c_republique.setPreserveRatio(true);

        this.getChildren().add(CaseRepublique);
        CaseRepublique.getChildren().add(c_republique);

        //CASE PRISON
        Pane CasePrison = new Pane() ;

        CasePrison.setLayoutX(15);
        CasePrison.setLayoutY(620);

        URL prison = getClass().getResource("Images/Case_Prison.png");
        Image i_prison = new Image(prison.toExternalForm());
        ImageView c_prison = new ImageView(i_prison);

        c_prison.setFitWidth(87);
        c_prison.setPreserveRatio(true);

        this.getChildren().add(CasePrison);
        CasePrison.getChildren().add(c_prison);



    }

    public void caseDeGauche() {
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
                c_villette.setTranslateX(100);
            }
        });


        this.getChildren().add(caseVillette);
    }

    public void plateauJeau(){

////////IMAGES
        URL logo_centre = getClass().getResource("Images/logo-centre.png");
        Image image = new Image(logo_centre.toExternalForm());
        ImageView imageView = new ImageView(image);

        //Case départ
        URL depart = getClass().getResource("Images/Case_Depart.png");
        Image i_depart = new Image(depart.toExternalForm());
        ImageView c_depart = new ImageView(i_depart);

        //Cases Groupe Violet
        URL belleville = getClass().getResource("Images/Case_Belleville.png");
        Image i_Belleville = new Image(belleville.toExternalForm());
        ImageView c_belleville = new ImageView(i_Belleville);

        URL lecourbe = getClass().getResource("Images/Case_Lecourbe.png");
        Image i_Lecourbe = new Image(lecourbe.toExternalForm());
        ImageView c_Lecourbe = new ImageView(i_Lecourbe);

        //Case prison
        URL prison = getClass().getResource("Images/Case_Prison.png");
        Image i_prison = new Image(prison.toExternalForm());
        ImageView c_prison = new ImageView(i_prison);

        //Case allez prison
        URL allez_prison = getClass().getResource("Images/Case_Allez_Prison.png");
        Image i_aprison = new Image(allez_prison.toExternalForm());
        ImageView c_aprison = new ImageView(i_aprison);

        //Case parc
        URL parc = getClass().getResource("Images/Case_Parc.png");
        Image i_parc = new Image(parc.toExternalForm());
        ImageView c_parc = new ImageView(i_parc);

        //Cases caisse de communauté
            //bas
        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);
            //gauche
        URL commu2 = getClass().getResource("Images/Case_Communaute.png");
        Image i_com2 = new Image(commu2.toExternalForm());
        ImageView c_com2 = new ImageView(i_com2);
            //droite
        URL commu3 = getClass().getResource("Images/Case_Communaute.png");
        Image i_commu3 = new Image(commu3.toExternalForm());
        ImageView c_commu3 = new ImageView(i_commu3);

        //Cases chance
            //bas
        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);
            //haut
        URL chance3 = getClass().getResource("Images/Case_Chance.png");
        Image i_chance3 = new Image(chance3.toExternalForm());
        ImageView c_chance3 = new ImageView(i_chance3);
            //droite
        URL chance2 = getClass().getResource("Images/Case_Chance.png");
        Image i_chance2 = new Image(chance2.toExternalForm());
        ImageView c_chance2 = new ImageView(i_chance2);

        //Case impot et taxe
        URL impot = getClass().getResource("Images/Case_Impot.png");
        Image i_impot = new Image(impot.toExternalForm());
        ImageView c_impot = new ImageView(i_impot);

        URL taxe = getClass().getResource("Images/Case_Taxe.png");
        Image i_taxe = new Image(taxe.toExternalForm());
        ImageView c_taxe = new ImageView(i_taxe);

        //Cases compagnies
            //eau
        URL ceaux = getClass().getResource("Images/Case_CEaux.png");
        Image i_ceaux = new Image(ceaux.toExternalForm());
        ImageView c_ceaux = new ImageView(i_ceaux);
            //electr
        URL celectr = getClass().getResource("Images/Case_CElect-15.png");
        Image i_celectr = new Image(celectr.toExternalForm());
        ImageView c_celectr = new ImageView(i_celectr);

        //Cases Gares
            //Gare M
        URL gareM = getClass().getResource("Images/Case_GareM.png");
        Image i_gareM = new Image(gareM.toExternalForm());
        ImageView c_gareM = new ImageView(i_gareM);

        //Gare M test


            //Gare du nord
        URL gareN = getClass().getResource("Images/Case_GareN.png");
        Image i_gareN = new Image(gareN.toExternalForm());
        ImageView c_gareN = new ImageView(i_gareN);
            //gare de lyon
        URL gareL = getClass().getResource("Images/Case_GareL.png");
        Image i_gareL = new Image(gareL.toExternalForm());
        ImageView c_gareL = new ImageView(i_gareL);
            //gare Saint-Lazare
        URL gareSL = getClass().getResource("Images/Case_GareSL.png");
        Image i_gareSL = new Image(gareSL.toExternalForm());
        ImageView c_gareSL = new ImageView(i_gareSL);

        //groupe bleu
        URL vaugirard = getClass().getResource("Images/Case_Vaugirard.png");
        Image i_vaugirard = new Image(vaugirard.toExternalForm());
        ImageView c_vaugirard = new ImageView(i_vaugirard);

        URL courcelles = getClass().getResource("Images/Case_Courcelles.png");
        Image i_courcelles = new Image(courcelles.toExternalForm());
        ImageView c_courcelles = new ImageView(i_courcelles);

        URL republique = getClass().getResource("Images/Case_Republique.png");
        Image i_republique = new Image(republique.toExternalForm());
        ImageView c_republique = new ImageView(i_republique);

        //groupe violete clair
        URL villette = getClass().getResource("Images/Case_Villette.png");
        Image i_villette = new Image(villette.toExternalForm());
        ImageView c_villette = new ImageView(i_villette);

        URL neuilly = getClass().getResource("Images/Case_Neuilly.png");
        Image i_neuilly = new Image(neuilly.toExternalForm());
        ImageView c_neuilly = new ImageView(i_neuilly);

        URL paradis = getClass().getResource("Images/Case_Paradis.png");
        Image i_paradis = new Image(paradis.toExternalForm());
        ImageView c_paradis = new ImageView(i_paradis);

        //groupe orange
        URL mozart = getClass().getResource("Images/Case_Mozart.png");
        Image i_mozart = new Image(mozart.toExternalForm());
        ImageView c_mozart = new ImageView(i_mozart);

        URL saintM = getClass().getResource("Images/Case_SaintM.png");
        Image i_saintM = new Image(saintM.toExternalForm());
        ImageView c_saintM = new ImageView(i_saintM);

        URL pigalle = getClass().getResource("Images/Case_Pigalle.png");
        Image i_pigalle = new Image(pigalle.toExternalForm());
        ImageView c_pigalle = new ImageView(i_pigalle);

        //groupe rouge
        URL matignon = getClass().getResource("Images/Case_Matignon.png");
        Image i_matignon = new Image(matignon.toExternalForm());
        ImageView c_matignon = new ImageView(i_matignon);

        URL malesherbes = getClass().getResource("Images/Case_Malesherbes.png");
        Image i_malesherbes = new Image(malesherbes.toExternalForm());
        ImageView c_malesherbes = new ImageView(i_malesherbes);

        URL henriM = getClass().getResource("Images/Case_HenriM.png");
        Image i_henriM = new Image(henriM.toExternalForm());
        ImageView c_henriM = new ImageView(i_henriM);

        //groupe jaune
        URL faubourgSH = getClass().getResource("Images/Case_FaubourgSH.png");
        Image i_faubourgSH = new Image(faubourgSH.toExternalForm());
        ImageView c_faubourgSH = new ImageView(i_faubourgSH);

        URL bourse = getClass().getResource("Images/Case_Bourse.png");
        Image i_bourse = new Image(bourse.toExternalForm());
        ImageView c_bourse = new ImageView(i_bourse);

        URL lafayette = getClass().getResource("Images/Case_Lafayette.png");
        Image i_lafayette = new Image(lafayette.toExternalForm());
        ImageView c_lafayette = new ImageView(i_lafayette);

        //groupe vert
        URL breteuil = getClass().getResource("Images/Case_Breteuil.png");
        Image i_breteuil = new Image(breteuil.toExternalForm());
        ImageView c_breteuil = new ImageView(i_breteuil);

        URL foch = getClass().getResource("Images/Case_Foch.png");
        Image i_foch = new Image(foch.toExternalForm());
        ImageView c_foch = new ImageView(i_foch);

        URL capucines = getClass().getResource("Images/Case_Capucines.png");
        Image i_capucines = new Image(capucines.toExternalForm());
        ImageView c_capucines = new ImageView(i_capucines);

        //groupe bleu foncé
        URL champsE = getClass().getResource("Images/Case_ChampsE.png");
        Image i_champsE = new Image(champsE.toExternalForm());
        ImageView c_champsE = new ImageView(i_champsE);

        URL paix = getClass().getResource("Images/Case_Paix.png");
        Image i_paix = new Image(paix.toExternalForm());
        ImageView c_paix = new ImageView(i_paix);


/////////TAILLE DES IMAGES
        //logo centre
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);

        //depart
        c_depart.setFitWidth(87);
        c_depart.setPreserveRatio(true);

        //prison
        c_prison.setFitWidth(87);
        c_prison.setPreserveRatio(true);

        //parc
        c_parc.setFitWidth(87);
        c_parc.setPreserveRatio(true);

        //allez prison
        c_aprison.setFitWidth(87);
        c_aprison.setPreserveRatio(true);

        //Caisse commu
        c_com.setFitWidth(48);
        c_com.setPreserveRatio(true);

        c_com2.setFitWidth(48);
        c_com2.setPreserveRatio(true);

        c_commu3.setFitWidth(48);
        c_commu3.setPreserveRatio(true);
        c_commu3.setRotate(-90);

        //Case chances
        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);

        c_chance3.setFitWidth(48);
        c_chance3.setPreserveRatio(true);
        c_chance3.setRotate(180);

        c_chance2.setFitWidth(48);
        c_chance2.setPreserveRatio(true);
        c_chance2.setRotate(-90);

        //groupe Violet
        c_belleville.setFitWidth(48);
        c_belleville.setPreserveRatio(true);

        c_Lecourbe.setFitWidth(48);
        c_Lecourbe.setPreserveRatio(true);

        //impôt et taxe
        c_impot.setFitWidth(48);
        c_impot.setPreserveRatio(true);

        c_taxe.setFitHeight(48);
        c_taxe.setPreserveRatio(true);

        //Gares
        c_gareM.setFitWidth(48);
        c_gareM.setPreserveRatio(true);

        c_gareN.setFitWidth(48);
        c_gareN.setPreserveRatio(true);

        c_gareL.setFitHeight(48);
        c_gareL.setPreserveRatio(true);

        c_gareSL.setFitHeight(48);
        c_gareSL.setPreserveRatio(true);

        //groupe bleu
        c_vaugirard.setFitWidth(48);
        c_vaugirard.setPreserveRatio(true);

        c_courcelles.setFitWidth(48);
        c_courcelles.setPreserveRatio(true);

        c_republique.setFitWidth(48);
        c_republique.setPreserveRatio(true);

        //groupe violet clair
        c_villette.setFitHeight(48);
        c_villette.setPreserveRatio(true);

        c_neuilly.setFitHeight(48);
        c_neuilly.setPreserveRatio(true);

        c_paradis.setFitHeight(48);
        c_paradis.setPreserveRatio(true);

        //groupe orange
        c_mozart.setFitHeight(48);
        c_mozart.setPreserveRatio(true);

        c_saintM.setFitHeight(48);
        c_saintM.setPreserveRatio(true);

        c_pigalle.setFitHeight(48);
        c_pigalle.setPreserveRatio(true);

        //groupe rouge
        c_matignon.setFitWidth(48);
        c_matignon.setPreserveRatio(true);

        c_malesherbes.setFitWidth(48);
        c_malesherbes.setPreserveRatio(true);

        c_henriM.setFitWidth(48);
        c_henriM.setPreserveRatio(true);

        //groupe jaune
        c_faubourgSH.setFitWidth(48);
        c_faubourgSH.setPreserveRatio(true);

        c_bourse.setFitWidth(48);
        c_bourse.setPreserveRatio(true);

        c_lafayette.setFitWidth(48);
        c_lafayette.setPreserveRatio(true);

        //groupe vert
        c_breteuil.setFitHeight(48);
        c_breteuil.setPreserveRatio(true);

        c_foch.setFitHeight(48);
        c_foch.setPreserveRatio(true);

        c_capucines.setFitHeight(48);
        c_capucines.setPreserveRatio(true);

        //groupe bleu foncé
        c_champsE.setFitHeight(48);
        c_champsE.setPreserveRatio(true);

        c_paix.setFitHeight(48);
        c_paix.setPreserveRatio(true);

        //Compagnies
        c_ceaux.setFitWidth(48);
        c_ceaux.setPreserveRatio(true);

        c_celectr.setFitHeight(48);
        c_celectr.setPreserveRatio(true);

/////////POSITION IMAGE
        //logo centre
        imageView.setX(145);
        imageView.setY(235);

        //////////////////////////LIGNE BAS
        c_depart.setX(532);
        c_depart.setY(628);

        c_belleville.setX(484);
        c_belleville.setY(628);

        c_com.setX(436);
        c_com.setY(628);

        c_Lecourbe.setX(388);
        c_Lecourbe.setY(628);

        c_impot.setX(340);
        c_impot.setY(628);

        c_gareM.setX(292);
        c_gareM.setY(628);

        c_vaugirard.setX(244);
        c_vaugirard.setY(628);

        c_chance.setX(196);
        c_chance.setY(628);

        c_courcelles.setX(148);
        c_courcelles.setY(628);

        c_republique.setX(100);
        c_republique.setY(628);

        c_prison.setX(15);
        c_prison.setY(628);

        //////////////////////////LIGNE HAUT

        c_parc.setX(15);
        c_parc.setY(110);

        c_matignon.setX(100);
        c_matignon.setY(110);

        c_chance3.setX(148);
        c_chance3.setY(110);

        c_malesherbes.setX(196);
        c_malesherbes.setY(110);

        c_henriM.setX(244);
        c_henriM.setY(110);

        c_gareN.setX(292);
        c_gareN.setY(110);

        c_faubourgSH.setX(340);
        c_faubourgSH.setY(110);

        c_bourse.setX(388);
        c_bourse.setY(110);

        c_ceaux.setX(436);
        c_ceaux.setY(110);

        c_lafayette.setX(484);
        c_lafayette.setY(110);

        c_aprison.setX(532);
        c_aprison.setY(110);

        //////////////////////////COLONNE GAUCHE
        c_villette.setX(15);
        c_villette.setY(580);

        c_celectr.setX(15);
        c_celectr.setY(532);

        c_neuilly.setX(15);
        c_neuilly.setY(484);

        c_paradis.setX(15);
        c_paradis.setY(436);

        c_gareL.setX(15);
        c_gareL.setY(388);

        c_mozart.setX(15);
        c_mozart.setY(340);

        c_com2.setRotate(90);
        c_com2.setX(35);
        c_com2.setY(272);

        c_saintM.setX(15);
        c_saintM.setY(244);

        c_pigalle.setX(15);
        c_pigalle.setY(196);

        //////////////////////////COLONNE DROITE
        c_breteuil.setX(532);
        c_breteuil.setY(196);

        c_foch.setX(532);
        c_foch.setY(244);

        c_commu3.setX(552);
        c_commu3.setY(272);

        c_capucines.setX(532);
        c_capucines.setY(340);

        c_gareSL.setX(532);
        c_gareSL.setY(388);

        c_chance2.setX(552);
        c_chance2.setY(416);

        c_champsE.setX(532);
        c_champsE.setY(484);

        c_taxe.setX(532);
        c_taxe.setY(532);

        c_paix.setX(532);
        c_paix.setY(580);

////////AJOUT
        this.getChildren().add(imageView);
        this.getChildren().add(c_depart);
        this.getChildren().add(c_belleville);
        this.getChildren().add(c_Lecourbe);
        this.getChildren().add(c_impot);
        this.getChildren().add(c_gareM);
        this.getChildren().add(c_vaugirard);
        this.getChildren().add(c_chance);
        this.getChildren().add(c_courcelles);
        this.getChildren().add(c_republique);
        this.getChildren().add(c_com);
        this.getChildren().add(c_prison);
        this.getChildren().add(c_villette);
        this.getChildren().add(c_celectr);
        this.getChildren().add(c_neuilly);
        this.getChildren().add(c_paradis);
        this.getChildren().add(c_gareL);
        this.getChildren().add(c_mozart);
        this.getChildren().add(c_com2);
        this.getChildren().add(c_saintM);
        this.getChildren().add(c_pigalle);
        this.getChildren().add(c_parc);
        this.getChildren().add(c_matignon);
        this.getChildren().add(c_chance3);
        this.getChildren().add(c_malesherbes);
        this.getChildren().add(c_henriM);
        this.getChildren().add(c_gareN);
        this.getChildren().add(c_faubourgSH);
        this.getChildren().add(c_bourse);
        this.getChildren().add(c_ceaux);
        this.getChildren().add(c_lafayette);
        this.getChildren().add(c_aprison);
        this.getChildren().add(c_breteuil);
        this.getChildren().add(c_foch);
        this.getChildren().add(c_commu3);
        this.getChildren().add(c_capucines);
        this.getChildren().add(c_gareSL);
        this.getChildren().add(c_chance2);
        this.getChildren().add(c_champsE);
        this.getChildren().add(c_taxe);
        this.getChildren().add(c_paix);
    }
}
