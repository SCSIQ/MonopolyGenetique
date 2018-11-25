package IHM.Plateau.Terrains.BleuFonce;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE DES CHAMPS ELYSEES
public class CaseChampsElysees extends Terrain {


    public CaseChampsElysees(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(532);
        this.setLayoutY(484);

        URL champsE = getClass().getResource("Images/Case_ChampsE.png");
        Image i_champsE = new Image(champsE.toExternalForm());
        ImageView c_champsE = new ImageView(i_champsE);

        c_champsE.setFitHeight(48);
        c_champsE.setPreserveRatio(true);

        getListeCases().add(this);
        this.getChildren().add(c_champsE);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Elysees";
    }
}
