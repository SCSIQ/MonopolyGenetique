package Metier.Plateau.ListeProprietes;

import Entites.Joueur;
import Metier.Plateau.Cases;

public abstract class Proprietes extends Cases {

    private String label ;
    private int prix ;
    private Joueur proprio ;

    public Proprietes(int position) {
        super(position);
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
