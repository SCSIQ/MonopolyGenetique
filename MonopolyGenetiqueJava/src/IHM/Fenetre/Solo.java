package IHM.Fenetre;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;


public class Solo extends Parent {

    public Solo() {
        //nombre d'adversaires
        Text t_adv = new Text(50, 50, "Choisissez le nombre d'adversaires : ");

        ComboBox nb_adversaires = new ComboBox();
        nb_adversaires.getItems().addAll(
                "2",
                "3",
                "4",
                "5"
        );
        nb_adversaires.setTranslateX(300);
        nb_adversaires.setTranslateY(30);

        //couleur
        Text t_couleur = new Text(50, 130, "Choisissez votre couleur : ");

        //nombre de tours
        Text t_tours = new Text(50, 190, "Choisissez le nombre de  : ");

        ComboBox nb_tours = new ComboBox();
        nb_tours.getItems().addAll(
                "20",
                "30",
                "40"
        );
        nb_tours.setTranslateX(300);
        nb_tours.setTranslateY(170);

        //boutons
        Button menu_principal = new Button("MENU PRINCIPAL");
        menu_principal.setTranslateX(40);
        menu_principal.setTranslateY(250);

        Button commencer_partie = new Button("COMMENCER PARTIE");
        commencer_partie.setTranslateX(300);
        commencer_partie.setTranslateY(250);

        //position
        /*this.setTranslateX(20);
        this.setTranslateY(20);*/

        //ajout des éléments à la fenêtre
        this.getChildren().add(t_adv);
        this.getChildren().add(nb_adversaires);
        this.getChildren().add(t_couleur);
        this.getChildren().add(t_tours);
        this.getChildren().add(nb_tours);
        this.getChildren().add(menu_principal);
        this.getChildren().add(commencer_partie);

    }
}
