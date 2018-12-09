package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.PossessionAdv;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZonePossessions;

import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DetailTerrain extends Parent {

    private Pane zoneInfosTerrain ;
    private Pane zoneMaisonHotel ;
    private int numBouton ;
    private ZonePossessions poss ;
    private PossessionAdv possAd ;

    public DetailTerrain(Automate automate, Stage fenetre_detail , Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton, PossessionAdv possAd, boolean joueurCourant){

        zoneInfosTerrain = new Pane();
        zoneMaisonHotel= new Pane();
        this.numBouton= numBouton ;
        this.poss = poss ;
        this.possAd = possAd ;

        if(joueurCourant==true){
            Label nomTerrain = new Label(poss.getListeTerrains().get(numBouton).toString().toUpperCase()+"");

            /////////TAILLE MIN ET MAX DE LA FENETRE
            fenetre_detail.setMinHeight(700);
            fenetre_detail.setMinWidth(500);

            fenetre_detail.setMaxHeight(500);
            fenetre_detail.setMaxWidth(700);


            nomTerrain.setLayoutY(20);
            nomTerrain.setLayoutX(80);
            nomTerrain.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));

            CouleurMétier s =poss.getListeTerrains().get(numBouton).getCouleur();
            Color couleurTerrain ;
            switch(s){
                case Rose : couleurTerrain = Color.rgb(189,91,163);
                    break ;
                case Vert: couleurTerrain = Color.rgb(28,137,67);
                    break ;
                case Orange: couleurTerrain = Color.rgb(234,157,34);
                    break ;
                case Jaune: couleurTerrain = Color.rgb(239,233,50);
                    break ;
                case Rouge: couleurTerrain = Color.rgb(224,30,37);
                    break ;
                case Marron: couleurTerrain = Color.rgb(122,57,149);
                    break ;
                case BleuFonce:  couleurTerrain = Color.rgb(68,77,160);
                    break;
                case BleuCiel: couleurTerrain = Color.rgb(9,172,227);
                    break ;

                default : couleurTerrain=Color.BLACK;
            }

            //ajout Couleur du joueur
            Rectangle r_couleur = new Rectangle();
            r_couleur.setHeight(50);
            r_couleur.setWidth(50);
            r_couleur.setLayoutX(10);
            r_couleur.setLayoutY(10);
            r_couleur.setStroke(Color.BLACK);
            r_couleur.setStrokeWidth(1);
            r_couleur.setFill(couleurTerrain);

            GenererPanelInfos(automate, true) ;
            GenererPanelMaisonHotel(automate);

            Button bt_ok = new Button("revenir au jeu");

            bt_ok.setLayoutX(180);
            bt_ok.setLayoutY(530);

            bt_ok.setPrefSize(150, 10);

            bt_ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //on rend la bonne opacité à la fenêtre
                    detruireCanvas(canvas);

                    //on ferme la fenêtre
                    fenetre_detail.close();
                }
            });

            //AJOUT
            this.getChildren().add(bt_ok);
            this.getChildren().add(nomTerrain);
            this.getChildren().add(r_couleur);
        }else {
            Label nomTerrain = new Label(possAd.getListeTerrains().get(numBouton).toString().toUpperCase()+"") ;

            /////////TAILLE MIN ET MAX DE LA FENETRE
            fenetre_detail.setMinHeight(400);
            fenetre_detail.setMinWidth(500);

            fenetre_detail.setMaxHeight(400);
            fenetre_detail.setMaxWidth(700);


            nomTerrain.setLayoutY(20);
            nomTerrain.setLayoutX(80);
            nomTerrain.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));

            CouleurMétier s =possAd.getListeTerrains().get(numBouton).getCouleur();
            Color couleurTerrain ;
            switch(s){
                case Rose : couleurTerrain = Color.rgb(189,91,163);
                    break ;
                case Vert: couleurTerrain = Color.rgb(28,137,67);
                    break ;
                case Orange: couleurTerrain = Color.rgb(234,157,34);
                    break ;
                case Jaune: couleurTerrain = Color.rgb(239,233,50);
                    break ;
                case Rouge: couleurTerrain = Color.rgb(224,30,37);
                    break ;
                case Marron: couleurTerrain = Color.rgb(122,57,149);
                    break ;
                case BleuFonce:  couleurTerrain = Color.rgb(68,77,160);
                    break;
                case BleuCiel: couleurTerrain = Color.rgb(9,172,227);
                    break ;

                default : couleurTerrain=Color.BLACK;
            }

            //ajout Couleur du joueur
            Rectangle r_couleur = new Rectangle();
            r_couleur.setHeight(50);
            r_couleur.setWidth(50);
            r_couleur.setLayoutX(10);
            r_couleur.setLayoutY(10);
            r_couleur.setStroke(Color.BLACK);
            r_couleur.setStrokeWidth(1);
            r_couleur.setFill(couleurTerrain);

            GenererPanelInfos(automate,false ) ;

            Button bt_ok = new Button("revenir au jeu");

            bt_ok.setLayoutX(180);
            bt_ok.setLayoutY(300);

            bt_ok.setPrefSize(150, 10);

            bt_ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //on rend la bonne opacité à la fenêtre
                    detruireCanvas(canvas);

                    //on ferme la fenêtre
                    fenetre_detail.close();
                }
            });

            //AJOUT
            this.getChildren().add(bt_ok);
            this.getChildren().add(nomTerrain);
            this.getChildren().add(r_couleur);
        }




        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_detail.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });


    }

    public void GenererPanelInfos(Automate automate, boolean joueurCourant){

        zoneInfosTerrain.setLayoutX(10);
        zoneInfosTerrain.setLayoutY(80);

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_infos = new Rectangle();
        rect_infos.setHeight(200);
        rect_infos.setWidth(475);
        rect_infos.setX(0);
        rect_infos.setY(0);
        //((Terrain)automate.getJoueurCourant().getListePropietes().get(numBouton))

        //COULEUR ET CONTOUR
        rect_infos.setFill(Color.TRANSPARENT);
        rect_infos.setStroke(Color.BLACK);

        if(joueurCourant==true) {


            //Contenu du panel
            Label l_infos = new Label("Loyer terrain nu : " + ((Terrain) poss.getListeTerrains().get(numBouton)).getLoyerSansMaison() + " €\n"
                    + "Loyer avec une maison : " + ((Terrain) poss.getListeTerrains().get(numBouton)).getLoyer1Maison() + " €\n" +
                    "Loyer avec deux maisons : " + ((Terrain) poss.getListeTerrains().get(numBouton)).getLoyer2Maison() + " €\n" +
                    "Loyer avec trois maisons : " + ((Terrain) poss.getListeTerrains().get(numBouton)).getLoyer3Maison() + " €\n" +
                    "Loyer avec quatre maisons : " + ((Terrain) poss.getListeTerrains().get(numBouton)).getLoyer4Maison() + " €\n" +
                    "Loyer avec un hôtel : " + ((Terrain) poss.getListeTerrains().get(numBouton)).getLoyerHotel() + " €\n\n" +
                    "Prix Maison : " + ((Terrain) poss.getListeTerrains().get(numBouton)).getPrixAjoutMaison() + " €\n" +
                    "Prix Hôtel :" + ((Terrain) poss.getListeTerrains().get(numBouton)).getPrixAjoutMaison() + " €");
            l_infos.setLayoutY(10);
            l_infos.setLayoutX(10);
            l_infos.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));

            zoneInfosTerrain.getChildren().add(rect_infos);
            zoneInfosTerrain.getChildren().add(l_infos);

            this.getChildren().add(zoneInfosTerrain);
        } else {
            //Contenu du panel
            Label l_infos = new Label("Loyer terrain nu : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyerSansMaison() + " €\n"
                    + "Loyer avec une maison : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer1Maison() + " €\n" +
                    "Loyer avec deux maisons : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer2Maison() + " €\n" +
                    "Loyer avec trois maisons : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer3Maison() + " €\n" +
                    "Loyer avec quatre maisons : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer4Maison() + " €\n" +
                    "Loyer avec un hôtel : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyerHotel() + " €\n\n" +
                    "Prix Maison : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getPrixAjoutMaison() + " €\n" +
                    "Prix Hôtel :" + ((Terrain) possAd.getListeTerrains().get(numBouton)).getPrixAjoutMaison() + " €");
            l_infos.setLayoutY(10);
            l_infos.setLayoutX(10);
            l_infos.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));

            zoneInfosTerrain.getChildren().add(rect_infos);
            zoneInfosTerrain.getChildren().add(l_infos);

            this.getChildren().add(zoneInfosTerrain);
        }
    }

    public void GenererPanelMaisonHotel(Automate automate){
        zoneMaisonHotel.setLayoutX(10);
        zoneMaisonHotel.setLayoutY(300);

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_maison = new Rectangle();
        rect_maison.setHeight(200);
        rect_maison.setWidth(475);
        rect_maison.setX(0);
        rect_maison.setY(0);

        //COULEUR ET CONTOUR
        rect_maison.setFill(Color.TRANSPARENT);
        rect_maison.setStroke(Color.BLACK);

        //Contenu du panel
        Label l_maison = new Label("VOUS POSSEDEZ X/3 TERRAINS DE CETTE COULEUR.\n" +
                                    "POUR CONSTRUIRE, VOUS DEVEZ POSSEDER LES 3.");
        l_maison.setLayoutY(30);
        l_maison.setLayoutX(10);
        l_maison.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

        Button bt_ConstruireMaison = new Button("CONSTRUIRE UNE\n       MAISON");
        Button bt_ConstruireHotel = new Button("CONSTRUIRE UN\n        HOTEL");

        bt_ConstruireHotel.setLayoutX(300);
        bt_ConstruireHotel.setLayoutY(125);

        bt_ConstruireMaison.setLayoutX(25);
        bt_ConstruireMaison.setLayoutY(125);

        zoneMaisonHotel.getChildren().add(rect_maison);
        zoneMaisonHotel.getChildren().add(l_maison);
        zoneMaisonHotel.getChildren().add(bt_ConstruireHotel);
        zoneMaisonHotel.getChildren().add(bt_ConstruireMaison);

        this.getChildren().add(zoneMaisonHotel);
    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
