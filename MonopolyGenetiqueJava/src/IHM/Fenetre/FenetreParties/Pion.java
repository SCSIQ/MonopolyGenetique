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
        int y = 60;
        for (int i = 0; i < automate.getNombreJoueur(); i++) {
            pions.add(i, new Circle());

            pions.get(i).setFill(automate.getListeJoueurs().get(i).getCouleur());

         Pane caseDepart = (Pane) plateauJeu.getListeCases().get(0);
            pions.get(i).setRadius(10);
            pions.get(i).setLayoutY(30);
            pions.get(i).setStroke(Color.BLACK);
            pions.get(i).setStrokeWidth(1);
            pions.get(i).setLayoutX(x);

            if(i==3)
            {
                x=20;
                pions.get(i).setLayoutY(y);
                pions.get(i).setLayoutX(x);

            }
            if(i==4)
            {
                pions.get(i).setLayoutY(y);
            }

            caseDepart.getChildren().add(pions.get(i));

            x += 20;


        }
    }

    public void entrerDansCase() {

        //ON ENLEVE LE PION DE LA CASE OU LE PION ETAIT AVANT LE LANCER DE DES
        this.sortirDeCase(pions.get(0));

        // ON RECUPERE LE PANEL OU LE PIONS VA ARRIVER APRES LE LANCER DE DES
        Pane p = (Pane) plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition());


        //horizontal + case bas

        int posJ1 =  automate.getListeJoueurs().get(0).getPion().getCase().getPosition();
        int posJ2 = automate.getListeJoueurs().get(1).getPion().getCase().getPosition();

        if(automate.getListeJoueurs().size()==2)
        {
            //Case du bas
            if((automate.getJoueurCourant().getPion().getCase().getPosition()>=0) && (automate.getJoueurCourant().getPion().getCase().getPosition()<10))
            {

                if(posJ1==posJ2)
                {
                    pions.get(0).setLayoutX(25);
                    pions.get(0).setLayoutY(35);
                    pions.get(1).setLayoutX(25);
                    pions.get(1).setLayoutY(60);
                }else{
                        pions.get(0).setLayoutX(25);
                        pions.get(0).setLayoutY(50);


                }
            }
            //case de haut
            else if(((automate.getJoueurCourant().getPion().getCase().getPosition()>=20) && (automate.getJoueurCourant().getPion().getCase().getPosition()<=30)))
            {
                if(posJ1==posJ2)
                {
                    pions.get(0).setLayoutX(25);
                    pions.get(0).setLayoutY(15);
                    pions.get(1).setLayoutX(25);
                    pions.get(1).setLayoutY(45);
                }else{
                    pions.get(0).setLayoutX(25);
                    pions.get(0).setLayoutY(30);


                }
            }
            //gauche
            else if((automate.getJoueurCourant().getPion().getCase().getPosition()>=11) && (automate.getJoueurCourant().getPion().getCase().getPosition()<=19))
            {
                if(posJ1==posJ2)
                {
                    pions.get(0).setLayoutX(15);
                    pions.get(0).setLayoutY(25);
                    pions.get(1).setLayoutX(45);
                    pions.get(1).setLayoutY(25);
                }else{
                    pions.get(0).setLayoutX(30);
                    pions.get(0).setLayoutY(25);


                }
            }
            //droite
            else if((automate.getJoueurCourant().getPion().getCase().getPosition()>=31) && (automate.getJoueurCourant().getPion().getCase().getPosition()<=39))
            {
                if(posJ1==posJ2)
                {
                    pions.get(0).setLayoutX(35);
                    pions.get(0).setLayoutY(25);
                    pions.get(1).setLayoutX(65);
                    pions.get(1).setLayoutY(25);
                }else{
                    pions.get(0).setLayoutX(55);
                    pions.get(0).setLayoutY(25);
                }
            }
            else if((automate.getJoueurCourant().getPion().getCase().getPosition()==10))
            {
                if(posJ1==posJ2)
                {
                    pions.get(0).setLayoutX(15);
                    pions.get(0).setLayoutY(15);
                    pions.get(1).setLayoutX(15);
                    pions.get(1).setLayoutY(40);
                }else{
                    pions.get(0).setLayoutX(15);
                    pions.get(0).setLayoutY(25);
                }
            }



        }

        // ON AJOUTE A CE PANEL
         p.getChildren().add(pions.get(0));


    }

    public void sortirDeCase(Circle c) {

        //ON RECUPERE LE PANEL OU ETAIT LE JOUEUR ET ON LE SUPPRIME DE CE PANEL
        Pane p = (Pane) plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition());
        p.getChildren().remove(c);
    }

    public void ChangerOrdrePion()
    {
        this.pions.add(pions.get(0));
        this.pions.remove(0);
    }
}

