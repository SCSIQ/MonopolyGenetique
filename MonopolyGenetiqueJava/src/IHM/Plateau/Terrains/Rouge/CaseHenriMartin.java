package IHM.Plateau.Terrains.Rouge;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE HENRI MARTIN
public class CaseHenriMartin extends Terrain {
    public CaseHenriMartin(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(244);
        this.setLayoutY(110);

        URL henriM = getClass().getResource("Images/Case_HenriM.png");
        Image i_henriM = new Image(henriM.toExternalForm());
        ImageView c_henriM = new ImageView(i_henriM);

        getListeCases().add(this);
        c_henriM.setFitWidth(48);
        c_henriM.setPreserveRatio(true);

        this.getChildren().add(c_henriM);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Henri-Martin";
    }
}
