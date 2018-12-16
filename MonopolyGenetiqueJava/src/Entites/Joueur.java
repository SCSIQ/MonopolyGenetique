package Entites;

import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Joueur {

    private String nom; // nom du joueur
    //private Color couleur; //couleur du joueur
    private int solde ; // montant de l'argent possédé
    private Pion pion ;
    private boolean aLanceDes = false; // initialise le boolean pour savoir si le joueur a déjà lancer les dés
    private ArrayList<Proprietes> listePropietes = new ArrayList<>();
    private int resDes1 = 0; // initialise à 0 le dés 1
    private int resDes2 = 0; // initialise à 0 le dés 2
    private int resLanceDes = 0; // initialise à 0 l'addition des deux dés
    private int nbDoubles = 0; //nombre de doubles que fait le joueur lors du lancé des dés
    private ArrayList<Cases> listeCases;
    private boolean estEnPrison = false;
    private int essaiesPourSortirDePrison = 0;
    private int nbCartesLibereDePrison = 0; //le nombre de cartes libéré de prison que le joueur possède

    public Joueur(ArrayList<Cases> listeCases, Color couleur) {
        this.solde = 15000; //a revoir car valeur fausse 150000
        this.listeCases = listeCases;
        this.pion = new Pion(this, listeCases.get(0), couleur);
        //this.couleur = couleur;
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * cette méthode est temporaire, elle permet simplement de tester le code métier
     */
    public void afficherProprietesPossedes(){

        System.out.println("    Liste des propriétés du "+this.nom+" :");

        if(this.listePropietes.size()!=0){

            for (Proprietes p : this.listePropietes) {
                System.out.println("        "+p.toString()+", d'une valeur de : "+p.getPrix()+"€");

            }
        }else {

            System.out.println("        Le joueur ne possède aucune propriétés pour le moment ");

        }
    }

    //------------------------------------------------------------------------------------------------------------------

    // renvoie la liste des propriétés que le joueur posséde
    public ArrayList<Proprietes> getListePropietes() {
        return listePropietes;
    }

    // ajoute une propriété à la liste des propriétés que le joueur possède
    public void ajouterPropriete(Proprietes p) {
        this.listePropietes.add(p);
    }

    // supprime une propriété à la liste des propriétés que le joueur possède
    public void supprimerPropriete(Proprietes p) {
        for (Proprietes _p : this.listePropietes) {
            if(_p == p){
                this.listePropietes.remove(p);
            }
        }
    }

    // fonction qui dit si le joueur a déjà lancer les dés avec vrai ou faux
    public boolean getaLanceDes() {
        return aLanceDes;
    }

    //augmente le montant de l'argent que le joueur posséde
    public void IncrementerSolde(int solde) {
        this.solde += solde;
    }

    //diminue le montant de l'argent que le joueur posséde
    public void DecrementerSolde(int solde) {
        this.solde -= solde;
    }


    public void setaLanceDes(boolean aLanceDes) {
        this.aLanceDes = aLanceDes;
    } // modifie la valeur du boolean

    public int getResDes1() {
        return resDes1;
    } //renvoie la valeur du premier dés

    public int getResDes2() {
        return resDes2;
    } //renvoie la valeur du deuxième dés

    public int getResLanceDes() {
        return resLanceDes;
    } // renvoie l'addition des deux dés

    public void setResDes1(int resDes1) {
        this.resDes1 = resDes1;
    } //modifie la valeur du premier dés

    public void setResDes2(int resDes2) {
        this.resDes2 = resDes2;
    } //modifie la valeur du deuxième dés

    public void setResLanceDes(int aresLanceDes) {
        this.resLanceDes = aresLanceDes;
    } // modifie le résultat de l'addition des deux dés

    public void Avancer(int position) {
        pion.avancer(position);
    } // procédure qui fait avancer le pion sur le plateau

    public ArrayList<Cases> getListeCases() {
        return listeCases;
    }

    public Pion getPion() {
        return pion;
    } //retourne le pion

    @Override
    public String toString() {
        return "    position du joueur : "+this.pion.toString();
    }

    public String getJoueurID()
    {
        return super.toString();
    }


    public String getNom() {
        return nom;
    } // renvoie le nom du joueur

    public void setNom(String nom) {
        this.nom = nom;
    } //modifie le nom du joueur

    public Color getCouleur() {
        return this.pion.getCouleur();
    } //renvoie la couleur du joueur

    public int getSolde() {
        return solde;
    } // renvoie l'argent que le joueur posséde

    public void setCouleur(Color couleur) {
        this.pion.setCouleur(couleur);
    } //modifie la valeur de la couleur

    public int getNbDoubles() {
        return nbDoubles;
    }

    public void setNbDoubles(int nbDoubles) {
        this.nbDoubles = nbDoubles;
    }

    public boolean getEstEnPrison() {
        return estEnPrison;
    }

    public int getEssaiesPourSortirDePrison() {
        return essaiesPourSortirDePrison;
    }

    public void setEstEnPrison(boolean estEnPrison) {
        this.estEnPrison = estEnPrison;
    }

    public void setEssaiesPourSortirDePrison(int essaiesPourSortirDePrison) {
        this.essaiesPourSortirDePrison = essaiesPourSortirDePrison;
    }

    public int getNbCartesLibereDePrison() {
        return nbCartesLibereDePrison;
    }

    public void gagnerUneCartesLibereDePrison() {
        this.nbCartesLibereDePrison++;
    }

    /**
     * 
     * @return true si une carte a bien pu être utilisé et false si ce n'est pas le cas
     */
    public boolean utiliserUneCartesLibereDePrison() {
        if(this.nbCartesLibereDePrison>0)
        {
            this.nbCartesLibereDePrison--;
            return true;
        }
        else
        {
            return false;
        }
    }
}

