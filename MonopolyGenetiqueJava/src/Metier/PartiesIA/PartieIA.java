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
    private InitialisationPartieIA initialisationPartieIA;
    private int nbAI=0;
    private int nbMutations;
    private int nbToursMax=0;

    public PartieIA(int nbAI,int nbMutations, int nbToursMax) {

        this.nbAI=nbAI;
        this.nbMutations=nbMutations;
        this.nbToursMax=nbToursMax;

        initialisationPartieIA = new InitialisationPartieIA(nbAI,nbMutations,nbToursMax);
        ArrayList<Color> listeCouleurs = new ArrayList<>();
        for(int i=0 ; i<nbAI ; i++){
            listeCouleurs.add(couleurAdversaire(i));
        }
        this.listeIA = initialisationPartieIA.getListeDesIA();
    }

    public void lancerPartie(int tourTotal){

        System.out.println("\n    DEBUT DE LA PARTIE\n");
        this.automate = this.initialisationPartieIA.automatePourIaInitialisation();

        automate.setNombreTourTotal(tourTotal);
        
        IA iaCourante = (IA)this.automate.getJoueurCourant();
        CentreDecision cd = new CentreDecision();

        for (int i = 0; i < 8; i++) {
            do{
                this.automate.evoluer("lancerDes"); //l'IA lance les dès

                //cd.priseDeDecision();

                //ensuite, si elle est sur une propriété appartenant à personne, elle l'achète

                if(iaCourante.getPion().getCase() instanceof Proprietes && ((Proprietes) iaCourante.getPion().getCase()).getProprio() == null){
                    this.automate.evoluer("acheterPropriete");
                }


            }while (iaCourante.getaLanceDes()==false); //si l'IA fait un double, elle rejoue
                this.automate.evoluer("tourSuivant");
        }

        Tournoi tournoi = new Tournoi(nbAI,nbMutations,nbToursMax);
        tournoi.lancerLeTournoi();
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
