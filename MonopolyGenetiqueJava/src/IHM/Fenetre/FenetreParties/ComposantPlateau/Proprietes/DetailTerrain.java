package IHM.Fenetre.FenetreParties.ComposantPlateau.Proprietes;

import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.PlateauJeu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.PossessionAdv;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZonePossessions;

import IHM.Fenetre.FenetreParties.Jeu;
import IHM.Plateau.VueCases;
import Metier.Automate.Automate;
import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;

public class DetailTerrain extends Parent {

    private Pane zoneInfosTerrain ;
    private Pane zoneMaisonHotel ;
    private int numBouton ;
    private ZonePossessions poss ;
    private PossessionAdv possAd ;
    private Pane zoneVendre;
    private PlateauJeu pl ;
    private Jeu jeu ;
    private Canvas canvas ;
    private Stage fenetre_detail;
    private Automate automate;

    public DetailTerrain(Automate automate, Stage fenetre_detail , Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton, PossessionAdv possAd, boolean joueurCourant, PlateauJeu pl, Jeu jeu){

        zoneInfosTerrain = new Pane();
        zoneMaisonHotel= new Pane();
        zoneVendre = new Pane();
        this.numBouton= numBouton ;
        this.poss = poss ;
        this.possAd = possAd ;
        this.pl = pl ;
        this.jeu = jeu ;
        this.fenetre_detail = fenetre_detail;
        this.canvas = canvas ;
        this.automate=automate;

         if(joueurCourant==true){

             Button nomTerrain = new Button(poss.getListeTerrains().get(numBouton).toString().toUpperCase());

             nomTerrain.setLayoutY(10);
             nomTerrain.setLayoutX(10);
             nomTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
             nomTerrain.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,null)));
             nomTerrain.setPrefSize(475,50);

            nomTerrain.setTextFill(Color.WHITE);

            //COULEUR
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

            //ajout Couleur de la possession du terrain du joueur
             nomTerrain.setBackground(new Background(new BackgroundFill(couleurTerrain, null, null)));

            //APPEL DES DIFFERNTS PANES
            GenererPanelInfos(automate, true) ;
            GenererPanelMaisonHotel(automate);
            genererPanelVendre(automate);


            //////////////////////////////////////////////////////////////REVENIR AU JEU
            Button bt_ok = new Button("REVENIR AU JEU");

            bt_ok.setLayoutX(180);
            bt_ok.setLayoutY(630);

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

             /////////TAILLE MIN ET MAX DE LA FENETRE
             fenetre_detail.setMinHeight(730);
             fenetre_detail.setMinWidth(515);

             fenetre_detail.setMaxHeight(730);
             fenetre_detail.setMaxWidth(515);

            //AJOUT
             this.getChildren().add(bt_ok);
             this.getChildren().add(nomTerrain);
        }else {
             Button nomTerrain = new Button(possAd.getListeTerrains().get(numBouton).toString().toUpperCase());

             nomTerrain.setLayoutY(10);
             nomTerrain.setLayoutX(10);
             nomTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
             nomTerrain.setBorder(new Border(new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,null,null)));
             nomTerrain.setPrefSize(475,50);

             nomTerrain.setTextFill(Color.WHITE);

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
             nomTerrain.setBackground(new Background(new BackgroundFill(couleurTerrain, null, null)));

            GenererPanelInfos(automate,false ) ;

            Button bt_ok = new Button("REVENIR AU JEU");

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

             /////////TAILLE MIN ET MAX DE LA FENETRE
             fenetre_detail.setMinHeight(410);
             fenetre_detail.setMinWidth(515);

             fenetre_detail.setMaxHeight(410);
             fenetre_detail.setMaxWidth(515);

            //AJOUT
            this.getChildren().add(bt_ok);
            this.getChildren().add(nomTerrain);
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
            Label l_infos = new Label("Loyer terrain nu : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyerSansMaison() + " €\n\n"
                    + "Loyer avec une maison : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer1Maison() + " €\n" +
                    "Loyer avec deux maisons : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer2Maison() + " €\n" +
                    "Loyer avec trois maisons : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer3Maison() + " €\n" +
                    "Loyer avec quatre maisons : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyer4Maison() + " €\n\n" +
                    "Loyer avec un hôtel : " + ((Terrain) possAd.getListeTerrains().get(numBouton)).getLoyerHotel() + " €");
            l_infos.setLayoutY(25);
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
        rect_maison.setHeight(170);
        rect_maison.setWidth(475);
        rect_maison.setX(0);
        rect_maison.setY(0);

        //COULEUR ET CONTOUR
        rect_maison.setFill(Color.TRANSPARENT);
        rect_maison.setStroke(Color.BLACK);

        //Contenu du panel
        Label l_maison = new Label("  VOUS POSSEDEZ "+ poss.getListeTerrains().get(numBouton).getNbTerrainCouleurPossedees()+" TERRAINS DE CETTE COULEUR.\n" +
                                    "POUR CONSTRUIRE, VOUS DEVEZ LES POSSEDER TOUS.");
        l_maison.setLayoutY(10);
        l_maison.setLayoutX(10);
        l_maison.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

        Label l_hotel = new Label("Note : Construire un hôtel = construire une 5eme maison");
        l_hotel.setLayoutY(135);
        l_hotel.setLayoutX(70);
        l_hotel.setFont(Font.font("Verdana", FontWeight.EXTRA_LIGHT, 12));


        Button bt_ConstruireMaison = new Button("CONSTRUIRE UNE MAISON");

        bt_ConstruireMaison.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //DIT AU METIER QU'ON ACHETE UNE MAISON DE PLUS
                //enregistremetn dans l'automate du terrain où l'on veut acheter la maison
                automate.setCasePourAjoutMaison(poss.getListeTerrains().get(numBouton));

               if (poss.getListeTerrains().get(numBouton).getProprioPossedeTouteLaCouleur()==true)
                {
                    automate.evoluer("AcheterMaison"); //ensuite demande à l'automate d'évoluer
                    //on remet à jour l'argent du joueur courant
                    jeu.getZoneJoueur().SupprimerJoueur();
                    jeu.getZoneJoueur().genereInfosJoueur(automate);

                    //Met à jour les adversaires :
                    jeu.getZoneAd().SupprimerAdversaire();
                    jeu.getZoneAd().genererAdversaire(automate, jeu.getFenetrePropri());
                    afficherMaison(automate);
                } else {
                   fenetreDevezAvoirTousTerrains(fenetre_detail, canvas, poss.getListeTerrains().get(numBouton)) ;
               }

           }
        });

        bt_ConstruireMaison.setLayoutX(130);
        bt_ConstruireMaison.setLayoutY(80);
        bt_ConstruireMaison.setPrefSize(220,10);

        zoneMaisonHotel.getChildren().add(l_hotel);
        zoneMaisonHotel.getChildren().add(rect_maison);
        zoneMaisonHotel.getChildren().add(l_maison);
        zoneMaisonHotel.getChildren().add(bt_ConstruireMaison);

        this.getChildren().add(zoneMaisonHotel);
    }



    public void genererPanelVendre(Automate automate)
    {
        zoneVendre.setLayoutX(10);
        zoneVendre.setTranslateY(480);

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_vendre = new Rectangle();
        rect_vendre.setHeight(130);
        rect_vendre.setWidth(475);
        rect_vendre.setX(0);
        rect_vendre.setY(0);

        //COULEUR ET CONTOUR
        rect_vendre.setFill(Color.TRANSPARENT);
        rect_vendre.setStroke(Color.BLACK);

        //Contenu du panel
        Label l_vendre = new Label("Vous pouvez vendre votre terrain pour "+((Terrain)poss.getListeTerrains().get(numBouton)).getPrix()+" € à la banque.");
        l_vendre.setLayoutY(10);
        l_vendre.setLayoutX(40);
        l_vendre.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

        l_vendre.setMaxWidth(400);
        l_vendre.setWrapText(true);
        l_vendre.setTextAlignment(TextAlignment.CENTER);

        Label l_warning = new Label("ATTENTION, CETTE ACTION EST DEFINITIVE !");
        l_warning.setLayoutY(57);
        l_warning.setLayoutX(30);
        l_warning.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        l_warning.setTextFill(Color.RED);

        Button bt_Vendre = new Button("VENDRE");


        bt_Vendre.setLayoutX(170);
        bt_Vendre.setLayoutY(85);
        bt_Vendre.setPrefSize(150,10);

        bt_Vendre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on fait évoluer l'automate

                fenetre_detail.close();
                fenetreVenteMaison(fenetre_detail,canvas);

            }
        });


        zoneVendre.getChildren().add(rect_vendre);
        zoneVendre.getChildren().add(bt_Vendre);
        zoneVendre.getChildren().add(l_vendre);
        zoneVendre.getChildren().add(l_warning);

        this.getChildren().add(zoneVendre);
    }

    private void afficherMaison(Automate automate)
    {
        //Si la case est en bas
        for (int i=0; i<10; i++) {

            if(automate.getCasePourAjoutMaison().getPosition()==i) {

                //Récupère la case pour placer la maison
                VueCases caseMaison = pl.getListeCases().get(automate.getCasePourAjoutMaison().getPosition());

                //AFFICHER MAISON SUIVANT LE NOMBRE DE MAISON

                if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 1) {
                    URL urlMaison = getClass().getResource("images/une_maison_bas.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.setImageMaison(maison);
                    caseMaison.getChildren().add(maison);
                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons()== 2) {

                    //Suppression de la première image

                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/deux_maisons_bas.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison

                    caseMaison.setImageMaison(maison);
                    caseMaison.getChildren().add(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 3) {

                    //Suppression de la première image

                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/trois_maisons_bas.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 4) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/quatre_maisons_bas.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 5) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/hotel_bas.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);
                }
            }

        }

        //Si la case est à gauche
        for (int i=10; i<20; i++) {
            //Récupère la case pour placer la maison
            VueCases caseMaison = pl.getListeCases().get(automate.getCasePourAjoutMaison().getPosition());

            if (automate.getCasePourAjoutMaison().getPosition() ==i) {
                //AFFICHER MAISON SUIVANT LE NOMBRE DE MAISON

                if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 1) {
                    URL urlMaison = getClass().getResource("images/une_maison_gauche.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(-4);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);
                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 2) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/deux_maisons_gauche.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(-4);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons()== 3) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/trois_maisons_gauche.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(-4);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 4) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/quatre_maisons_gauche.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(-4);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 5) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/hotel_gauche.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(-4);
                    maison.setLayoutY(0);

                    maison.setFitWidth(90);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);
                }
            }
        }



        //Si la case est en haut
        for (int i=20; i<30; i++) {
            //Récupère la case pour placer la maison
            VueCases caseMaison = pl.getListeCases().get(automate.getCasePourAjoutMaison().getPosition());
            if (automate.getCasePourAjoutMaison().getPosition() == i) {

                //AFFICHER MAISON SUIVANT LE NOMBRE DE MAISON

                if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 1) {

                    URL urlMaison = getClass().getResource("images/une_maison_haut.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    caseMaison.setImageMaison(maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(-4);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 2) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/deux_maisons_haut.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(-4);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons()== 3) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/trois_maisons_haut.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(-4);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 4) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/quatre_maisons_haut.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(-4);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);
                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 5) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/hotel_haut.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(-4);

                    maison.setFitWidth(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);
                }
            }
        }


        //Si la case est à droite
        for (int i=30; i<40; i++) {
            //Récupère la case pour placer la maison
            VueCases caseMaison = pl.getListeCases().get(automate.getCasePourAjoutMaison().getPosition());
            if (automate.getCasePourAjoutMaison().getPosition() == i) {
                //AFFICHER MAISON SUIVANT LE NOMBRE DE MAISON

                if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons()== 1) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/une_maison_droite.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 2) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/deux_maisons_droite.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 3) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/trois_maisons_droite.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);
                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 4) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/quatre_maisons_droite.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);

                } else if (((Terrain)automate.getCasePourAjoutMaison()).getNbMaisons() == 5) {
                    //Suppression de la première image
                    caseMaison.getChildren().remove(caseMaison.getImageMaison());

                    URL urlMaison = getClass().getResource("images/hotel_droit.png");
                    Image i_maison = new Image(urlMaison.toExternalForm());
                    ImageView maison = new ImageView(i_maison);

                    maison.setLayoutX(0);
                    maison.setLayoutY(0);

                    maison.setFitHeight(50);
                    maison.setPreserveRatio(true);

                    //Ajout de la maison
                    caseMaison.getChildren().add(maison);
                    caseMaison.setImageMaison(maison);
                }
            }
        }

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

    public void fenetreDevezAvoirTousTerrains(Stage fenetre_actuelle, Canvas canvas, Cases cases)
    {
       //jeu.fenetreNoire();

        Stage nouvelle_fenetre_tousTerrains = new Stage();
        FenetreDevezAvoirTousTerrains fenetreTerrains = new FenetreDevezAvoirTousTerrains(nouvelle_fenetre_tousTerrains, canvas, jeu, cases);

        Scene nouvelle_scene = new  Scene(fenetreTerrains,500,270);

        nouvelle_fenetre_tousTerrains.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_tousTerrains.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_tousTerrains.initOwner(fenetre_actuelle);

        nouvelle_fenetre_tousTerrains.show();
    }

    public void fenetreVenteMaison(Stage fenetre_actuelle, Canvas canvas)
    {
        Stage nouvelle_fenetre_tousTerrains = new Stage();
        VentePropriete fenetreTerrains = new VentePropriete(nouvelle_fenetre_tousTerrains, canvas, jeu, automate, numBouton);

        Scene nouvelle_scene = new  Scene(fenetreTerrains,500,270);

        nouvelle_fenetre_tousTerrains.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_tousTerrains.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_tousTerrains.initOwner(jeu.getFenetrePropri());

        nouvelle_fenetre_tousTerrains.show();
    }
}