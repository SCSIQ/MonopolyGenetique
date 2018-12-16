package Metier.Plateau.ListeProprietes.ListeGares;

import Metier.Plateau.ListeProprietes.Proprietes;

public abstract class Gare extends Proprietes {

    public Gare(int position) {
        super(position);
        super.setPrix(2000);
        super.setPrixHypotheque(0);
    }

    protected int loyer = 250;

    public int getNbGaresPossedees() {
        int nbGarres = 0;
        for (Proprietes p : super.getProprio().getListePropietes()) {
            if(p instanceof Gare)
            {
                nbGarres++;
            }
        }
        return nbGarres;
    }

    public int getLoyer() {

        int toReturn = loyer;

        if(super.getProprio()!=null)
        {
            int nbGares = 0;
            for (Proprietes p:super.getProprio().getListePropietes()) {
                if(p instanceof Gare)
                {
                    nbGares++;
                }
            }

            switch (nbGares){
                case 1 : toReturn = loyer;
                    break;
                case 2 : toReturn = 2*loyer;
                    break;
                case 3 : toReturn = 4*loyer;
                    break;
                case 4 : toReturn = 8*loyer;
                    break;
                default : toReturn = loyer;
            }
        }

        return toReturn;
    }
}
