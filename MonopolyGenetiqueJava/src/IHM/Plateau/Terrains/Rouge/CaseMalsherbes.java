package IHM.Plateau.Terrains.Rouge;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE MALSHERBES
public class CaseMalsherbes extends Terrain {

    private ImageView maison ;

    public CaseMalsherbes(Cases caseMetier) {
        super(caseMetier);

        this.setLayoutX(196);
        this.setLayoutY(110);

        URL malesherbes = getClass().getResource("Images/Case_Malesherbes.png");
        Image i_malesherbes = new Image(malesherbes.toExternalForm());
        ImageView c_malesherbes = new ImageView(i_malesherbes);

        c_malesherbes.setFitWidth(48);
        c_malesherbes.setPreserveRatio(true);

        this.getChildren().add(c_malesherbes);
    }


    @Override
    public String getType() {
        return "Boul. Malsherbes";
    }
    @Override
    public void setImageMaison(ImageView maison) {
        this. maison = maison ;
    }

    @Override
    public ImageView getImageMaison() {
        return maison;
    }
}
