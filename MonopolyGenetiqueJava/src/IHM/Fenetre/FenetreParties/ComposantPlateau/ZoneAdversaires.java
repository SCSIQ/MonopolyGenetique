package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
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

//CLASSE S'OCCUPANT DE LA PARTIE DES ADVERSAIRES DES JOUEURS
public class ZoneAdversaires extends Parent {
    //Attributs
    Canvas canvas;


    public ZoneAdversaires(Stage primaryStage, Stage fenetre_actuelle, Automate automate, Canvas canvas)
    {
        this.canvas=canvas;

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

        //Ajout adversaire
        for(int i=0;i<=automate.getNombreJoueur();i++) {
            if(automate.getListeJoueurs().size()==2)
            {
                if((i==1) &&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant())) {
                    RectangleAdv1(primaryStage, fenetre_actuelle,automate, i);
                }
            }
            else if(automate.getListeJoueurs().size()==3)
            {
                if((i==1) &&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant())) {
                    RectangleAdv1(primaryStage, fenetre_actuelle,automate, i);
                }else if((i==2)&&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant())) {
                    RectangleAdv2(primaryStage, fenetre_actuelle,automate, i);
                }

            }else if(automate.getListeJoueurs().size()==4)
            {
                if((i==1) &&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant())) {
                    RectangleAdv1(primaryStage, fenetre_actuelle,automate, i);
                }else if((i==2)&&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv2(primaryStage, fenetre_actuelle,automate, i);
                }else if((i==3)&&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv3(primaryStage, fenetre_actuelle,automate, i);
                }
            }else if(automate.getListeJoueurs().size()==5)
            {
                if((i==1) &&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant())) {
                    RectangleAdv1(primaryStage, fenetre_actuelle,automate, i);
                }else if((i==2)&&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv2(primaryStage, fenetre_actuelle,automate, i);
                }else if((i==3)&&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv3(primaryStage, fenetre_actuelle,automate, i);
                }else if((i==4)&&(automate.getListeJoueurs().get(i)!=automate.getJoueurCourant()))
                {
                    RectangleAdv4(primaryStage, fenetre_actuelle,automate, i);
                }
            }

        }


    }

    //Les différentes zones des adversaires
    public void RectangleAdv1(Stage primaryStage, Stage fenetre_actuelle, Automate automate,int i)
    {
        //Dessin du premier rectangle
        Rectangle rect_adv = new Rectangle();
        rect_adv.setHeight(60);
        rect_adv.setWidth(300);
        rect_adv.setX(635);
        rect_adv.setY(115);
        rect_adv.setStroke(Color.BLACK);
        rect_adv.setStrokeWidth(1);
        rect_adv.setFill(Color.TRANSPARENT);
        this.getChildren().add(rect_adv);

        //Nom du joueur
        Label adv1 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv1.setLayoutX(700);
        adv1.setLayoutY(120);
        this.getChildren().add(adv1);

        //ARGENT Joueur 2
        Label argent_adv1 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv1.setLayoutX(700);
        argent_adv1.setLayoutY(150);
        this.getChildren().add(argent_adv1);

        //BOUTON DETAILS
        Button bt_adv_details = new Button("DETAILS");
        bt_adv_details.setLayoutX(850);
        bt_adv_details.setLayoutY(120);
        this.getChildren().add(bt_adv_details);

        //ajout rectangle couleur
        Rectangle r_adv1_couleur = new Rectangle();
        r_adv1_couleur.setHeight(50);
        r_adv1_couleur.setWidth(50);
        r_adv1_couleur.setLayoutX(640);
        r_adv1_couleur.setLayoutY(120);
        r_adv1_couleur.setStroke(Color.BLACK);
        r_adv1_couleur.setStrokeWidth(1);
        r_adv1_couleur.setFill(automate.getListeJoueurs().get(1).getCouleur());
        this.getChildren().add(r_adv1_couleur);

        //action bouton
        bt_adv_details.setOnAction(new EventHandler<ActionEvent>(){
        @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(primaryStage, fenetre_actuelle, automate, i);
            }
        });

    }

    public void RectangleAdv2(Stage primaryStage, Stage fenetre_actuelle, Automate automate,int i)
    {
        //Dessin du premier rectangle
        Rectangle rect_adv2 = new Rectangle();
        rect_adv2.setHeight(60);
        rect_adv2.setWidth(300);
        rect_adv2.setX(635);
        rect_adv2.setY(190);
        rect_adv2.setStroke(Color.BLACK);
        rect_adv2.setStrokeWidth(1);
        rect_adv2.setFill(Color.TRANSPARENT);
        this.getChildren().add(rect_adv2);

        //Nom du joueur
        Label adv2 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv2.setLayoutX(700);
        adv2.setLayoutY(195);
        this.getChildren().add(adv2);

        //ARGENT Joueur 2
        Label argent_adv2 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv2.setLayoutX(700);
        argent_adv2.setLayoutY(225);
        this.getChildren().add(argent_adv2);

        //BOUTON DETAILS
        Button bt_adv_details2 = new Button("DETAILS");
        bt_adv_details2.setLayoutX(850);
        bt_adv_details2.setLayoutY(195);
        this.getChildren().add(bt_adv_details2);

        //ajout rectangle couleur
        Rectangle r_adv2_couleur = new Rectangle();
        r_adv2_couleur.setHeight(50);
        r_adv2_couleur.setWidth(50);
        r_adv2_couleur.setLayoutX(640);
        r_adv2_couleur.setLayoutY(195);
        r_adv2_couleur.setStroke(Color.BLACK);
        r_adv2_couleur.setStrokeWidth(1);
        r_adv2_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());
        this.getChildren().add(r_adv2_couleur);

        //action bouton
        bt_adv_details2.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(primaryStage, fenetre_actuelle, automate, i);
            }
        });
    }

    public void RectangleAdv3(Stage primaryStage, Stage fenetre_actuelle, Automate automate,int i)
    {
        //Dessin du premier rectangle
        Rectangle rect_adv3 = new Rectangle();
        rect_adv3.setHeight(60);
        rect_adv3.setWidth(300);
        rect_adv3.setX(955);
        rect_adv3.setY(115);
        rect_adv3.setStroke(Color.BLACK);
        rect_adv3.setStrokeWidth(1);
        rect_adv3.setFill(Color.TRANSPARENT);
        this.getChildren().add(rect_adv3);

        //Nom du joueur
        Label adv3 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv3.setLayoutX(1020);
        adv3.setLayoutY(120);
        this.getChildren().add(adv3);

        //ARGENT Joueur 3
        Label argent_adv3 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv3.setLayoutX(1020);
        argent_adv3.setLayoutY(150);
        this.getChildren().add(argent_adv3);

        //BOUTON DETAILS
        Button bt_adv_details3 = new Button("DETAILS");
        bt_adv_details3.setLayoutX(1170);
        bt_adv_details3.setLayoutY(120);
        this.getChildren().add(bt_adv_details3);

        //ajout rectangle couleur
        Rectangle r_adv3_couleur = new Rectangle();
        r_adv3_couleur.setHeight(50);
        r_adv3_couleur.setWidth(50);
        r_adv3_couleur.setLayoutX(960);
        r_adv3_couleur.setLayoutY(120);
        r_adv3_couleur.setStroke(Color.BLACK);
        r_adv3_couleur.setStrokeWidth(1);
        r_adv3_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());
        this.getChildren().add(r_adv3_couleur);

        //action bouton
        bt_adv_details3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(primaryStage, fenetre_actuelle, automate, i);
            }
        });
    }

    public void RectangleAdv4(Stage primaryStage, Stage fenetre_actuelle, Automate automate,int i)
    {
        //Dessin du premier rectangle
        Rectangle rect_adv4 = new Rectangle();
        rect_adv4.setHeight(60);
        rect_adv4.setWidth(300);
        rect_adv4.setX(955);
        rect_adv4.setY(190);
        rect_adv4.setStroke(Color.BLACK);
        rect_adv4.setStrokeWidth(1);
        rect_adv4.setFill(Color.TRANSPARENT);
        this.getChildren().add(rect_adv4);

        //Nom du joueur
        Label adv4 = new Label(automate.getListeJoueurs().get(i).getNom());
        adv4.setLayoutX(1020);
        adv4.setLayoutY(195);
        this.getChildren().add(adv4);

        //ARGENT Joueur 2
        Label argent_adv4 = new Label("ARGENT : "+automate.getListeJoueurs().get(i).getSolde()+" €");
        argent_adv4.setLayoutX(1020);
        argent_adv4.setLayoutY(225);
        this.getChildren().add(argent_adv4);

        //BOUTON DETAILS
        Button bt_adv_details4 = new Button("DETAILS");
        bt_adv_details4.setLayoutX(1170);
        bt_adv_details4.setLayoutY(195);
        this.getChildren().add(bt_adv_details4);

        //ajout rectangle couleur
        Rectangle r_adv4_couleur = new Rectangle();
        r_adv4_couleur.setHeight(50);
        r_adv4_couleur.setWidth(50);
        r_adv4_couleur.setLayoutX(960);
        r_adv4_couleur.setLayoutY(195);
        r_adv4_couleur.setStroke(Color.BLACK);
        r_adv4_couleur.setStrokeWidth(1);
        r_adv4_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());
        this.getChildren().add(r_adv4_couleur);

        //action bouton
        bt_adv_details4.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
                possessionAdv(primaryStage, fenetre_actuelle, automate, i);
            }
        });

    }

    //création de la fenêtre de possession des advseraires
    public void possessionAdv(Stage primaryStage, Stage fenetre_actuelle, Automate automate, int i)
    {
        fenetreNoire();

        Stage nouvelle_fenetre_possession_Adv = new Stage();

        PossessionAdv possAdv = new PossessionAdv(primaryStage, nouvelle_fenetre_possession_Adv, fenetre_actuelle, canvas, automate, i);
        Scene nouvelle_scene = new Scene(possAdv, 650,610);

        nouvelle_fenetre_possession_Adv.setScene(nouvelle_scene);

        //fenetre modale
        nouvelle_fenetre_possession_Adv.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_possession_Adv.initOwner(fenetre_actuelle);

        nouvelle_fenetre_possession_Adv.show();
    }

    public void fenetreNoire()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        canvas.setOpacity(0.5);
        gc.fillRect(0,0, 1600,1600);
        this.getChildren().add(canvas);
    }
}
