package Metier.Cartes.CartesCaisseDeCommunaute;

import Metier.Automate.Automate;

public class CommunauteReculer extends CaisseDeCommunaute {

    public CommunauteReculer() { super.setTexte("Reculez à la case Avenue Matignon ");
    }
    @Override
    public void agir(Automate automate) {

        automate.setContenuCartePiochée("Reculez à la case Avenue Matignon");
        //automate.
    }


}
