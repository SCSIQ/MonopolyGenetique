package Metier.Plateau.ListeProprietes.ListeGares;

public class Gare1 extends Gare {

    public Gare1() {
        super(5);
        super.setPrix(2000);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Gare de Montparmasse";
    }
}
