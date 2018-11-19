package Metier;

import Entites.IA;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class InitialisationPartieIA extends InitialisationPartie{

    private void creationListeIA(int nombre, ArrayList<Color> listeCouleurs){
        for(int i=0 ; i<nombre ; i++){
            super.listeJoueurs.add(new IA(super.listeCases, listeCouleurs.get(i)));
        }
    }
}
