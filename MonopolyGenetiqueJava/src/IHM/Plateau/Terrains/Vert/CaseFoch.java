package IHM.Plateau.Terrains.Vert;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE DE FOCH
public class CaseFoch extends Terrain {
    public CaseFoch(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(532);
        this.setLayoutY(244);

        URL foch = getClass().getResource("Images/Case_Foch.png");
        Image i_foch = new Image(foch.toExternalForm());
        ImageView c_foch = new ImageView(i_foch);

        c_foch.setFitHeight(48);
        c_foch.setPreserveRatio(true);
        getListeCases().add(32,this);
        this.getChildren().add(c_foch);

    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Foch";
    }
}
