package Metier.Automate.Argent.Proprietes;

import Entites.Joueur;
import Metier.Automate.Choix.ChoixPossibles;
import Metier.Plateau.Proprietes;
import Metier.Automate.Etat;

import java.util.ArrayList;

public class AcheterPropriete extends Etat{

    public AcheterPropriete(ArrayList<Joueur> listeJoueurs) {
        super(listeJoueurs);
    }

    @Override
    public void agir() {

        //normalement ces infos sont données par l'IHM car varient selon la case ou se trouve le pion
        Proprietes p = new Proprietes();
        p.setPrix(500);

        //ici doit être vérifié si le joueur est en capacité de payer. Si non, alors il doit vendre des
        //propriétés. Si malgré cela il ne peut toujours pas payer, alors il perd la partie

        Joueur joueur = super.getListeJoueurs().get(0);
        joueur.Payer(p.getPrix());

    }

    @Override
    public Etat transition() {
        return new ChoixPossibles(super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "AcheterPropriete{}";
    }
}
