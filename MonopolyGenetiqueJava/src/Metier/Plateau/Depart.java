package Metier.Plateau;

public class Depart extends Cases  {

    public Depart() {
        super(0); //case en position 0
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Départ";
    }
}
