package IHM.Plateau;

import Entites.Joueur;
import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Proprietes extends VueCases {

    private String label ;
    private int prix ;
    private Joueur proprio ;


    public Proprietes(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }
}
