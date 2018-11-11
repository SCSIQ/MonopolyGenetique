package Metier.Plateau.ListeProprietes.ListeGares;

public class Gare2 extends Gare {

    public Gare2() {
        super(15);
        super.setPrix(2000);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Gare de Lyon";
    }
}
