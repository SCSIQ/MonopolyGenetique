package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Entites.Joueur;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.ServicePublic;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class fenetreCasePossedee extends Parent  {

    private Canvas canvas ;

    public fenetreCasePossedee(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur, Jeu jeu, ZonePossessions poss){

        this.canvas = canvas ;
        Joueur j=null ;
        int prixAPayer=0;
        if(automate.getJoueurCourant().getPion().getCase() instanceof  Terrain){
            prixAPayer =((Terrain)automate.getJoueurCourant().getPion().getCase()).getLoyerSansMaison();
            j =((Terrain)automate.getJoueurCourant().getPion().getCase()).getProprio();

        }else if(automate.getJoueurCourant().getPion().getCase() instanceof ServicePublic){
            prixAPayer =((ServicePublic)automate.getJoueurCourant().getPion().getCase()).getLoyer();
            j =((ServicePublic)automate.getJoueurCourant().getPion().getCase()).getProprio();
        }

        Label l = new Label("Vous êtes sur la case :\n"+plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType()+
                "\n\nElle appartient au joueur "+j.getNom()+".\n\nVous lui devez "+prixAPayer+" € ");
        l.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l.setLayoutX(170);
        l.setLayoutY(50);

        l.setScaleX(2);
        l.setScaleY(2);

        ////////////////////////////BOUTON
        //ACTION PAYER
        Button bt_payer= new Button("PAYER");

        bt_payer.setLayoutX(175);
        bt_payer.setLayoutY(210);

        bt_payer.setPrefSize(150, 10);

        bt_payer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(520);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(520);

//////////////////////AJOUT
        this.getChildren().add(bt_payer);
        this.getChildren().add(l);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

}
