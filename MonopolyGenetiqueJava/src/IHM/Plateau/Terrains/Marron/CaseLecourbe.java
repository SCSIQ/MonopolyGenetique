package IHM.Plateau.Terrains.Marron;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//RUE LECOURBE
public class CaseLecourbe extends Terrain {

    private ImageView c_Lecourbe ;

    public CaseLecourbe(Cases caseMetier) {

        super(caseMetier);

        ////////CASE LECOURBE

        this.setLayoutX(388);
        this.setLayoutY(628);


        URL lecourbe = getClass().getResource("Images/Case_Lecourbe.png");
        Image i_Lecourbe = new Image(lecourbe.toExternalForm());
        c_Lecourbe = new ImageView(i_Lecourbe);

        c_Lecourbe.setFitWidth(48);
        c_Lecourbe.setPreserveRatio(true);

        this.getChildren().add(c_Lecourbe);

    }



    @Override
    public String getType() {
        return "Rue Lecourbe";
    }
}
