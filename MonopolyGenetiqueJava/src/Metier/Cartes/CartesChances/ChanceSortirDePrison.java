package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

public class ChanceSortirDePrison extends Chance {

    public ChanceSortirDePrison(){
        super.setTexte("Vous gagnez une carte libéré de prison");
    }

    @Override
    public void agir(Automate automate) {
        automate.getJoueurCourant().gagnerUneCartesLibereDePrison(); //donne au joueur une carte sortir de prison
    }
}
