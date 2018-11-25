package IHM.Plateau.Terrains.BleuCiel;


import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE RUE REPUBLIQUE
public class CaseRepublique extends Terrain {


    public CaseRepublique(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(100);
        this.setLayoutY(628);


        URL republique = getClass().getResource("Images/Case_Republique.png");
        Image i_republique = new Image(republique.toExternalForm());
        ImageView c_republique = new ImageView(i_republique);

        c_republique.setFitWidth(48);
        c_republique.setPreserveRatio(true);

        this.getChildren().add(this);
        this.getChildren().add(c_republique);
        getListeCases().add(9,this);

    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Republique";
    }
}
