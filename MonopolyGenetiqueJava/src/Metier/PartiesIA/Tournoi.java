package Metier.PartiesIA;

import java.io.*;
import java.util.ArrayList;

public class Tournoi {

    private ArrayList<PartieIA> listeParties = new ArrayList<>();
    private int nbIA;
    private int nbMutations;
    private int nbpartie;

    private InputStream fichierLire;
    private  FileWriter fichierEcrire;

    private int nbToursMax;

    public Tournoi(int nbAI, int nbMutations, int nbToursMax,int nbpartie) {
        this.nbIA = nbAI;
        this.nbMutations = nbMutations;
        this.nbToursMax = nbToursMax;
        this.nbpartie=nbpartie;

        //crée toutes les parties
        //for (int j = 0; j < this.nbIA/4; j++) {
        for (int j = 0; j < nbpartie; j++) {
            this.listeParties.add(new PartieIA(nbAI,nbMutations, this.nbToursMax,nbpartie));
        }

        System.out.println(System.getProperty("user.home")); //ne renvoit pas le bon répertoire, à voir
        try{
            this.fichierLire=new FileInputStream(System.getProperty("user.home")+"/Documents/GitHub/MonopolyGenetique/MonopolyGenetiqueJava/src/Metier/PartiesIA/texte/text.txt");
            InputStreamReader lecture=new InputStreamReader(fichierLire);
            BufferedReader buff=new BufferedReader(lecture);
            String ligne;
            while ((ligne=buff.readLine())!=null){
                System.out.println(ligne);
            }
            buff.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        try {
            fichierEcrire = new FileWriter("" + System.getProperty("user.home") + "/Documents/GitHub/MonopolyGenetique/MonopolyGenetiqueJava/src/Metier/PartiesIA/texte/text.txt", true);
            //fichierEcrire.write("COUCOU C'EST MOI");
            fichierEcrire.close();
        } catch (IOException e) {
            e.printStackTrace();
        } {

        }

    }

    public void lancerLeTournoi(){
        lancerUneSerieDePArties();
    }

    private void lancerUneSerieDePArties() {
        int i=1;
       for (PartieIA p : listeParties) {
            System.out.println("\n**************************************************************************************************************************************************************************************************\n"
                    +"**************************************************************************************************************************************************************************************************\n"+
                    "PARTIE "+i+"\n");
            p.lancerPartie(nbToursMax, fichierLire, fichierEcrire, i);
            i++;

       }
    }



}
