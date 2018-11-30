package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Chance extends VueCases {


    public Chance(Cases caseMetier) {
        super(caseMetier);
    }



    @Override
    public String getType() {
        return "Chance";
    }

    public void PiocherCarteChance(){

    }
}
