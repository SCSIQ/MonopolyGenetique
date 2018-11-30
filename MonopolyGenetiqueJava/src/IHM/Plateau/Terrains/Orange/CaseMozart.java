package IHM.Plateau.Terrains.Orange;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE Mozart
public class CaseMozart extends Terrain {

    public CaseMozart(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(15);
        this.setLayoutY(340);

        URL mozart = getClass().getResource("Images/Case_Mozart.png");
        Image i_mozart = new Image(mozart.toExternalForm());
        ImageView c_mozart = new ImageView(i_mozart);

        c_mozart.setFitHeight(48);
        c_mozart.setPreserveRatio(true);

        this.getChildren().add(c_mozart);
    }



    @Override
    public String getType() {
        return "Mozart";
    }
}
