package IHM.Plateau.Terrains.BleuCiel;


import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE RUE REPUBLIQUE
public class CaseRepublique extends Terrain {


    public CaseRepublique(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Republique";
    }
}
