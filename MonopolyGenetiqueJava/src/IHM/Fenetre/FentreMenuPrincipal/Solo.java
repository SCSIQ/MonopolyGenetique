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


public class Solo extends Parent {

    public Solo(Stage primaryStage, Stage nouvelle_fenetre) {

////////TEXTE

        Text t_titre = new Text(250,40,"NOUVELLE PARTIE SOLO");
        Text t_adv = new Text(76, 120, "Choisissez le nombre d'adversaires : ");
        Text t_couleur = new Text(64, 180, "Choisissez votre couleur : ");
        Text t_tours = new Text(74, 240, "Choisissez le nombre de  tours : ");

            //taille
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        t_adv.setScaleX(1.5);
        t_adv.setScaleY(1.5);

        t_couleur.setScaleX(1.5);
        t_couleur.setScaleY(1.5);

        t_tours.setScaleX(1.5);
        t_tours.setScaleY(1.5);

////////COMBOBOX

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

        //selection premier élément
        nb_adversaires.getSelectionModel().selectFirst();
        nb_tours.getSelectionModel().selectFirst();

        //position
        nb_adversaires.setLayoutX(490);
        nb_adversaires.setLayoutY(100);

        nb_tours.setLayoutX(490);
        nb_tours.setLayoutY(220);

        //taille
        nb_adversaires.setPrefSize(100,20);
        nb_tours.setPrefSize(100, 20);

////////COLORPICKER

        ColorPicker couleur = new ColorPicker();
        couleur.setValue(Color.RED);

        /*ComboBox<String> couleur = new ComboBox<String>();
        ObservableList<String> data = FXCollections.observableArrayList(
                "rouge", "bleu", "noir", "jaune", "blanc", "vert" );
        couleur.setItems(data);*/

            //position
        couleur.setLayoutX(490);
        couleur.setLayoutY(160);


            //taille
        couleur.setPrefSize(100,30);

////////BOUTONS
        //création des boutons
        Button menu_principal = new Button("MENU PRINCIPAL");
        Button commencer_partie = new Button("COMMENCER LA PARTIE");

        //positionnement
        menu_principal.setTranslateX(30);
        menu_principal.setTranslateY(300);

        commencer_partie.setTranslateX(340);
        commencer_partie.setTranslateY(300);

        //taille
        menu_principal.setPrefSize(250,30);
        commencer_partie.setPrefSize(250,30);

////////ACTION SI BOUTON MENU PRINCIPAL
        menu_principal.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.show() ;
                nouvelle_fenetre.close();
            }
        });

        //ACTION SI BOUTON COMMENCER PARTIE
        commencer_partie.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                //début initialisation automate
                InitialisationPartieJoueurs initialisationPartieJoueurs = new InitialisationPartieJoueurs();
                ArrayList<CouleurPion> listeCouleurs = new ArrayList<>();
                for(int i=0 ; i<Integer.valueOf((String) nb_adversaires.getValue()) ; i++){
                    listeCouleurs.add(CouleurPion.rouge);
                }
                Automate automate = initialisationPartieJoueurs.automateInitialisation(Integer.valueOf((String) nb_adversaires.getValue()),listeCouleurs);
                //fin initialisation automate

                Stage nouvelle_fenetre_plateau = new Stage();
                Jeu fenetre_jeu = new Jeu(primaryStage,nouvelle_fenetre_plateau,couleur.getValue(),automate);
                Scene nouvelle_scene = new Scene(fenetre_jeu,1275,710);

                nouvelle_fenetre_plateau.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre_plateau.show();
                nouvelle_fenetre.close();

            }
        });

////////BLOCAGE REDUCTION

        nouvelle_fenetre.setMinWidth(630);
        nouvelle_fenetre.setMinHeight(390);

        nouvelle_fenetre.setMaxWidth(630);
        nouvelle_fenetre.setMaxHeight(390);

////////ajout des éléments à la fenêtre
        this.getChildren().add(t_titre);
        this.getChildren().add(t_adv);
        this.getChildren().add(nb_adversaires);
        this.getChildren().add(t_couleur);
        this.getChildren().add(couleur);
        this.getChildren().add(t_tours);
        this.getChildren().add(nb_tours);
        this.getChildren().add(menu_principal);
        this.getChildren().add(commencer_partie);

    }
}
