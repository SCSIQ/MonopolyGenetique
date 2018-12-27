package Metier.Cartes.CartesCaisseDeCommunaute;

import Metier.Automate.Automate;

public class CommunauteReculer extends CaisseDeCommunaute {

    public CommunauteReculer() { super.setTexte("Reculez à la case Avenue Matignon ");
    }
    @Override
    public void agir(Automate automate) {
        //Essai
        if ( 0<=automate.getJoueurCourant().getPion().getCase().getPosition() && automate.getJoueurCourant().getPion().getCase().getPosition()<=21){ //si position est entre 21 et 40
             automate.getJoueurCourant().Avancer(21);

        }else {
            //Passe par la case démarrer donc +1500
            automate.getJoueurCourant().IncrementerSolde(1500);
            automate.getJoueurCourant().Avancer(21 );
        }


        automate.setContenuCartePiochée("Reculez à la case Avenue Matignon");
    }


}
