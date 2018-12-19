package IHM.Plateau.CartePiocher;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CaseCarte extends VueCases {


    public CaseCarte(Cases caseMetier) {
        super(caseMetier);
    }



    @Override
    public String getType() {
        return "Chance";
    }

    @Override
    public void setImageMaison(ImageView maison) {

    }

    @Override
    public ImageView getImageMaison() {
        return null;
    }
}
