package Metier.PartiesIA;

import Entites.IA;

public class CentreDecision {

    private IA ia;

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

                    break;
                //</editor-fold>

                //<editor-fold desc="Case propriétés">
                case "propriété":

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
