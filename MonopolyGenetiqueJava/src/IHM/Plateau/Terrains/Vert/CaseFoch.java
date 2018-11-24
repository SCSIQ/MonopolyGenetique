package IHM.Plateau.Terrains.Vert;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

//CASE DE FOCH
public class CaseFoch extends Terrain {
    public CaseFoch(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }
}
