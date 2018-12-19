package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

public class ChancePerdreArgent extends Chance {

    public ChancePerdreArgent() { super.setTexte("Vous avez perdu 1 000€ ! "); }

    @Override
    public void agir(Automate automate) {
        automate.getJoueurCourant().DecrementerSolde(1000); //perdu 1 000€
        automate.setContenuCartePiochée("Vous avez perdu 1 000€ ! ");
    }
}
