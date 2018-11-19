package Metier.Plateau.ListeProprietes.ListeGares;

public class Gare2 extends Gare {

    public Gare2(int position) {
        super(position);
        super.setPrix(2000);
    }

    @Override
    public String toString() {
        return "Gare de Lyon";
    }
}
