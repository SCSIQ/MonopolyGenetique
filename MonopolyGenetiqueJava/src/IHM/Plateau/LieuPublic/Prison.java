package IHM.Plateau.LieuPublic;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class Prison extends VueCases {

    public Prison(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(15);
        this.setLayoutY(628);

        URL prison = getClass().getResource("Images/Case_Prison.png");
        Image i_prison = new Image(prison.toExternalForm());
        ImageView c_prison = new ImageView(i_prison);

        c_prison.setFitWidth(87);
        c_prison.setPreserveRatio(true);


        this.getChildren().add(c_prison);
    }



    @Override
    public String getType() {
        return "Prison";
    }

    @Override
    public void setImageMaison(ImageView maison) {

    }

    @Override
    public ImageView getImageMaison() {
        return null;
    }
}
