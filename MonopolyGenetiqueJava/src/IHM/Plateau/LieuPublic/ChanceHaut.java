package IHM.Plateau.LieuPublic;

import IHM.Plateau.Chance;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;

public class ChanceHaut extends Chance {

    public ChanceHaut(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(148);
        this.setLayoutY(110);

        URL chance = getClass().getResource("Images/Case_Chance_Haut.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);

        this.getChildren().add(c_chance);
    }
}
