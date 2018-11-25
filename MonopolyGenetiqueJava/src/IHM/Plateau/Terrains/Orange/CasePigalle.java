package IHM.Plateau.Terrains.Orange;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE PIGALLE
public class CasePigalle extends Terrain {

    public CasePigalle(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(15);
        this.setLayoutY(196);

        URL pigalle = getClass().getResource("Images/Case_Pigalle.png");
        Image i_pigalle = new Image(pigalle.toExternalForm());
        ImageView c_pigalle = new ImageView(i_pigalle);

        c_pigalle.setFitHeight(48);
        c_pigalle.setPreserveRatio(true);

        this.getChildren().add(c_pigalle);
        getListeCases().add(19,this);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Pigalle";
    }
}
