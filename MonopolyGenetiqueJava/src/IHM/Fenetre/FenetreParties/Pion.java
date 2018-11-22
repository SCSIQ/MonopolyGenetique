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
        this.sortirDeCase(pions.get(0));
        Pane p = (Pane) plateauJeu.getListePanel().get(automate.getJoueurCourant().getPion().getCase().getPosition());

      //  System.out.println(automate.getJoueurCourant().getPion().getCase());
        //pions.get(automate.getListeJoueurs().indexOf(automate.getJoueurCourant())); //permet de récupérer le joueur courant et donc le pions
        p.getChildren().add(pions.get(0));
    }

    public void sortirDeCase(Circle c) {
        Pane p = (Pane) plateauJeu.getListePanel().get(automate.getJoueurCourant().getPion().getCase().getPosition());
        p.getChildren().remove(c);
    }
}

