package Metier.Automate;

import Entites.Joueur;
import Metier.Automate.Etats.Des.LancerDesInitial;
import Metier.Automate.Etats.Etat;

import java.util.ArrayList;

public class Automate {

    private Etat etatCourant;
    private ArrayList<Joueur> listeJoueurs ;
    private boolean automatedEvolution = false;
    private int numTour = 1;
    private int nbJoueurTour = 1;

    public Automate(ArrayList<Joueur> listeJoueurs){
        this.listeJoueurs = listeJoueurs; //récupère la liste des joueurs depuis la classe InitialisationPartie
        this.etatCourant = new LancerDesInitial(this, listeJoueurs); //lancement Etat initial
        System.out.println("Etat initial : "+this.etatCourant.toString());
        evoluer(""); //pour passer de l'état LancerDesInitial à l'état ChoixPossibles
    }

    //cette méthode est appellée dès que l'on veut faire évoluer l'automate, à savoir,
    //faire quelque chose dans le jeu comme cliquer sur un bouton
    //cette méthode est appellée soit depuis l'IHM pour une évolutions lors d'un event,
    //soit par un Etat pour une évolution automatique
    public void evoluer(String event){
        System.out.println(this.etatCourant.toString()+" - - - - - - - - - - ->");
        this.etatCourant.agir(event);
        this.etatCourant = this.etatCourant.transition(event);
        System.out.println("- - - - - - - - - - - - - - - - - - - -> "+this.etatCourant.toString());
        if(automatedEvolution == true){
            automatedEvolution = false;
            this.evoluer(event);
        }
    }

    //variable permettant de demander à l'automate d'évoluer une fois de plus de façon automatique
    public void setAutomatedEvolution(boolean automatedEvolution) {
        this.automatedEvolution = automatedEvolution;
    }

    //retourne le joueur qui est entrain de jouer
    public Joueur getJoueurCourant() {
        return listeJoueurs.get(0);
    }

    //retourne ne nombre de joueurs
    public int getNombreJoueur(){
        return listeJoueurs.size() ;
    }

    //retourne la liste des joueurs
    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public int getNumTour() {
        return numTour;
    }

    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    public int getNbJoueurTour() {
        return nbJoueurTour;
    }

    public void setNbJoueurTour(int nbJoueurTour) {
        this.nbJoueurTour = nbJoueurTour;
    }
}
