package IHM.Plateau.LieuPublic;

import IHM.Plateau.LieuPublic.ServicePublic;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class Robinet extends ServicePublic {

    public Robinet(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(436);
        this.setLayoutY(110);

        URL ceaux = getClass().getResource("Images/Case_CEaux.png");
        Image i_ceaux = new Image(ceaux.toExternalForm());
        ImageView c_ceaux = new ImageView(i_ceaux);

        c_ceaux.setFitWidth(48);
        c_ceaux.setPreserveRatio(true);

        this.getChildren().add(c_ceaux);
    }



    @Override
    public String getType() {
        return "Robinet";
    }
}
