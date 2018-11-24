package IHM.Plateau.LieuPublic;

import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class ServicePublic extends Proprietes {

    public ServicePublic(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }

    @Override
    public abstract String getType();

}
