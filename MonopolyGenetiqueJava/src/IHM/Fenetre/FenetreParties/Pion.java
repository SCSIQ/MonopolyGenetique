package IHM.Fenetre.FenetreParties;

import Entites.Joueur;
import Metier.Automate.Automate;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Pion extends Parent {

    private Automate automate ;
    private Jeu jeu ;
    private ArrayList<Circle> pions;

    public Pion(Automate automate, Jeu jeu){

        this.automate = automate ;
        this.jeu = jeu ;
        pions = new ArrayList<>();

        int x = 20;
        for (int i=0; i<automate.getNombreJoueur();i++)
        {
             pions.add(i, new Circle());

            //Comment on fait avec la couleur ?
            pions.get(i).setFill(automate.getListeJoueurs().get(i).getCouleur());

          //  Pane caseDepart = (Pane) jeu.getListePanel().get(0);

            pions.get(i).setRadius(10);
            pions.get(i).setLayoutY(x );
            pions.get(i).setLayoutX(x);
          //  caseDepart.getChildren().add(pions.get(i));

            x += 20 ;



        }
    }

    public void entrerDansCase()
    {

    }

    public void sortirDeCase()
    {

    }

    public void deplacer()
    { // le pion doit se déplacer donc faire une fonction sortir et entrer pour les cases
      //  Pane p = (Pane) jeu.getListePanel().get(automate.getJoueurCourant().getResLanceDes());
        //automate.getJoueurCourant();
        //enlever le pion sur la case de départ
        //p.getChildren().add(pions.get(1));
    }
}
