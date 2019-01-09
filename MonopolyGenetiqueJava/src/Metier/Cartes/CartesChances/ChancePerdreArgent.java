package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

import java.util.Random;

public class ChancePerdreArgent extends Chance {

    private int numCarte;
    private String contenu="";
    private int solde=500;
    private Random rand ;

    public ChancePerdreArgent() {
        diffCarte();
        super.setTexte(contenu+solde+" € !");
    }

    @Override
    public void agir(Automate automate) {
        automate.getJoueurCourant().DecrementerSolde(solde);
        automate.setContenuCartePiochée(contenu+solde+" € ! ");
    }

    public void diffCarte()
    {
        rand = new Random();

        numCarte=rand.nextInt(6)+1;

        switch(numCarte)
        {
            case 1 : contenu="On vous a volé !!\nVous avez perdu ";
                solde = 1000;
                break;
            case 2 : contenu="Vous devez payez l'anniversaire de votre tante.\nPayez ";
                solde = 1500;
                break;
            case 3 : contenu="Votre assurance vous taxe.\nPayez ";
                solde = 1000;
                break;
            case 4 : contenu="Vous perdez au loto.\nVous avez perdu ";
                solde = 500;
                break;
            case 5 : contenu="Vous allez en vacances.\nPayez ";
                solde = 800;
                break;
            case 6 : contenu="Vous allez à l'hopital.\nPayez ";
                solde = 500;
                break;
            default: contenu="Payez ";
                break;

        }
    }
}
