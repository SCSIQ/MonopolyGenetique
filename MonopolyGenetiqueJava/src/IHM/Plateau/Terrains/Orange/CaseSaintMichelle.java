package IHM.Plateau.Terrains.Orange;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE SAINT MICHELLE
public class CaseSaintMichelle extends Terrain {

    public CaseSaintMichelle(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Michelle";
    }
}
