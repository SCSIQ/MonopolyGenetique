package Metier.PartiesIA;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.InitialisationPartieIA;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PartieIA {

    private Automate automate;
    private ArrayList<Joueur> listeIA;
    private InitialisationPartieIA initialisationPartieIA = new InitialisationPartieIA();

    public PartieIA(int nbAI, int nbToursMax) {
        ArrayList<Color> listeCouleurs = new ArrayList<>();
        for(int i=0 ; i<nbAI ; i++){
            listeCouleurs.add(couleurAdversaire(i));
        }
        this.listeIA = this.initialisationPartieIA.creationListeIA(nbAI, listeCouleurs);
    }

    public void lancerPartie(){
        this.automate = this.initialisationPartieIA.automatePourIaInitialisation(this.listeIA);
    }

    private Color couleurAdversaire(int i)
    {

        Color couleur;
        switch (i){
            case 0 : couleur = Color.CRIMSON;
                break;
            case 1 : couleur = Color.DARKMAGENTA;
                break;
            case 2 : couleur = Color.DARKTURQUOISE;
                break;
            case 3 : couleur = Color.CORAL;
                break;
            case 4 : couleur = Color.MEDIUMSEAGREEN;
                break;
            default: couleur = Color.AZURE;
        }
        return couleur;
    }

}
