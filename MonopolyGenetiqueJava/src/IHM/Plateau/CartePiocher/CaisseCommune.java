package IHM.Plateau.CartePiocher;

import IHM.Plateau.VueCases;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CaisseCommune extends VueCases {


    public CaisseCommune(Cases caseMetier) {
        super(caseMetier);
    }



    @Override
    public String getType() {
        return "Caisse de Communauté";
    }

    public void PiocherCarteCaisseCommune(){

    }
}
