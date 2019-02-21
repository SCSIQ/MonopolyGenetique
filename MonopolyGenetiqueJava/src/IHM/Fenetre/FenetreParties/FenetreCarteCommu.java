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
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetreCarteCommu extends Parent {

    private Canvas canvas;
    private ZoneInfoJoueur zoneJoueur;
    private ZoneAdversaires zoneAd;


    public FenetreCarteCommu(Stage fenetre_actuelle, Canvas canvas, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd, Pion pion)
    {
        //Initialisation
        this.canvas=canvas;
        this.zoneJoueur=zoneJoueur;
        this.zoneAd=zoneAd;

        Button carte_commu= new Button("CAISSE DE COMMUNAUTE");

        carte_commu.setLayoutY(10);
        carte_commu.setLayoutX(10);
        carte_commu.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        carte_commu.setTextFill(Color.WHITE);
        carte_commu.setBackground(new Background(new BackgroundFill(Color.rgb(9,172,227), null, null)));
        carte_commu.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        carte_commu.setPrefSize(475,50);


        //RECTANGLE

        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(235);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //TEXTE

        String caisseComm = automate.getContenuCartePiochée();

        Label l_contenu = new Label(caisseComm);
        l_contenu.setLayoutX(100);
        l_contenu.setLayoutY(100);
        l_contenu.setMaxWidth(300);
        l_contenu.setWrapText(true);
        l_contenu.setTextAlignment(TextAlignment.CENTER);

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

                if(caisseComm=="Vous retournez sur la case départ !")
                {
                    automate.getJoueurCourant().getPion().avancer(0);
                    pion.entrerDansCase();
                }else if(caisseComm=="Reculez à la case Avenue Matignon ")
                {
                    automate.getJoueurCourant().getPion().avancer(21);
                    pion.entrerDansCase();
                }

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
        this.getChildren().add(l_contenu);
        this.getChildren().add(carte_commu);
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
