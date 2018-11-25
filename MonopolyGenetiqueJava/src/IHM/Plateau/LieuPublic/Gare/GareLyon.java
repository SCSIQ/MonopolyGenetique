package IHM.Plateau.LieuPublic.Gare;


import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ArrayList;

public class GareLyon extends Proprietes {

    public GareLyon(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(15);
        this.setLayoutY(388);


        URL gareL = getClass().getResource("Images/Case_GareL.png");
        Image i_gareL = new Image(gareL.toExternalForm());
        ImageView c_gareL = new ImageView(i_gareL);

        this.setBackground(new Background(new BackgroundImage(i_gareL, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));

        c_gareL.setFitHeight(48);
        c_gareL.setPreserveRatio(true);

        this.getChildren().add(c_gareL);
        getListeCases().add(this);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Gare de Lyon";
    }
}
