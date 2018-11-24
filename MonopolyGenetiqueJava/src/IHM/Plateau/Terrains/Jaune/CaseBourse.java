package IHM.Plateau.Terrains.Jaune;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

////CASE PLACE DE LA BOURSE
public class CaseBourse extends Terrain {

    public CaseBourse(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Bourse";
    }
}
