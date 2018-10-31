package Metier.Automate;

import Entites.Joueur;

public class Automate {

    private Etat etatCourant;
    private Joueur joueur ;

    public Automate(Joueur listeJoueurs){
        this.joueur = listeJoueurs;
        //this.etatCourant = new AffichageIHMmenuIA(this.joueur);
    }

    public void evoluer(){
        this.etatCourant.agir();
        this.etatCourant = this.etatCourant.transition();
    }

}
