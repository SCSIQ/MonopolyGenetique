package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Etat;

import java.util.ArrayList;
import java.util.Random;

public class PiocherCarteCaisseComm extends Etat {
    public PiocherCarteCaisseComm(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {
        if(getAutomate().getJoueurCourant().getPion().getCase() instanceof Metier.Plateau.ListeCartes.CaisseCommune)
        {
            if(getAutomate().getTirerCarteCaisseCommune()!=-1)
            {
                getAutomate().getListeDesCartesCaisseCommune().get(getAutomate().getTirerCarteCaisseCommune()).agir(getAutomate());
            }
            else
            {
                Random rand = new Random();
                getAutomate().getListeDesCartesCaisseCommune().get(rand.nextInt(3)).agir(getAutomate());
            }
        }
    }

    @Override
    public Etat transition(String event) {
        return  new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "PiocherCarteCaisseCommune{}";
    }
}
