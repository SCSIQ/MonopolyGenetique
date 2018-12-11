package Metier.Automate.Etats.Des;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Automate.Etats.Deplacement;
import Metier.Automate.Etats.Etat;

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

        //System.out.println("AVANT DEPLACEMENT --> LancerDesJoueur : "+j.getaLanceDes());

        if(j.getaLanceDes()==false){
            this.transitionToDeplacement = true;

            int de1;
            int de2;
            Random toto = new Random();

            de1=toto.nextInt(6)+1;
            de2=toto.nextInt(6)+1;
            //de1=2;
            //de2=2;

            int score = de1+de2;
            j.setResDes1(de1);
            j.setResDes2(de2);
            j.setResLanceDes(score);
            System.out.println("    score joueur : "+score);

            if(de1==de2 && j.getNbDoubles()<2) //si double mais pas le troisième
            {
                j.setaLanceDes(false);
                j.setNbDoubles(j.getNbDoubles()+1);
            }
            else if(j.getNbDoubles()==2) //si trois doubles
            {
                j.setaLanceDes(true);
                j.getPion().setGoToPrison(true);
            }
            else
            {
                j.setaLanceDes(true);
            }
            //System.out.println("APRES DEPLACEMENT --> LancerDesJoueur : "+j.getaLanceDes());

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
