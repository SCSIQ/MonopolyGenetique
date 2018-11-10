package Metier.Automate.Des;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Deplacement;
import Metier.Automate.Etat;

import java.util.ArrayList;
import java.util.Random;

public class LancerDesJoueur extends Etat {

    public LancerDesJoueur(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        Joueur j = super.getListeJoueurs().get(0); //récupère le joueur courant

        if(j.getaLanceDes()==false){
            j.setaLanceDes(true);
            int de1;
            int de2;
            Random toto = new Random();
            de1=toto.nextInt(6)+1;
            de2=toto.nextInt(6)+1;
            int score = de1+de2;
            System.out.println("    score joueur : "+score);
        }else{
            System.out.println("    vous avez déjà lancé des dés");
        }
    }

    @Override
    public Etat transition(String event) {
        return new Deplacement(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "LancerDesJoueur{}";
    }
}