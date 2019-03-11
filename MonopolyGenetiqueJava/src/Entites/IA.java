package Entites;

import Metier.Automate.Automate;
import Metier.PartiesIA.CentreDecision;
import Metier.PartiesIA.CritereIA;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static Metier.PartiesIA.CritereIA.*;

public class IA extends Joueur {

    private CentreDecision DM;
    private HashMap<CritereIA, Double> poids = new HashMap<CritereIA,Double>();

    //CONSTRUCTEURS
    public IA(ArrayList<Cases> listeCases, Color couleur, CentreDecision DM) {
        super(listeCases, couleur);
        setDM(DM);

    }

    public IA(IA pere, IA mere)
    {

    }

    //GETTER SETTER
    public CentreDecision getDM() {
        return DM;
    }

    public void setDM(CentreDecision DM) {
        this.DM = DM;
    }

    //METHODES

    public void initialisationHashMap()
    {
        poids.put(argent, 0.7);
        /*poids.put(cartesCouleurs2, 0.8);
        poids.put(terrainComplet, 0.6);*/
        poids.put(sortirPrison,0.8);
    }

    public double sommePoids()
    {
        double s=0;
        for(CritereIA i : poids.keySet())
        {
            s+=poids.get(i);
        }

        return s;
    }

    /**
     * Permet de savoir si IA a assez d'argent pour acheter
     * @return 1 = assez argent  et 0= pas assez d'argent
     */
    public int AssezArgent()
    {
        int res =1;

        //Si l'IA n'a pas le double de la propriété qu'elle veut acheter
        if(this.getSolde()<((Proprietes)this.getPion().getCase()).getPrix()*2) {
            res = 0;
        }

        return res;
    }

    /**
     *
     */
    public int SortirPrison()
    {
        boolean res =false;
        int ires=0;

        //si elle est en prison
        if(this.getEstEnPrison()==true)
        {
            res = this.utiliserUneCartesLibereDePrison();

            if(res==true)
            {
                ires=1;
            }
            else if(this.getSolde()>500*2)
            {
                ires=1;
            }
        }

          return ires;

    }

    /**
     * DOit avoir tous les terrains de la même couleurs
     */
    public void ConstruireMaisons()
    {

    }

    public void CalculSituation(Automate automate)
    {
        this.initialisationHashMap();
        double sommePoids = this.sommePoids();
        double note =0.0;


        note+= poids.get(argent)*this.AssezArgent()+poids.get(sortirPrison)*this.SortirPrison();


        note+=note/sommePoids;

        if(note>0.5)
        {
            System.out.println("coucou");
            if(this.AssezArgent()==1)
            {
                System.out.println("je suis là");
                automate.evoluer("acheterPropriete");
            }
            if(this.SortirPrison()==1)
            {
                System.out.println("lalalère");
               this.setEstEnPrison(false);
            }

        }

    }




}
