package IHM.Plateau.Terrains.Rouge;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE MATIGNON
public class CaseMatignon extends Terrain {

    public CaseMatignon(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(100);
        this.setLayoutY(110);

        URL matignon = getClass().getResource("Images/Case_Matignon.png");
        Image i_matignon = new Image(matignon.toExternalForm());
        ImageView c_matignon = new ImageView(i_matignon);


        c_matignon.setFitWidth(48);
        c_matignon.setPreserveRatio(true);

        this.getChildren().add(c_matignon);
    }



    @Override
    public String getType() {
        return "Avenue Matignon";
    }
}
