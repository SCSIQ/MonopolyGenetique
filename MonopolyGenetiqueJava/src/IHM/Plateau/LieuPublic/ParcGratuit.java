package IHM.Plateau.LieuPublic;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class ParcGratuit extends VueCases {

    public ParcGratuit(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(15);
        this.setLayoutY(110);

        URL parc = getClass().getResource("Images/Case_Parc.png");
        Image i_parc = new Image(parc.toExternalForm());
        ImageView c_parc = new ImageView(i_parc);

        c_parc.setFitWidth(87);
        c_parc.setPreserveRatio(true);

        this.getChildren().add(c_parc);
    }



    @Override
    public String getType() {
        return "Parc gratuit";
    }
}
