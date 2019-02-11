package Metier.PartiesIA;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.InitialisationPartieIA;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PartieIA {

    private Automate automate;
    private ArrayList<Joueur> listeIA;
    private InitialisationPartieIA initialisationPartieIA = new InitialisationPartieIA();

    public PartieIA(int nbAI, int nbToursMax) {
        ArrayList<Color> listeCouleurs = new ArrayList<>();
        for(int i=0 ; i<nbAI ; i++){
            listeCouleurs.add(couleurAdversaire(i));
        }
        this.listeIA = this.initialisationPartieIA.creationListeIA(nbAI, listeCouleurs);
    }

    public void lancerPartie(){
        System.out.println("\n    DEBUT DE LA PARIE\n");
        this.automate = this.initialisationPartieIA.automatePourIaInitialisation(this.listeIA,automate.getNombreTourTotal());
        IA iaCourante = (IA)this.automate.getJoueurCourant();
        for (int i = 0; i < 8; i++) {
            do{
                this.automate.evoluer("lancerDes"); //l'IA lance les dès

                //ensuite, si elle est sur une propriété appartenant à personne, elle l'achète
                if(iaCourante.getPion().getCase() instanceof Proprietes && ((Proprietes) iaCourante.getPion().getCase()).getProprio() == null){
                    this.automate.evoluer("acheterPropriete");
                }
            }while (iaCourante.getaLanceDes()==false); //si l'IA fait un double, elle rejoue
            this.automate.evoluer("tourSuivant");
        }


    }

    private Color couleurAdversaire(int i)
    {

        Color couleur;
        switch (i){
            case 0 : couleur = Color.CRIMSON;
                break;
            case 1 : couleur = Color.DARKMAGENTA;
                break;
            case 2 : couleur = Color.DARKTURQUOISE;
                break;
            case 3 : couleur = Color.CORAL;
                break;
            case 4 : couleur = Color.MEDIUMSEAGREEN;
                break;
            default: couleur = Color.AZURE;
        }
        return couleur;
    }

}
