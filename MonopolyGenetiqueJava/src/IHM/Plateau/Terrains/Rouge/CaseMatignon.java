package IHM.Plateau.Terrains.Rouge;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE MATIGNON
public class CaseMatignon extends Terrain {

    public CaseMatignon(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Matignon";
    }
}
