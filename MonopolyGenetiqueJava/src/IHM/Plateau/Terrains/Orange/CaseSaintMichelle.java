package IHM.Plateau.Terrains.Orange;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE SAINT MICHELLE
public class CaseSaintMichelle extends Terrain {

    public CaseSaintMichelle(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(15);
        this.setLayoutY(244);

        URL saintM = getClass().getResource("Images/Case_SaintM.png");
        Image i_saintM = new Image(saintM.toExternalForm());
        ImageView c_saintM = new ImageView(i_saintM);

        c_saintM.setFitHeight(48);
        c_saintM.setPreserveRatio(true);

        this.getChildren().add(c_saintM);
        getListeCases().add(18,this);
        this.getChildren().add(this);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Michelle";
    }
}
