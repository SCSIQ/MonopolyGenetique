package Metier.PartiesIA.ComparerIA;

import Entites.IA;

import java.util.Comparator;

public class ComparateurIA implements Comparator<IA> {

    //CONSTRUCTEUR
    public ComparateurIA(){

    }


    @Override
    public int compare(IA ia, IA ia2) {
        int result =2;

        if(ia.getScoreJoueur().getScoreTotal()<ia2.getScoreJoueur().getScoreTotal())
        {
            result=-1;
        }
        else if(ia.getScoreJoueur().getScoreTotal()>ia2.getScoreJoueur().getScoreTotal())
        {
            result=1;
        }
        else if(ia.getScoreJoueur().getScoreTotal()==ia2.getScoreJoueur().getScoreTotal())
        {
            result=0;
        }

        return result;
    }
}
