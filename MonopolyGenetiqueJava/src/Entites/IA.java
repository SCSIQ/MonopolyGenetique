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
        poids.put(cartesCouleurs2, 0.8);
        poids.put(terrainComplet, 0.6);
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
    public void SortirPrison()
    {
        //si elle est en prison
        if(this.getEstEnPrison()==true)
        {
            //si elle a une carte libéré de prison
            if(this.getNbCartesLibereDePrison()>0)
            {

            }
        }

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


        note+= poids.get(argent)*this.AssezArgent();


        note+=note/sommePoids;

        if(note>0.5)
        {
            automate.evoluer("acheterPropriete");
        }

    }




}
