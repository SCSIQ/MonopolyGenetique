package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

public class ChanceRdvDueDeLaPaie extends Chance {

    public ChanceRdvDueDeLaPaie() {
        super.setTexte("Rendez-vous rue de la paie");
    }

    @Override
    public void agir(Automate automate) {
        automate.getJoueurCourant().Avancer(39); //avance à la rue de la paie
    }

    public String getTypeCarte()
    {
        return "Rendez-vous rue de la paix." ;
    }
}
