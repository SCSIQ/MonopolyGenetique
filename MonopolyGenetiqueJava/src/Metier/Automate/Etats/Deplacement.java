package Metier.Automate.Etats;

import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Argent.PayerLoyer;
import Metier.Automate.Etats.Argent.PayerTaxe;
import Metier.Plateau.AllerEnPrison;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.Proprietes;
import Metier.Plateau.ListeTaxes.Taxes;
import Metier.Plateau.ParcGratuit;
import Metier.Automate.Etats.ChoixPossibles;

import java.util.ArrayList;

public class Deplacement extends Etat{

    private boolean doitPayerLoyer = false;
    private boolean doitPayerTaxe = false;

    public Deplacement(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
        //permet de demander à l'automate d'évoluer une fois du plus de façon automatique
        super.getAutomate().setAutomatedEvolution(true);
    }

    private void avancer(Joueur j, int resDes, Cases position){
        int newPositionToGo = position.getPosition() + resDes;

        System.out.println("    nouvelle position : "+newPositionToGo);

        //si change de tour de plateau et passe par la case départ
        if (newPositionToGo > 39)
        {
            newPositionToGo = newPositionToGo - 40; //Permet de denrepositionner le pion sur le nouveau tour du plateau

            //si le joueur courant s'arrête sur la case départ précissement il gagne 3 000€
            if(newPositionToGo==0){
                super.getAutomate().getJoueurCourant().IncrementerSolde(3000);
            }
            else { // sinon il gagne 1 500€
                super.getAutomate().getJoueurCourant().IncrementerSolde(1500);
            }
        }
        j.Avancer(newPositionToGo); //demande au joueur d'avancer son pion (le joueur connais les résultats de son lancé de dès

        System.out.println(j.toString());

        //si la case est une propriété
        if(j.getPion().getCase() instanceof Proprietes)
        {
            //si elle appatien à un joueur
            if( (((Proprietes) j.getPion().getCase()).getProprio() != null) && (((Proprietes) j.getPion().getCase()).getProprio() != j) )
            {
                doitPayerLoyer = true; //active la transition à l'état faisant payer le loyer à un autre joueur
            }
        }

        //si la case est une taxe
        if(j.getPion().getCase() instanceof Taxes)
        {
            doitPayerTaxe = true; //active la transition à l'état faisant payer les taxes
        }

        //si c'est la carte aller en prison
        if(j.getPion().getCase() instanceof AllerEnPrison)
        {
            j.Avancer(10); //avancer à la case prison
            j.setEstEnPrison(true);
        }

        //si c'est le parc gratuit
        if(j.getPion().getCase() instanceof ParcGratuit)
        {
            getAutomate().setArgentRecupDansParcGratuit(((ParcGratuit)j.getListeCases().get(20)).getArgantDansParc());
            j.IncrementerSolde(((ParcGratuit)j.getListeCases().get(20)).recupererArgent()); //récupérer l'argent se trouvant dans le parc gratuit
        }
    }

    @Override
    public void agir(String event) {
        Joueur j = super.getListeJoueurs().get(0);

        int resDes = j.getResLanceDes();
        //int resDes = 5; //POUR IHM

        Cases position = j.getPion().getCase();

        //si le joueur doit aller en prison
        if(j.getPion().getGoToPrison()==true)
        {
            j.getPion().setGoToPrison(false);
            j.Avancer(10);
            j.setEstEnPrison(true);
            j.setaLanceDes(true);
        }
        else if(j.getEstEnPrison()==true) //si le joueur est en prison
        {
            if(j.getResDes1()==j.getResDes2()) //si il a fait un double
            {
                j.setEstEnPrison(false);
                avancer(j, resDes, position);
            }
            else if(j.getEssaiesPourSortirDePrison()>=2) //si ça fait déja 2 tours qu'il est en prison
            {
                j.DecrementerSolde(500); //paye 500 pour sortir (n'a pas le choix)
                j.setEstEnPrison(false);
                avancer(j, resDes, position);
            }
            else
            {
                j.setEssaiesPourSortirDePrison(j.getEssaiesPourSortirDePrison()+1);
            }
            System.out.println("    EssaiesPourSortirDePrison : "+j.getEssaiesPourSortirDePrison());
        }
        else //sinon, déroulement normal des déplacements
        {
            avancer(j, resDes, position);
        }

    }

    @Override
    public Etat transition(String event) {
        if(doitPayerLoyer==true)
        {
            return new PayerLoyer(super.getAutomate(), super.getListeJoueurs());
        }
        else if(doitPayerTaxe==true)
        {
            return new PayerTaxe(super.getAutomate(), super.getListeJoueurs());
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
