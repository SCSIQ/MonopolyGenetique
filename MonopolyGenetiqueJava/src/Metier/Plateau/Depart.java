package Metier.Plateau;

public class Depart extends Cases  {

    public Depart(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "Départ";
    }

    /*chaque joueur qui passe sur la case départ gagne 1 5000€ */
}
