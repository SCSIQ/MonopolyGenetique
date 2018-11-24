package IHM.Plateau.CartePiocher;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ParcGratuit extends VueCases {

    public ParcGratuit(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Parc gratuit";
    }
}
