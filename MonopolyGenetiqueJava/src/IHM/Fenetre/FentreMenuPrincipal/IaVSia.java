package IHM.Fenetre.FentreMenuPrincipal;

import Entites.CouleurPion;
import Entites.Joueur;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.InitialisationPartie;
import Metier.InitialisationPartieIA;
import Metier.PartiesIA.Tournoi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IaVSia extends Parent {

    public IaVSia(Stage primaryStage, Stage nouvelle_fenetre)
    {
////////TEXTE
        Text t_titre = new Text(210,30,"NOUVELLE PARTIE IA VS IA");
        Text t_nbIA =  new Text(80,120,"Entrez le nombre d'intelligences artificielles : ");
        Text t_nbMutations = new Text(80,180,"Entrez le nombre de mutations à effectuer : ");
        Text t_nbTours = new Text(80,240,"Entrez le nombre de tours maximum par partie : ");

        //taille
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        t_nbIA.setScaleX(1.5);
        t_nbIA.setScaleY(1.5);

        t_nbMutations.setScaleX(1.5);
        t_nbMutations.setScaleY(1.5);

        t_nbTours.setScaleX(1.5);
        t_nbTours.setScaleY(1.5);

////////COMBO BOX
            //création des combo box
        ComboBox nb_ia = new ComboBox();
        nb_ia.getItems().addAll(
                "20",
                "40",
                "60",
                "80",
                "100"
        );
        ComboBox nb_mutations= new ComboBox();
        nb_mutations.getItems().addAll(
                "100",
                "200",
                "300",
                "400",
                "500"
        );
        ComboBox nb_tours = new ComboBox();
        nb_tours.getItems().addAll(
                "20",
                "30",
                "40",
                "50"
        );
            //affichage du premier élément des combo box
        nb_ia.getSelectionModel().selectFirst();
        nb_mutations.getSelectionModel().selectFirst();
        nb_tours.getSelectionModel().selectFirst();

            //positionnement des combo box
        nb_ia.setLayoutX(490);
        nb_ia.setLayoutY(100);

        nb_mutations.setLayoutX(490);
        nb_mutations.setLayoutY(160);

        nb_tours.setLayoutX(490);
        nb_tours.setLayoutY(220);

            //taille
        nb_ia.setPrefSize(100,20);
        nb_mutations.setPrefSize(100,20);
        nb_tours.setPrefSize(100, 20);

////////BOUTONS quitter et lancer partie
            //création des boutons
        Button menu_principal = new Button("MENU PRINCIPAL");
        Button commencer_partie = new Button("COMMENCER LE TOURNOI");

            //positionnement
        menu_principal.setTranslateX(30);
        menu_principal.setTranslateY(300);

        commencer_partie.setTranslateX(340);
        commencer_partie.setTranslateY(300);

            //taille
        menu_principal.setPrefSize(250,30);
        commencer_partie.setPrefSize(250,30);

            //ACTION SI BOUTON MENU PRINCIPAL
        menu_principal.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.show();
                nouvelle_fenetre.close();
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
                Automate automate = new Automate(listeJoueurs);
                */

                //lancement du tournoi
                System.out.println("\n    DEBUT DU TOURNOI\n");
                System.out.println("Nombre d'IA : "+Integer.valueOf((String) nb_ia.getValue()));
                System.out.println("Nombre de mutations à effectuer : "+Integer.valueOf((String) nb_mutations.getValue()));
                System.out.println("Nombre de tours max par partie : "+Integer.valueOf((String) nb_tours.getValue()));

                Tournoi tournoi = new Tournoi(Integer.valueOf((String) nb_ia.getValue()),Integer.valueOf((String) nb_mutations.getValue()),Integer.valueOf((String) nb_tours.getValue()));
                tournoi.lancerLeTournoi();
                //fin lancement du tournoi

                /*
                Color couleur= Color.BLACK;
                Stage nouvelle_fenetre_plateau = new Stage();
                Jeu fenentre_jeu = new Jeu(primaryStage,nouvelle_fenetre_plateau,couleur,automate) ;
                Scene nouvelle_scene = new Scene(fenentre_jeu,1275,710);

                nouvelle_fenetre_plateau.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre_plateau.show();
                nouvelle_fenetre.close();
                */
            }
        });

////////BLOCAGE REDUCTION

        nouvelle_fenetre.setMinWidth(630);
        nouvelle_fenetre.setMinHeight(390);

        nouvelle_fenetre.setMaxWidth(630);
        nouvelle_fenetre.setMaxHeight(390);

////////AJOUT
        this.getChildren().add(t_titre);
        this.getChildren().add(t_nbIA);
        this.getChildren().add(t_nbMutations);
        this.getChildren().add(t_nbTours);
        this.getChildren().add(nb_ia);
        this.getChildren().add(nb_mutations);
        this.getChildren().add(nb_tours);
        this.getChildren().add(menu_principal);
        this.getChildren().add(commencer_partie);
    }
}
