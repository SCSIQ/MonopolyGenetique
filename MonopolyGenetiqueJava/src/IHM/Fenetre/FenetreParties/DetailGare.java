package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.ZonePossessions;
import Metier.Automate.Automate;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DetailGare extends Parent {


    private Pane zoneInfos ;
    private int numBouton ;
    private ZonePossessions poss ;

    public DetailGare(Automate automate, Stage fenetre_detail , Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton){

        this.numBouton = numBouton ;
        this.poss = poss ;

    }
}
