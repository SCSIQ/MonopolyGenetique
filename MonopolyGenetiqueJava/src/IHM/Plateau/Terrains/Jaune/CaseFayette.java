package IHM.Plateau.Terrains.Jaune;

import IHM.Plateau.Proprietes;
import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;


//CASE LA FAYETTE
public class CaseFayette extends Terrain {

    public CaseFayette(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(484);
        this.setLayoutY(110);

        URL lafayette = getClass().getResource("Images/Case_Lafayette.png");
        Image i_lafayette = new Image(lafayette.toExternalForm());
        ImageView c_lafayette = new ImageView(i_lafayette);

        c_lafayette.setFitWidth(48);
        c_lafayette.setPreserveRatio(true);

        getListeCases().add(this);
        this.getChildren().add(c_lafayette);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Fayette";
    }
}