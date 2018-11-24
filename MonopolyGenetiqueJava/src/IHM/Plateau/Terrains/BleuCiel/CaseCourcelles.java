package IHM.Plateau.Terrains.BleuCiel;



import IHM.Plateau.Terrain;
import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE RUE DE COURCELLES
public class CaseCourcelles extends Terrain {

    public CaseCourcelles(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Courcelles";
    }
}
