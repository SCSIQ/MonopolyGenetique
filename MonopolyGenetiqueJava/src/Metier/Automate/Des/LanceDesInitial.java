package Metier.Automate.Des;
import java.util.Random;

public class LanceDesInitial {

    public void LancerDes () {
        int de1;
        int de2;
        Random toto = new Random();

        de1=toto.nextInt(6)+1;
        de2=toto.nextInt(6)+1;
//
        System.out.println("Dé1 : "+de1);
        System.out.println("Dé2 : "+de2);
    }

}
