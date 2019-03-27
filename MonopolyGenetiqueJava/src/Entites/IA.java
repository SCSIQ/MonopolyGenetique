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

    public HashMap<CritereIA, Double> getPoids() {
        return poids;
    }

    public void setPoids(HashMap<CritereIA, Double> poids) {
        this.poids = poids;
    }

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
        poids.put(terrainRapportePlus,0.0);

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
        System.out.println("------------------\nPRISON\nnote non = "+non+"\nnote oui = "+oui);
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


    /**
     *
     * @return le note obtenue en faveur du oui
     */
    public double noteOuiAcheter()
    {
       double res = decision.BeaucoupArgent()*poids.get(beaucoupArgent)+decision.dejaUneCase()*poids.get(dejaUneCase);

       res=res/(poids.get(beaucoupArgent)+poids.get(dejaUneCase));

       return res;
    }

    /**
     *
     * @return la note obtenue en faveur du non
     */
    public double noteNonAcheter()
    {
        double res = decision.pasBeaucoupArgent()*poids.get(pasBeaucoupArgent);

        res=res/(poids.get(pasBeaucoupArgent));

        return res;
    }

    /**
     * Permet de peser le pour et le contre afin de savoir si l'IA achète ou non
     * @param automate
     */
    public void compareNoteAcheter(Automate automate)
    {
        double oui = this.noteOuiAcheter();
        double non = this.noteNonAcheter();

        System.out.println("------------------\nACHETER OU NON \nnote non = "+non+"\nnote oui = "+oui);
        if(oui>non)//Je fais l'action
        {
            automate.evoluer("acheterPropriete");
        }

    }


///////////////////////////////////////////////////////////////////////////////////////////////////CONSTRUIRE OU NON UNE MAISON ?????????????????????

    /*
        Les critères pour construire des maisons
            - beacoup d'argent (ou pas beaucoup)
            - si maison la plus rentable (si maison pas rentable)
     */

    //POUR L'INSTANT QUE L'ARGENT EST GERE !!!!
    public double noteNonConstruire()
    {
        double res = decision.pasBeaucoupArgent()*poids.get(pasBeaucoupArgent);

        res=res/(poids.get(pasBeaucoupArgent));

        return res;
    }

    public double noteOuiConstruire()
    {
        double res = decision.BeaucoupArgent()*poids.get(beaucoupArgent)+decision.construireMaison()*poids.get(terrainRapportePlus);

        res=res/(poids.get(beaucoupArgent)+poids.get(terrainRapportePlus));

        return res;
    }

}
