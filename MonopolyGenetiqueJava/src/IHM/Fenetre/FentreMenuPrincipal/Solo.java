package IHM.Fenetre.FentreMenuPrincipal;

import IHM.Fenetre.FenetreParties.Jeu;
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


public class Solo extends Parent {

    public Solo(Stage primaryStage, Stage nouvelle_fenetre) {



        //titre
        Text t_titre = new Text(150,15,"NOUVELLE PARTIE SOLO");
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        //nombre d'adversaires
        Text t_adv = new Text(50, 70, "Choisissez le nombre d'adversaires : ");

        ComboBox nb_adversaires = new ComboBox();
        nb_adversaires.getItems().addAll(
                "2",
                "3",
                "4",
                "5"
        );

        nb_adversaires.getSelectionModel().selectFirst();

        nb_adversaires.setLayoutX(300);
        nb_adversaires.setLayoutY(50);

        //couleur
        Text t_couleur = new Text(50, 130, "Choisissez votre couleur : ");

        ColorPicker couleur = new ColorPicker();
        couleur.setValue(Color.RED);
        couleur.setLayoutX(300);
        couleur.setLayoutY(110);

        //nombre de tours
        Text t_tours = new Text(50, 190, "Choisissez le nombre de  tours : ");

        ComboBox nb_tours = new ComboBox();
        nb_tours.getItems().addAll(
                "20",
                "30",
                "40"
        );

        nb_tours.getSelectionModel().selectFirst();

        nb_tours.setLayoutX(300);
        nb_tours.setLayoutY(170);




        //boutons
        Button menu_principal = new Button("MENU PRINCIPAL");
        menu_principal.setTranslateX(40);
        menu_principal.setTranslateY(250);

        Button commencer_partie = new Button("COMMENCER PARTIE");
        commencer_partie.setTranslateX(300);
        commencer_partie.setTranslateY(250);

        //ACTION SI BOUTON MENU PRINCIPAL
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

                nouvelle_fenetre.close();

            }
        });


        //position
        this.setTranslateX(20);
        this.setTranslateY(5);

        //ajout des éléments à la fenêtre
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
