package IHM.Fenetre.FenetreParties.ComposantPlateau;

import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VentePropriete  extends Parent {

    public VentePropriete(Stage fenetre_actuelle, Canvas canvas, Jeu jeu, Automate automate, int numBouton)
    {


        //////////////////////////////////////////////////////////////////////////TITRE ET RECTANGLE
        Button bt_lance = new Button("VENTE");

        bt_lance.setLayoutY(10);
        bt_lance.setLayoutX(10);
        bt_lance.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_lance.setTextFill(Color.WHITE);
        bt_lance.setBackground(new Background(new BackgroundFill(Color.RED,null,null)));
        bt_lance.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));

        //RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);
        bt_lance.setPrefSize(475,50);

//////////////////////////////////////////////////////////////////////////TEXTE
        Label t_nb = new Label("VOUS AVEZ VENDU : \n "+jeu.getPoss().getListeTerrains().get(numBouton)+"\n\nVOUS GAGNEZ "+((Terrain)jeu.getPoss().getListeTerrains().get(numBouton)).getPrix()+" €" );

        t_nb.setLayoutX(100);
        t_nb.setLayoutY(80);
        t_nb.setText(t_nb.getText().toUpperCase());

        t_nb.setMaxWidth(400);
        t_nb.setWrapText(true);
        t_nb.setTextAlignment(TextAlignment.CENTER);

        t_nb.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));

//////////////////////////////////////////////////////////////////BOUTON
        Button bt_ok = new Button("OK");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

        bt_ok.setPrefSize(150, 10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);
                automate.evoluer("vendrePropriete");
                jeu.getPoss().getListeTerrains().remove(numBouton);
                jeu.getPoss().effacerPossession();
                jeu.getPoss().afficherTerrain(automate);
                jeu.getZoneJoueur().SupprimerJoueur();
                jeu.getZoneJoueur().genereInfosJoueur(automate);

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

        //AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(bt_lance);
        this.getChildren().add(t_nb);
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
