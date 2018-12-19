package IHM.Plateau;

import Metier.Plateau.Cases;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.util.ArrayList;

public abstract class  VueCases extends Pane {

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


    //Permet de récupérer le type de la Case
    public abstract String getType() ;

    public abstract void setImageMaison(ImageView maison) ;

    public abstract ImageView getImageMaison() ;




}
