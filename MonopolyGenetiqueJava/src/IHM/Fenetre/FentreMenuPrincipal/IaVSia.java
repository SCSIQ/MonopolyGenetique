package IHM.Fenetre.FentreMenuPrincipal;

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
        //titre
        Text t_titre = new Text(190,20,"NOUVELLE PARTIE IA VS IA");
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        //texte
        Text t_nbJoueurs =  new Text(50,80,"Choisissez le nombre de joueurs : ");
        Text t_nbEquipes = new Text(50,140,"Choisissez le nombre d'équipes pour le tournoi : ");
        Text t_nbTours = new Text(50,200,"Choisissez le nombre de tours : ");

        //COMBO BOX
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
            //affichage du premier élément
        nb_adversaires.getSelectionModel().selectFirst();
        nb_equipes.getSelectionModel().selectFirst();
        nb_tours.getSelectionModel().selectFirst();

        nb_adversaires.setLayoutX(400);
        nb_adversaires.setLayoutY(60);
        nb_equipes.setLayoutX(400);
        nb_equipes.setLayoutY(120);
        nb_tours.setLayoutX(400);
        nb_tours.setLayoutY(180);

        //BOUTONS quitter et lancer partie
        Button menu_principal = new Button("MENU PRINCIPAL");
        menu_principal.setTranslateX(40);
        menu_principal.setTranslateY(250);

        Button commencer_partie = new Button("COMMENCER LE TOURNOI");
        commencer_partie.setTranslateX(300);
        commencer_partie.setTranslateY(250);

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

                nouvelle_fenetre.close();
            }
        });

        //ajout
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
