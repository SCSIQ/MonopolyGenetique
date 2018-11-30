package IHM.Plateau.Terrains.Vert;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE DE BRETEUIL
public class CaseBreteuil extends Terrain {
    public CaseBreteuil(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(532);
        this.setLayoutY(196);

        URL breteuil = getClass().getResource("Images/Case_Breteuil.png");
        Image i_breteuil = new Image(breteuil.toExternalForm());
        ImageView c_breteuil = new ImageView(i_breteuil);

        c_breteuil.setFitHeight(48);
        c_breteuil.setPreserveRatio(true);
        this.getChildren().add(c_breteuil);
    }



    @Override
    public String getType() {
        return "Breuteuil";
    }
}
