package IHM.Plateau.Terrains.Rose;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE DE LA VILETTE
public class CaseVillette extends Terrain {
    public CaseVillette(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Villette";
    }
}
