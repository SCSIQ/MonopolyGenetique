package Metier.Automate.Etats.Argent;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeTaxes.Impot;
import Metier.Plateau.ListeTaxes.TaxeDeLuxe;
import Metier.Plateau.ListeTaxes.Taxes;
import Metier.Plateau.ParcGratuit;

import java.util.ArrayList;

public class PayerTaxe extends Etat {

    public PayerTaxe(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    @Override
    public void agir(String event) {

        Joueur j = super.getListeJoueurs().get(0);
        int sommeAPayer = 0;

        sommeAPayer = ((Taxes)j.getPion().getCase()).getPrixTaxe(); //réccupère la somme à payer
        j.DecrementerSolde(sommeAPayer); //fait payer le joueur
        ((ParcGratuit)j.getListeCases().get(20)).verserARgent(sommeAPayer); //met l'argent dans le parc gratuit

    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "PayerTaxe{}";
    }
}
