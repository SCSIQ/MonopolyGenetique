package IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu;

import IHM.Plateau.Fabrique;
import IHM.Plateau.VueCases;
import Metier.Automate.Automate;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;


//CLASSE COMPORTANT LA LISTE DES CASES DU PLATEAU
public class PlateauJeu extends Parent {
    
   private ArrayList<VueCases> listeCases;
   private GraphicsDevice ecran = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice() ;


    // génère le carré délimitant la zone du plateu
    public PlateauJeu(Automate automate)
    {
        this.listeCases= new ArrayList<>();
        Fabrique Fab_Case = new Fabrique();

        for(int i =0; i<automate.getJoueurCourant().getListeCases().size(); i++)
        {

            VueCases c = Fab_Case.FabriqueCase(automate.getJoueurCourant().getListeCases().get(i));
            if(c!= null)
            {
              this.getChildren().add(c);
              listeCases.add(c);
            }


        }
        Rectangle rect_plateau = new Rectangle();
        //TAILLE DU RECTANGLE ET POSITION

        rect_plateau.setHeight(604);
        rect_plateau.setWidth(604);
        rect_plateau.setX(15);
        rect_plateau.setY(110);

        //COULEUR ET CONTOUR
        rect_plateau.setFill(Color.TRANSPARENT);
        rect_plateau.setStroke(Color.BLACK);
        this.getChildren().add(rect_plateau);
    }

    //IMAGE DU CENTRE DU PLATEAU
    public void plateauJeu(){

////////IMAGES
        URL logo_centre = getClass().getResource("Images/logo-centre.png");
        Image image = new Image(logo_centre.toExternalForm());
        ImageView imageView = new ImageView(image);

/////////TAILLE DES IMAGES
        //logo centre
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);

/////////POSITION IMAGE
        //logo centre
        imageView.setX(145);
        imageView.setY(235);
////////AJOUT
        this.getChildren().add(imageView);

    }

    //RETOURNE LA LISTE DES CASES
    //UTILISEE POUR LES PIONS
    public ArrayList<VueCases> getListeCases(){
        return listeCases ;
    }

}
