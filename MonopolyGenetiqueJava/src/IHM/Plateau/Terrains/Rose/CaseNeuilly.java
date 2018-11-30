package IHM.Plateau.Terrains.Rose;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE NEUILLY
public class CaseNeuilly extends Terrain {
    public CaseNeuilly(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(15);
        this.setLayoutY(484);

        URL neuilly = getClass().getResource("Images/Case_Neuilly.png");
        Image i_neuilly = new Image(neuilly.toExternalForm());
        ImageView c_neuilly = new ImageView(i_neuilly);

        c_neuilly.setFitHeight(48);
        c_neuilly.setPreserveRatio(true);

        this.getChildren().add(c_neuilly);

    }



    @Override
    public String getType() {
        return "Avenue de Neuilly";
    }
}
