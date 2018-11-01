package Metier.Automate.Choix;

import Entites.Joueur;
import Metier.Automate.Etat;

import java.util.ArrayList;

public class ChoixPossibles extends Etat {

    public ChoixPossibles(ArrayList<Joueur> listeJoueurs) {
        super(listeJoueurs);
    }

    @Override
    public void agir() {
        //cet état n'a pas pour vocation de faire quelque chose de particulier mais plutôt
        //de permettre la transition entre plusieurs actions possibles parmi le choix proposé
        //au joueur comme par exemple lancer les dés, consulter ses propriétés, etc
    }

    @Override
    public Etat transition() {
        return null;
    }

    @Override
    public String toString() {
        return "ChoixPossibles{}";
    }
}
