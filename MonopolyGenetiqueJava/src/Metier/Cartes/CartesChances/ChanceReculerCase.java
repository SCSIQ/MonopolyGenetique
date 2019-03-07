package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

public class ChanceReculerCase extends Chance {

    public ChanceReculerCase() {super.setTexte("Vous reculez de 6 cases"); }

    @Override
    public void agir(Automate automate) {

        if ( automate.getJoueurCourant().getPion().getCase().getPosition()-6 <0){ //si position -6 est inférieur a 0
          int difference = automate.getJoueurCourant().getPion().getCase().getPosition() ; //variable qui prend 6-position
          automate.getJoueurCourant().Avancer(40 -difference);

        }else {
            automate.getJoueurCourant().Avancer(automate.getJoueurCourant().getPion().getCase().getPosition()-6 );
        }

        automate.setContenuCartePiochée("Vous reculez de 6 cases");
    }
}
