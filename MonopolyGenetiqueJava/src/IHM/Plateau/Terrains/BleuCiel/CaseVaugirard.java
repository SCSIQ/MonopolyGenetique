package IHM.Plateau.Terrains.BleuCiel;

import IHM.Plateau.Proprietes;
import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE RUE DE VAUGIRAD
public class CaseVaugirard extends Terrain {


    public CaseVaugirard(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Vaugirard";
    }
}
