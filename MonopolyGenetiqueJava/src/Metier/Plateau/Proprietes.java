package Metier.Plateau;

import Entites.Joueur;

public class Proprietes extends Cases {

    private String label ;
    private int prix ;
    private Joueur proprio ;

    public Proprietes() {
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
