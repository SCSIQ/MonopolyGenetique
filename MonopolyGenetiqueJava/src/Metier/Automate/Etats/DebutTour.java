package Metier.Automate.Etats;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Automate;

import java.util.ArrayList;

public class DebutTour extends Etat{

    private Automate automate;

    public DebutTour(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
        this.automate=automate;
    }

    @Override
    public void agir(String event) {

        Joueur j = super.getListeJoueurs().get(0);

        if(j instanceof IA){
            System.out.println("    TOUR : "+automate.getNumTour());
            System.out.println("    Joueur IA : "+j.getNom());
            System.out.println("    SOLDE  "+j.getSolde());
            System.out.println("    CARTE PRISON  "+j.getNbCartesLibereDePrison());
            System.out.println("    PRISON  "+j.getEstEnPrison());
        }
        else
        {
            System.out.println("    Joueur humain : "+j.getNom());
        }

        getAutomate().setNbJoueurTour(getAutomate().getNbJoueurTour()+1);

        if(getAutomate().getNbJoueurTour()%getAutomate().getListeJoueurs().size()==1)
        {
            getAutomate().setNumTour(getAutomate().getNumTour()+1);
        }

        j.setaLanceDes(false); //just in case
        j.setResDes1(0);
        j.setResDes2(0);
        j.setResLanceDes(0);
        j.setNbDoubles(0);
        //ici ajouter les actions automatisées que doivent faire les joueurs en début de tour si il y en a
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "DebutTour{}";
    }
}
