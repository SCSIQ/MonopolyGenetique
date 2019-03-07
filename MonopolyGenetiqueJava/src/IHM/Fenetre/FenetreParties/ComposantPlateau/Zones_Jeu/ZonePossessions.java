package IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu;


import IHM.Fenetre.FenetreParties.ComposantPlateau.Proprietes.DetailCompagnie;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Proprietes.DetailGare;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Proprietes.DetailTerrain;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeGares.Gare;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.ServicePublic;
import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ZonePossessions extends Parent {

    //private GraphicsDevice ecran = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice() ;
    private Pane zoneTerrain ;
    private Pane zoneCompagnie ;
    private Pane zoneGare ;

    private ZoneAdversaires ad;

    private ArrayList<Gare> listeGares ;
    private ArrayList<Terrain> listeTerrains ;
    private ArrayList<Button> boutonsCompagnie ;
    private ArrayList<Button> boutonsTerrains ;
    private ArrayList<Button> boutonsGares ;

    private ArrayList<Label> listeGaresLabel ;
    private ArrayList<Label> listeTerrainsLabel ;
    private ArrayList<Label> listeCompagniesLabel ;
    private ArrayList<Rectangle> listeCouleur ;

    private Stage fenetre_actuelle;
    private Canvas canvas;
    private Automate automate;
    private Jeu jeu ;
    private PlateauJeu pl ;


    public ZonePossessions(Automate automate, Stage fenetre_actuelle, Canvas canvas, Jeu jeu, ZoneAdversaires ad, PlateauJeu pl)
    {
        this.jeu = jeu ;
        this.automate = automate ;
        this.canvas= canvas ;
        this.fenetre_actuelle = fenetre_actuelle;
        this.ad = ad ;
        this.pl = pl ;

        zoneTerrain = new Pane() ;
        zoneCompagnie = new Pane() ;
        zoneGare = new Pane() ;
        listeCompagnies = new ArrayList<>();
        listeGares = new ArrayList<>();
        listeTerrains = new ArrayList<>();
        boutonsCompagnie = new ArrayList<>();
        boutonsGares = new ArrayList<>();
        boutonsTerrains = new ArrayList<>();
        listeCompagniesLabel = new ArrayList<>();
        listeTerrainsLabel = new ArrayList<>();
        listeGaresLabel = new ArrayList<>();

        listeCouleur = new ArrayList<>() ;

        //Ajout d'un label "POSSESSION"
        Label textPossession = new Label("VOS POSSESSIONS");
        textPossession.setLayoutX(860);
        textPossession.setLayoutY(290);
        textPossession.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(textPossession);

        Rectangle rect_possession = new Rectangle();
        //TAILLE DU RECTANGLE ET POSITION

        rect_possession.setHeight(429);
        rect_possession.setWidth(630);
        rect_possession.setX(630);
        rect_possession.setY(285);

        //COULEUR ET CONTOUR
        rect_possession.setFill(Color.TRANSPARENT);
        rect_possession.setStroke(Color.BLACK);
        this.getChildren().add(rect_possession);
    }

    public void RectangleTerrain(Automate automate){

       //////////////////////UN PANEL POUR LA ZONE TERRAIN

        //int height = ecran.getDisplayMode().getHeight();
        //int width = ecran.getDisplayMode().getWidth();

        zoneTerrain.setLayoutX(635);
        zoneTerrain.setLayoutY(315);

       // this.afficherTerrain(automate);

        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(120);
        textTerrain.setLayoutY(10);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        Rectangle rect_terrain = new Rectangle();
        rect_terrain.setHeight(390);
        rect_terrain.setWidth(305);
        rect_terrain.setX(0);
        rect_terrain.setY(0);



        //COULEUR ET CONTOUR
        rect_terrain.setFill(Color.TRANSPARENT);
        rect_terrain.setStroke(Color.BLACK);

        zoneTerrain.getChildren().add(rect_terrain);
        zoneTerrain.getChildren().add(textTerrain);
        this.getChildren().add(zoneTerrain);

    }

    public void RectangleGare(Automate automate){

        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(120);
        textGare.setLayoutY(10);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        ///////////////////////UN PANEL POUR LA ZONE GARE

        //int height = ecran.getDisplayMode().getHeight();
        // int width = ecran.getDisplayMode().getWidth();

        zoneGare.setLayoutX(950);
        zoneGare.setLayoutY(315);

       // this.afficherGare(automate);

        //TAILLE DU RECTANGLE ET POSITION

        Rectangle rect_gare  = new Rectangle();
        rect_gare.setWidth(305);
        rect_gare.setHeight(160);
        rect_gare.setX(0);
        rect_gare.setY(0);

        //COULEUR ET CONTOUR
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);

        zoneGare.getChildren().add(textGare);
        zoneGare.getChildren().add(rect_gare);
        this.getChildren().add(zoneGare);
    }



    public void RectangleCompagnies(Automate automate){

        //Ajout d'un label "COMPAGNIES"
        Label textCompagnies = new Label("COMPAGNIES");
        textCompagnies.setLayoutX(100);
        textCompagnies.setLayoutY(10);
        textCompagnies.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

//////////////////////PANEL POUR LA ZONE COMPAGNIE
        //int height = ecran.getDisplayMode().getHeight();
        //int width = ecran.getDisplayMode().getWidth();

        zoneCompagnie.setLayoutX(950);
        zoneCompagnie.setLayoutY(490);

        //this.afficherCompagnie(automate);
        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_compagnie = new Rectangle();
        rect_compagnie.setHeight(110);
        rect_compagnie.setWidth(305);
        rect_compagnie.setX(0);
        rect_compagnie.setY(0);

        //COULEUR ET CONTOUR
        rect_compagnie.setFill(Color.TRANSPARENT);
        rect_compagnie.setStroke(Color.BLACK);



        zoneCompagnie.getChildren().add(rect_compagnie);
        zoneCompagnie.getChildren().add(textCompagnies);
        this.getChildren().add(zoneCompagnie);
    }

    public void RectangleCartePrison(){

        //Ajout d'un label "Vous êtes libéré de prison"
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" : "+automate.getJoueurCourant().getNbCartesLibereDePrison());
        textPrison.setLayoutX(1000);
        textPrison.setLayoutY(620);
        textPrison.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 12));
        this.getChildren().add(textPrison);

