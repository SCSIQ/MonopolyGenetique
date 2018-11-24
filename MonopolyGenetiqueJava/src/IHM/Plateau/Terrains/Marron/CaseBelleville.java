package IHM.Plateau.Terrains.Marron;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE BELLEVILLE
public class CaseBelleville extends Terrain {

    public CaseBelleville(Cases caseMetier, ArrayList<Pane> listeCases)
    {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Belleville";
    }
}
