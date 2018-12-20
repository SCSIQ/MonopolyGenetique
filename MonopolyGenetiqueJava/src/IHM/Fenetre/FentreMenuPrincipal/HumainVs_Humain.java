package IHM.Fenetre.FentreMenuPrincipal;

import Entites.CouleurPion;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.InitialisationPartieJoueurs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class HumainVs_Humain extends Parent {

    public HumainVs_Humain(Stage primaryStage, Stage nouvelle_fenetre) {
        ////////TEXTE
        Button t_titre = new Button("NOUVELLE PARTIE HUMAIN VS HUMAIN");

        t_titre.setLayoutX(10);
        t_titre.setLayoutY(10);
        t_titre.setPrefSize(590,60);
        t_titre.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        t_titre.setTextFill(Color.WHITE);
        t_titre.setBackground(new Background(new BackgroundFill(Color.rgb(9,172,227), null, null)));
        t_titre.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));

        //TEXT
        Label t_adv = new Label("Choisissez le nombre de joueurs : ");
        Label t_tours = new Label("Choisissez le nombre de tours : ");

        t_adv.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
        t_tours.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));

        //TAILLE ET POSITION

        t_adv.setLayoutX(100);
        t_adv.setLayoutY(115);

        t_tours.setLayoutX(100);
        t_tours.setLayoutY(195);

        t_adv.setScaleX(1.5);
        t_adv.setScaleY(1.5);
        t_tours.setScaleX(1.5);
        t_tours.setScaleY(1.5);

        //Rectangle
        Rectangle r_contour = new Rectangle();
        r_contour.setHeight(325);
        r_contour.setWidth(590);
        r_contour.setLayoutX(10);
        r_contour.setLayoutY(10);
        r_contour.setStroke(Color.BLACK);
        r_contour.setStrokeWidth(1);
        r_contour.setFill(Color.TRANSPARENT);


////////COMBO BOX

        ComboBox nb_adversaires = new ComboBox();
        nb_adversaires.getItems().addAll(
                "2",
                "3",
                "4",
                "5"
        );
        ComboBox nb_tours = new ComboBox();
        nb_tours.getItems().addAll(
                "20",
                "30",
                "40"
        );

        //SELECTION DU PREMIER ELEMENT DE LA LISTE
        nb_adversaires.getSelectionModel().selectFirst();
        nb_tours.getSelectionModel().selectFirst();

        //POSITION
        nb_adversaires.setLayoutX(480);
        nb_adversaires.setLayoutY(110);

        nb_tours.setLayoutX(480);
        nb_tours.setLayoutY(190);

        //TAILLE COMBO BOX
        nb_adversaires.setPrefSize(100,30);
        nb_tours.setPrefSize(100, 30);

////////BOUTONS

        //BOUTONS MENU PRINCIPAL ET COMMENCER PARTIE
        Button menu_principal = new Button("MENU PRINCIPAL");
        Button commencer_partie = new Button("COMMENCER PARTIE");

        //POSITION
        menu_principal.setLayoutX(30);
        menu_principal.setLayoutY(290);
        commencer_partie.setLayoutX(330);
        commencer_partie.setLayoutY(290);

        //TAILLE BOUTONS
        menu_principal.setPrefSize(250,30);
        commencer_partie.setPrefSize(250,30);

////////ACTION BOUTON

        //ACTION SI BOUTON MENU PRINCIPAL
        menu_principal.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.show();
                nouvelle_fenetre.close() ;

            }
        });

        //ACTION SI BOUTON COMMENCER PARTIE
        commencer_partie.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                /*
                //ici ajouter lancement automate avec en param le joueur
                Joueur j = new Joueur(null, null);
                ArrayList<Joueur> listeJoueurs = new ArrayList<>();
                listeJoueurs.add(j);
                /*for(int i = 0; i<Integer.valueOf((String) nb_adversaires.getValue()) ; i++){
                    listeJoueurs.add(new Joueur());
                }
                System.out.println("Nombre de joueurs : "+listeJoueurs.size());
                Automate automate = new Automate(listeJoueurs);*/

                //début initialisation automate
                InitialisationPartieJoueurs initialisationPartieJoueurs = new InitialisationPartieJoueurs();
                ArrayList<Color> listeCouleurs = new ArrayList<>();
                for(int i=0 ; i<Integer.valueOf((String) nb_adversaires.getValue()) ; i++){
                    listeCouleurs.add(couleurAdversaire(i));
                }

                Automate automate = initialisationPartieJoueurs.automateInitialisation(Integer.valueOf((String) nb_adversaires.getValue()),listeCouleurs);
                //fin initialisation automate


                //création du plateau
                Stage nouvelle_fenetre_plateau = new Stage();
                Jeu fenetre_jeu = new Jeu(primaryStage,nouvelle_fenetre_plateau,automate.getJoueurCourant().getCouleur(),automate);
                Scene nouvelle_scene = new Scene(fenetre_jeu,1275,730);
                nouvelle_fenetre_plateau.setScene(nouvelle_scene);
                nouvelle_fenetre_plateau.show();

                nouvelle_fenetre.close();

            }
        });

////////BLOCAGE REDUCTION

        nouvelle_fenetre.setMinWidth(630);
        nouvelle_fenetre.setMinHeight(390);

        nouvelle_fenetre.setMaxWidth(630);
        nouvelle_fenetre.setMaxHeight(390);

////////AJOUT

        //ajout des éléments à la fenêtre
        this.getChildren().add(r_contour);
        this.getChildren().add(t_titre);
        this.getChildren().add(t_adv);
        this.getChildren().add(nb_adversaires);
        this.getChildren().add(t_tours);
        this.getChildren().add(nb_tours);
        this.getChildren().add(menu_principal);
        this.getChildren().add(commencer_partie);

    }

    public Color couleurAdversaire(int i)
    {

        Color couleur;
        switch (i){
            case 0 : couleur = Color.CRIMSON;
                break;
            case 1 : couleur = Color.DARKMAGENTA;
                break;
            case 2 : couleur = Color.DARKTURQUOISE;
                break;
            case 3 : couleur = Color.CORAL;
                break;
            case 4 : couleur = Color.MEDIUMSEAGREEN;
                break;
            default: couleur = Color.AZURE;
        }
        return couleur;
    }

}
