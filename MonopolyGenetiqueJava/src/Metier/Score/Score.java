package Metier.Score;

import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;

import java.util.ArrayList;

public class Score {


    //ATTRIBUTS
    int scoreTotal;
    int scoreTerrain = 20; //Val d'un terrain (pour l'instant chaque terrain a la même val)

    //CONSTRUCTEUR
    public Score()
    {
        scoreTotal=0;

    }

    //PROPRIETES
    public int getScoreTotal() {
        return scoreTotal;
    }

    //METHODES

    /**
     * Calcule du score propriété
     * @param nbPropriete
     * @return le score total concernant les terrains
     */
    public int scoreTerrain(int nbPropriete)
    {
        int scoreProp = 20;
        int score=0;

        score=scoreProp*nbPropriete;

        return score;
    }

    public int scoreArgent()
    {
        return 0;
    }

    /**
     * Calcul du score en fonction du nombre de maisons par terrain
     * @param maisons
     * @return le score dédié au maisons
     */
    public int scoreMaison(ArrayList<Proprietes> maisons)
    {
        int score=0;

        for(int i=0;i<maisons.size();i++)
        {
            if(maisons.get(i) instanceof Terrain)
            {
                if(((Terrain)maisons.get(i)).getNbMaisons()==1)
                {
                    score+=50;
                }else if(((Terrain)maisons.get(i)).getNbMaisons()==2)
                {
                    score+=70;
                }else if(((Terrain)maisons.get(i)).getNbMaisons()==3)
                {
                    score+=90;
                }else if(((Terrain)maisons.get(i)).getNbMaisons()==4)
                {
                    score+=110;
                }else if(((Terrain)maisons.get(i)).getNbMaisons()==5)
                {
                    score+=200;
                }

            }

        }
        return score;
    }


    /**
     *
     * @param nbPropriete
     * @param maisons
     * @return scoreTotal
     */
    public int calculScore(int nbPropriete,ArrayList<Terrain> maisons)
    {
        scoreTotal = scoreTerrain(nbPropriete)+scoreMaison(maisons);
        return scoreTotal;
    }
}
