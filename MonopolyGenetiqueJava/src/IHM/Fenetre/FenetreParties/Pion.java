package IHM.Fenetre.FenetreParties;

import Metier.Automate.Automate;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pion extends Parent {

    public Pion(Automate automate, Jeu jeu){

        int x = 20;
        for (int i=0; i<automate.getNombreJoueur();i++)
        {

                Circle c = new Circle();
                //Comment on fait avec la couleur ?
            automate.getJoueurCourant().getPion().getCouleurPion() ; // retourne la couleur mais de type CouleurPion et non Color
                c.setFill(Color.GREEN);
                Pane caseDepart = (Pane) jeu.getListePanel().get(0);

                c.setRadius(10);
                c.setLayoutY(x );
                c.setLayoutX(x);
                caseDepart.getChildren().add(c);

                x += 20 ;



        }
    }
}
