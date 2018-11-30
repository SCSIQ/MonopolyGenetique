package IHM.Plateau.Terrains.Rose;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE PARADIS
public class CaseParadis extends Terrain {

    public CaseParadis(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(15);
        this.setLayoutY(436);

        URL paradis = getClass().getResource("Images/Case_Paradis.png");
        Image i_paradis = new Image(paradis.toExternalForm());
        ImageView c_paradis = new ImageView(i_paradis);

        c_paradis.setFitHeight(48);
        c_paradis.setPreserveRatio(true);

        this.getChildren().add(c_paradis);

    }



    @Override
    public String getType() {
        return "Rue du Paradis";
    }
}
