package Metier.PartiesIA;

import java.util.ArrayList;

public class Tournoi {

    private ArrayList<PartieIA> listeParties = new ArrayList<>();
    private int nbIA;
    private int nbMutations;
    private int nbpartie;


    private int nbToursMax;

    public Tournoi(int nbAI, int nbMutations, int nbToursMax,int nbpartie) {
        this.nbIA = nbAI;
        this.nbMutations = nbMutations;
        this.nbToursMax = nbToursMax;
        this.nbpartie=nbpartie;

        //crée toutes les parties
        //for (int j = 0; j < this.nbIA/4; j++) {
        for (int j = 0; j < nbpartie; j++) {
            this.listeParties.add(new PartieIA(nbAI,nbMutations, this.nbToursMax,nbpartie));
        }
    }

    public void lancerLeTournoi(){
        lancerUneSerieDePArties();
    }

    private void lancerUneSerieDePArties() {
       for (PartieIA p : listeParties) {
           int i=1;
            System.out.println("\n**************************************************************************************************************************************************************************************************\n"
                    +"**************************************************************************************************************************************************************************************************\n"+
                    "PARTIE "+(i)+"\n");
            p.lancerPartie(nbToursMax);
            i++;
       }
    }



}