////////////////////CREATION D'UN PANEL POUR LA ZONE Prison
        /*Pane zonePrison = new Pane() ;
        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        zonePrison.setLayoutX(950);
        zonePrison.setLayoutY(545);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zonePrison.setPrefSize(width*0.22,height*0.1);
        zonePrison.setBorder(border1);

        zonePrison.getChildren().add(textPrison);
        this.getChildren().add(zonePrison);*/


        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_cartePrison = new Rectangle();
        rect_cartePrison.setHeight(50);
        rect_cartePrison.setWidth(305);
        rect_cartePrison.setX(950);
        rect_cartePrison.setY(605);

        //COULEUR ET CONTOUR
        rect_cartePrison.setFill(Color.TRANSPARENT);
        rect_cartePrison.setStroke(Color.BLACK);
        this.getChildren().add(rect_cartePrison);
}




    public void afficherTerrain(Automate automate)
    {
        int y = 0 ;
        int j = 0 ;
        for(int i =0 ; i<automate.getJoueurCourant().getListePropietes().size(); i++)
        {
            if(automate.getJoueurCourant().getListePropietes().get(i) instanceof Terrain){
                Label terrain = new Label(""+automate.getJoueurCourant().getListePropietes().get(i).toString()+"\n");
                terrain.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                terrain.setLayoutX(50);
                terrain.setLayoutY(40+y);
                Terrain ter = (Terrain) automate.getJoueurCourant().getListePropietes().get(i);


                CouleurMétier s = ((Terrain)automate.getJoueurCourant().getListePropietes().get(i)).getCouleur();
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
                r_couleur.setHeight(20);
                r_couleur.setWidth(20);
                r_couleur.setLayoutX(10);
                r_couleur.setLayoutY(37+y);
                r_couleur.setStroke(Color.BLACK);
                r_couleur.setStrokeWidth(1);
                r_couleur.setFill(couleurTerrain);
                zoneTerrain.getChildren().add(r_couleur);

                //Bouton détail
                Button bt_detail = new Button("DETAILS");
                bt_detail.setBackground(new Background(new BackgroundFill(Color.rgb(239,239,239), null, null)));
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setLayoutX(225);
                bt_detail.setLayoutY(37+y);

                boutonsTerrains.add(j, bt_detail);
                listeTerrainsLabel.add(terrain);
                listeCouleur.add(r_couleur);


                this.appuieBoutonTerrain(bt_detail, j);

                listeTerrains.add(ter);
                zoneTerrain.getChildren().add(terrain);
                zoneTerrain.getChildren().add(bt_detail);
                y+=30 ;
                j++ ;
            }


        }
    }

    public void afficherGare(Automate automate)
    {
        int y = 0 ;
        int j = 0;
        for(int i =0 ; i<automate.getJoueurCourant().getListePropietes().size(); i++)
        {
            if(automate.getJoueurCourant().getListePropietes().get(i) instanceof Gare){
                Label gare = new Label(""+automate.getJoueurCourant().getListePropietes().get(i).toString()+"\n");
                gare.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                gare.setLayoutX(15);
                gare.setLayoutY(37+y);

                Button bt_detail = new Button("DETAILS") ;
                bt_detail.setBackground(new Background(new BackgroundFill(Color.rgb(239,239,239), null, null)));
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setLayoutX(215);
                bt_detail.setLayoutY(33+y);

                boutonsGares.add(j, bt_detail);
                listeGaresLabel.add(gare);

                Gare gares = (Gare) automate.getJoueurCourant().getListePropietes().get(i);

                this.appuieBoutonGare(bt_detail, j);


                zoneGare.getChildren().add(bt_detail);
                listeGares.add(gares);
                zoneGare.getChildren().add(gare);
                y+=30 ;
                j++ ;
            }


        }
    }

    public void afficherCompagnie(Automate automate)
    {
        int y = 0 ;
        int j =0;
        for(int i =0 ; i<automate.getJoueurCourant().getListePropietes().size(); i++)
        {
            if(automate.getJoueurCourant().getListePropietes().get(i) instanceof ServicePublic){

                Label compagnie = new Label(""+automate.getJoueurCourant().getListePropietes().get(i).toString()+"\n");
                compagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                ServicePublic compa = (ServicePublic) automate.getJoueurCourant().getListePropietes().get(i);

                compagnie.setLayoutX(15);
                compagnie.setLayoutY(37+y);

                Button bt_detail = new Button("DETAILS") ;
                bt_detail.setBackground(new Background(new BackgroundFill(Color.rgb(239,239,239), null, null)));
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setLayoutX(215);
                bt_detail.setLayoutY(33+y);

                boutonsCompagnie.add(j, bt_detail);
                listeCompagniesLabel.add(compagnie);

                this.appuieBoutonCompagnie(bt_detail, j);
                listeCompagnies.add(compa);

                zoneCompagnie.getChildren().add(compagnie);
                zoneCompagnie.getChildren().add(bt_detail);
                y+=30 ;
                j++ ;
            }

        }
    }

    public void effacerPossession()
    {
        zoneCompagnie.getChildren().removeAll(listeCompagniesLabel);
        listeCompagnies= null ;
        listeCompagnies= new ArrayList<>() ;
        zoneCompagnie.getChildren().removeAll(boutonsCompagnie);

        zoneTerrain.getChildren().removeAll(listeTerrainsLabel);
        zoneTerrain.getChildren().removeAll(boutonsTerrains);
        listeTerrains= null ;
        listeTerrains= new ArrayList<>() ; ;

        zoneGare.getChildren().removeAll(listeGaresLabel);
        zoneGare.getChildren().removeAll(boutonsGares);
        listeGares = null ;
        listeGares = new ArrayList<>() ;

        zoneTerrain.getChildren().removeAll(listeCouleur);

    }


    //si on appuie sur un boutons Détails sur terrains
    public void appuieBoutonTerrain(Button b, int numBouton)
    {
        b.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               fenetreDetailTerrain(fenetre_actuelle, automate, numBouton);
           }
        });
    }


    //si on appuie sur un boutons Détails sur compagnie
    public void appuieBoutonCompagnie(Button b, int i )
    {

            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    fenetreDetailCompagnie(fenetre_actuelle, automate, i);

                }
            });


    }

    //si on appuie sur un boutons Détails sur gare
    public void appuieBoutonGare(Button b, int i )
    {
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    fenetreDetailGare(fenetre_actuelle, automate, i);
                }

            });

    }


    public void fenetreDetailTerrain(Stage fenetre_actuelle, Automate automate, int numBouton)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_detail = new Stage();
        DetailTerrain fenetreDetail = new DetailTerrain(automate,nouvelle_fenetre_detail, fenetre_actuelle, canvas, this, numBouton, ad.getPossAd(), true, pl, jeu);

        Scene nouvelle_scene = new  Scene(fenetreDetail,500,700);

        nouvelle_fenetre_detail.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_detail.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_detail.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_detail.show();
    }


    public void fenetreDetailGare(Stage fenetre_actuelle, Automate automate, int numBouton)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_detail = new Stage();
        DetailGare fenetreDetail = new DetailGare(automate,nouvelle_fenetre_detail, fenetre_actuelle, canvas, this, numBouton, ad.getPossAd(), true);

        Scene nouvelle_scene = new  Scene(fenetreDetail,500,700);

        nouvelle_fenetre_detail.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_detail.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_detail.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_detail.show();
    }

    public void fenetreDetailCompagnie(Stage fenetre_actuelle, Automate automate, int numBouton)
    {
        jeu.fenetreNoire();

        Stage nouvelle_fenetre_detail = new Stage();
        DetailCompagnie fenetreDetail = new DetailCompagnie(automate,nouvelle_fenetre_detail, fenetre_actuelle, canvas, this, numBouton, ad.getPossAd(), true);

        Scene nouvelle_scene = new  Scene(fenetreDetail,500,700);

        nouvelle_fenetre_detail.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_detail.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_detail.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_detail.show();
    }



    private ArrayList<ServicePublic> listeCompagnies ;

    public ArrayList<ServicePublic> getListeCompagnies() {
        return listeCompagnies;
    }

    public ArrayList<Gare> getListeGares() {
        return listeGares;
    }

    public ArrayList<Terrain> getListeTerrains() {
        return listeTerrains;
    }

}