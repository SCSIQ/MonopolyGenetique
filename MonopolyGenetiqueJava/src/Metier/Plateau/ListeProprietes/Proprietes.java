package Metier.Plateau.ListeProprietes;

import Entites.Joueur;
import Metier.Plateau.Cases;

public abstract class Proprietes extends Cases {

    private Joueur proprio ;

    private int prixAchat ;
    private int prixHypotheque;
    private int prixAjoutMaison;
    private int prixVenteMaison;

    //de 1 à 4 = nombre de maisons, 5 = un hotel
    private int nbMaisons = 0;

    private int loyerSansMaison;
    private int loyer1Maison;
    private int loyer2Maison;
    private int loyer3Maison;
    private int loyer4Maison;
    private int loyerHotel;

    public Proprietes(int position) {
        super(position);
    }

    public int getPrix() {
        return prixAchat;
    }

    public void setPrix(int prix) {
        this.prixAchat = prix;
    }

    public void ajoutMaison(){
        //ici on ajoute une maison
    }

    public void ventenMaison(){
        //ici on enlève une maison
    }

    //permet d'ajouter une maison
    //retourne vrai si l'action à bien pû se faire, sinon retourne faux
    public boolean ajouterMaison(){
        if(this.nbMaisons < 5){
            this.nbMaisons++;
            return true;
        }else {
            return false;
        }
    }

    //permet de supprimer une maison
    //retourne vrai si l'action à bien pû se faire, sinon retourne faux
    public boolean supprimerMaison(){
        if(this.nbMaisons > 0){
            this.nbMaisons--;
            return true;
        }else {
            return false;
        }
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

    public Joueur getProprio() {
        return proprio;
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

    public void setProprio(Joueur proprio) {
        this.proprio = proprio;
    }
}
