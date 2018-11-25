package IHM.Plateau.Terrains.BleuCiel;



import IHM.Plateau.Terrain;
import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE RUE DE COURCELLES
public class CaseCourcelles extends Terrain {

    public CaseCourcelles(Cases caseMetier) {
        super(caseMetier);


        this.setLayoutX(148);
        this.setLayoutY(628);


        URL courcelles = getClass().getResource("Images/Case_Courcelles.png");
        Image i_courcelles = new Image(courcelles.toExternalForm());
        ImageView c_courcelles = new ImageView(i_courcelles);

        c_courcelles.setFitWidth(48);
        c_courcelles.setPreserveRatio(true);

        this.getChildren().add(this);
        this.getChildren().add(c_courcelles);
        getListeCases().add(8,this);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Courcelles";
    }
}
