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
        System.out.println("    avant déplacement : "+j.toString());

        int resDes = j.getResLanceDes();

        Cases position = j.getPion().getCase();

        boolean goToPrison = false;
        int newPositionToGo = position.getPosition() + resDes;

        System.out.println("newPositionToGo : "+newPositionToGo);

        if(j.getPion().isGoToPrison()==true)
        {
            position = j.getListeCases().get(10);
        }
        else
        {
            if (position.getPosition() + resDes > 39) //si change de tour de plateau et passe par la case départ
            {
                newPositionToGo = newPositionToGo - 40; //Permet de denrepositionner le pion sur le nouveau tour du plateau
                this.passeParDepart = true;
            }
            else{ //sinon ne peut pas avancer....
                System.out.println("    ne peut pas avancer pour le moment...\n        Veuillez contacter Aurian");
            }
            j.Avancer(newPositionToGo); //demande au joueur d'avancer son pion (le joueur connais les résultats de son lancé de dès)
        }
        j.getPion().setGoToPrison(false);

        System.out.println("    après déplacement : "+j.toString());
    }

    @Override
    public Etat transition(String event) {
        if(this.passeParDepart == true)
        {
            return new Depart(super.getAutomate(), super.getListeJoueurs());
        }
        else
        {
            return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
        }
    }

    @Override
    public String toString() {
        return "Deplacement{}";
    }
}
