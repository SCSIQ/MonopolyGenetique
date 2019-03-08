package Metier;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.PartiesIA.Tournoi;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class InitialisationPartieIA extends InitialisationPartie{

    //ATTRIBUTS
    private int nb_ia=0;
    private int nb_mutations=0;
    private int nb_tours=0;
    private ArrayList<Joueur> listeDesIA;

    //GETTER SETTER
    public ArrayList<Joueur> getListeDesIA() {
        return listeDesIA;
    }

    public void setListeDesIA(ArrayList<Joueur> listeDesIA) {
        this.listeDesIA = listeDesIA;
    }



    //CONSTRUCTEUR
    public InitialisationPartieIA(int nb_ia, int nb_mutations, int nb_tours)
    {
        this.nb_ia=nb_ia;
        this.nb_mutations=nb_mutations;
        this.nb_tours=nb_tours;
        listeDesIA=new ArrayList<>();
    }

    //METHODES
    public void creationListeIA(){

        for(int i=0 ; i<nb_ia ; i++){
            Color c = couleurIA(i);
            listeDesIA.add(new IA(super.listeCases, c, null));
        }
    }

    public Automate automatePourIaInitialisation() {
        super.creationListeCases();
        super.creationListeCartesChances();
        super.creationListeCartesCaisseCommune();
        creationListeIA();

        Automate automate = new Automate(listeDesIA, this.listeDesCartesChances, this.listeDesCartesCaisseCommune,nb_tours);



        return automate;
    }

    public Color couleurIA(int i)
    {

        Color couleur;
        switch (i){
            case 0 : couleur = Color.CRIMSON;
                break;
            case 1 : couleur = Color.DARKMAGENTA;
                break;
            case 2 : couleur = Color.DARKTURQUOISE;
                break;
            case 3 : couleur = Color.CORAL;
                break;
            case 4 : couleur = Color.MEDIUMSEAGREEN;
                break;
            default: couleur = Color.AZURE;
        }
        return couleur;
    }
}
