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
            case "Départ": c= new Depart(caseMetier);
            break;
            default: c= null;
        }
        return c;
    }
}
