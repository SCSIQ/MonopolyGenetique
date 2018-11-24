package IHM.Plateau.LieuPublic.Gare;

import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GareMontparnasse extends Proprietes {


    public GareMontparnasse(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Gare de Montparnasse";
    }
}
