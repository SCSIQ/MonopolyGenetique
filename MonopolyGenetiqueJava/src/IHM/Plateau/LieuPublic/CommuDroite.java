package IHM.Plateau.LieuPublic;

import IHM.Plateau.Terrains.CaisseCommune;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class CommuDroite extends CaisseCommune {

    public CommuDroite(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(552);
        this.setLayoutY(272);

        URL commu3 = getClass().getResource("Images/Case_Communaute.png");
        Image i_commu3 = new Image(commu3.toExternalForm());
        ImageView c_commu3 = new ImageView(i_commu3);

        c_commu3.setFitWidth(48);
        c_commu3.setPreserveRatio(true);
        c_commu3.setRotate(-90);

        this.getChildren().add(c_commu3);
        getListeCases().add(this);
    }
}
