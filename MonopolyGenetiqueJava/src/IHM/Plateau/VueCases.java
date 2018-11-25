package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public abstract class  VueCases extends Pane {

    //ATTRIBUTS
    private int position ;
    private Cases caseMetier ;
    private ArrayList<Pane> listeCases = new ArrayList<>();

    //CONSTRUCTEUR PRENANT UNE CASE DU METIER EN PARAMETRE
    public VueCases(Cases caseMetier)
    {
        this.listeCases = new ArrayList<>();
        this.caseMetier = caseMetier;
    }


    //GETTER POUR MANIPULER LES CASES
    public Cases getCase(){
        return caseMetier;
    }

    public  ArrayList<Pane> getListeCases(){
        return listeCases;
    }
    public abstract void setListeCases(Pane p);


    //Permet de récupérer le type de la Case
    public abstract String getType() ;



}
