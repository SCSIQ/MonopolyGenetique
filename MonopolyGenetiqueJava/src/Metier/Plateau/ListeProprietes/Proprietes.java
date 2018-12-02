package Metier.Plateau.ListeProprietes;

import Entites.Joueur;
import Metier.Plateau.Cases;

public abstract class Proprietes extends Cases {

    private Joueur proprio ;

    private int prixAchat ; /// prix d'achat de la propriété
    private int prixHypotheque; /// prix de l'hypothèque de la propriété

    public Proprietes(int position) {
        super(position);
    }

    ///////////getter//////////////
    public int getPrixHypotheque() {
        return prixHypotheque;
    }

    public Joueur getProprio() {
        return proprio;
    }

    public int getPrix() {
        return prixAchat;
    }

    ////////////setter /////////////
    public void setPrixHypotheque(int prixHypotheque) {
        this.prixHypotheque = prixHypotheque;
    }

    public void setProprio(Joueur proprio) {
        this.proprio = proprio;
    }

    public void setPrix(int prix) {
        this.prixAchat = prix;
    }
}
