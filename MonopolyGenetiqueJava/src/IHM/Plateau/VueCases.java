package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class  VueCases {

    //ATTRIBUTS
    private int position ;
    private Cases caseMetier ;
    private ArrayList<Pane> listeCases = new ArrayList<>() ;

    //CONSTRUCTEUR PRENANT UNE CASE DU METIER EN PARAMETRE
    public VueCases(Cases caseMetier, ArrayList<Pane> listeCases)
    {
        this.listeCases= listeCases;
        this.caseMetier = caseMetier;
    }


    //GETTER POUR MANIPULER LES CASES
    public Cases getCase(){
        return caseMetier;
    }
 

}
