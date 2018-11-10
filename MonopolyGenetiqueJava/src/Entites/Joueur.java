package Entites;

import Metier.Plateau.Proprietes;
import java.util.ArrayList;

public class Joueur {

    private int solde ;
    private Pion pion ;
    private boolean aLanceDes = false;
    private ArrayList<Proprietes> listePropietes;

    public Joueur() {
        this.solde = 500; //a revoir car valeur fausse
        this.aLanceDes = false;
    }

    public void LancerDes(){

    }

    public void Acheter (Proprietes p){

    }

    public void Vendre ( Proprietes p){

    }

    public void Payer( int somme){

    }

    public void RecevoirArgent ( int somme){

    }

    public void PiocherCarte(){

    }

    public void Perdre(){

    }

    public void Gagner(){

    }

    public void QuitterPartie(){

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
}
