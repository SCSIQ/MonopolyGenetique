package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class Impot extends Taxes {


    public Impot(Cases caseMetier) {
        super(caseMetier);


        this.setLayoutX(340);
        this.setLayoutY(628);

        URL impot = getClass().getResource("Images/Case_Impot.png");
        Image i_impot = new Image(impot.toExternalForm());
        ImageView c_impot = new ImageView(i_impot);

        c_impot.setFitWidth(48);
        c_impot.setPreserveRatio(true);

        this.getChildren().add(c_impot);
    }


    @Override
    public String getType() {
        return "Impôt sur le revenu";
    }

    @Override
    public void setImageMaison(ImageView maison) {

    }

    @Override
    public ImageView getImageMaison() {
        return null;
    }
}
