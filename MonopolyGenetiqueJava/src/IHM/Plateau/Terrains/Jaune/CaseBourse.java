package IHM.Plateau.Terrains.Jaune;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

////CASE PLACE DE LA BOURSE
public class CaseBourse extends Terrain {

    private ImageView maison ;
    public CaseBourse(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(388);
        this.setLayoutY(110);

        URL bourse = getClass().getResource("Images/Case_Bourse.png");
        Image i_bourse = new Image(bourse.toExternalForm());
        ImageView c_bourse = new ImageView(i_bourse);

        c_bourse.setFitWidth(48);
        c_bourse.setPreserveRatio(true);

        this.getChildren().add(c_bourse);
    }


    @Override
    public String getType() {
        return "Place de la Bourse";
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
