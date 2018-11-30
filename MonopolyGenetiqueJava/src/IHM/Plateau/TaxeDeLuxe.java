package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

public class TaxeDeLuxe extends Taxes {


    public TaxeDeLuxe(Cases caseMetier) {
        super(caseMetier);
        this.setLayoutX(532);
        this.setLayoutY(532);

        URL taxe = getClass().getResource("Images/Case_Taxe.png");
        Image i_taxe = new Image(taxe.toExternalForm());
        ImageView c_taxe = new ImageView(i_taxe);

        c_taxe.setFitHeight(48);
        c_taxe.setPreserveRatio(true);

        this.getChildren().add(c_taxe);
    }


    @Override
    public String getType() {
        return "Taxe de luxe";
    }
}
