package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.ZonePossessions;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DetailTerrain extends Parent {

    private Pane zoneInfosTerrain ;
    private int numBouton ;

    public DetailTerrain(Automate automate,Stage fenetre_detail ,Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton){

        zoneInfosTerrain = new Pane() ;
        this.numBouton= numBouton ;

        Label nomTerrain = new Label(poss.getListeTerrains().get(numBouton).getText().toUpperCase()+"");

        nomTerrain.setLayoutY(20);
        nomTerrain.setLayoutX(10);
        nomTerrain.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));


        GenererPanelInfos(automate ) ;

        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_detail.setMinHeight(700);
        fenetre_detail.setMinWidth(500);

        fenetre_detail.setMaxHeight(500);
        fenetre_detail.setMaxWidth(700);



        //AJOUT
        this.getChildren().add(nomTerrain);
    }

    public void GenererPanelInfos(Automate automate){

        zoneInfosTerrain.setLayoutX(10);
        zoneInfosTerrain.setLayoutY(80);

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_infos = new Rectangle();
        rect_infos.setHeight(200);
        rect_infos.setWidth(475);
        rect_infos.setX(0);
        rect_infos.setY(0);

        //COULEUR ET CONTOUR
        rect_infos.setFill(Color.TRANSPARENT);
        rect_infos.setStroke(Color.BLACK);

        //Contenu du panel
        Label l_infos = new Label("Loyer terrain nu : "+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).getLoyerSansMaison()+" €\n" +
                                       "Loyer avec une maison : "+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).getLoyer1Maison()+" €\n"+
                                       "Loyer avec deux maisons : "+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).getLoyer2Maison()+" €\n"+
                                       "Loyer avec trois maisons : "+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).getLoyer3Maison()+" €\n"+
                                       "Loyer avec quatre maisons : "+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).getLoyer4Maison()+" €\n"+
                                       "Loyer avec un hôtel : "+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).getLoyerHotel()+" €\n\n"+
                                       "Prix Maison : "+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).getPrixAjoutMaison()+" €\n"+
                                       "Prix Hôtel : "); //+((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton)).get()+" €");
        l_infos.setLayoutY(10);
        l_infos.setLayoutX(10);
        l_infos.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));

        zoneInfosTerrain.getChildren().add(rect_infos);
        zoneInfosTerrain.getChildren().add(l_infos);

        this.getChildren().add(zoneInfosTerrain);
    }
}
