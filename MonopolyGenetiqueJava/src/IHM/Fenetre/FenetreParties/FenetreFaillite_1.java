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
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FenetreFaillite_1 extends Parent {

    private Jeu jeu;
    private  Automate automate;

    public FenetreFaillite_1(Stage nouvelle_fenetre_faillite, Canvas canvas, Automate automate, ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd, Jeu jeu) {

        //initialisation
        this.jeu= jeu;
        this.automate= automate;


        Button bt_perdu= new Button("PERDU ...");
        bt_perdu.setLayoutY(10);
        bt_perdu.setLayoutX(10);
        bt_perdu.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_perdu.setTextFill(Color.WHITE);
        bt_perdu.setBackground(new Background(new BackgroundFill( Color.rgb(9,172,227),null, null)));
        bt_perdu.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        bt_perdu.setPrefSize(475,50);



        /////////////////////////////LABELS

        Label l_faille = new Label("Vous n'avez pas assez d'argent pour payer ! ");
        Label l_perdu = new Label("Vous avez perdu !");


        l_faille.setFont(Font.font("Verdana", FontWeight.NORMAL, 19));

        l_faille.setLayoutX(30);
        l_faille.setLayoutY(80);



        Color rouge = Color.RED;
        l_perdu.setTextFill(rouge);
        l_perdu.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        l_perdu.setWrapText(true);
        l_perdu.setTextAlignment(TextAlignment.CENTER);

        l_faille.setWrapText(true);
        l_faille.setTextAlignment(TextAlignment.CENTER);

        l_perdu.setLayoutY(130);
        l_perdu.setLayoutX(155);

        //RECTANGLE

        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(235);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //BOUTON OK
        Button bt_ok = new Button("OK");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

        bt_ok.setPrefSize(150, 10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                zoneAd.SupprimerAdversaire();
                zoneAd.genererAdversaire(automate, jeu.getFenetrePropri());

                zoneJoueur.SupprimerJoueur();
                zoneJoueur.genereInfosJoueur(automate);

                //S'il ne reste plus qu'un joueur dans le jeu
                if(automate.getListeJoueurs().size()==1)
                {
                    fenetreGagne(jeu.getFenetrePropri());
                }

                //on ferme la fenêtre
                nouvelle_fenetre_faillite.close();
            }
        });


        /////////TAILLE MIN ET MAX DE LA FENETRE
        nouvelle_fenetre_faillite.setMinHeight(300);
        nouvelle_fenetre_faillite.setMinWidth(515);

        nouvelle_fenetre_faillite.setMaxHeight(300);
        nouvelle_fenetre_faillite.setMaxWidth(515);


        //AJOUT
        this.getChildren().add(l_faille);
        this.getChildren().add(l_perdu);
        this.getChildren().add(r_fond);
        this.getChildren().add(bt_ok);
        this.getChildren().add(bt_perdu);
    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

    public void fenetreGagne(Stage fenetre_actuelle)
    {
        jeu.fenetreNoire();
        Stage nouvelle_fenetre_gagne = new Stage();
        FenetreGagne fenetreGagner = new FenetreGagne(nouvelle_fenetre_gagne, automate, jeu);

        Scene nouvelle_scene = new  Scene(fenetreGagner,500,600);

        nouvelle_fenetre_gagne.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_gagne.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_gagne.initOwner(fenetre_actuelle);

        nouvelle_fenetre_gagne.show();
    }

}
