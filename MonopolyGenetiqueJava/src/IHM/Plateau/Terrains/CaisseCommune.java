package IHM.Plateau.Terrains;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CaisseCommune extends VueCases {

    public CaisseCommune(Cases caseMetier) {
        super(caseMetier);
    }



    @Override
    public String getType() {
        return "Caisse de communautée";
    }

    @Override
    public void setImageMaison(ImageView maison) {

    }

    @Override
    public ImageView getImageMaison() {
        return null;
    }
}
