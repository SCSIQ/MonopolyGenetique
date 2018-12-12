package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZoneInfoJoueur;
import Metier.Automate.Automate;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

}
