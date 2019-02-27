package Metier.PartiesIA.Générations;

import Entites.IA;
import Metier.PartiesIA.ComparerIA.ComparateurIA;

import java.util.ArrayList;

public class Generation
{
    //ATTRIBUTS
    private ArrayList<IA> listeIA ;
    private ArrayList<IA> listeSurvivant;
    private ArrayList<IA> listeMutant;
    private IA  ia;

    //CONSTRUCTEUR
    public Generation()
    {
        //Initatialisation des listes
        this.listeIA= new ArrayList<>();
        this.listeMutant  = new ArrayList<>();
        this.listeSurvivant = new ArrayList<>();
    }

    //METHODES
    private void selection(int nbSurvivant)
    {
        this.listeIA.sort(new ComparateurIA(this.ia));
        while(this.listeIA.size()>nbSurvivant) {
            this.listeIA.remove(this.listeIA.size()-1);
        }
        this.listeSurvivant = new ArrayList<>(this.listeIA);

    }
}
