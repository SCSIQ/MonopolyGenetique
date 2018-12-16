package Metier.Plateau.ListeProprietes.ListeTerrains;

import IHM.Plateau.Couleur;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;

public abstract class Terrain extends Proprietes {

    protected CouleurMétier couleur;

    protected int prixAjoutMaison; /// prix d'une maison

    //de 1 à 4 = nombre de maisons, 5 = un hotel
    private int nbMaisons = 0;

    ////prix des loyer suivant le nombre de maison sur la propriété

    protected int loyerSansMaison ;
    protected int loyer1Maison;
    protected int loyer2Maison;
    protected int loyer3Maison;
    protected int loyer4Maison;
    protected int loyerHotel; // loyer avec un hôtel

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

    public int getNbTerrainCouleurPossedees() {
        int nbTerrains = 0;
        for (Proprietes p : super.getProprio().getListePropietes()) {
            if(p instanceof Terrain)
            {
                if(((Terrain)p).couleur == this.couleur)
                {
                    nbTerrains++;
                }
            }
        }
        return nbTerrains;
    }

    ///////////////////////SETTER ///////////
     public void setLoyerSansMaison(int loyerSansMaison) {
        this.loyerSansMaison = loyerSansMaison;
    }

    public void setPrixAjoutMaison(int prixAjoutMaison) {
        this.prixAjoutMaison = prixAjoutMaison;
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

////////////////// Couleur de la case

    public CouleurMétier getCouleur()
    {
        return couleur;
    }

    public boolean getProprioPossedeTouteLaCouleur() {

        boolean toreturn = false;
        int nbTerrainDeCetteCouleur = 0;
        int nbTerrainQuePossedeLeProprio = 0;

        for (Cases c:getProprio().getListeCases()) {
            if(c instanceof Terrain){
                if(((Terrain)c).getCouleur()==this.couleur){
                    nbTerrainDeCetteCouleur++;
                }
            }
        }

        for (Proprietes p:this.getProprio().getListePropietes()) {
            if(p instanceof Terrain){
                if(((Terrain)p).getCouleur()==this.couleur){
                    nbTerrainQuePossedeLeProprio++;
                }
            }
        }

        if(nbTerrainDeCetteCouleur == nbTerrainQuePossedeLeProprio){
            toreturn = true;
        }

        return toreturn;
    }
}
