package IHM.Plateau.LieuPublic.Gare;


import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class GareSaintLazare extends Proprietes {


    public GareSaintLazare(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(532);
        this.setLayoutY(388);

        URL gareSL = getClass().getResource("Images/Case_GareSL.png");
        Image i_gareSL = new Image(gareSL.toExternalForm());
        ImageView c_gareSL = new ImageView(i_gareSL);

        c_gareSL.setFitHeight(48);
        c_gareSL.setPreserveRatio(true);
        this.getChildren().add(c_gareSL);
    }



    @Override
    public String getType() {
        return "Gare de Saint-Lazare";
    }

    @Override
    public void setImageMaison(ImageView maison) {

    }

    @Override
    public ImageView getImageMaison() {
        return null;
    }
}
