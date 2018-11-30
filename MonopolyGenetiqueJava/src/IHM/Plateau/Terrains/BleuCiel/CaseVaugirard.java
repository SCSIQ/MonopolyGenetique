package IHM.Plateau.Terrains.BleuCiel;

import IHM.Plateau.Proprietes;
import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE RUE DE VAUGIRAD
public class CaseVaugirard extends Terrain {


    public CaseVaugirard(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(244);
        this.setLayoutY(628);


        URL vaugirard = getClass().getResource("Images/Case_Vaugirard.png");
        Image i_vaugirard = new Image(vaugirard.toExternalForm());
        ImageView c_vaugirard = new ImageView(i_vaugirard);

        c_vaugirard.setFitWidth(48);
        c_vaugirard.setPreserveRatio(true);

        this.getChildren().add(c_vaugirard);
    }



    @Override
    public String getType() {
        return "Vaugirard";
    }
}
