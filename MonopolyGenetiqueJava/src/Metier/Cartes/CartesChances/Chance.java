package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;
import Metier.Cartes.Cartes;

public abstract class Chance extends Cartes {

    public Chance() {
    }

    public abstract void  agir(Automate automate);
}
