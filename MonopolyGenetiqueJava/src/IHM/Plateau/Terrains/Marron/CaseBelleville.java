package IHM.Plateau.Terrains.Marron;

import IHM.Plateau.Terrain;
import Metier.Plateau.Cases;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;

//CASE BELLEVILLE
public class CaseBelleville extends Terrain {

    private ImageView imageBelleville ;

    public CaseBelleville(Cases caseMetier)
    {
        super(caseMetier);
        ////////CASE BELLEVILLE

        //dimension du panel

        this.setLayoutX(484);
        this.setLayoutY(628);

        //creation de l'image
        URL belleville = getClass().getResource("Images/Case_Belleville.png");
        Image i_Belleville = new Image(belleville.toExternalForm());
        imageBelleville = new ImageView(i_Belleville);

        //taille de l'image
        imageBelleville.setFitWidth(48);
        imageBelleville.setPreserveRatio(true);
        //ajout au panel de l'image et ajout du panel dans le jeu
        this.getChildren().add(imageBelleville);
        getListeCases().add(this);

    }

    @Override
    public void setListeCases(Pane p) {

    }

    @Override
    public String getType() {
        return "Belleville";
    }
}
