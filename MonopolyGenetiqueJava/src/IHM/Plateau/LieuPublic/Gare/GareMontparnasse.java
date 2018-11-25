package IHM.Plateau.LieuPublic.Gare;

import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class GareMontparnasse extends Proprietes {


    public GareMontparnasse(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(292);
        this.setLayoutY(628);


        URL gareM = getClass().getResource("Images/Case_GareM.png");
        Image i_gareM = new Image(gareM.toExternalForm());
        ImageView c_gareM = new ImageView(i_gareM);

        c_gareM.setFitWidth(48);
        c_gareM.setPreserveRatio(true);

        this.getChildren().add(this);
        this.getChildren().add(c_gareM);
        getListeCases().add(5,this);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Gare de Montparnasse";
    }
}
