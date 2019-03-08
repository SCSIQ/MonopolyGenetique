package Metier.PartiesIA;

import java.util.ArrayList;

public class Tournoi {

    private ArrayList<PartieIA> listeParties = new ArrayList<>();
    private int nbIA;
    private int nbMutations;


    private int nbToursMax;

    public Tournoi(int nbAI, int nbMutations, int nbToursMax) {
        this.nbIA = nbAI;
        this.nbMutations = nbMutations;
        this.nbToursMax = nbToursMax;

        //crée toutes les parties
        //for (int j = 0; j < this.nbIA/4; j++) {
        for (int j = 0; j < 1; j++) {
            this.listeParties.add(new PartieIA(4,nbMutations, this.nbToursMax));
        }
    }

    public void lancerLeTournoi(){

        lancerUneSerieDePArties();
    }

    private void lancerUneSerieDePArties() {
        for (PartieIA p : this.listeParties) {
            p.lancerPartie(nbToursMax);
        }
    }



}
