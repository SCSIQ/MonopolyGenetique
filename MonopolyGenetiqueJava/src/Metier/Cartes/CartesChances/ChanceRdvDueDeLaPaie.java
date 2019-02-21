package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

public class ChanceRdvDueDeLaPaie extends Chance {

    public ChanceRdvDueDeLaPaie() {super.setTexte("Rendez-vous rue de la paix"); }

    @Override
    public void agir(Automate automate) {

        System.out.println("coucou");
        automate.getJoueurCourant().Avancer(39); //avance à la rue de la paix
        automate.setContenuCartePiochée("Rendez-vous rue de la paix");
    }



}
