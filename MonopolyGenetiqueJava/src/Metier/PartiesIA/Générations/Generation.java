package Metier.PartiesIA.Générations;

import Entites.IA;
import Metier.PartiesIA.ComparerIA.ComparateurIA;

import java.util.ArrayList;
import java.util.Random;

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

    private void reproduction(int nombreSurvivant) {
        Random rand = new Random();
        while(this.listeIA.size()<listeIA.size()) {
            IA pere = this.listeIA.get(rand.nextInt(nombreSurvivant));
            IA mere = this.listeIA.get(rand.nextInt(nombreSurvivant));
            this.listeIA.add(new IA(pere,mere));
        }
    }

    private void mutation(int nombreSurvivant,int nombreMutation) {
        Random rand = new Random();
        for(int i = 0;i < nombreMutation;i++) {
            IA mutant = this.listeIA.get(nombreSurvivant+rand.nextInt(this.listeIA.size()-nombreSurvivant));
            this.listeMutant.add(mutant);
        }
    }

    public void evolution(int nombreSurvivant,int nombreMutation) {
        this.selection(nombreSurvivant);
        this.reproduction(nombreSurvivant);
        this.mutation(nombreSurvivant,nombreMutation);
      //  this.controleurSelection.action_evolutaion();
    }
}
