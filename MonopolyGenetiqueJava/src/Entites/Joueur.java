package Entites;

import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import java.util.ArrayList;

public class Joueur {

    private int solde ;
    private Pion pion ;
    private boolean aLanceDes = false;
    private ArrayList<Proprietes> listePropietes;
    private int resLanceDes = 0;
    private ArrayList<Cases> listeCases;

    public Joueur(ArrayList<Cases> listeCases, CouleurPion couleur) {
        this.solde = 500; //a revoir car valeur fausse
        this.listeCases = listeCases;
        this.pion = new Pion(this, listeCases.get(0), couleur);
    }

    public ArrayList<Proprietes> getListePropietes() {
        return listePropietes;
    }

    public void setListePropietes(ArrayList<Proprietes> listePropietes) {
        this.listePropietes = listePropietes;
    }

    public boolean getaLanceDes() {
        return aLanceDes;
    }

    public void setaLanceDes(boolean aLanceDes) {
        this.aLanceDes = aLanceDes;
    }

    public int getResLanceDes() {
        return resLanceDes;
    }

    public void setResLanceDes(int resLanceDes) {
        this.resLanceDes = resLanceDes;
    }

    public void avancer() {
        pion.avancer(this.resLanceDes);
    }

    public ArrayList<Cases> getListeCases() {
        return listeCases;
    }

    @Override
    public String toString() {
        return "    position du joueur : "+this.pion.toString();
    }
}
