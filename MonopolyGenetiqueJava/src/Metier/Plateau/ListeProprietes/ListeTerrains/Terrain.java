package Metier.Plateau.ListeProprietes.ListeTerrains;

import IHM.Plateau.Couleur;
import Metier.Plateau.ListeProprietes.Proprietes;

public abstract class Terrain extends Proprietes {

    private Couleur couleur ;

    private int prixAjoutMaison; /// prix d'une maison

    //de 1 à 4 = nombre de maisons, 5 = un hotel
    private int nbMaisons = 0;

    private int loyerSansMaison ;

    ////prix des loyer suivant le nombre de maison sur la propriété

    private int loyer1Maison;
    private int loyer2Maison;
    private int loyer3Maison;
    private int loyer4Maison;
    private int loyerHotel; // loyer avec un hôtel

    /////////CONSTRUCTEUR///////
    public Terrain(int position) {
        super(position);
    }


    //////////permet d'ajouter une maison
    //retourne vrai si l'action à bien pû se faire, sinon retourne faux
    public boolean ajouterMaison(){
        if(this.nbMaisons < 5){
            this.nbMaisons++;
            return true;
        }else {
            return false;
        }
    }

    //////////permet de supprimer une maison
    //retourne vrai si l'action à bien pû se faire, sinon retourne faux
    public boolean supprimerMaison(){
        if(this.nbMaisons > 0){
            this.nbMaisons--;
            return true;
        }else {
            return false;
        }
    }

    ////////////////GETTER /////////////////
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

    public int getNbMaisons() { return nbMaisons; }

    public int getPrixAjoutMaison() { return prixAjoutMaison; }

    public int getLoyerHotel() {
        return loyerHotel;
    }

    ///////////////////////SETTER ///////////
    public void setLoyerSansMaison(int loyerSansMaison) {
        this.loyerSansMaison = loyerSansMaison;
    }

    public void setLoyerHotel(int loyerHotel) {
        this.loyerHotel = loyerHotel;
    }

    // si on ajoute 200€ au loyer par maison ça vous va ?
    public void setLoyer1Maison(int loyer1Maison) {
        this.loyer1Maison = loyer1Maison; // this.loyer1Maison = loyerSansMaison + 200 ;

    }

    public void setLoyer2Maison(int loyer2Maison) {
        this.loyer2Maison = loyer2Maison; // this.loyer2Maison = loyer1Maison + 200 ;
    }

    public void setLoyer3Maison(int loyer3Maison) {
        this.loyer3Maison = loyer3Maison;// this.loyer3Maison = loyer2Maison + 200 ;
    }

    public void setLoyer4Maison(int loyer4Maison) {
        this.loyer4Maison = loyer4Maison;// this.loyer4Maison = loyer3Maison + 200 ;
    }

    public void setNbMaisons(int nbMaisons) { this.nbMaisons = nbMaisons;  } // renvoie le nombre de maison que possède un terrain

    public void setPrixAjoutMaison(int prixAjoutMaison) {this.prixAjoutMaison = prixAjoutMaison; }
}
