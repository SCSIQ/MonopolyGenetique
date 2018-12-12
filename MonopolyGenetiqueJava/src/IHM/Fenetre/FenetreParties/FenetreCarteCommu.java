package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.PasAssezArgent;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneInfoJoueur;
import Metier.Automate.Automate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetreCarteCommu extends Parent {

    private Canvas canvas;
    private ZoneInfoJoueur zoneJoueur;
    private ZoneAdversaires zoneAd;


    public FenetreCarteCommu(Stage fenetre_actuelle, Canvas canvas, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        //Initialisation
        this.canvas=canvas;
        this.zoneJoueur=zoneJoueur;
        this.zoneAd=zoneAd;

        //RECTANGLE
        Rectangle r_commu = new Rectangle();
        r_commu.setHeight(50);
        r_commu.setWidth(475);
        r_commu.setLayoutX(10);
        r_commu.setLayoutY(15);
        r_commu.setStroke(Color.BLACK);
        r_commu.setStrokeWidth(1);
        r_commu.setFill(Color.rgb(9, 172, 227));

        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(15);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //TEXTE
        Label l_Commu = new Label("CAISSE DE COMMUNAUTE");
        l_Commu.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        l_Commu.setLayoutX(160);
        l_Commu.setLayoutY(33);

        l_Commu.setScaleX(2);
        l_Commu.setScaleY(2);

        l_Commu.setTextFill(Color.WHITE);

        Label l_contenu = new Label("Cette case n'a pour l'instant aucun effet.");
        l_contenu.setLayoutX(100);
        l_contenu.setLayoutY(100);

        l_contenu.setScaleX(1.5);
        l_contenu.setScaleY(1.5);



        //BOUTON
        Button bt_ok = new Button("Ok");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

        bt_ok.setPrefSize(150,10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on remet à jour l'argent du joueur courant
                zoneJoueur.SupprimerJoueur();
                zoneJoueur.genereInfosJoueur(automate);

                //Met à jour les adversaires :
                zoneAd.SupprimerAdversaire();
                zoneAd.genererAdversaire(automate, fenetre_actuelle);

                //on ferme la fenêtre
                fenetre_actuelle.close();

            }
        });

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);

/////////////////////////////////////////////////AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(r_commu);
        this.getChildren().add(l_Commu);
        this.getChildren().add(l_contenu);
        this.getChildren().add(bt_ok);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

}
