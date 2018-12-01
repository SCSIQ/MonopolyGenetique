package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Plateau.Cases;

import java.util.ArrayList;

public class Deplacement extends Etat{

    private boolean passeParDepart = false;

    public Deplacement(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        Joueur j = super.getListeJoueurs().get(0);
        //System.out.println("    avant déplacement : "+j.toString());

        int resDes = j.getResLanceDes();
        //int resDes = 1; //POUR IHM

        Cases position = j.getPion().getCase();

        boolean goToPrison = false;
        int newPositionToGo = position.getPosition() + resDes;

        //System.out.println("D'où on vient : "+position.getPosition());
        //System.out.println("De combien on avance : "+resDes);
        System.out.println("    nouvelle position : "+newPositionToGo);

        //si change de tour de plateau et passe par la case départ
        if (newPositionToGo > 39)
        {
            newPositionToGo = newPositionToGo - 40; //Permet de denrepositionner le pion sur le nouveau tour du plateau
            this.passeParDepart = true;

            //si le joueur courant s'arrête sur la case départ précissement il gagne 3 000€
            if(newPositionToGo==0){
                super.getAutomate().getJoueurCourant().IncrementerSolde(3000);
            }else { // sinon il gagne 1 500€
                super.getAutomate().getJoueurCourant().IncrementerSolde(1500);
            }
        }
        j.Avancer(newPositionToGo); //demande au joueur d'avancer son pion (le joueur connais les résultats de son lancé de dès

        System.out.println(j.toString());
    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "Deplacement{}";
    }
}
