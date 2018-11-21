package Metier.Plateau.ListeProprietes;

import Entites.Joueur;
import Metier.Plateau.Cases;

public abstract class Proprietes extends Cases {

    private int prixAchat ;
    private int prixHypotheque;
    private int loyerSansMaison;
    private int loyer1Maison;
    private int loyer2Maison;
    private int loyer3Maison;
    private int loyer4Maison;
    private int loyerHotel;
    private Joueur proprio ;

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

    public int getLoyerSansMaison() {
        return loyerSansMaison;
    }

    public int getLoyer1Maison() {
        return loyer1Maison;
    }

    public int getLoyer2Maison() {
        return loyer2Maison;
    }

    public int getLoyer3Maison() {
        return loyer3Maison;
    }

    public int getLoyer4Maison() {
        return loyer4Maison;
    }

    public int getLoyerHotel() {
        return loyerHotel;
    }

    ////////////setter /////////////
    public void setPrixHypotheque(int prixHypotheque) {
        this.prixHypotheque = prixHypotheque;
    }

    public void setLoyerSansMaison(int loyerSansMaison) {
        this.loyerSansMaison = loyerSansMaison;
    }

    public void setLoyer1Maison(int loyer1Maison) {
        this.loyer1Maison = loyer1Maison;
    }

    public void setLoyer2Maison(int loyer2Maison) {
        this.loyer2Maison = loyer2Maison;
    }

    public void setLoyer3Maison(int loyer3Maison) {
        this.loyer3Maison = loyer3Maison;
    }

    public void setLoyer4Maison(int loyer4Maison) {
        this.loyer4Maison = loyer4Maison;
    }

    public void setLoyerHotel(int loyerHotel) {
        this.loyerHotel = loyerHotel;
    }
}
