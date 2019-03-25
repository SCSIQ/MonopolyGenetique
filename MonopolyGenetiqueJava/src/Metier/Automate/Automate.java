package Metier.Automate;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Etats.Des.LancerDesInitial;
import Metier.Automate.Etats.Etat;
import Metier.Cartes.Cartes;
import Metier.Plateau.Cases;

import java.util.ArrayList;

public class Automate {

    //ATTRIBUTS
    private Etat etatCourant;
    private ArrayList<Joueur> listeJoueurs ;
    private ArrayList<Cartes> listeDesCartesChances;
    private ArrayList<Cartes> listeDesCartesCaisseCommune;
    private boolean automatedEvolution = false;
    private int numTour = 1;
    private int nbJoueurTour = 1;

    private int tirerCarteChance = -1;
    private int tirerCarteCaisseCommune = -1;

    private Cases casePourAjoutMaison;
    private String contenuCartePiochée;
    private int argentRecupDansParcGratuit;
    private int nombreTourTotal;
    private int numBouton =0 ;

    private boolean partieFinie=false;
    private ArrayList<Joueur> listeIAGagnantes;


    //CONSTRUCTEUR
    public Automate(ArrayList<Joueur> listeJoueurs, ArrayList<Cartes> listeDesCartesChances, ArrayList<Cartes> listeDesCartesCaisseCommune,int nbTour){
        this.listeJoueurs = listeJoueurs; //récupère la liste des joueurs depuis la classe InitialisationPartie
        this.listeDesCartesChances = listeDesCartesChances;
        this.listeDesCartesCaisseCommune = listeDesCartesCaisseCommune;
        this.etatCourant = new LancerDesInitial(this, listeJoueurs); //lancement Etat initial
        this.nombreTourTotal=nbTour;
        System.out.println("Etat initial : "+this.etatCourant.toString());
        evoluer(""); //pour passer de l'état LancerDesInitial à l'état ChoixPossibles

        listeIAGagnantes= new ArrayList<>();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////METHODE

    //cette méthode est appellée dès que l'on veut faire évoluer l'automate, à savoir,
    //faire quelque chose dans le jeu comme cliquer sur un bouton
    //cette méthode est appellée soit depuis l'IHM pour une évolutions lors d'un event,
    //soit par un Etat pour une évolution automatique
    public void evoluer(String event){
        if(partieFinie==false)
        {
            System.out.println(this.etatCourant.toString()+" - - - - - - - - - - ->");
            this.etatCourant.agir(event);

            this.etatCourant = this.etatCourant.transition(event);
            System.out.println("- - - - - - - - - - - - - - - - - - - -> "+this.etatCourant.toString());


            if(automatedEvolution == true){
                automatedEvolution = false;
                this.evoluer(event);
            }
        }else
        {
          //  System.out.println("- - - - - - - - - - - - - - - - - - - -> FINI");
        }






    }


/////////////////////////////////////////////////////////////////////////////////////GETTER SETTERS

    public ArrayList<Joueur> getListeIAGagnantes() {
        return listeIAGagnantes;
    }

    public void setListeIAGagnantes(ArrayList<Joueur> listeIAGagnantes) {
        this.listeIAGagnantes = listeIAGagnantes;
    }

    public void afficheIAGagnantes()
    {
        System.out.println("LISTE DES IA GAGNANTES ");
        for(int i=0; i<getListeIAGagnantes().size(); i++)
        {
            System.out.println("        "+getListeIAGagnantes().get(i).getNom());
        }
    }


    public boolean isPartieFinie() {return partieFinie;}
    public void setPartieFinie(boolean partieFinie) {this.partieFinie = partieFinie;}

    public void setNumBouton(int numBouton) {
        this.numBouton = numBouton;
    }
    public int getNumBouton() {
        return numBouton;
    }

    public int getNombreTourTotal() {
        return nombreTourTotal;
    }
    public void setNombreTourTotal(int nombreTourTotal) {
        this.nombreTourTotal = nombreTourTotal;
    }
    //variable permettant de demander à l'automate d'évoluer une fois de plus de façon automatique
    public void setAutomatedEvolution(boolean automatedEvolution) {
        this.automatedEvolution = automatedEvolution;
    }

    //retourne le joueur qui est entrain de jouer
    public Joueur getJoueurCourant() {
        return listeJoueurs.get(0);
    }

    //retourne ne nombre de joueurs
    public int getNombreJoueur(){
        return listeJoueurs.size() ;
    }

    //retourne la liste des joueurs
    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public int getNumTour() {
        return numTour;
    }

    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    public int getNbJoueurTour() {
        return nbJoueurTour;
    }

    public void setNbJoueurTour(int nbJoueurTour) {
        this.nbJoueurTour = nbJoueurTour;
    }

    public ArrayList<Cartes> getListeDesCartesChances() {
        return listeDesCartesChances;
    }

    public ArrayList<Cartes> getListeDesCartesCaisseCommune() {
        return listeDesCartesCaisseCommune;
    }

    //---Getter et Setter pour l'enregistrement de la case oùl'on veut constuire la maison
    public Cases getCasePourAjoutMaison() {
        return casePourAjoutMaison;
    }

    public void setCasePourAjoutMaison(Cases casePourAjoutMaison) {
        this.casePourAjoutMaison = casePourAjoutMaison;
    }

    //---Getter et Setter pour l'enregistrement de la carte piochée par le joueur
    public String getContenuCartePiochée() {
        return contenuCartePiochée;
    }

    public void setContenuCartePiochée(String contenuCartePiochée) {
        this.contenuCartePiochée = contenuCartePiochée;
    }

    public int getArgentRecupDansParcGratuit() {
        return argentRecupDansParcGratuit;
    }

    public void setArgentRecupDansParcGratuit(int argentRecupDansParcGratuit) {
        this.argentRecupDansParcGratuit = argentRecupDansParcGratuit;
    }

    public int getTirerCarteChance() {
        return tirerCarteChance;
    }

    public int getTirerCarteCaisseCommune() {
        return tirerCarteCaisseCommune;
    }

    public void setTirerCarteChance(int tirerCarteChance) {
        this.tirerCarteChance = tirerCarteChance;
    }

    public void setTirerCarteCaisseCommune(int tirerCarteCaisseCommune) {
        this.tirerCarteCaisseCommune = tirerCarteCaisseCommune;
    }
}
