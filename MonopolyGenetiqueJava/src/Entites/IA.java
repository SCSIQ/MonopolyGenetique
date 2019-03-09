package Entites;

import Metier.PartiesIA.CentreDecision;
import Metier.PartiesIA.CritereIA;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static Metier.PartiesIA.CritereIA.argent;
import static Metier.PartiesIA.CritereIA.cartesCouleurs2;

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
    }


    /**
     * Permet de savoir si IA a assez d'argent pour acheter
     * @return
     */
    public boolean AssezArgent()
    {
        boolean res =true;

        //Si l'IA n'a pas le double de la propriété qu'elle veut acheter
        if(this.getSolde()<((Proprietes)this.getPion().getCase()).getPrix()*2) {
            res = false;
        }

        return res;
    }

    /**
     *
     */
    public void SortirPrison()
    {

    }

    /**
     *
     */
    public void ConstruireMaisons()
    {

    }

    public void CalculSituation()
    {
        this.initialisationHashMap();
        double note =0.0;

        for (CritereIA i : poids.keySet()) {

            note+=poids.get(i);
        }

    }




}
