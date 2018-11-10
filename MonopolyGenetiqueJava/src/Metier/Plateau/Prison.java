package Metier.Plateau;

public class Prison extends Cases  {

    public Prison() {
        super(10);
    }

    @Override
    public int getPosition() {
        return super.position;
    }

    @Override
    public String toString() {
        return "Prison";
    }
}
