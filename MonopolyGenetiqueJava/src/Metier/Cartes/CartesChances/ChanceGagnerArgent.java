package Metier.Cartes.CartesChances;

import Metier.Automate.Automate;

import java.util.Random;

public class ChanceGagnerArgent extends Chance {

    private int numCarte;
    private String contenu="";
    private int solde=500;
    private Random rand ;

    public ChanceGagnerArgent (){
        rand = new Random();
        diffCarte();
        super.setTexte(contenu+solde+" € !");
    }

    @Override
    public void agir(Automate automate) {

        automate.getJoueurCourant().IncrementerSolde(solde);
        automate.setContenuCartePiochée(contenu+solde+"€ ! ");
    }

    public void diffCarte()
    {
        numCarte=rand.nextInt(2)+1;

        switch(numCarte)
        {
            case 1 : contenu="Vous aidez Gepetto à travailler dans sa menuiserie. \n Vous recevez ";
                solde = 1000;
                break;
            case 2 : contenu="Vous gagnez au loto ! \n Vous remportez ";
                solde = 15000;
                break;
            default: solde=1000;
                break;

        }
    }
}
