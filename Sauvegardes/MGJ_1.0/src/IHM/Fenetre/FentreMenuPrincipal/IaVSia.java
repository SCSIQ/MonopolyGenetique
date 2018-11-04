package IHM.Fenetre.FentreMenuPrincipal;

import IHM.Fenetre.FenetreParties.Jeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IaVSia extends Parent {

    public IaVSia(Stage primaryStage, Stage nouvelle_fenetre)
    {
////////TEXTE
        Text t_titre = new Text(190,30,"NOUVELLE PARTIE IA VS IA");
        Text t_nbJoueurs =  new Text(70,80,"Choisissez le nombre de joueurs : ");
        Text t_nbEquipes = new Text(90,140,"Choisissez le nombre d'équipes pour le tournoi : ");
        Text t_nbTours = new Text(70,200,"Choisissez le nombre de tours : ");

        //taille
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        t_nbJoueurs.setScaleX(1.5);
        t_nbJoueurs.setScaleY(1.5);

        t_nbEquipes.setScaleX(1.5);
        t_nbEquipes.setScaleY(1.5);

        t_nbTours.setScaleX(1.5);
        t_nbTours.setScaleY(1.5);

////////COMBO BOX
            //création des combo box
        ComboBox nb_adversaires = new ComboBox();
        nb_adversaires.getItems().addAll(
                "2",
                "3",
                "4",
                "5"
        );
        ComboBox nb_equipes = new ComboBox();
        nb_equipes.getItems().addAll(
                "2",
                "3",
                "4",
                "5"
        );
        ComboBox nb_tours = new ComboBox();
        nb_tours.getItems().addAll(
                "20",
                "30",
                "40",
                "50"
        );
            //affichage du premier élément des combo box
        nb_adversaires.getSelectionModel().selectFirst();
        nb_equipes.getSelectionModel().selectFirst();
        nb_tours.getSelectionModel().selectFirst();

            //positionnement des combo box
        nb_adversaires.setLayoutX(430);
        nb_adversaires.setLayoutY(60);
        nb_equipes.setLayoutX(430);
        nb_equipes.setLayoutY(120);
        nb_tours.setLayoutX(430);
        nb_tours.setLayoutY(180);

            //taille
        nb_adversaires.setPrefSize(60,10);
        nb_equipes.setPrefSize(60,10);
        nb_tours.setPrefSize(60, 10);

////////BOUTONS quitter et lancer partie
            //création des boutons
        Button menu_principal = new Button("MENU PRINCIPAL");
        Button commencer_partie = new Button("COMMENCER LE TOURNOI");

            //positionnement
        menu_principal.setTranslateX(30);
        menu_principal.setTranslateY(250);

        commencer_partie.setTranslateX(290);
        commencer_partie.setTranslateY(250);

            //taille
        menu_principal.setPrefSize(200,10);
        commencer_partie.setPrefSize(200,10);

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
                Stage nouvelle_fenetre_plateau = new Stage();
                Jeu fenentre_jeu = new Jeu(primaryStage,nouvelle_fenetre_plateau) ;
                Scene nouvelle_scene = new Scene(fenentre_jeu,1275,1275);

                nouvelle_fenetre_plateau.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre_plateau.show();
                nouvelle_fenetre.close();
            }
        });

////////AJOUT
        this.getChildren().add(t_titre);
        this.getChildren().add(t_nbJoueurs);
        this.getChildren().add(t_nbEquipes);
        this.getChildren().add(t_nbTours);
        this.getChildren().add(nb_adversaires);
        this.getChildren().add(nb_equipes);
        this.getChildren().add(nb_tours);
        this.getChildren().add(menu_principal);
        this.getChildren().add(commencer_partie);
    }
}