package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FentreMenuPrincipal.MenuJeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Jeu extends Parent {
    public Jeu(Stage primaryStage, Stage nouvelle_fenetre){


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

    public void RectangleInfoJoueur(Rectangle rect_infosJoueur){

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
        Label textPossession = new Label("POSSESSION");
        textPossession.setLayoutX(930);
        textPossession.setLayoutY(290);

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
