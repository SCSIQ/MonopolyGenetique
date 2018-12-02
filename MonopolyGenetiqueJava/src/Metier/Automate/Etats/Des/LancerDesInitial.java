package Metier.Automate.Etats.Des;
import Entites.Joueur;
import Metier.Automate.Automate;
import Metier.Automate.Etats.Choix.ChoixPossibles;
import Metier.Automate.Etats.Etat;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class LancerDesInitial extends Etat {

    public LancerDesInitial(Automate automate, ArrayList<Joueur> listeJoueurs) {
        super(automate, listeJoueurs);
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
    public void agir(String event) {

        System.out.println("///////////////////////////////////////////////////////");

        for(int i=0 ; i<super.getListeJoueurs().size() ; i++)
        {
            System.out.println("    "+super.getListeJoueurs().get(i).getJoueurID());
        }

        System.out.println("------->MELANGE DES JOUEURS");

        Collections.shuffle(super.getListeJoueurs());
        Collections.shuffle(super.getListeJoueurs());

        for(int i=0 ; i<super.getListeJoueurs().size() ; i++)
        {
            super.getListeJoueurs().get(i).setNom("Joueur"+(i+1)); //attribut à chaque joueur un nom : Joueur1, Joueur2, etc
            System.out.println("    "+super.getListeJoueurs().get(i).getJoueurID());
        }

        System.out.println("///////////////////////////////////////////////////////");

//
        /*
        Map<Joueur,Integer> joueurhashMap = new HashMap<Joueur,Integer>();

        ArrayList<Integer> listeNb = new ArrayList<>();

        for(int i=0 ; i<super.getListeJoueurs().size() ; i++) {

            Joueur joueurCourant = super.getListeJoueurs().get(i); //récupère le joueur courant
            Random toto = new Random();
            int de1 = toto.nextInt(6) + 1; //lancé dé 1
            int de2 = toto.nextInt(6) + 1; //lancé dé 2
            int score = de1 + de2; //score total des dés

            listeNb.add(score); //ajoute le score à une liste temporaire de nb entiers que l'on va trier
            joueurhashMap.put(joueurCourant, score); //enregistre le score associé au joueur
        }

        super.getListeJoueurs().clear();

        Collections.sort(listeNb); //trie la liste de nombres par ordre décroissant
        Collections.reverse(listeNb); //puis la retourne par ordre croissant

        for(int i=0 ; i<listeNb.size() ; i++){ //pour chaque élément de la liste

            //récupère le joueur associé à la valeur triée
            Joueur joueurTemp = (Joueur) getKeyFromValue(joueurhashMap,listeNb.get(i));
            joueurTemp.setNom("Joueur"+(i+1));
            super.getListeJoueurs().add(joueurTemp); //puis l'ajoute à la liste à retourner
        }
        */ // Region previous code

    }

    @Override
    public Etat transition(String event) {
        return new ChoixPossibles(super.getAutomate(), super.getListeJoueurs());
    }

    @Override
    public String toString() {
        return "LancerDesInitial{}";
    }
}
