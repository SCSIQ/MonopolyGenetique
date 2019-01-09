package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;
import Metier.Cartes.Cartes;

import java.util.Random;

public abstract class Chance extends Cartes {


    public Chance() {
    }

    public abstract void  agir(Automate automate);
}
