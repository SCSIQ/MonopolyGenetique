package Metier.Cartes.CartesCaisseDeCommunaute;

import Metier.Automate.Automate;

public class CommunauteDepart extends CaisseDeCommunaute {

    public CommunauteDepart() {super.setTexte("Vous retournez sur la case départ !");
    }

    @Override
    public void agir(Automate automate) {
        automate.getJoueurCourant().Avancer(0); //avancer à la case départ
        automate.setContenuCartePiochée("Vous retournez sur la case départ !");
    }
}
