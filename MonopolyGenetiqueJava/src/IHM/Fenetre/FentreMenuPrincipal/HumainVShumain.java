package IHM.Fenetre.FentreMenuPrincipal;

import Entites.Joueur;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HumainVShumain extends Parent {

    public HumainVShumain(Stage primaryStage, Stage nouvelle_fenetre){

////////TEXTE
        Text t_titre = new Text(140,30,"NOUVELLE PARTIE HUMAIN VS HUMAIN");
        Text t_adv = new Text(80, 90, "Choisissez le nombre de joueurs : ");
        Text t_tours = new Text(80, 190, "Choisissez le nombre de tours : ");

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
        nb_adversaires.setLayoutX(440);
        nb_adversaires.setLayoutY(70);

        nb_tours.setLayoutX(440);
        nb_tours.setLayoutY(170);

        //TAILLE COMBO BOX
        nb_adversaires.setPrefSize(60,10);
        nb_tours.setPrefSize(60, 10);

////////BOUTONS

        //BOUTONS MENU PRINCIPAL ET COMMENCER PARTIE
        Button menu_principal = new Button("MENU PRINCIPAL");
        Button commencer_partie = new Button("COMMENCER PARTIE");

        //POSITION
        menu_principal.setLayoutX(40);
        menu_principal.setLayoutY(250);
        commencer_partie.setLayoutX(300);
        commencer_partie.setLayoutY(250);

        //TAILLE BOUTONS
        menu_principal.setPrefSize(200,10);
        commencer_partie.setPrefSize(200,10);

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
                Color couleur= Color.BLACK;

                //ici ajouter lancement automate avec en param le joueur
                Joueur j = new Joueur();
                ArrayList<Joueur> listeJoueurs = new ArrayList<>();
                listeJoueurs.add(j);
                /*for(int i = 0; i<Integer.valueOf((String) nb_adversaires.getValue()) ; i++){
                    listeJoueurs.add(new Joueur());
                }*/
                System.out.println("Nombre de joueurs : "+listeJoueurs.size());
                Automate automate = new Automate(listeJoueurs);


                Stage nouvelle_fenetre_plateau = new Stage();
                Jeu fenentre_jeu = new Jeu(primaryStage, nouvelle_fenetre_plateau, couleur,automate) ;
                Scene nouvelle_scene = new Scene(fenentre_jeu,1275,1275);

                nouvelle_fenetre_plateau.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre_plateau.show();
                nouvelle_fenetre.close();
            }
        });

////////BLOCAGE REDUCTION

        nouvelle_fenetre.setMinWidth(530);
        nouvelle_fenetre.setMinHeight(330);

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

}
