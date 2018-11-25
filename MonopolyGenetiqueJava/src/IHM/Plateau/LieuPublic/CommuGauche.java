package IHM.Plateau.LieuPublic;

import IHM.Plateau.Terrains.CaisseCommune;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class CommuGauche extends CaisseCommune {

    public CommuGauche(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(35);
        this.setLayoutY(272);

        URL commu = getClass().getResource("Images/Case_Communaute.png");
        Image i_com = new Image(commu.toExternalForm());
        ImageView c_com = new ImageView(i_com);

        c_com.setRotate(90);
        c_com.setFitWidth(48);
        c_com.setPreserveRatio(true);

        this.getChildren().add(c_com);
        getListeCases().add(this);
    }
}
