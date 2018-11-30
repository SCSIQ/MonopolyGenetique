package IHM.Plateau.Terrains.BleuFonce;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE DE LA PAIX
public class CasePaix extends Terrain {


    public CasePaix(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(532);
        this.setLayoutY(580);

        URL paix = getClass().getResource("Images/Case_Paix.png");
        Image i_paix = new Image(paix.toExternalForm());
        ImageView c_paix = new ImageView(i_paix);

        c_paix.setFitHeight(48);
        c_paix.setPreserveRatio(true);


        this.getChildren().add(c_paix);
    }



    @Override
    public String getType() {
        return "Rue de la Paix";
    }
}
