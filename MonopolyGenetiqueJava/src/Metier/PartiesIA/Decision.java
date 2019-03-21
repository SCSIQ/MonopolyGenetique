package Metier.PartiesIA;

import Entites.IA;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeGares.Gare;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.ServicePublic;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;

import java.util.ArrayList;

public class Decision {

    private IA ia;

    public Decision(IA ia)
    {
        this.ia=ia;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////DECISION ARGENT

    /**
     *
     * @return 1 si a beaucoup d'argent
     */
    public int BeaucoupArgent()
    {
        int res = 0;

        if(ia.getSolde()>=1000)
        {
            res=1;
        }

        return res;
    }

    /**
     *
     * @return 1 n'a pas beaucoup d'argent
     */
    public int pasBeaucoupArgent()
    {
        int res = 0;

        if(ia.getSolde()<800)
        {
            res=1;
        }

        return res;
    }

    ////////////////////////////////////////////////////////////////////////////////////////CARTE LIBERE PRISON

    /**
     *
     * @return 1 si a une carte libéré de prison
     */
    public int aCarteLiberePrison()
    {
        int res = 0;

        if(ia.getNbCartesLibereDePrison()>0)
        {
            res=1;
        }

        return res;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////CASE SUIVANTE

    /**
     *
     * @return 1 si la case suivante n'appartient à personne ou si elle appartient à l'ia courante
     */
    public int noteCaseSuivanteBonne()
    {
        int res = 0;
        int posCaseSuivante = ia.getPion().getCase().getPosition()+ia.getResLanceDes();

        if(ia.getListeCases().get(posCaseSuivante) instanceof Proprietes)
        {
            if(((Proprietes)ia.getListeCases().get(posCaseSuivante)).getProprio()==null
                    ||((Proprietes)ia.getListeCases().get(posCaseSuivante)).getProprio()==ia)
            {
                res=1;
            }

        }

        return res;
    }

    /**
     *
     * @return 1 si la case suivante appartient à un autre joueur
     */
    public int noteCaseSuivanteMauvaise()
    {
        int res = 0;
        int posCaseSuivante = ia.getPion().getCase().getPosition()+ia.getResLanceDes();

        if(ia.getListeCases().get(posCaseSuivante) instanceof Proprietes)
        {
            if(((Proprietes)ia.getListeCases().get(posCaseSuivante)).getProprio()!=null
                    ||((Proprietes)ia.getListeCases().get(posCaseSuivante)).getProprio()!=ia)
            {
                res=1;
            }

        }

        return res;
    }

/////////////////////////////////////////////////////////////////////////////////////ACHETER OU PAS ///////////////

    /**
     *
     * @return 1 si l'ia courante a eu moins une case de la même couleur que la case où elle est tombée
     */
    public int dejaUneCase()
    {
        int res = 0;
        int nbCouleur=0;

        for(Proprietes p : ia.getListePropietes())
        {
            if(ia.getPion().getCase() instanceof Terrain)
            {
                if(p instanceof  Terrain) {
                    if (((Terrain) ia.getPion().getCase()).getCouleur() == ((Terrain) p).getCouleur()) {
                        nbCouleur++;
                    }
                }

            }else if(ia.getPion().getCase() instanceof ServicePublic) //si c'est une compagnie
            {
                if(p instanceof  ServicePublic)
                {
                    res=1;
                }
            }else if(ia.getPion().getCase() instanceof Gare) //si c'est une gare
            {
                if(p instanceof  Gare)
                {
                    res=1;
                }
            }
        }

        if(nbCouleur>=1)
        {
            res=1;
        }

        return res;
    }


/////////////////////////////////////////////////////////////////////////////////////CONSTRUIRE MAISONS OU PAS ///////////////

    /**
     * Regarde lequel loyer rapporte le plus avec une maison
     * @return Terrain qui rapporte le plus
     */
    public Terrain maisonRapporteLePlus()
    {
        Terrain t=null;
        boolean terrain =false; //Permet de récupérer le premier terrain

        while(terrain)
        {
            int i=0;
            if(ia.getListePropietes().get(i) instanceof  Terrain)
            {
                //Si le joueur a le groupe de couleur en entier
                if(((Terrain)ia.getListePropietes().get(i)).getATousLesTerrainsDeMemeCouleur()==true)
                {
                    t=(Terrain)ia.getListePropietes().get(i);
                    terrain=true;
                }

            }
            i++;
        }
        if(terrain==true)
        {
            for(Proprietes p : ia.getListePropietes())
            {
                if(ia.getPion().getCase() instanceof Terrain)
                {
                    if(((Terrain)p).getNbMaisons()==0)
                    {
                        if(t.getLoyer1Maison()<((Terrain) p).getLoyer1Maison())
                        {
                            t=((Terrain)p);
                        }
                    }
                }
            }
        }


        return t;
    }


    public int construireMaison()
    {
        int res=0;
        if(this.maisonRapporteLePlus()!=null)
        {
            res=1;
        }

        return res;
    }




}
