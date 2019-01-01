package IHM.Fenetre.FenetreParties.ComposantPlateau;

import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetreGagne extends Parent {

    private Automate automate;
    private Jeu jeu ;

    public FenetreGagne(Stage fenetre, Automate automate, Jeu jeu)
    {
        this.automate = automate;
        this.jeu = jeu ;


        //////////////////////////////////////Label
        Button bt_gagnant = new Button("GAGNANT");
        bt_gagnant.setLayoutY(10);
        bt_gagnant.setLayoutX(10);
        bt_gagnant.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_gagnant.setTextFill(Color.WHITE);
        bt_gagnant.setBackground(new Background(new BackgroundFill( Color.rgb(9,172,227),null, null)));
        bt_gagnant.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        bt_gagnant.setPrefSize(475,50);

        ////////////////////////RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(235);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        ////////////////////////////////Contenu
            // j'ai mis par default que le joueur courant gagnait
        Label l_contenu = new Label(automate.getListeJoueurs().get(0).getNom()+" a gagné !") ;
        l_contenu.setLayoutX(148);
        l_contenu.setLayoutY(125);
        l_contenu.setMaxWidth(300);
        l_contenu.setWrapText(true);
        l_contenu.setTextAlignment(TextAlignment.CENTER);
        l_contenu.setFont(Font.font("Verdana", FontWeight.BOLD, 18));


        ///////////////////BOUTONS
        //Bouton retour menu princial
        Button bt_menu = new Button("MENU PRINCIPAL");
        bt_menu.setLayoutX(175);
        bt_menu.setLayoutY(190);

        bt_menu.setPrefSize(150,10);

        bt_menu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                fenetre.close();
                jeu.getFenetrePropri().close() ;
                jeu.getPrimaryStage().show() ;


            }
        });

        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre.setMinHeight(300);
        fenetre.setMinWidth(515);

        fenetre.setMaxHeight(300);
        fenetre.setMaxWidth(515);


        //////////////Ajout
        this.getChildren().add(r_fond);
        this.getChildren().add(bt_gagnant);
        this.getChildren().add(l_contenu);
        this.getChildren().add(bt_menu);
    }

}
