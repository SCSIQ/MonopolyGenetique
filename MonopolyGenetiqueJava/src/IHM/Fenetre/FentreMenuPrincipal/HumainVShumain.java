package IHM.Fenetre.FentreMenuPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HumainVShumain extends Parent {

    public HumainVShumain(Stage primaryStage, Stage nouvelle_fenetre){

        //titre
        Text t_titre = new Text(130,20,"NOUVELLE PARTIE HUMAIN VS HUMAIN");
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        Text t_adv = new Text(50, 80, "Choisissez le nombre d'adversaires : ");

        ComboBox nb_adversaires = new ComboBox();
        nb_adversaires.getItems().addAll(
                "2",
                "3",
                "4",
                "5"
        );

        nb_adversaires.getSelectionModel().selectFirst();

        nb_adversaires.setLayoutX(300);
        nb_adversaires.setLayoutY(60);


        //nombre de tours
        Text t_tours = new Text(50, 190, "Choisissez le nombre de tours : ");

        ComboBox nb_tours = new ComboBox();
        nb_tours.getItems().addAll(
                "20",
                "30",
                "40"
        );

        nb_tours.getSelectionModel().selectFirst();

        nb_tours.setTranslateX(300);
        nb_tours.setTranslateY(170);

        //BOUTONS MENU PRINCIPAL ET COMMENCER PARTIE
        Button menu_principal = new Button("MENU PRINCIPAL");
        menu_principal.setLayoutX(40);
        menu_principal.setLayoutY(250);

        Button commencer_partie = new Button("COMMENCER PARTIE");
        commencer_partie.setLayoutX(300);
        commencer_partie.setLayoutY(250);

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

                nouvelle_fenetre.close();
            }
        });

        //position
        this.setTranslateX(20);
        this.setTranslateY(10);

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
