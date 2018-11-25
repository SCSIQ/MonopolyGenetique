package IHM.Plateau.Terrains.Jaune;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE SAINT HONORE
public class CaseHonore extends Terrain {

    public CaseHonore(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(340);
        this.setLayoutY(110);

        URL faubourgSH = getClass().getResource("Images/Case_FaubourgSH.png");
        Image i_faubourgSH = new Image(faubourgSH.toExternalForm());
        ImageView c_faubourgSH = new ImageView(i_faubourgSH);

        c_faubourgSH.setFitWidth(48);
        c_faubourgSH.setPreserveRatio(true);

        getListeCases().add(this);
        this.getChildren().add(c_faubourgSH);

    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Honore";
    }
}
