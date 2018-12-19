package Metier.Cartes.CartesCaisseDeCommunaute;

import Metier.Automate.Automate;
import Metier.Cartes.Cartes;

public abstract class CaisseDeCommunaute extends Cartes {

    public CaisseDeCommunaute() {
    }

    public abstract void  agir(Automate automate);
}
