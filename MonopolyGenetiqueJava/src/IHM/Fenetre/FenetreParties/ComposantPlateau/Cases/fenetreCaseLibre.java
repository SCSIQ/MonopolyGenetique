package IHM.Fenetre.FenetreParties.ComposantPlateau.Cases;

//importation mise par Jérémy
import IHM.Fenetre.FenetreParties.PasAssezArgent;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.PlateauJeu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneInfoJoueur;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZonePossessions;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//PERMET DE PROPOSER QUE L'UTILISATEUR ACHETE LA CASE SI ELLE EST LIBRE
public class fenetreCaseLibre extends Parent {

    private Canvas canvas;
    private int argentJ;
    private int coutcase;
    private Jeu jeu ;

    public fenetreCaseLibre(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur, Jeu jeu, ZonePossessions poss)
    {
        this.canvas=canvas;
        this.jeu= jeu ;

        Button l = new Button(plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType());

        l.setLayoutY(10);
        l.setLayoutX(10);
        l.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        l.setPrefSize(475,50);
        l.setText(l.getText().toUpperCase());


        Label l_contenu = new Label("\n\nElle n'appartient à personne.\n          Elle coûte "+((Proprietes)automate.getJoueurCourant().getPion().getCase()).getPrix()+" € ");
        l_contenu.setLayoutX(150);
        l_contenu.setLayoutY(40);
        l_contenu.setScaleX(1.5);
        l_contenu.setScaleY(1.5);


        coutcase=((Proprietes)automate.getJoueurCourant().getPion().getCase()).getPrix();
        argentJ=automate.getJoueurCourant().getSolde();

        Color couleurTerrain = Color.WHITE ;
        ///COULEUR DE LA CASE
        if(automate.getJoueurCourant().getPion().getCase() instanceof Terrain) {
            CouleurMétier s = ((Terrain) automate.getJoueurCourant().getPion().getCase()).getCouleur();

            switch (s) {
                case Rose:
                    couleurTerrain = Color.rgb(189, 91, 163);
                    break;
                case Vert:
                    couleurTerrain = Color.rgb(28, 137, 67);
                    break;
                case Orange:
                    couleurTerrain = Color.rgb(234, 157, 34);
                    break;
                case Jaune:
                    couleurTerrain = Color.rgb(239, 233, 50);
                    break;
                case Rouge:
                    couleurTerrain = Color.rgb(224, 30, 37);
                    break;
                case Marron:
                    couleurTerrain = Color.rgb(122, 57, 149);
                    break;
                case BleuFonce:
                    couleurTerrain = Color.rgb(68, 77, 160);
                    break;
                case BleuCiel:
                    couleurTerrain = Color.rgb(9, 172, 227);
                    break;

                default:
                    couleurTerrain = Color.BLACK;
            }
            l.setTextFill(Color.WHITE);
            l.setBackground(new Background(new BackgroundFill(couleurTerrain, null, null)));
        }else{
            l.setBackground(new Background(new BackgroundFill(Color.rgb(247,247,247), null, null)));
        }



        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

//////////////////////////////////////////////////////////////////////////BOUTON
        //ACTION ACHETER
        Button bt_acheter= new Button("ACHETER");

        bt_acheter.setLayoutX(50);
        bt_acheter.setLayoutY(190);

        bt_acheter.setPrefSize(150, 10);

        bt_acheter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                automate.evoluer("acheterPropriete"); //demande à l'automate d'acheter la propriété

                //SI PAS ASSEZ D'ARGENT.
                if(coutcase>argentJ)
                {

                    Stage nouvelle_fenetre_PasAssezArgent= new Stage();
                    PasAssezArgent fenetre_PasAssezArgent = new PasAssezArgent(automate, nouvelle_fenetre_PasAssezArgent, canvas, zoneJoueur, jeu.getZoneAd(), jeu, false);

                    Scene nouvelle_scene = new Scene(fenetre_PasAssezArgent,320,200);

                    nouvelle_fenetre_PasAssezArgent.setScene(nouvelle_scene);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_PasAssezArgent.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_PasAssezArgent.initOwner(fenetre_actuelle);

                    //on ferme la fenêtre
                    fenetre_actuelle.close();

                    //ON MONTRE LA FENETRE !!!!
                    nouvelle_fenetre_PasAssezArgent.show();

                }else{

                    //on rend la bonne opacité à la fenêtre
                    detruireCanvas(canvas);

                    //on efface d'abord la liste pour pas réécrire par deçu
                    poss.effacerPossession();
                    //On affiche les terrains, gares et compagnies achetés
                    poss.afficherTerrain(automate);
                    poss.afficherCompagnie(automate);
                    poss.afficherGare(automate);

                    //met à jour l'argent dans IHM
                    zoneJoueur.SupprimerJoueur();
                    zoneJoueur.genereInfosJoueur(automate);
                    //on ferme la fenêtre
                    fenetre_actuelle.close();

                }


            }
        });

        //ACTION NE RIEN FAIRE
        Button bt_rien= new Button("NE RIEN FAIRE");

        bt_rien.setLayoutX(300);
        bt_rien.setLayoutY(190);

        bt_rien.setPrefSize(150, 10);

        bt_rien.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);

        /////////////////////////////////////////////////////////////////////////AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(l);
        this.getChildren().add(l_contenu);
        this.getChildren().add(bt_acheter);
        this.getChildren().add(bt_rien);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

}
