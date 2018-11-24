package IHM.Plateau.LieuPublic;

import IHM.Plateau.LieuPublic.ServicePublic;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Robinet extends ServicePublic {

    public Robinet(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public String getType() {
        return "Robinet";
    }
}
