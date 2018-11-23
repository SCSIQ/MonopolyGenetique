package IHM.Plateau;

import Metier.Plateau.Cases;

public abstract class  VueCases {

    //ATTRIBUTS
    private int position ;
    private Cases caseMetier ;

    //CONSTRUCTEUR PRENANT UNE CASE DU METIER EN PARAMETRE
    public VueCases(Cases caseMetier)
    {
        this.caseMetier = caseMetier;
    }


    //GETTER POUR MANIPULER LES CASES
    public Cases getCase(){
        return caseMetier;
    }
 

}
