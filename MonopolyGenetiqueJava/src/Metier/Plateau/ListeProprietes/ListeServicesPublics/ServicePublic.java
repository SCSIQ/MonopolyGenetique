package Metier.Plateau.ListeProprietes.ListeServicesPublics;

import Metier.Plateau.ListeProprietes.ListeGares.Gare;
import Metier.Plateau.ListeProprietes.Proprietes;

public abstract class ServicePublic extends Proprietes {

    protected int loyer = 100;

    public ServicePublic(int position) {
        super(position);
        super.setPrix(1500);
        super.setPrixHypotheque(0);
    }

    public int getNbServicePublicPosseddes() {
        int nbServicePublic = 0;
        for (Proprietes p : super.getProprio().getListePropietes()) {
            if(p instanceof ServicePublic)
            {
                nbServicePublic++;
            }
        }
        return nbServicePublic;
    }

    public int getLoyer(int resDesJCourant) {

        int toReturn = loyer;

        if(super.getProprio()!=null)
        {
            int nbServicePublic = 0;
            for (Proprietes p:super.getProprio().getListePropietes()) {
                if(p instanceof ServicePublic)
                {
                    nbServicePublic++;
                }
            }

            switch (nbServicePublic) {
                case 1:
                    toReturn = loyer * resDesJCourant;
                    break;
                case 2:
                    toReturn = (loyer * 2) * resDesJCourant;
                    break;
                default:
                    toReturn = loyer;
            }
        }

        return toReturn;
    }
}
