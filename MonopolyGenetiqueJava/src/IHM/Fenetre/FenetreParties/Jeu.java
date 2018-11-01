package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FentreMenuPrincipal.MenuJeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;

public class Jeu extends Parent {
    public Jeu(Stage primaryStage, Stage nouvelle_fenetre){

////////IMAGES
        URL logo_centre = getClass().getResource("logo-centre.png");
        Image image = new Image(logo_centre.toExternalForm());
        ImageView imageView = new ImageView(image);

            //Case départ
        URL depart = getClass().getResource("Case_Depart.png");
        Image i_depart = new Image(depart.toExternalForm());
        ImageView c_depart = new ImageView(i_depart);

             //Case prison
        URL prison = getClass().getResource("Case_Prison.png");
        Image i_prison = new Image(prison.toExternalForm());
        ImageView c_prison = new ImageView(i_prison);

            //Case parc
        URL allez_prison = getClass().getResource("Case_Allez_Prison.png");
        Image i_aprison = new Image(allez_prison.toExternalForm());
        ImageView c_aprison = new ImageView(i_aprison);

            //Case allez prison
        URL parc = getClass().getResource("Case_Parc.png");
        Image i_parc = new Image(parc.toExternalForm());
        ImageView c_parc = new ImageView(i_parc);

        //TAILLE DES IMAGES
            //logo centre
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);
            //depart
        c_depart.setFitWidth(100);
        c_depart.setPreserveRatio(true);
            //prison
        c_prison.setFitWidth(100);
        c_prison.setPreserveRatio(true);
            //parc
        c_parc.setFitWidth(100);
        c_parc.setPreserveRatio(true);
            //allez prison
        c_aprison.setFitWidth(100);
        c_aprison.setPreserveRatio(true);

        //POSITION IMAGE
            //logo centre
        imageView.setX(155);
        imageView.setY(230);
            //case départ
        c_depart.setX(505);
        c_depart.setY(580);
            //prison
        c_prison.setX(55);
        c_prison.setY(580);
            //parc
        c_parc.setX(55);
        c_parc.setY(130);
            //allez prison
        c_aprison.setX(505);
        c_aprison.setY(130);


        //DEFINITIONS DES RECTANGLES DANS LE JEU
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
        RectangleInfoJoueur(rect_infosJoueur);
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

                Stage nouvelle_fenetre_menu = new Stage();
                MenuJeu fenetre_menu = new MenuJeu(primaryStage, nouvelle_fenetre_menu, nouvelle_fenetre);

                Scene nouvelle_scene = new Scene(fenetre_menu,200,270);

                nouvelle_fenetre_menu.setScene(nouvelle_scene);
                nouvelle_fenetre_menu.show();

                //opacité fenetre du plateau
                nouvelle_fenetre.setOpacity(0.5);

                //BLOQUER TOUTES INTERACTIONS AVEC PLATEAU
               /* if(nouvelle_fenetre_menu.isShowing()==true)
                {
                    nouvelle_fenetre.initModality(Modality.APPLICATION_MODAL);
                }*/

            }
        });

////////BLOCAGE REDUCTION

        nouvelle_fenetre.setMinWidth(1290);
        nouvelle_fenetre.setMinHeight(750);

        // AJOUT A L'ECRAN

        this.getChildren().add(rect_infosJoueur);
        this.getChildren().add(rect_plateau);
        this.getChildren().add(imageView);
        this.getChildren().add(c_depart);
        this.getChildren().add(c_prison);
        this.getChildren().add(c_parc);
        this.getChildren().add(c_aprison);
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

    public void RectangleInfoJoueur(Rectangle rect_infosJoueur){

        //ajout labels
        Label argent = new Label("ARGENT :");
        Label enPrison = new Label("EN PRISON :");
        Label tour = new Label("TOUR :");

        //ARGENT
        argent.setLayoutX(300);
        argent.setLayoutY(50);
        argent.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(argent);

        //EN PRISON
        enPrison.setLayoutX(500);
        enPrison.setLayoutY(50);
        enPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(enPrison);

        //TOUR
        tour.setLayoutX(750);
        tour.setLayoutY(50);
        tour.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(tour);



        //TAILLE DU RECTANGLE ET POSITION

        rect_infosJoueur.setHeight(85);
        rect_infosJoueur.setWidth(1210.4);
        rect_infosJoueur.setX(55);
        rect_infosJoueur.setY(18.3);

        //COULEUR ET CONTOUR
        rect_infosJoueur.setFill(Color.TRANSPARENT);
        rect_infosJoueur.setStroke(Color.BLACK);
    }


    public void RectanglePlateau(Rectangle rect_plateau){

        //TAILLE DU RECTANGLE ET POSITION

        rect_plateau.setHeight(550);
        rect_plateau.setWidth(550);
        rect_plateau.setX(55);
        rect_plateau.setY(130);

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
        bt_menu.setLayoutX(1105);
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

}
