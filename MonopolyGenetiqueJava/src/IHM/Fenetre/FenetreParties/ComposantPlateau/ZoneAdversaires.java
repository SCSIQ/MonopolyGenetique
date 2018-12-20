package IHM.Fenetre.FenetreParties.ComposantPlateau;

import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.awt.event.*;

//CLASSE S'OCCUPANT DE LA PARTIE DES ADVERSAIRES DES JOUEURS
public class ZoneAdversaires extends Parent {
    //Attributs
    private Canvas canvas;
    private Pane infoAdv1;
    private Pane infoAdv2;
    private Pane infoAdv3;
    private Pane infoAdv4;
    private Jeu jeu;


    private PossessionAdv possAd ;
    private PlateauJeu pl ;

    public PossessionAdv getPossAd() {
        return possAd;
    }



    public ZoneAdversaires(Stage primaryStage, Stage fenetre_actuelle, Automate automate, Canvas canvas, Jeu jeu, PlateauJeu pl)
    {
        this.canvas=canvas;
        this.jeu=jeu;
        this.pl = pl ;

        //Ajout label adversaire
        Label adversaire = new Label("ADVERSAIRES");
        adversaire.setLayoutX(890);
        adversaire.setLayoutY(255);
        adversaire.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(adversaire);

        Rectangle rect_adversaire = new Rectangle() ;
        //TAILLE DU RECTANGLE ET POSITION
        rect_adversaire.setHeight(170);
        rect_adversaire.setWidth(630);
        rect_adversaire.setX(630);
        rect_adversaire.setY(110);
        //COULEUR ET CONTOUR
        rect_adversaire.setFill(Color.TRANSPARENT);
        rect_adversaire.setStroke(Color.BLACK);

        this.getChildren().add(rect_adversaire);
    }

    public void genererAdversaire(Automate automate, Stage fenetre_actuelle){
        //AJOUT ADVERSAIRES

            //DEUX JOUEURS
            if(automate.getListeJoueurs().size()==2)
            {
                RectangleAdv1(fenetre_actuelle,automate, 1);

            }
            //TROIS JOUEURS
            else if(automate.getListeJoueurs().size()==3)
            {
                RectangleAdv1(fenetre_actuelle,automate, 1);
                RectangleAdv2(fenetre_actuelle,automate, 2);


            }
            //QUATRE JOUEURS
            else if(automate.getListeJoueurs().size()==4)
            {
                RectangleAdv1(fenetre_actuelle,automate, 1);
                RectangleAdv2(fenetre_actuelle,automate, 2);
                RectangleAdv3(fenetre_actuelle,automate, 3);

            }
            //CINQ JOUEURS
            else if(automate.getListeJoueurs().size()==5)
            {
                 RectangleAdv1(fenetre_actuelle,automate, 1);
                 RectangleAdv2(fenetre_actuelle,automate, 2);
                 RectangleAdv3(fenetre_actuelle,automate, 3);
                 RectangleAdv4(fenetre_actuelle,automate, 4);

            }



    }

    public void SupprimerAdversaire(){
        this.getChildren().removeAll(infoAdv1);
        this.getChildren().removeAll(infoAdv2);
        this.getChildren().removeAll(infoAdv3);
        this.getChildren().removeAll(infoAdv4);
    }

