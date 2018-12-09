package IHM.Fenetre.FenetreParties.ComposantPlateau;


import IHM.Fenetre.FenetreParties.DetailTerrain;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.ListeGares.Gare;
import Metier.Plateau.ListeProprietes.ListeServicesPublics.ServicePublic;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ZonePossessions extends Parent {

    //private GraphicsDevice ecran = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice() ;
    private Pane zoneTerrain ;
    private Pane zoneCompagnie ;
    private Pane zoneGare ;

    private ArrayList<Gare> listeGares ;
    private ArrayList<Terrain> listeTerrains ;
    private ArrayList<Button> boutonsCompagnie ;
    private ArrayList<Button> boutonsTerrains ;
    private ArrayList<Button> boutonsGares ;

    private ArrayList<Label> listeGaresLabel ;
    private ArrayList<Label> listeTerrainsLabel ;
    private ArrayList<Label> listeCompagniesLabel ;

    private Stage fenetre_actuelle;
    private Canvas canvas;
    private Automate automate;
    private Jeu jeu ;

   // private int numBouton=0;

    public ZonePossessions(Automate automate, Stage fenetre_actuelle, Canvas canvas, Jeu jeu)
    {
        this.jeu = jeu ;
        this.automate = automate ;
        this.canvas= canvas ;
        this.fenetre_actuelle = fenetre_actuelle;

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
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" :");
        textPrison.setLayoutX(1000);
        textPrison.setLayoutY(610);
        textPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
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
        for(int i =0 ; i<automate.getJoueurCourant().getListePropietes().size(); i++)
        {
            if(automate.getJoueurCourant().getListePropietes().get(i) instanceof Terrain){
                Label terrain = new Label(""+automate.getJoueurCourant().getListePropietes().get(i).toString()+"\n");
                terrain.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                terrain.setLayoutX(10);
                terrain.setLayoutY(30+y);
                Terrain ter = (Terrain) automate.getJoueurCourant().getListePropietes().get(i);

                Button bt_detail = new Button("DETAILS");
                bt_detail.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setLayoutX(200);
                bt_detail.setLayoutY(30+y);

                boutonsTerrains.add(bt_detail);
                listeTerrainsLabel.add(terrain);

                this.appuieBoutonTerrain(bt_detail, i);

                listeTerrains.add(ter);
                zoneTerrain.getChildren().add(terrain);
                zoneTerrain.getChildren().add(bt_detail);
                y+=30 ;
            }


        }
    }

    public void afficherGare(Automate automate)
    {
        int y = 0 ;
        for(int i =0 ; i<automate.getJoueurCourant().getListePropietes().size(); i++)
        {
            if(automate.getJoueurCourant().getListePropietes().get(i) instanceof Gare){
                Label gare = new Label(""+automate.getJoueurCourant().getListePropietes().get(i).toString()+"\n");
                gare.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                gare.setLayoutX(10);
                gare.setLayoutY(30+y);

                Button bt_detail = new Button("DETAILS") ;
                bt_detail.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setLayoutX(200);
                bt_detail.setLayoutY(30+y);

                boutonsGares.add(bt_detail);
                listeGaresLabel.add(gare);

                Gare gares = (Gare) automate.getJoueurCourant().getListePropietes().get(i);

                listeGares.add(gares);
                zoneGare.getChildren().add(gare);
                zoneGare.getChildren().add(bt_detail);
                y+=30 ;
            }


        }
    }

    public void afficherCompagnie(Automate automate)
    {

        int y = 0 ;
        for(int i =0 ; i<automate.getJoueurCourant().getListePropietes().size(); i++)
        {
            if(automate.getJoueurCourant().getListePropietes().get(i) instanceof ServicePublic){

                Label compagnie = new Label(""+automate.getJoueurCourant().getListePropietes().get(i).toString()+"\n");
                compagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                ServicePublic compa = (ServicePublic) automate.getJoueurCourant().getListePropietes().get(i);
                listeCompagnies.add(compa);
                compagnie.setLayoutX(10);
                compagnie.setLayoutY(30+y);

                Button bt_detail = new Button("DETAILS") ;
                bt_detail.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setLayoutX(200);
                bt_detail.setLayoutY(30+y);

                boutonsCompagnie.add(bt_detail);
                listeCompagniesLabel.add(compagnie);

                zoneCompagnie.getChildren().add(compagnie);
                zoneCompagnie.getChildren().add(bt_detail);
                y+=30 ;
            }

        }
    }

    public void effacerPossession()
    {
        zoneCompagnie.getChildren().removeAll(listeCompagniesLabel);
        listeTerrains.removeAll(listeTerrains);
        zoneCompagnie.getChildren().removeAll(boutonsCompagnie);

        zoneTerrain.getChildren().removeAll(listeTerrainsLabel);
        zoneTerrain.getChildren().removeAll(boutonsTerrains);

        zoneGare.getChildren().removeAll(listeGaresLabel);
        zoneGare.getChildren().removeAll(boutonsGares);

    }


    public void appuieBoutonTerrain(Button b, int numBouton)
    {
        b.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               fenetreDetailTerrain(fenetre_actuelle, automate, numBouton);
           }
        });
    }

    //si on appuie sur un boutons Détails sur terrains
  /*  public void appuieBoutonTerrain()
    {
        for(int i=0; i<boutonsTerrains.size(); i++)
        {
            numBouton= i ;
            boutonsTerrains.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    fenetreDetailTerrain(fenetre_actuelle, automate, numBouton);
                }

            });
        }

        numBouton=0 ;
    }*/

    //si on appuie sur un boutons Détails sur compagnie
    public void appuieBoutonCompagnie()
    {
        for(Button detail : boutonsCompagnie)
        {
            detail.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int numBouton=0 ;
                    //fenetreDetail(fenetre_actuelle, automate, numBouton);
                    numBouton++ ;
                }
            });

        }
    }

    //si on appuie sur un boutons Détails sur gare
    public void appuieBoutonGare()
    {
        for(Button detail : boutonsGares)
        {
            detail.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    int numBouton=0 ;
                    //fenetreDetail(fenetre_actuelle, automate, numBouton);
                    numBouton++ ;
                }

            });
        }
    }


    public void fenetreDetailTerrain(Stage fenetre_actuelle, Automate automate, int numBouton)
    {
       // jeu.fenetreNoire();

        Stage nouvelle_fenetre_detail = new Stage();
        DetailTerrain fenetreDetail = new DetailTerrain(automate,nouvelle_fenetre_detail, fenetre_actuelle, canvas, this, numBouton);

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

    public ArrayList<Button> getBoutonsCompagnie() {
        return boutonsCompagnie;
    }

    public ArrayList<Button> getBoutonsTerrains() {
        return boutonsTerrains;
    }

    public ArrayList<Button> getBoutonsGares() {
        return boutonsGares;
    }
}
