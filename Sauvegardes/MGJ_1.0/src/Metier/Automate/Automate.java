package Metier.Automate;

import Entites.Joueur;
import Metier.Automate.Des.LancerDesInitial;
import Metier.Automate.Des.LancerDesJoueur;

import java.util.ArrayList;

public class Automate {

    private Etat etatCourant;
    private ArrayList<Joueur> listeJoueurs ;

    public Automate(ArrayList<Joueur> listeJoueurs){
        this.listeJoueurs = listeJoueurs;
        this.etatCourant = new LancerDesInitial(listeJoueurs);
        //this.etatCourant.agir();
    }

    public void evoluer(){
        this.etatCourant.agir();
        this.etatCourant = this.etatCourant.transition();
    }

}
