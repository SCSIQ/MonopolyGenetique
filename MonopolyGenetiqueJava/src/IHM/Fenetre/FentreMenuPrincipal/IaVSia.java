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
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IaVSia extends Parent {

    public IaVSia(Stage primaryStage, Stage nouvelle_fenetre)
    {
////////TEXTE

        //TITRE
        Button t_titre = new Button("NOUVELLE PARTIE IA VS IA");

        t_titre.setLayoutX(10);
        t_titre.setLayoutY(10);
        t_titre.setPrefSize(590,60);
        t_titre.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
        t_titre.setTextFill(Color.WHITE);
        t_titre.setBackground(new Background(new BackgroundFill(Color.rgb(9,172,227), null, null)));
        t_titre.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));

        //Rectangle
        Rectangle r_contour = new Rectangle();
        r_contour.setHeight(325);
        r_contour.setWidth(590);
        r_contour.setLayoutX(10);
        r_contour.setLayoutY(10);
        r_contour.setStroke(Color.BLACK);
        r_contour.setStrokeWidth(1);
        r_contour.setFill(Color.TRANSPARENT);


        Label t_nbIA =  new Label("Entrez le nombre d'intelligences artificielles : ");
        Label t_nbMutations = new Label("Entrez le nombre de mutations à effectuer : ");
        Label t_nbTours = new Label("Entrez le nombre de tours maximum par partie : ");

        //taille
        t_nbIA.setLayoutX(30);
        t_nbMutations.setLayoutX(30);
        t_nbTours.setLayoutX(30);

        t_nbIA.setLayoutY(105);
        t_nbMutations.setLayoutY(165);
        t_nbTours.setLayoutY(225);

        t_nbIA.setFont(Font.font("Verdana", FontWeight.NORMAL, 18));
        t_nbMutations.setFont(Font.font("Verdana", FontWeight.NORMAL, 18));
        t_nbTours.setFont(Font.font("Verdana", FontWeight.NORMAL, 18));

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
        nb_ia.setLayoutX(480);
        nb_ia.setLayoutY(100);

        nb_mutations.setLayoutX(480);
        nb_mutations.setLayoutY(160);

        nb_tours.setLayoutX(480);
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
        menu_principal.setTranslateY(290);

        commencer_partie.setTranslateX(330);
        commencer_partie.setTranslateY(290);

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
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.println("    DEBUT DU TOURNOI");
                System.out.println("-------------------------------------------------------------------------------\n");

                System.out.println("Nombre d'IA : "+Integer.valueOf((String) nb_ia.getValue()));
                System.out.println("Nombre de mutations à effectuer : "+Integer.valueOf((String) nb_mutations.getValue()));
                System.out.println("Nombre de tours max par partie : "+Integer.valueOf((String) nb_tours.getValue()));

                Tournoi tournoi = new Tournoi(Integer.valueOf((String) nb_ia.getValue()),Integer.valueOf((String) nb_mutations.getValue()),Integer.valueOf((String) nb_tours.getValue()));
                tournoi.lancerLeTournoi();

                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.println("    FIN DU TOURNOI");
                System.out.println("-------------------------------------------------------------------------------\n");
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
        this.getChildren().add(r_contour);
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
