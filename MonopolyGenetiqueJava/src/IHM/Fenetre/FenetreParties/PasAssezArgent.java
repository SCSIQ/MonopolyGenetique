package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneInfoJoueur;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PasAssezArgent extends Parent {

    private Canvas canvas;
    private ZoneInfoJoueur zoneJoueur;
    private ZoneAdversaires zoneAd;
    private Jeu jeu;

    //fini permettant de savoir si la partie se fini pour le joueur
    public PasAssezArgent(Automate automate,Stage fenetre_actuelle, Canvas canvas, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd, Jeu jeu, boolean fini)
    {
        this.canvas= canvas;
        this.zoneAd= zoneAd;
        this.zoneJoueur = zoneJoueur;
        this.jeu= jeu;

        //BOUTONS
        Button bt_attention = new Button("ATTENTION");

        bt_attention.setLayoutY(10);
        bt_attention.setLayoutX(10);
        bt_attention.setPrefSize(475,10);
        bt_attention.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_attention.setTextFill(Color.WHITE);
        bt_attention.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        bt_attention.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));

        Label l = new Label("Vous n'avez pas assez d'argent !!");
        Button bt_ok = new Button("ok");

        l.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l.setLayoutX(135);
        l.setLayoutY(110);

        l.setScaleX(2);
        l.setScaleY(2);

        Color rouge = Color.RED;
        l.setTextFill(rouge);


        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

        bt_ok.setPrefSize(150, 10);

        //RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //ACTION BOUTON
        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas();

                //on ferme la fenêtre
                fenetre_actuelle.close();

                if(fini==true)
                {
                    automate.evoluer("Faillite");
                    fenetreFaillite(fenetre_actuelle,automate);
                }

            }
        });


/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);


        //AJOUT

        this.getChildren().add(r_fond);
        this.getChildren().add(l);
        this.getChildren().add(bt_ok);
        this.getChildren().add(bt_attention);

    }

    public void detruireCanvas()
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

    public void fenetreFaillite(Stage fenetre_actuelle, Automate automate)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_Faillite = new Stage();

        FenetreFaillite_1 fenetre= new FenetreFaillite_1(nouvelle_fenetre_Faillite,canvas, automate, zoneJoueur, zoneAd, jeu);

        Scene nouvelle_scene = new  Scene(fenetre,650,550);

        nouvelle_fenetre_Faillite.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_Faillite.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_Faillite.initOwner(jeu.getFenetrePropri());

        //POSITION DE LA FENETRE
        nouvelle_fenetre_Faillite.show();
    }

}
