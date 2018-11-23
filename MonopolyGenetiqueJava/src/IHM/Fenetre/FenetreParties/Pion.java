package IHM.Fenetre.FenetreParties;

import Entites.Joueur;
import IHM.Fenetre.FenetreParties.ComposantPlateau.PlateauJeu;
import Metier.Automate.Automate;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Pion extends Parent {

    //ATTRIBUTS
    private Automate automate; // correspond à l'automate
    private PlateauJeu plateauJeu;// correspond au plateau du jeu avec les cases
    private ArrayList<Circle> pions;// correspond à la liste des pions

    public Pion(Automate automate, PlateauJeu plateauJeu) {

        this.automate = automate;
        this.plateauJeu = plateauJeu;
        pions = new ArrayList<>();

        int x = 20;
        for (int i = 0; i < automate.getNombreJoueur(); i++) {
            pions.add(i, new Circle());

            pions.get(i).setFill(automate.getListeJoueurs().get(i).getCouleur());

            Pane caseDepart = (Pane) plateauJeu.getListePanel().get(0);
            pions.get(i).setRadius(10);
            pions.get(i).setLayoutY(20);
            pions.get(i).setLayoutX(x);
            caseDepart.getChildren().add(pions.get(i));

            x += 20;


        }
    }

    public void entrerDansCase() {

        //ON ENLEVE LE PION DE LA CASE OU LE PION ETAIT AVANT LE LANCER DE DES
        this.sortirDeCase(pions.get(0));

        // ON RECUPERE LE PANEL OU LE PIONS VA ARRIVER APRES LE LANCER DE DES
        Pane p = (Pane) plateauJeu.getListePanel().get(automate.getJoueurCourant().getPion().getCase().getPosition());

        // ON AJOUTE A CE PANEL
         p.getChildren().add(pions.get(0));

        ChangerOrdrePion(pions);

    }

    public void sortirDeCase(Circle c) {

        //ON RECUPERE LE PANEL OU ETAIT LE JOUEUR ET ON LE SUPPRIME DE CE PANEL
        Pane p = (Pane) plateauJeu.getListePanel().get(automate.getJoueurCourant().getPion().getCase().getPosition());
        p.getChildren().remove(c);
    }

    public void ChangerOrdrePion(ArrayList<Circle> pions)
    {
        pions.add(pions.get(0));
        pions.remove(0);
    }
}

