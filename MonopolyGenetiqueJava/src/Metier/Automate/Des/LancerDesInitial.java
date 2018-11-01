package Metier.Automate.Des;
import Entites.Joueur;
import Metier.Automate.Etat;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class LancerDesInitial extends Etat {

    public LancerDesInitial(ArrayList<Joueur> listeJoueurs) {
        super(listeJoueurs);
    }

    private static Object getKeyFromValue(Map hm, Object value){
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void agir() {

        Map<Joueur,Integer> joueurhashMap = new HashMap<Joueur,Integer>();

        int sizeListe=super.getListeJoueurs().size();
        ArrayList<Joueur> listeEtat = super.getListeJoueurs(); //récupére la liste des joueurs
        ArrayList<Joueur> listeTriee = new ArrayList<>();
        ArrayList<Integer> listeNb = new ArrayList<>();

        for(int i=0 ; i<sizeListe ; i++) {

            Joueur joueurCourant = super.getListeJoueurs().get(i); //récupère le joueur courant
            Random toto = new Random();
            int de1 = toto.nextInt(6) + 1; //lancé dé 1
            int de2 = toto.nextInt(6) + 1; //lancé dé 2
            int score = de1 + de2; //score total des dés

            listeNb.add(score); //ajoute le score à une liste temporaire de nb entiers que l'on va trier
            joueurhashMap.put(joueurCourant, score); //enregistre le score associé au joueur
        }

        Collections.sort(listeNb); //trie la liste de nombres par ordre décroissant
        Collections.reverse(listeNb); //puis la retourne par ordre croissant

        for(int i=0 ; i<listeNb.size() ; i++){ //pour chaque élément de la liste

            //récupère le joueur associé à la valeur triée
            Joueur joueurTemp = (Joueur) getKeyFromValue(joueurhashMap,listeNb.get(i));
            listeTriee.add(joueurTemp); //puis l'ajoute à la liste à retourner
        }

        super.setListeJoueurs(listeTriee); //update la liste des joueurs (ordonée)

    }

    @Override
    public Etat transition() {
        return null;
    }
}
