package IHM.Plateau.LieuPublic;

import IHM.Plateau.Proprietes;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class ServicePublic extends Proprietes {

    public ServicePublic(Cases caseMetier) {
        super(caseMetier);
    }

    @Override
    public abstract String getType();

}
