package Metier.Plateau.ListeProprietes.ListeServicesPublics;

import Metier.Plateau.ListeProprietes.Proprietes;

public abstract class ServicePublic extends Proprietes {

    protected int loyer = 200;

    public ServicePublic(int position) {
        super(position);
        super.setPrix(15000);
        super.setPrixHypotheque(0);
    }

    public int getLoyer() {

        //ici coder le fait que le loyer dépend du nombre de service public que possède le joueur
        //ainsi que du résultat des dès du joueur devant payer le loyer

        return loyer;
    }
}
