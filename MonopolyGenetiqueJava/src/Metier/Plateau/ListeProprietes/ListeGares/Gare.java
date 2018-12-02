package Metier.Plateau.ListeProprietes.ListeGares;

import Metier.Plateau.ListeProprietes.Proprietes;

public abstract class Gare extends Proprietes {

    public Gare(int position) {
        super(position);
        super.setPrix(20000);
        super.setPrixHypotheque(0);
    }

    protected int loyer = 2500;

    public int getLoyer() {

        //ici coder le fait que le loyer dépend du nombre de gares que possède le joueur

        if(super.getProprio()!=null)
        {

        }
        return loyer;
    }
}
