package Metier;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Cartes.Cartes;
import Metier.Cartes.CartesChances.ChanceRdvDueDeLaPaie;
import Metier.Cartes.CartesChances.ChanceSortirDePrison;
import Metier.Plateau.*;
import Metier.Plateau.ListeCartes.*;
import Metier.Plateau.ListeProprietes.ListeGares.Gare1;
import Metier.Plateau.ListeProprietes.ListeGares.Gare2;
import Metier.Plateau.ListeProprietes.ListeGares.Gare3;
import Metier.Plateau.ListeProprietes.ListeGares.Gare4;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.Ampoule;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.Robinet;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel1;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel2;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuCiel.BleuCiel3;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce.BleuFonce1;
import Metier.Plateau.ListeProprietes.ListeTerrains.BleuFonce.BleuFonce2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Jaune.Jaune1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Jaune.Jaune2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Jaune.Jaune3;
import Metier.Plateau.ListeProprietes.ListeTerrains.Marron.Marron1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Marron.Marron2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Orange.Orange1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Orange.Orange2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Orange.Orange3;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rose.Rose3;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rouge.Rouge1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rouge.Rouge2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Rouge.Rouge3;
import Metier.Plateau.ListeProprietes.ListeTerrains.Vert.Vert1;
import Metier.Plateau.ListeProprietes.ListeTerrains.Vert.Vert2;
import Metier.Plateau.ListeProprietes.ListeTerrains.Vert.Vert3;
import Metier.Plateau.ListeTaxes.Impot;
import Metier.Plateau.ListeTaxes.TaxeDeLuxe;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public abstract class InitialisationPartie {

    protected ArrayList<Cases> listeCases = new ArrayList<>();
    protected ArrayList<Joueur> listeJoueurs = new ArrayList<>();
    protected ArrayList<Cartes> listeDesCartesChances = new ArrayList<>();

    //seule méthode pouvant être appellée depuis l'extérieur
    //cette méthode permet de créer et d'initialiser l'automate
    //puis le retourne pour qu'il soit utilisé dans l'IHM
    //cette méthode à besoin en entrée du nombre de joueurs, ainsi
    //que de la liste des couleurs des joueurs, dans l'ordre dans
    //lequel ils ont été rentrés
    public Automate automateInitialisation(int nombreJoueurs, ArrayList<Color> listeCouleurs){
        creationListeCases();
        creationListeCartesChances();
        creationListeJoueurs(nombreJoueurs, listeCouleurs);
        Automate automate = new Automate(this.listeJoueurs, this.listeDesCartesChances);
        return automate;
    }

    protected void creationListeCartesChances(){
        this.listeDesCartesChances.add(new ChanceRdvDueDeLaPaie());
        this.listeDesCartesChances.add(new ChanceSortirDePrison());
    }

    protected void creationListeCases(){
        this.listeCases.add(new Depart(0));
        this.listeCases.add(new Marron1(1));
        this.listeCases.add(new CaisseCommune1(2));
        this.listeCases.add(new Marron2(3));
        this.listeCases.add(new Impot(4));
        this.listeCases.add(new Gare1(5));
        this.listeCases.add(new BleuCiel1(6));
        this.listeCases.add(new Chance1(7));
        this.listeCases.add(new BleuCiel2(8));
        this.listeCases.add(new BleuCiel3(9));
        this.listeCases.add(new Prison(10));
        this.listeCases.add(new Rose1(11));
        this.listeCases.add(new Ampoule(12));
        this.listeCases.add(new Rose2(13));
        this.listeCases.add(new Rose3(14));
        this.listeCases.add(new Gare2(15));
        this.listeCases.add(new Orange1(16));
        this.listeCases.add(new CaisseCommune2(17));
        this.listeCases.add(new Orange2(18));
        this.listeCases.add(new Orange3(19));
        this.listeCases.add(new ParcGratuit(20));
        this.listeCases.add(new Rouge1(21));
        this.listeCases.add(new Chance2(22));
        this.listeCases.add(new Rouge2(23));
        this.listeCases.add(new Rouge3(24));
        this.listeCases.add(new Gare3(25));
        this.listeCases.add(new Jaune1(26));
        this.listeCases.add(new Jaune2(27));
        this.listeCases.add(new Robinet(28));
        this.listeCases.add(new Jaune3(29));
        this.listeCases.add(new AllerEnPrison(30));
        this.listeCases.add(new Vert1(31));
        this.listeCases.add(new Vert2(32));
        this.listeCases.add(new CaisseCommune3(33));
        this.listeCases.add(new Vert3(34));
        this.listeCases.add(new Gare4(35));
        this.listeCases.add(new Chance3(36));
        this.listeCases.add(new BleuFonce1(37));
        this.listeCases.add(new TaxeDeLuxe(38));
        this.listeCases.add(new BleuFonce2(39));

    }

    protected void creationListeJoueurs(int nombre, ArrayList<Color> listeCouleurs){
        for(int i=0 ; i<nombre ; i++){
            listeJoueurs.add(new Joueur(this.listeCases, listeCouleurs.get(i)));
        }
    }
}
