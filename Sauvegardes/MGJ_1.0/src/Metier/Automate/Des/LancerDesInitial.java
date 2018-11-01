package Metier.Automate.Des;
import Entites.Joueur;
import Metier.Automate.Etat;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Random;

public class LancerDesInitial extends Etat {

    public LancerDesInitial(ArrayList<Joueur> listeJoueurs) {
        super(listeJoueurs);
    }

    @Override
    public void agir() {

        HashMap<Joueur,Integer> joueurhashMap = new HashMap<>();

        int sizeListe=super.getListeJoueurs().size();
        ArrayList<Joueur> listeEtat = super.getListeJoueurs(); //récupére la liste des joueurs
        ArrayList<Joueur> listeTriee = new ArrayList<>();

        for(int i=0 ; i<sizeListe ; i++){

            System.out.println("    i : "+i);

            Joueur joueurCourant = super.getListeJoueurs().get(i); //récupère le joueur courant
            Random toto = new Random();
            int de1=toto.nextInt(6)+1; //lancé dé 1
            int de2=toto.nextInt(6)+1; //lancé dé 2
            int score = de1+de2; //score total des dés
            System.out.println("Score joueur "+i+" : "+score);

            joueurhashMap.put(joueurCourant,score); //enregistre le score pour le joueur




            /*boolean ajoutListe = false;
            int j = 0;
            if(i!=0){
                while(ajoutListe==false){
                    System.out.println("score premier dans listetriee : "+joueurhashMap.get(listeTriee.get(j)));
                    if(joueurhashMap.get(joueurCourant)>joueurhashMap.get(listeTriee.get(j))){
                        System.out.println("placement en j-1");
                        listeTriee.add(j,joueurCourant);
                        ajoutListe = true;
                    }
                    System.out.println("coucou");
                    if(j==i){
                        System.out.println("placement en derniere position");
                        listeTriee.add(joueurCourant);
                        ajoutListe = true;
                    }
                    System.out.println("coucou2");
                    j++;
                }
            }else{
                listeTriee.add(joueurCourant);
            }*/

            System.out.println("premier joueur listeTriée : "+joueurhashMap.get(listeTriee.get(i))+"\n");
        }
        super.setListeJoueurs(listeEtat); //update la liste des joueurs
    }

    @Override
    public Etat transition() {
        return null;
    }
}
