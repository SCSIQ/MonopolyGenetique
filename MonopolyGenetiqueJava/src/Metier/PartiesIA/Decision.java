package Metier.PartiesIA;

import Entites.IA;

public class Decision {

    private IA ia;

    public Decision(IA ia)
    {
        this.ia=ia;
    }

    public int BeaucoupArgent()
    {
        int res = 0;

        if(ia.getSolde()>=1000)
        {
            res=1;
        }

        return res;
    }

    public int pasBeaucoupArgent()
    {
        int res = 0;

        if(ia.getSolde()<800)
        {
            res=1;
        }

        return res;
    }

    public int aCarteLiberePrison()
    {
        int res = 0;

        if(ia.getNbCartesLibereDePrison()>0)
        {
            res=1;
        }

        return res;
    }

    public int noteCase()
    {
        int res = 0;
        return res;
    }
}
