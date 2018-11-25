package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class Taxes extends VueCases {


    public Taxes(Cases caseMetier) {
        super(caseMetier);
    }

    @Override
    public abstract String getType();
}
