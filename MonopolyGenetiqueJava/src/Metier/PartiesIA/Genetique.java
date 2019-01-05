package Metier.PartiesIA;

import java.util.ArrayList;
import Metier.PartiesIA.CentreDecision;


public class Genetique{

    private ArrayList<CentreDecision> listDM = new ArrayList<>();

    public void setListDM(ArrayList<CentreDecision> listDM) {
        this.listDM = listDM;
    }

    public ArrayList<CentreDecision> getListDM() {
        return listDM;
    }

    public Genetique(int nbIA, int nbMut) {

        creationDM(nbIA);

    }

    private void creationDM(int nbIA)
    {
        for(int i=0;i<nbIA;i++)
        {
            listDM.add(new CentreDecision());
        }
    }


}
