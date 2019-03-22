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
    private ArrayList<Joueur> listeIaGagnante; //liste ou sera stockée les meilleures IA de chaque partie
    private InitialisationPartieIA initialisationPartieIA;
    private int nbAI=0;
    private int nbMutations;
    private int nbToursMax=0;
    private int nbPartie=0;
    private Joueur gagnante=null;

    public PartieIA(int nbAI,int nbMutations, int nbToursMax,int nbPartie) {

        this.nbAI=nbAI;
        this.nbMutations=nbMutations;
        this.nbToursMax=nbToursMax;
        this.listeIaGagnante = new ArrayList<>();
        this.nbPartie=nbPartie;

        initialisationPartieIA = new InitialisationPartieIA(nbAI,nbMutations,nbToursMax,nbPartie);
        ArrayList<Color> listeCouleurs = new ArrayList<>();
        for(int i=0 ; i<nbAI ; i++){
            listeCouleurs.add(couleurAdversaire(i));
        }
        this.listeIA = initialisationPartieIA.getListeDesIA();
    }

    public void lancerPartie(int tourTotal) {
        int compteurPartie=1;
        System.out.println("\n    DEBUT DE LA PARTIE\n");
        this.automate = this.initialisationPartieIA.automatePourIaInitialisation();

        automate.setNombreTourTotal(tourTotal);

        for(int j=1;j<=tourTotal;j++)
        {

            for (int i = 0; i < automate.getListeJoueurs().size(); i++) {

                    IA iaCourante = (IA) this.automate.getJoueurCourant();


                    do {
                        this.automate.evoluer("lancerDes"); //l'IA lance les dès

                        //ensuite, si elle est sur une propriété appartenant à personne, elle l'achète
                        if (iaCourante.getPion().getCase() instanceof Proprietes && ((Proprietes) iaCourante.getPion().getCase()).getProprio() == null) {
                            iaCourante.compareNoteAcheter(automate);
                        }
                        if(iaCourante.getEstEnPrison()==true)
                        {
                            iaCourante.compareNotePrison();
                        }





                    }while (iaCourante.getaLanceDes() == false); //si l'IA fait un double, elle rejoue
                        this.automate.evoluer("tourSuivant");

                    if(automate.getListeJoueurs().size()== 1)
                    {
                        setGagnante(automate.getListeJoueurs().get(0));
                        System.out.println("IA gagnante : "+getGagnante().getNom());
                        automate.evoluer("FinPartie");
                    }
                    else if(nbToursMax==automate.getNumTour())
                    {
                        int score=automate.getListeJoueurs().get(0).getScoreJoueur().getScoreTotal();

                        for(int k=0;k<automate.getListeJoueurs().size();k++)
                        {
                            if(score<automate.getListeJoueurs().get(k).getScoreJoueur().getScoreTotal())
                            {
                                score=automate.getListeJoueurs().get(k).getScoreJoueur().getScoreTotal();
                                setGagnante(automate.getListeJoueurs().get(k));
                            }
                        }
                        System.out.println("IA gagnante : "+getGagnante().getNom());
                        automate.evoluer("FinPartie");
                    }

                }
            }
    }

    public Joueur getGagnante() {
        return gagnante;
    }

    public void setGagnante(Joueur gagnante) {
        this.gagnante = gagnante;
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
