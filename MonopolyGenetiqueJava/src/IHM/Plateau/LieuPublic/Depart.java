package IHM.Plateau.LieuPublic;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class Depart extends VueCases {

    private ImageView imageDepart ;

    public Depart(Cases caseMetier) {
        super(caseMetier);


        ////////CASE DEPART
        this.setLayoutX(532);
        this.setLayoutY(628);

        URL depart = getClass().getResource("Images/Case_Depart.png");
        Image i_depart = new Image(depart.toExternalForm());
        imageDepart = new javafx.scene.image.ImageView(i_depart);

        imageDepart.setFitWidth(87);
        imageDepart.setPreserveRatio(true);



        getListeCases().add(0, this);
        this.getChildren().add(imageDepart);

    }

    @Override
    public void setListeCases(Pane p) {
        getListeCases().add(0, this);
    }


    @Override
    public String getType() {
        return "Départ";
    }
}
