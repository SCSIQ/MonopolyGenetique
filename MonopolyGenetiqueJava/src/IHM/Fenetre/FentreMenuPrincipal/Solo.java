package IHM.Fenetre.FentreMenuPrincipal;

import Entites.Joueur;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
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

        Text t_titre = new Text(200,30,"NOUVELLE PARTIE SOLO");
        Text t_adv = new Text(76, 80, "Choisissez le nombre d'adversaires : ");
        Text t_couleur = new Text(64, 140, "Choisissez votre couleur : ");
        Text t_tours = new Text(74, 200, "Choisissez le nombre de  tours : ");

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
        nb_adversaires.setLayoutX(430);
        nb_adversaires.setLayoutY(60);

        nb_tours.setLayoutX(430);
        nb_tours.setLayoutY(180);

        //taille
        nb_adversaires.setPrefSize(60,10);
        nb_tours.setPrefSize(60, 10);

////////COLORPICKER

        ColorPicker couleur = new ColorPicker();
        couleur.setValue(Color.RED);

            //position
        couleur.setLayoutX(430);
        couleur.setLayoutY(120);

            //taille
        couleur.setPrefSize(60,25);

////////BOUTONS
        //création des boutons
        Button menu_principal = new Button("MENU PRINCIPAL");
        Button commencer_partie = new Button("COMMENCER LA PARTIE");

        //positionnement
        menu_principal.setTranslateX(30);
        menu_principal.setTranslateY(250);

        commencer_partie.setTranslateX(290);
        commencer_partie.setTranslateY(250);

        //taille
        menu_principal.setPrefSize(200,10);
        commencer_partie.setPrefSize(200,10);

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

                //ici ajouter lancement automate avec en param le joueur
                Joueur j = new Joueur(null);
                ArrayList<Joueur> listeJoueurs = new ArrayList<>();
                listeJoueurs.add(j);
                for(int i = 0; i<Integer.valueOf((String) nb_adversaires.getValue()) ; i++){
                    listeJoueurs.add(new Joueur(null));
                }
                System.out.println("Nombre de joueurs : "+listeJoueurs.size());
                Automate automate = new Automate(listeJoueurs);

                Stage nouvelle_fenetre_plateau = new Stage();
                Jeu fenentre_jeu = new Jeu(primaryStage,nouvelle_fenetre_plateau,couleur.getValue(),automate);
                Scene nouvelle_scene = new Scene(fenentre_jeu,1275,710);

                nouvelle_fenetre_plateau.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre_plateau.show();
                nouvelle_fenetre.close();

            }
        });

////////BLOCAGE REDUCTION

        nouvelle_fenetre.setMinWidth(530);
        nouvelle_fenetre.setMinHeight(330);

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
