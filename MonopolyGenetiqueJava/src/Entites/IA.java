package Entites;

import Metier.Automate.Automate;
import Metier.PartiesIA.CentreDecision;
import Metier.PartiesIA.CritereIA;
import Metier.PartiesIA.Decision;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;
import Metier.Plateau.Prison;
import javafx.scene.paint.Color;

import java.util.*;

import static Metier.PartiesIA.CritereIA.*;

public class IA extends Joueur {

    //ATTRIBUTS
    private HashMap<CritereIA, Double> poids;
    private Decision decision;

    //CONSTRUCTEURS
    public IA(ArrayList<Cases> listeCases, Color couleur, CentreDecision DM) {
        super(listeCases, couleur);
        poids = new HashMap<CritereIA,Double>();
        initialisationHashMap();
        decision = new Decision(this);
    }

    public IA(IA pere, IA mere)
    {

    }


    //METHODES

    /**
     * initialise la hashmap des critères avec un poids random pour chaque critères
     */
    public void initialisationHashMap()
    {
        System.out.println("IA "+this.getNom());
        //INITIALISATION
        poids.put(pasBeaucoupArgent,0.0);
        poids.put(beaucoupArgent,0.0);
        poids.put(aCarteLiberePrison,0.0);
        poids.put(caseSuivanteMauvaise,0.0);
        poids.put(caseSuivanteBonne,0.0);
        poids.put(dejaUneCase,0.0);

        //REMPLISSAGE AVEC LES POIDS ALEA
        for(CritereIA i : poids.keySet())
        {
            Random rand = new Random();
            Double nb= (double) Math.round(rand.nextDouble()*100)/100;

            poids.put(i,nb);

            System.out.println("critères "+i.toString()+"/"+poids.get(i));
        }

    }

///////////////////////////////////////////////////////////////////////////////////////////////////SORTIR OU NON DE PRISON ?????????????????????

    /**
     *
     * @return res la note pour dire qu'il ne veut pas sortir de prison (avec ses critères)
     */
    public double noteNonSortirPrison()
    {
        double res = decision.pasBeaucoupArgent()*poids.get(pasBeaucoupArgent)+decision.noteCaseSuivanteMauvaise()*poids.get(caseSuivanteMauvaise);

        res=res/(poids.get(pasBeaucoupArgent)+poids.get(caseSuivanteMauvaise));
        return res;
    }

    /**
     *
     * @return res la note pour dire qu'il veut sortir de prison
     */
    public double noteOuiSortirPrison()
    {
        double res = decision.BeaucoupArgent()*poids.get(beaucoupArgent)+decision.aCarteLiberePrison()*poids.get(aCarteLiberePrison)+decision.noteCaseSuivanteBonne()*poids.get(caseSuivanteBonne);

        res=res/(poids.get(beaucoupArgent)+poids.get(aCarteLiberePrison)+poids.get(caseSuivanteBonne));
        return res;
    }


    /**
     * Pèse le pour et le contre pour savoir s'il sort de prison ou non en fonction des notes obtenues pour le oui ou pour le non
     */
    public void compareNotePrison()
    {
        double non = noteNonSortirPrison();
        double oui = noteOuiSortirPrison();
        System.out.println("note non = "+non+"\nnote oui = "+oui);
        if(oui>non)//Je fais l'action
        {
            this.setEstEnPrison(false);
            if(this.getNbCartesLibereDePrison()>0)
            {
                this.utiliserUneCartesLibereDePrison();
            }
            else
            {
                this.DecrementerSolde(500);
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////ACHETER OU NON LA CASE ?????????????????????

    /*critère pour acheter une case :
        - argent (beaucoup ou pas beaucoup)
        - si plusiseurs case de même couleur --> déjà si j'ai une case de la même couleur
    */



    public double noteOuiAcheter()
    {
       double res = decision.BeaucoupArgent()*poids.get(beaucoupArgent)+decision.dejaUneCase()*poids.get(dejaUneCase);

       res=res/(poids.get(beaucoupArgent)+poids.get(dejaUneCase));

       return res;
    }

    public double noteNonAcheter()
    {
        double res = decision.pasBeaucoupArgent()*poids.get(pasBeaucoupArgent);

        res=res/(poids.get(pasBeaucoupArgent));

        return res;
    }


///////////////////////////////////////////////////////////////////////////////////////////////////CONSTRUIRE OU NON UNE MAISON ?????????????????????

}
