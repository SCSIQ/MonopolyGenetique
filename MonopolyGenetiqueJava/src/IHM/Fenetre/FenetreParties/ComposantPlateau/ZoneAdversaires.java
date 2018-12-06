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

//CLASSE S'OCCUPANT DE LA PARTIE DES ADVERSAIRES DES JOUEURS
public class ZoneAdversaires extends Parent {
    //Attributs
    private Canvas canvas;
    private Pane infoAdv1;
    private Pane infoAdv2;
    private Pane infoAdv3;
    private Pane infoAdv4;
    private Jeu jeu;

    public ZoneAdversaires(Stage primaryStage, Stage fenetre_actuelle, Automate automate, Canvas canvas, Jeu jeu)
    {
        this.canvas=canvas;
        this.jeu=jeu;

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
        //automate.getListeJoueurs().get(0)== joueur courant, un adversaire ne doit pas être égal à lui
        //d'où la condition : automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()
        for(int i=0;i<=automate.getNombreJoueur();i++) {

            //DEUX JOUEURS
            if(automate.getListeJoueurs().size()==2)
            {
                if((i==1) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv1(fenetre_actuelle,automate, i);
                }
            }
            //TROIS JOUEURS
            else if(automate.getListeJoueurs().size()==3)
            {
                if((i==1) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv1(fenetre_actuelle,automate, i);
                }
                else if((i==2) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv2(fenetre_actuelle,automate, i);
                }

            }
            //QUATRE JOUEURS
            else if(automate.getListeJoueurs().size()==4)
            {
                if((i==1) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv1(fenetre_actuelle,automate, i);
                }
                else if((i==2) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv2(fenetre_actuelle,automate, i);
                }
                else if((i==3) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv3(fenetre_actuelle,automate, i);
                }
            }
            //CINQ JOUEURS
            else if(automate.getListeJoueurs().size()==5)
            {
                if((i==1) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv1( fenetre_actuelle,automate, i);
                }
                else if((i==2) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv2(fenetre_actuelle,automate, i);
                }
                else if((i==3) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv3(fenetre_actuelle,automate, i);
                }
                else if((i==4) && (automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv4(fenetre_actuelle,automate, i);
                }
            }

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

        //Dessin du premier rectangle
        Rectangle rect_adv = new Rectangle();
        rect_adv.setHeight(60);
        rect_adv.setWidth(300);
        rect_adv.setX(635);
        rect_adv.setY(115);
        rect_adv.setStroke(Color.BLACK);
        rect_adv.setStrokeWidth(1);
        rect_adv.setFill(Color.TRANSPARENT);

        //Nom du joueur
        Label adv1 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv1.setLayoutX(700);
        adv1.setLayoutY(120);

        //ARGENT Joueur 2
        Label argent_adv1 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv1.setLayoutX(700);
        argent_adv1.setLayoutY(150);

        //BOUTON DETAILS
        Button bt_adv_details = new Button("DETAILS");
        bt_adv_details.setLayoutX(850);
        bt_adv_details.setLayoutY(120);

        //ajout rectangle couleur
        Rectangle r_adv1_couleur = new Rectangle();
        r_adv1_couleur.setHeight(50);
        r_adv1_couleur.setWidth(50);
        r_adv1_couleur.setLayoutX(640);
        r_adv1_couleur.setLayoutY(120);
        r_adv1_couleur.setStroke(Color.BLACK);
        r_adv1_couleur.setStrokeWidth(1);
        r_adv1_couleur.setFill(automate.getListeJoueurs().get(1).getCouleur());

        //ACTION BOUTON
        bt_adv_details.setOnAction(new EventHandler<ActionEvent>(){
        @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, i);
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

        //Dessin du premier rectangle
        Rectangle rect_adv2 = new Rectangle();
        rect_adv2.setHeight(60);
        rect_adv2.setWidth(300);
        rect_adv2.setX(635);
        rect_adv2.setY(190);
        rect_adv2.setStroke(Color.BLACK);
        rect_adv2.setStrokeWidth(1);
        rect_adv2.setFill(Color.TRANSPARENT);

        //Nom du joueur
        Label adv2 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv2.setLayoutX(700);
        adv2.setLayoutY(195);

        //ARGENT Joueur 2
        Label argent_adv2 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv2.setLayoutX(700);
        argent_adv2.setLayoutY(225);

        //BOUTON DETAILS
        Button bt_adv_details2 = new Button("DETAILS");
        bt_adv_details2.setLayoutX(850);
        bt_adv_details2.setLayoutY(195);

        //ajout rectangle couleur
        Rectangle r_adv2_couleur = new Rectangle();
        r_adv2_couleur.setHeight(50);
        r_adv2_couleur.setWidth(50);
        r_adv2_couleur.setLayoutX(640);
        r_adv2_couleur.setLayoutY(195);
        r_adv2_couleur.setStroke(Color.BLACK);
        r_adv2_couleur.setStrokeWidth(1);
        r_adv2_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());


        //ACTION BOUTON
        bt_adv_details2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, i);
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

        //Dessin du premier rectangle
        Rectangle rect_adv3 = new Rectangle();
        rect_adv3.setHeight(60);
        rect_adv3.setWidth(300);
        rect_adv3.setX(955);
        rect_adv3.setY(115);
        rect_adv3.setStroke(Color.BLACK);
        rect_adv3.setStrokeWidth(1);
        rect_adv3.setFill(Color.TRANSPARENT);

        //Nom du joueur
        Label adv3 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv3.setLayoutX(1020);
        adv3.setLayoutY(120);

        //ARGENT Joueur 3
        Label argent_adv3 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv3.setLayoutX(1020);
        argent_adv3.setLayoutY(150);

        //BOUTON DETAILS
        Button bt_adv_details3 = new Button("DETAILS");
        bt_adv_details3.setLayoutX(1170);
        bt_adv_details3.setLayoutY(120);

        //ajout rectangle couleur
        Rectangle r_adv3_couleur = new Rectangle();
        r_adv3_couleur.setHeight(50);
        r_adv3_couleur.setWidth(50);
        r_adv3_couleur.setLayoutX(960);
        r_adv3_couleur.setLayoutY(120);
        r_adv3_couleur.setStroke(Color.BLACK);
        r_adv3_couleur.setStrokeWidth(1);
        r_adv3_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());

        //ACTION WORDPRESS
        bt_adv_details3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, i);
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

