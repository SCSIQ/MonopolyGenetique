package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.ZonePossessions;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetailTerrain extends Parent {

    public DetailTerrain(Automate automate, Stage fenetre_actuelle, Canvas canvas, ZonePossessions poss, int numBouton){

        Label nomTerrain = new Label(poss.getListeTerrains().get(numBouton).getText()+"");

        nomTerrain.setLayoutY(20);
        nomTerrain.setLayoutX(10);



        //AJOUT
        this.getChildren().add(nomTerrain);
    }
}
