package IHM.Plateau.LieuPublic;

import IHM.Plateau.Chance;
import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class ChanceBas extends Chance {


    public ChanceBas(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(196);
        this.setLayoutY(628);

        URL chance = getClass().getResource("Images/Case_Chance.png");
        Image i_chance = new Image(chance.toExternalForm());
        ImageView c_chance = new ImageView(i_chance);

        c_chance.setFitWidth(48);
        c_chance.setPreserveRatio(true);

        this.getChildren().add(c_chance);
    }
}
