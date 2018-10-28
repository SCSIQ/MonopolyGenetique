package IHM.Fenetre;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class IaVSia extends Parent {

    public IaVSia(Stage primaryStage)
    {
        //titre
        Text t_titre = new Text(190,20,"NOUVELLE PARTIE IA VS IA");
        t_titre.setScaleX(2);
        t_titre.setScaleY(2);

        //boutons quitter et lancer partie
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
                Accueil accueil = new Accueil(primaryStage) ;
                Scene nouvelle_scene = new Scene(accueil,300,275);
                Stage nouvelle_fenetre = new Stage();
                nouvelle_fenetre.setScene(nouvelle_scene);
                nouvelle_fenetre.show();
            }
        });

        //ACTION SI BOUTON COMMENCER PARTIE
        commencer_partie.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {


            }
        });

        //ajout
        this.getChildren().add(t_titre);
        this.getChildren().add(menu_principal);
        this.getChildren().add(commencer_partie);
    }
}
