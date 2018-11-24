package IHM.Plateau.LieuPublic;

import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Ampoule extends Proprietes {

    public Ampoule(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Ampoule";
    }

}
