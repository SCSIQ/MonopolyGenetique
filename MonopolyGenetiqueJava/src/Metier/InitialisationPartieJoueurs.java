package Metier;

import Entites.Humain;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class InitialisationPartieJoueurs extends InitialisationPartie{

    private void creationListeJoueurs(int nombre, ArrayList<Color> listeCouleurs){
        for(int i=0 ; i<nombre ; i++){
            super.listeJoueurs.add(new Humain(super.listeCases, listeCouleurs.get(i)));
        }
    }
}
