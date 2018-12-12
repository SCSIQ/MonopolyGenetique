package IHM.Fenetre.FenetreParties.ComposantPlateau;

import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeTaxes.Taxes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class FenetreTaxe extends Parent {

    //ATTRIBUTS
    private Canvas canvas ;
    private ZoneInfoJoueur zoneJoueur ;
    private ZoneAdversaires zoneAd;

    public FenetreTaxe(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur, Jeu jeu, ZoneAdversaires zoneAd)
    {
        //INITIALISATION
        this.canvas = canvas ;
        this.zoneJoueur =zoneJoueur;
        this.zoneAd = zoneAd ;


        Label l = new Label("Vous êtes sur la case :\n"+plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType()+
                "\n\nVous devez "+((Taxes)automate.getJoueurCourant().getPion().getCase()).getPrixTaxe() +" € ");
        l.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l.setLayoutX(170);
        l.setLayoutY(50);

        l.setScaleX(2);
        l.setScaleY(2);

        ////////////////////////////BOUTON
        //ACTION PAYER
        Button bt_payer= new Button("PAYER");

        bt_payer.setLayoutX(175);
        bt_payer.setLayoutY(210);

        bt_payer.setPrefSize(150, 10);

        bt_payer.setOnAction(new EventHandler<ActionEvent>() {
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

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(520);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(520);

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        event.consume();
    }
});



//////////////////////AJOUT
        this.getChildren().add(bt_payer);
        this.getChildren().add(l);


    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
