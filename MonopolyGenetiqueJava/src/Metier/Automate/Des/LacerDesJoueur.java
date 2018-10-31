package Metier.Automate.Des;

import Entites.Joueur;
import Metier.Automate.Etat;

public class LacerDesJoueur extends Etat {

    public LacerDesJoueur(Joueur joueur) {
        super(joueur);
    }

    public void LancementDes(){
    }

    @Override
    public void agir() {

    }

    @Override
    public Etat transition() {
        return null;
    }
}