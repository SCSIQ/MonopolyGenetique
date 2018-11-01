package Metier.Automate.Des;
import Entites.Joueur;
import Metier.Automate.Etat;

import java.util.ArrayList;
import java.util.Random;

public class LancerDesInitial extends Etat {

    public LancerDesInitial(ArrayList<Joueur> listeJoueurs) {
        super(listeJoueurs);
    }

    @Override
    public void agir() {
        int de1;
        int de2;
        Random toto = new Random();

        de1=toto.nextInt(6)+1;
        de2=toto.nextInt(6)+1;

        int score = de1+de2;

        System.out.println("Dé1 : "+de1);
        System.out.println("Dé2 : "+de2);
        System.out.println("score joueur : "+score);
    }

    @Override
    public Etat transition() {
        return null;
    }
}
