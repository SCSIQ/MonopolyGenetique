package IHM.Plateau.LieuPublic;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Prison extends VueCases {

    public Prison(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Prison";
    }
}
