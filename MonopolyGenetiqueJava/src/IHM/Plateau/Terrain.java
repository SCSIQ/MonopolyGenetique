package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class Terrain extends Proprietes {
    private Couleur couleur ;
    private int maison ;

    public Terrain(Cases caseMetier) {
        super(caseMetier);
    }

    @Override
    public abstract String getType();


    public void AcheterMaison() {

    }

    public void VendreMaison(){

    }
}
