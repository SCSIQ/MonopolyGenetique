package Metier.PartiesIA.Scenario;

public class Scenario {

    //ATTRIBUTS
    private int nbSurvivants;
    private int nbMutant;
    private int tailleGeneration ;

    //CONSTRUCTEUR
    public Scenario(int tailleGeneration, int nbSurvivants, int nbMutant)
    {
        this.nbMutant = nbMutant;
        this.tailleGeneration= tailleGeneration;
        this.nbSurvivants= nbSurvivants; 
    }

}
