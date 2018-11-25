package IHM.Plateau.Terrains.Rose;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE DE LA VILETTE
public class CaseVillette extends Terrain {
    public CaseVillette(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(15);
        this.setLayoutY(580);

        URL villette = getClass().getResource("Images/Case_Villette.png");
        Image i_villette = new Image(villette.toExternalForm());
        ImageView c_villette = new ImageView(i_villette);

        c_villette.setFitHeight(48);
        c_villette.setPreserveRatio(true);

        this.getChildren().add(c_villette);

        getListeCases().add(this);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Villette";
    }
}
