package Metier.Cartes.CartesCaisseDeCommunaute;

import Metier.Automate.Automate;

public class CommunauteGagnerArgent extends CaisseDeCommunaute{

    public CommunauteGagnerArgent() {
        super.setTexte("Recevez 2 000€ pour votre remarquable performance à la Féérie Dansante des Sirènes.");
    }

    @Override
    public void agir(Automate automate) {
        automate.getJoueurCourant().IncrementerSolde(2000); //gagner 2 000€
        automate.setContenuCartePiochée("Recevez 2 000€ pour votre remarquable performance à la Féérie Dansante des Sirènes.");
    }
}
