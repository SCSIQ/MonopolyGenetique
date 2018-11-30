package IHM.Plateau.LieuPublic;

import IHM.Plateau.Chance;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class ChanceDroite extends Chance {

    public ChanceDroite(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(532);
        this.setLayoutY(436);

        URL chance = getClass().getResource("Images/Case_Chance_Droite.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitHeight(48);
        c_chance.setPreserveRatio(true);

        this.getChildren().add(c_chance);
    }
}
