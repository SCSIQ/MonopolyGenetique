package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

public class ChanceSortirDePrison extends Chance {

    public ChanceSortirDePrison() {
        super.setTexte("Sortir de prison");
    }

    @Override
    public void agir(Automate automate) {
        automate.getJoueurCourant().setEstEnPrison(false); //permet au joueur de sortir de prison
    }
}
