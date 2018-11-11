package Metier.Automate.Des;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Choix.ChoixPossibles;
import Metier.Automate.Deplacement;
import Metier.Automate.Etat;

import java.util.ArrayList;
import java.util.Random;

public class LancerDesJoueur extends Etat {

    private boolean transitionToDeplacement = true;

    public LancerDesJoueur(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        //IMPORTANT !!!
        //Ne prend pas en compte les 3 doubles qui evoient en prison
        //A coder...

        Joueur j = super.getListeJoueurs().get(0); //récupère le joueur courant

        if(j.getaLanceDes()==false){
            this.transitionToDeplacement = true;
            j.setaLanceDes(true);
            int de1;
            int de2;
            Random toto = new Random();
            de1=toto.nextInt(6)+1;
            de2=toto.nextInt(6)+1;
            int score = de1+de2;
            j.setResDes1(de1);
            j.setResDes2(de1);
            j.setResLanceDes(score);
            System.out.println("    score joueur : "+score);
        }else{
            this.transitionToDeplacement = false;
            System.out.println("    vous avez déjà lancé des dés");
        }
    }

    @Override
    public Etat transition(String event) {
        if(this.transitionToDeplacement == false){
            this.transitionToDeplacement = true;
            return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        }
        else{
            return new Deplacement(super.getAutomate(), super.getListeJoueurs());
        }

    }

    @Override
    public String toString() {
        return "LancerDesJoueur{}";
    }
}