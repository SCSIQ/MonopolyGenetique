package Metier;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Automate;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class InitialisationPartieIA extends InitialisationPartie{

    public ArrayList<Joueur> creationListeIA(int nombre, ArrayList<Color> listeCouleurs){
        ArrayList<Joueur> listeIA = new ArrayList<>();
        super.creationListeCases();
        for(int i=0 ; i<nombre ; i++){
            listeIA.add(new IA(super.listeCases, listeCouleurs.get(i), null));
        }
        return listeIA;
    }

    public Automate automatePourIaInitialisation(ArrayList<Joueur> listeDesIA,int nbTour) {
        super.creationListeCartesChances();
        Automate automate = new Automate(listeDesIA, this.listeDesCartesChances, this.listeDesCartesCaisseCommune,nbTour);
        return automate;
    }
}
