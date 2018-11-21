package Metier.Automate.Etats.Argent.Maison;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Etat;

import java.util.ArrayList;

public class AcheterMaison extends Etat {

    public AcheterMaison(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
    }

    @Override
    public void agir(String event) {

        //tout d'abord, lors de la création d'une case coté métier, indiquer le prix d'achat d'une maison
        //(bien penser à l'ajouter dans la classe propriete)

        //ensuite,
        //récupérer le pris d'une maison sur la case puis demande au joueur de donner son solde
        //ensuite l'état soustrait du solde du joueur le prix puis redonne le nouveau solde au joueur

        //enfin, dire à la case qu'elle a une maison de plus ( ajouterMaison() )

        //pour finir tu peux faire l'Etat vendreMaison{}

    }

    @Override
    public Etat transition(String event) {
        return null;
    }
}