    //Les différentes zones des adversaires
    public void RectangleAdv1(Stage fenetre_actuelle, Automate automate,int i)
    {
        //Création d'un pane
        infoAdv1 = new Pane();

        infoAdv1.setLayoutX(635);
        infoAdv1.setLayoutY(115);

        //Dessin du premier rectangle
        Rectangle rect_adv = new Rectangle();
        rect_adv.setHeight(60);
        rect_adv.setWidth(300);
        rect_adv.setX(0);
        rect_adv.setY(0);
        rect_adv.setStroke(Color.BLACK);
        rect_adv.setStrokeWidth(1);
        rect_adv.setFill(Color.TRANSPARENT);

        //Nom du joueur
        Label adv1 = new Label(automate.getListeJoueurs().get(1).getNom());
        adv1.setLayoutX(65);
        adv1.setLayoutY(5);
        adv1.setText(adv1.getText().toUpperCase());

        //ARGENT Joueur 2
        Label argent_adv1 = new Label("ARGENT : "+automate.getListeJoueurs().get(1).getSolde()+" €");
        argent_adv1.setLayoutX(65);
        argent_adv1.setLayoutY(35);

        //BOUTON DETAILS
        Button bt_adv_details = new Button("DETAILS");
        bt_adv_details.setLayoutX(215);
        bt_adv_details.setLayoutY(5);

        //ajout rectangle couleur
        Rectangle r_adv1_couleur = new Rectangle();
        r_adv1_couleur.setHeight(50);
        r_adv1_couleur.setWidth(50);
        r_adv1_couleur.setLayoutX(5);
        r_adv1_couleur.setLayoutY(5);
        r_adv1_couleur.setStroke(Color.BLACK);
        r_adv1_couleur.setStrokeWidth(1);
        r_adv1_couleur.setFill(automate.getListeJoueurs().get(1).getCouleur());

        //ACTION BOUTON
        bt_adv_details.setOnAction(new EventHandler<ActionEvent>(){
        @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, 1);
            }
        });

        //AJOUT
        infoAdv1.getChildren().add(rect_adv);
        infoAdv1.getChildren().add(adv1);
        infoAdv1.getChildren().add(argent_adv1);
        infoAdv1.getChildren().add(bt_adv_details);
        infoAdv1.getChildren().add(r_adv1_couleur);
        this.getChildren().add(infoAdv1);

    }

    public void RectangleAdv2(Stage fenetre_actuelle, Automate automate,int i)
    {
        infoAdv2 = new Pane();
        infoAdv2.setLayoutX(635);
        infoAdv2.setLayoutY(190);

        //Dessin du premier rectangle
        Rectangle rect_adv2 = new Rectangle();
        rect_adv2.setHeight(60);
        rect_adv2.setWidth(300);
        rect_adv2.setX(0);
        rect_adv2.setY(0);
        rect_adv2.setStroke(Color.BLACK);
        rect_adv2.setStrokeWidth(1);
        rect_adv2.setFill(Color.TRANSPARENT);

        //Nom du joueur
        Label adv2 = new Label(automate.getListeJoueurs().get(2).getNom());
        adv2.setLayoutX(65);
        adv2.setLayoutY(5);
        adv2.setText(adv2.getText().toUpperCase());

        //ARGENT Joueur 2
        Label argent_adv2 = new Label("ARGENT : "+automate.getListeJoueurs().get(2).getSolde()+" €");
        argent_adv2.setLayoutX(65);
        argent_adv2.setLayoutY(35);

        //BOUTON DETAILS
        Button bt_adv_details2 = new Button("DETAILS");
        bt_adv_details2.setLayoutX(215);
        bt_adv_details2.setLayoutY(5);

        //ajout rectangle couleur
        Rectangle r_adv2_couleur = new Rectangle();
        r_adv2_couleur.setHeight(50);
        r_adv2_couleur.setWidth(50);
        r_adv2_couleur.setLayoutX(5);
        r_adv2_couleur.setLayoutY(5);
        r_adv2_couleur.setStroke(Color.BLACK);
        r_adv2_couleur.setStrokeWidth(1);
        r_adv2_couleur.setFill(automate.getListeJoueurs().get(2).getCouleur());


        //ACTION BOUTON
        bt_adv_details2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, 2);
            }
        });

        //AJOUT
        infoAdv2.getChildren().add(rect_adv2);
        infoAdv2.getChildren().add(adv2);
        infoAdv2.getChildren().add(argent_adv2);
        infoAdv2.getChildren().add(bt_adv_details2);
        infoAdv2.getChildren().add(r_adv2_couleur);
        this.getChildren().add(infoAdv2);
    }

    public void RectangleAdv3(Stage fenetre_actuelle, Automate automate,int i)
    {
        infoAdv3 = new Pane();
        infoAdv3.setLayoutX(955);
        infoAdv3.setLayoutY(115);

        //Dessin du premier rectangle
        Rectangle rect_adv3 = new Rectangle();
        rect_adv3.setHeight(60);
        rect_adv3.setWidth(300);
        rect_adv3.setX(0);
        rect_adv3.setY(0);
        rect_adv3.setStroke(Color.BLACK);
        rect_adv3.setStrokeWidth(1);
        rect_adv3.setFill(Color.TRANSPARENT);

        //Nom du joueur
        Label adv3 = new Label(automate.getListeJoueurs().get(3).getNom());
        adv3.setLayoutX(65);
        adv3.setLayoutY(5);
        adv3.setText(adv3.getText().toUpperCase());

        //ARGENT Joueur 3
        Label argent_adv3 = new Label("ARGENT : "+automate.getListeJoueurs().get(3).getSolde()+" €");
        argent_adv3.setLayoutX(65);
        argent_adv3.setLayoutY(35);

        //BOUTON DETAILS
        Button bt_adv_details3 = new Button("DETAILS");
        bt_adv_details3.setLayoutX(215);
        bt_adv_details3.setLayoutY(5);

        //ajout rectangle couleur
        Rectangle r_adv3_couleur = new Rectangle();
        r_adv3_couleur.setHeight(50);
        r_adv3_couleur.setWidth(50);
        r_adv3_couleur.setLayoutX(5);
        r_adv3_couleur.setLayoutY(5);
        r_adv3_couleur.setStroke(Color.BLACK);
        r_adv3_couleur.setStrokeWidth(1);
        r_adv3_couleur.setFill(automate.getListeJoueurs().get(3).getCouleur());

        //ACTION WORDPRESS
        bt_adv_details3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, 3);
            }
        });

        //AJOUT
        infoAdv3.getChildren().add(rect_adv3);
        infoAdv3.getChildren().add(adv3);
        infoAdv3.getChildren().add(argent_adv3);
        infoAdv3.getChildren().add(bt_adv_details3);
        infoAdv3.getChildren().add(r_adv3_couleur);
        this.getChildren().add(infoAdv3);
    }

    public void RectangleAdv4(Stage fenetre_actuelle, Automate automate,int i)
    {
        infoAdv4 = new Pane();
        infoAdv4.setLayoutX(955);
        infoAdv4.setLayoutY(190);

        //Dessin du premier rectangle
        Rectangle rect_adv4 = new Rectangle();
        rect_adv4.setHeight(60);
        rect_adv4.setWidth(300);
        rect_adv4.setX(0);
        rect_adv4.setY(0);
        rect_adv4.setStroke(Color.BLACK);
        rect_adv4.setStrokeWidth(1);
        rect_adv4.setFill(Color.TRANSPARENT);


        //Nom du joueur
        Label adv4 = new Label(automate.getListeJoueurs().get(4).getNom());
        adv4.setLayoutX(65);
        adv4.setLayoutY(5);
        adv4.setText(adv4.getText().toUpperCase());

        //ARGENT Joueur 2
        Label argent_adv4 = new Label("ARGENT : "+automate.getListeJoueurs().get(4).getSolde()+" €");
        argent_adv4.setLayoutX(65);
        argent_adv4.setLayoutY(35);


        //BOUTON DETAILS
        Button bt_adv_details4 = new Button("DETAILS");
        bt_adv_details4.setLayoutX(215);
        bt_adv_details4.setLayoutY(5);


        //ajout rectangle couleur
        Rectangle r_adv4_couleur = new Rectangle();
        r_adv4_couleur.setHeight(50);
        r_adv4_couleur.setWidth(50);
        r_adv4_couleur.setLayoutX(5);
        r_adv4_couleur.setLayoutY(5);
        r_adv4_couleur.setStroke(Color.BLACK);
        r_adv4_couleur.setStrokeWidth(1);
        r_adv4_couleur.setFill(automate.getListeJoueurs().get(4).getCouleur());


        //ACTION BOUTON
        bt_adv_details4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, 4);
            }
        });

        //AJOUT
        infoAdv4.getChildren().add(rect_adv4);
        infoAdv4.getChildren().add(adv4);
        infoAdv4.getChildren().add(argent_adv4);
        infoAdv4.getChildren().add(bt_adv_details4);
        infoAdv4.getChildren().add(r_adv4_couleur);
        this.getChildren().add(infoAdv4);

    }

    //création de la fenêtre de possession des advseraires
    public void possessionAdv(Stage fenetre_actuelle, Automate automate, int i)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_possession_Adv = new Stage();

        possAd = new PossessionAdv(nouvelle_fenetre_possession_Adv, fenetre_actuelle, canvas, automate, i, jeu, pl);
        Scene nouvelle_scene = new Scene(possAd, 620,610);

        nouvelle_fenetre_possession_Adv.setScene(nouvelle_scene);

        //fenetre modale
        nouvelle_fenetre_possession_Adv.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_possession_Adv.initOwner(fenetre_actuelle);

        nouvelle_fenetre_possession_Adv.show();
    }


}
