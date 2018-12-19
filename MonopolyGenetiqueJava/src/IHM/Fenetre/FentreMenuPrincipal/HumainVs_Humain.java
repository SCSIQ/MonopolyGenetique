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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class HumainVs_Humain extends Parent {

    public HumainVs_Humain(Stage primaryStage, Stage nouvelle_fenetre) {
        ////////TEXTE
        Text t_titre = new Text(200,40,"NOUVELLE PARTIE HUMAIN VS HUMAIN");
        Text t_adv = new Text(80, 130, "Choisissez le nombre de joueurs : ");
        Text t_tours = new Text(80, 210, "Choisissez le nombre de tours : ");

        //TAILLE
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        t_adv.setScaleX(1.5);
        t_adv.setScaleY(1.5);

        t_tours.setScaleX(1.5);
        t_tours.setScaleY(1.5);


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
        nb_adversaires.setLayoutX(490);
        nb_adversaires.setLayoutY(110);

        nb_tours.setLayoutX(490);
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
        menu_principal.setLayoutY(300);
        commencer_partie.setLayoutX(340);
        commencer_partie.setLayoutY(300);

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