        //Dessin du premier rectangle
        Rectangle rect_adv4 = new Rectangle();
        rect_adv4.setHeight(60);
        rect_adv4.setWidth(300);
        rect_adv4.setX(955);
        rect_adv4.setY(190);
        rect_adv4.setStroke(Color.BLACK);
        rect_adv4.setStrokeWidth(1);
        rect_adv4.setFill(Color.TRANSPARENT);


        //Nom du joueur
        Label adv4 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv4.setLayoutX(1020);
        adv4.setLayoutY(195);


        //ARGENT Joueur 2
        Label argent_adv4 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv4.setLayoutX(1020);
        argent_adv4.setLayoutY(225);


        //BOUTON DETAILS
        Button bt_adv_details4 = new Button("DETAILS");
        bt_adv_details4.setLayoutX(1170);
        bt_adv_details4.setLayoutY(195);


        //ajout rectangle couleur
        Rectangle r_adv4_couleur = new Rectangle();
        r_adv4_couleur.setHeight(50);
        r_adv4_couleur.setWidth(50);
        r_adv4_couleur.setLayoutX(960);
        r_adv4_couleur.setLayoutY(195);
        r_adv4_couleur.setStroke(Color.BLACK);
        r_adv4_couleur.setStrokeWidth(1);
        r_adv4_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());


        //ACTION BOUTON
        bt_adv_details4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(fenetre_actuelle, automate, i);
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

        PossessionAdv possAdv = new PossessionAdv(nouvelle_fenetre_possession_Adv, fenetre_actuelle, canvas, automate, i, jeu);
        Scene nouvelle_scene = new Scene(possAdv, 620,610);

        nouvelle_fenetre_possession_Adv.setScene(nouvelle_scene);

        //fenetre modale
        nouvelle_fenetre_possession_Adv.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_possession_Adv.initOwner(fenetre_actuelle);

        nouvelle_fenetre_possession_Adv.show();
    }


}
