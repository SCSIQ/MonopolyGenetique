package IHM.Plateau.LieuPublic.Gare;


import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class GareNord extends Proprietes {

    public GareNord(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(292);
        this.setLayoutY(110);

        URL gareN = getClass().getResource("Images/Case_GareN.png");
        Image i_gareN = new Image(gareN.toExternalForm());
        ImageView c_gareN = new ImageView(i_gareN);

        c_gareN.setFitWidth(48);
        c_gareN.setPreserveRatio(true);

        getListeCases().add(25,this);
        this.getChildren().add(c_gareN);

    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Gare de Nord";
    }
}
