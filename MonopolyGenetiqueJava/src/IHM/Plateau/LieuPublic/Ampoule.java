package IHM.Plateau.LieuPublic;

import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;


public class Ampoule extends Proprietes{


    public Ampoule(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(15);
        this.setLayoutY(532);

        URL celectr = getClass().getResource("Images/Case_CElect-15.png");
        Image i_celectr = new Image(celectr.toExternalForm());
        ImageView c_celectr = new ImageView(i_celectr);

        c_celectr.setFitHeight(48);
        c_celectr.setPreserveRatio(true);

        this.getChildren().add(c_celectr);

    }



    @Override
    public String getType() {
        return "Ampoule";
    }
}
