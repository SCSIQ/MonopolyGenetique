package Metier.Plateau;

public class ParcGratuit extends Cases {

    private int argent = 0;

    public ParcGratuit(int position) {
        super(position);
    }

    @Override
    public String toString() {
        return "ParcGratuit";
    }

    /**
     * cette méthode retourne la somme du parc gratuit et le vide
     * @return la somme se trouvant dans le parc gratuit avant de le vider
     */
    public int recupererArgent() {
        int toReturn = this.argent;
        this.argent = 0;
        return toReturn;
    }

    public void verserARgent(int somme) {
        this.argent += somme;
    }

    public int getArgantDansParc() {
        return argent;
    }
}
