package Metier.Plateau.ListeProprietes;

import Entites.Joueur;
import Metier.Plateau.Cases;

public abstract class Proprietes extends Cases {

    private Joueur proprio ;

    private int prixAchat ; /// prix d'achat de la propriété
    private int prixHypotheque; /// prix de l'hypothèque de la propriété

    private int loyerHotel; // loyer avec un hôtel

    public Proprietes(int position) {
        super(position);
    }

    public int getPrix() {
        return prixAchat;
    }

    public void setPrix(int prix) {
        this.prixAchat = prix;
    }

    ///////////getter//////////////
    public int getPrixHypotheque() {
        return prixHypotheque;
    }

    public int getLoyerHotel() {
        return loyerHotel;
    }

    public Joueur getProprio() {
        return proprio;
    }

    ////////////setter /////////////
    public void setPrixHypotheque(int prixHypotheque) {
        this.prixHypotheque = prixHypotheque;
    }

    public void setLoyerHotel(int loyerHotel) {
        this.loyerHotel = loyerHotel;
    }

    public void setProprio(Joueur proprio) {
        this.proprio = proprio;
    }
}
