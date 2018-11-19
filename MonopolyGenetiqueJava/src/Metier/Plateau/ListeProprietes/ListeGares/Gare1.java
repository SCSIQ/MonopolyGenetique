package Metier.Plateau.ListeProprietes.ListeGares;

public class Gare1 extends Gare {

    public Gare1(int position) {
        super(position);
        super.setPrix(2000);
    }

    @Override
    public String toString() {
        return "Gare de Montparmasse";
    }
}
