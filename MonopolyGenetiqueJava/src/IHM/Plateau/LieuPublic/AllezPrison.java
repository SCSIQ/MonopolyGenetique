package IHM.Plateau.LieuPublic;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;

public class AllezPrison extends VueCases {

    public AllezPrison(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(532);
        this.setLayoutY(110);

        URL allez_prison = getClass().getResource("Images/Case_Allez_Prison.png");
        Image i_aprison = new Image(allez_prison.toExternalForm());
        ImageView c_aprison = new ImageView(i_aprison);

        c_aprison.setFitHeight(87);
        c_aprison.setPreserveRatio(true);

        this.getChildren().add(c_aprison);
        getListeCases().add(this);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "AllezEnPrison";
    }
}
