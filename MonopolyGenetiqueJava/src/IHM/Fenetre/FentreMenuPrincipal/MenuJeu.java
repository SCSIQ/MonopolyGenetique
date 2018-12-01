package IHM.Fenetre.FentreMenuPrincipal;

import Entites.Joueur;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.InitialisationPartieJoueurs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ArrayList;

public class MenuJeu extends Parent {



    public MenuJeu(Automate automate, Stage primaryStage, Stage nouvelle_fenetre, Stage fenetre_actuelle, Color couleur, Canvas canvas)
    {

////////IMAGE
        URL logo = getClass().getResource("logo.png");
        Image image = new Image(logo.toExternalForm());
        ImageView imageView = new ImageView(image);

        //TAILLE DE L'IMAGE
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);

        imageView.setLayoutX(10);

////////BOUTONS
        Button bt_nouvelle_P = new Button("NOUVELLE PARTIE") ;
        Button bt_rependreP = new Button("REPRENDRE PARTIE");
        Button bt_menuP = new Button("MENU PRINCIPAL");

        //POSITION
        bt_nouvelle_P.setLayoutX(25);
        bt_nouvelle_P.setLayoutY(190);

        bt_rependreP.setLayoutX(25);
        bt_rependreP.setLayoutY(250);

        bt_menuP.setLayoutX(25);
        bt_menuP.setLayoutY(320);

        //TAILLE
        bt_nouvelle_P.setPrefSize(270,30);
        bt_rependreP.setPrefSize(270,30);
        bt_menuP.setPrefSize(270,30);

////////ACTIONS BOUTONS
        //NOUVELLE PARTIE
        bt_nouvelle_P.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {


                //début initialisation automate
                InitialisationPartieJoueurs initialisationPartieJoueurs = new InitialisationPartieJoueurs();
                ArrayList<Color> listeCouleurs = new ArrayList<>();
                for(int i=0 ; i<automate.getNombreJoueur() ; i++){
                    listeCouleurs.add(automate.getListeJoueurs().get(i).getCouleur());
                }
                Automate _automate = initialisationPartieJoueurs.automateInitialisation(automate.getNombreJoueur(),listeCouleurs);
                //fin initialisation automate


                Stage nouvelle_fenetre_plateau = new Stage();
                Jeu fenentre_jeu = new Jeu(primaryStage,nouvelle_fenetre_plateau,couleur,_automate) ;
                Scene nouvelle_scene = new Scene(fenentre_jeu,1275,1275);

                nouvelle_fenetre_plateau.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre_plateau.show();

                //on ferme les autres
                nouvelle_fenetre.close();
                fenetre_actuelle.close();

            }
        });

        //REPRENDRE PARTIE
        bt_rependreP.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //on ferme la fenêtre
                nouvelle_fenetre.close();

                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);


            }
        });

        //RETOUR MENU PRINCIPAL
        bt_menuP.setOnAction(new EventHandler<ActionEvent>(){
        @Override
            public void handle(ActionEvent event) {

            //on ferme la fenêtre
            nouvelle_fenetre.close();
            fenetre_actuelle.close();

            //on affiche le menu
            primaryStage.show();

        }
    });

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        nouvelle_fenetre.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });


////////BLOQUAGE DE REDUCTION DE LA FENETRE
        nouvelle_fenetre.setMinWidth(330);
        nouvelle_fenetre.setMinHeight(410);

        nouvelle_fenetre.setMaxWidth(330);
        nouvelle_fenetre.setMaxHeight(410);

////////AJOUT
        this.getChildren().add(imageView);
        this.getChildren().add(bt_nouvelle_P);
        this.getChildren().add(bt_rependreP);
        this.getChildren().add(bt_menuP);

    }


    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
