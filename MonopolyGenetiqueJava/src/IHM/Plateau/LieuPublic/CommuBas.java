package IHM.Plateau.LieuPublic;

import IHM.Plateau.Terrains.CaisseCommune;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class CommuBas extends CaisseCommune {

    public CommuBas(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(436);
        this.setLayoutY(628);

        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);

        c_com.setFitWidth(48);
        c_com.setPreserveRatio(true);

        this.getChildren().add(c_com);
        getListeCases().add(this);
    }
}
