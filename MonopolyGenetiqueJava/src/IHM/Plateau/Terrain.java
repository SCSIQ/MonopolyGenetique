package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Terrain extends Proprietes {
    private Couleur couleur ;
    private int maison ;

    public Terrain(Cases caseMetier, ArrayList<Pane> listeCases) {
        super(caseMetier, listeCases);
    }


    public void AcheterMaison() {

    }

    public void VendreMaison(){

    }
}
