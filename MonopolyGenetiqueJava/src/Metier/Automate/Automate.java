package Metier.Automate;

import Entites.Joueur;
import Metier.Automate.Des.LancerDesInitial;
import Metier.Automate.Des.LancerDesJoueur;

import java.util.ArrayList;

public class Automate {

    private Etat etatCourant;
    private ArrayList<Joueur> listeJoueurs ;
    private boolean automatedEvolution = false;

    public Automate(ArrayList<Joueur> listeJoueurs){
        this.listeJoueurs = listeJoueurs;
        this.etatCourant = new LancerDesInitial(this, listeJoueurs);
        System.out.println("Etat actuel : "+this.etatCourant.toString());
        evoluer(""); //pour passer de l'état LancerDesInitial à l'état ChoixPossibles
    }

    public void evoluer(String event){
        this.etatCourant.agir(event);
        this.etatCourant = this.etatCourant.transition(event);
        System.out.println("Etat actuel : "+this.etatCourant.toString());
        if(automatedEvolution == true){
            automatedEvolution = false;
            this.evoluer(event);
        }
    }

    //variable permettant de demander à l'automate d'évoluer une fois de plus de façon automatique
    public void setAutomatedEvolution(boolean automatedEvolution) {
        this.automatedEvolution = automatedEvolution;
    }

    public Joueur getJoueurCourant() {
        return listeJoueurs.get(0);
    }
}
