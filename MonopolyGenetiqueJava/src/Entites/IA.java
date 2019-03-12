package Entites;

import Metier.Automate.Automate;
import Metier.PartiesIA.CentreDecision;
import Metier.PartiesIA.CritereIA;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import Metier.Plateau.Prison;
import javafx.scene.paint.Color;

import java.util.*;

import static Metier.PartiesIA.CritereIA.*;

public class IA extends Joueur {

    //ATTRIBUTS
    private HashMap<CritereIA, Double> poids;

    //CONSTRUCTEURS
    public IA(ArrayList<Cases> listeCases, Color couleur, CentreDecision DM) {
        super(listeCases, couleur);
        poids = new HashMap<CritereIA,Double>();
        initialisationHashMap();
    }

    public IA(IA pere, IA mere)
    {

    }


    //METHODES

    public void initialisationHashMap()
    {
        System.out.println("IA "+this.getNom());
        //INITIALISATION
        poids.put(sortirPrison,0.0);
        poids.put(argent,0.0);
        poids.put(terrainComplet,0.0);

        //REMPLISSAGE AVEC LES POIDS ALEA
        for(CritereIA i : poids.keySet())
        {
            Random rand = new Random();
            Double nb= rand.nextDouble();

            poids.put(i,nb);

            System.out.println("critères "+i.toString()+"/"+poids.get(i));
        }

    }

    public double sommePoids()
    {
        double s=0;
        for(CritereIA i : poids.keySet())
        {
            s+=poids.get(i);
        }
        System.out.println("somme poids : "+s);
        return s;
    }

    /**
     * Permet de savoir si IA a assez d'argent pour acheter
     * @return 1 = assez argent  et 0= pas assez d'argent
     */
    public int AssezArgent()
    {
        int res = 0;

        //Si l'IA n'a pas le double de la propriété qu'elle veut acheter
        if(this.getPion().getCase() instanceof  Proprietes)
        {
            if(this.getSolde()>=((Proprietes)this.getPion().getCase()).getPrix()*2) {
                res = 1;
            }
        }
        else if(this.getPion().getCase() instanceof Prison)
        {
            if(this.getSolde()>=1000) {
                res = 1;
            }
        }


        return res;
    }

    /**
     *
     */
    public int SortirPrison()
    {
        int ires=0;

        //si elle est en prison
        if(this.getEstEnPrison()==true)
        {
            if(this.getNbCartesLibereDePrison()>0)
            {
                ires=1;
            }
            else if(AssezArgent()==1)
            {
                ires=1;
            }
        }

          return ires;

    }

    /**
     * Doit avoir tous les terrains de la même couleurs
     */
    public int ConstruireMaisons()
    {
        return 0;
    }

    public void CalculSituation(Automate automate)
    {
        double sommePoids = this.sommePoids();
        double note = 0.0;


        note+= poids.get(argent)*this.AssezArgent()+poids.get(sortirPrison)*this.SortirPrison()+poids.get(terrainComplet)*this.ConstruireMaisons();


        System.out.println("Note avant : "+note);
        note+=note/sommePoids;
        System.out.println("Note : "+note);

        if(note>0.5)
        {
            if(this.AssezArgent()==1 && this.getPion().getCase() instanceof  Proprietes)
            {
                automate.evoluer("acheterPropriete");
            }
            if(this.SortirPrison()==1 && this.getNbCartesLibereDePrison()==0)
            {
                jeSorsPrisonEnPayant();
            } else if(this.SortirPrison()==1 &&this.getNbCartesLibereDePrison()>0)
            {
                jeSorsPrisonAvecCarte();
            }

        }

    }


    public void jeSorsPrisonEnPayant()
    {
        this.setEstEnPrison(false);
        this.DecrementerSolde(500);
    }
    public void jeSorsPrisonAvecCarte()
    {
        this.setEstEnPrison(false);
        this.utiliserUneCartesLibereDePrison();
    }


}
