package Metier.Cartes;

import Metier.Automate.Automate;

public abstract class Cartes {

    private String texte;

    public Cartes() {
    }

    /**
     * cette méthode demande à l'automate d'agir en fonction de ce que la carte demande de faire
     */
    public abstract void agir(Automate automate);

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
