package Metier.PartiesIA;

import Entites.IA;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.Proprietes;

import java.util.HashMap;

public class CentreDecision {

    private IA ia;
    private IA iaCourante;//=(IA)this.automate.getJoueurCourant();
    private Automate automate;

    private HashMap<CritereIA, Double> poids = new HashMap<CritereIA,Double>();

    public CentreDecision() {

    }

    public void affectationIA(IA ia)
    {
        this.ia = ia;
    }

    public void desaffectationIA()
    {
        this.ia = null;
    }

    public String priseDeDecision()
    {
        String action="null";

        if(this.ia!=null)
        {



            switch(action)
            {
                //<editor-fold desc="Case fin de tour">
                case "tour Fin":

                    if(iaCourante.getPion().getCase() instanceof Proprietes && ((Proprietes) iaCourante.getPion().getCase()).getProprio() == null){
                        this.automate.evoluer("acheterPropriete");
                    }

                    break;
                //</editor-fold>

                //<editor-fold desc="Case Achat propriétés">
                case "propriété":

                    break;
                //</editor-fold>

                //<editor-fold desc="Case ">
                case "":

                    break;
                //</editor-fold>

                //<editor-fold desc="Case ">
                case "1":

                    break;
                //</editor-fold>

                //<editor-fold desc="Case ">
                case "2":

                    break;
                //</editor-fold>

                //<editor-fold desc="Case ">
                case "3":

                    break;
                //</editor-fold>

                //<editor-fold desc="Case passer le tour">
                    default:

                    break;
                //</editor-fold>
            }
        }
        else
        {
            System.out.println("Aucune IA affectée");
        }



        return action;

    }

}
