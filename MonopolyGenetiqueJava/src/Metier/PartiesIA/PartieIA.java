package Metier.PartiesIA;

import Entites.IA;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.InitialisationPartieIA;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static Metier.PartiesIA.CritereIA.*;

public class PartieIA {

    private Automate automate;
    private ArrayList<Joueur> listeIA;
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
        this.nbPartie=nbPartie;

        initialisationPartieIA = new InitialisationPartieIA(nbAI,nbMutations,nbToursMax,nbPartie);
        ArrayList<Color> listeCouleurs = new ArrayList<>();
        for(int i=0 ; i<nbAI ; i++){
            listeCouleurs.add(couleurAdversaire(i));
        }
        this.listeIA = initialisationPartieIA.getListeDesIA();
    }

    public void lancerPartie(int tourTotal, InputStream fichierLire, FileWriter fichierEcrire) {
        int compteurPartie=1;
        System.out.println("\n    DEBUT DE LA PARTIE\n");
        this.automate = this.initialisationPartieIA.automatePourIaInitialisation();
        boolean fini=false;

        automate.setNombreTourTotal(tourTotal);

        while(fini==false)
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

                    if(automate.getListeJoueurs().size()== 1)
                    {
                        fini=true;
                        initialisationPartieIA.getListeIAGagnantes().add(automate.getListeJoueurs().get(0));
                        //System.out.println("IA gagnante : "+getGagnante().getNom());
                        automate.evoluer("FinPartie");
                        initialisationPartieIA.afficheIAGagnantes();

                        try {
                            fichierEcrire = new FileWriter("" + System.getProperty("user.home") + "/Documents/GitHub/MonopolyGenetique/MonopolyGenetiqueJava/src/Metier/PartiesIA/texte/text.txt", true);
                            fichierEcrire.write(automate.getJoueurCourant().getNom()+" "+
                                    ((IA)automate.getJoueurCourant()).getPoids().get(pasBeaucoupArgent)+" "+
                                    ((IA)automate.getJoueurCourant()).getPoids().get(beaucoupArgent)+" "+
                                    ((IA)automate.getJoueurCourant()).getPoids().get(aCarteLiberePrison)+
                                    ((IA)automate.getJoueurCourant()).getPoids().get(caseSuivanteBonne)+" "+
                                    ((IA)automate.getJoueurCourant()).getPoids().get(caseSuivanteMauvaise)+" "+
                                    ((IA)automate.getJoueurCourant()).getPoids().get(dejaUneCase)+" "+
                                    ((IA)automate.getJoueurCourant()).getPoids().get(terrainRapportePlus)+" "+"\n");
                            fichierEcrire.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }



                    }
                    else {
                        this.automate.evoluer("tourSuivant");
                    }
                }
            if(nbToursMax>=automate.getNumTour())
            {


                int score=automate.getListeJoueurs().get(0).getScoreJoueur().getScoreTotal();

                Joueur joueur= null;
                for(int k=0;k<automate.getListeJoueurs().size();k++)
                {
                    if(score<=automate.getListeJoueurs().get(k).getScoreJoueur().getScoreTotal())
                    {
                        score=automate.getListeJoueurs().get(k).getScoreJoueur().getScoreTotal();
                        joueur=automate.getListeJoueurs().get(k);

                    }
                }
                //System.out.println("IA gagnante : "+automate.getGagnante().getNom());

                initialisationPartieIA.getListeIAGagnantes().add(joueur);

                automate.evoluer("FinPartie");
                try {
                    fichierEcrire = new FileWriter("" + System.getProperty("user.home") + "/Documents/GitHub/MonopolyGenetique/MonopolyGenetiqueJava/src/Metier/PartiesIA/texte/text.txt", true);
                    fichierEcrire.write(joueur.getNom()+" "+
                            ((IA)joueur).getPoids().get(pasBeaucoupArgent)+" "+
                            ((IA)joueur).getPoids().get(beaucoupArgent)+" "+
                            ((IA)joueur).getPoids().get(aCarteLiberePrison)+
                            ((IA)joueur).getPoids().get(caseSuivanteBonne)+" "+
                            ((IA)joueur).getPoids().get(caseSuivanteMauvaise)+" "+
                            ((IA)joueur).getPoids().get(dejaUneCase)+" "+
                            ((IA)joueur).getPoids().get(terrainRapportePlus)+" "+"\n");
                    fichierEcrire.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                fini=true;
            }
        }

        initialisationPartieIA.afficheIAGagnantes();
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
