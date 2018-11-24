package IHM.Plateau;


import IHM.Plateau.LieuPublic.Depart;
import Metier.Plateau.Cases;

public class Fabrique {

    public Fabrique(){

    }

    public VueCases FabriqueCase(Cases caseMetier)
    {
        VueCases c= null ;
        switch(caseMetier.toString()){
            /*case "Départ": c= new Depart(caseMetier, getListeCases());
            break;
            case "Gare": c = new Gare(caseMetier, getListeCases());
            break;
            case "Ampoule": c = new Ampoule(caseMetier, getListeCases());
            break;
            case "ParcGratuit": c = new ParcGratuit(caseMetier, getListeCases));
            break;
            case "Prison": c = new Prison(caseMetier, getListeCases());
            break;
            case "Robinet": c = new Robinet(caseMetier, getListeCases());
            break;
            case "TaxeDeLuxe": c = new TaxedeLuxe(caseMetier, getListeCases());
            break;
            case "Impot": c = new Impot(caseMetier, getListeCases());
            break;

            */
            default: c= null;
        }
        return c;
    }
}
