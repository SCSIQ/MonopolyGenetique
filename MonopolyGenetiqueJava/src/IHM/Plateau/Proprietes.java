package IHM.Plateau;

import Entites.Joueur;
import Metier.Plateau.Cases;

public class Proprietes extends VueCases {

    private String label ;
    private int prix ;
    private Joueur proprio ;

    public Proprietes(Cases caseMetier) {
        super(caseMetier);
    }
}
