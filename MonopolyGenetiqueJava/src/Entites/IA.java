package Entites;

import Metier.PartiesIA.CentreDecision;
import Metier.Plateau.Cases;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class IA extends Joueur {

    private CentreDecision DM;

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

}
