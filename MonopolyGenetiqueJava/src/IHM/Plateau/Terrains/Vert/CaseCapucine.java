package IHM.Plateau.Terrains.Vert;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE DE CAPUCINES
public class CaseCapucine extends Terrain {
    public CaseCapucine(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(532);
        this.setLayoutY(340);

        URL capucines = getClass().getResource("Images/Case_Capucines.png");
        Image i_capucines = new Image(capucines.toExternalForm());
        ImageView c_capucines = new ImageView(i_capucines);

        c_capucines.setFitHeight(48);
        c_capucines.setPreserveRatio(true);

        getListeCases().add(this);
        this.getChildren().add(c_capucines);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Capucine";
    }
}
