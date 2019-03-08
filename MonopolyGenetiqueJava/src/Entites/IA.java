package Entites;

import Metier.PartiesIA.CentreDecision;
import Metier.PartiesIA.CritereIA;
import Metier.Plateau.Cases;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

public class IA extends Joueur {

    private CentreDecision DM;
    private HashMap<CritereIA, Double> poids = new HashMap<CritereIA,Double>();


    public CentreDecision getDM() {
        return DM;
    }

    public void setDM(CentreDecision DM) {
        this.DM = DM;
    }

    public IA(ArrayList<Cases> listeCases, Color couleur, CentreDecision DM) {
        super(listeCases, couleur);
        setDM(DM);
    }

    public IA(IA pere, IA mere)
    {

    }

}
