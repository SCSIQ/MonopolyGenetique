package IHM.Plateau.Terrains;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

public class CaisseCommune extends VueCases {

    public CaisseCommune(Cases caseMetier) {
        super(caseMetier);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Caisse de communautée";
    }
}
