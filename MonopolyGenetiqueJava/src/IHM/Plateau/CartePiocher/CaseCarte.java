package IHM.Plateau.CartePiocher;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CaseCarte extends VueCases {


    public CaseCarte(Cases caseMetier) {
        super(caseMetier);
    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Chance";
    }
}
