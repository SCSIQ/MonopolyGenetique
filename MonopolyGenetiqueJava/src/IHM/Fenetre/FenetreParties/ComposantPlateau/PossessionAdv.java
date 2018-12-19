package IHM.Fenetre.FenetreParties.ComposantPlateau;

import IHM.Fenetre.FenetreParties.DetailCompagnie;
import IHM.Fenetre.FenetreParties.DetailGare;
import IHM.Fenetre.FenetreParties.DetailTerrain;
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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.xml.ws.Service;
import java.util.ArrayList;


public class PossessionAdv extends Parent {

    private Stage fenetre_actuelle;
    private Canvas canvas;
    private Automate automate;
    private Jeu jeu ;
    private int numJoueur;

    private Pane zoneTerrain ;
    private Pane zoneCompagnie ;
    private Pane zoneGare ;

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

    private ArrayList<Gare> listeGares ;
    private ArrayList<Terrain> listeTerrains ;
    private ArrayList<Button> boutonsCompagnie ;
    private ArrayList<Button> boutonsTerrains ;
    private ArrayList<Button> boutonsGares ;

    private ArrayList<Label> listeGaresLabel ;
    private ArrayList<Label> listeTerrainsLabel ;
    private ArrayList<Label> listeCompagniesLabel ;
    private ArrayList<Rectangle> listeCouleur ;

    private PlateauJeu pl ;

    public PossessionAdv(Stage nouvelle_fenetre_menu, Stage fenetre_actuelle, Canvas canvas, Automate automate,int i, Jeu jeu, PlateauJeu pl)
    {
        this.automate=automate;
        this.canvas=canvas;
        this.jeu=jeu;
        this.fenetre_actuelle=fenetre_actuelle;
        this.numJoueur=i;

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

        boutonsTerrains = new ArrayList<>();
        listeCompagniesLabel = new ArrayList<>();
        listeTerrainsLabel = new ArrayList<>();
        listeGaresLabel = new ArrayList<>();

        listeCouleur = new ArrayList<>() ;

        Text t_adv1 = new Text("Possession de "+automate.getListeJoueurs().get(i).getNom());
        t_adv1.setScaleX(2);
        t_adv1.setScaleY(2);
        t_adv1.setLayoutX(250);
        t_adv1.setLayoutY(45);


        //Rectangle couleur joueur -> A VOIR SI ON GARDE ...
        Rectangle r_couleur = new Rectangle();
        r_couleur.setHeight(60);
        r_couleur.setWidth(60);
        r_couleur.setX(15);
        r_couleur.setY(15);
        r_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());


        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_possession = new Rectangle();
        rect_possession.setHeight(500);
        rect_possession.setWidth(630);
        rect_possession.setX(10);
        rect_possession.setY(10);
        rect_possession.setFill(Color.TRANSPARENT);
        rect_possession.setStroke(Color.BLACK);


        this.getChildren().add(rect_possession);
        this.getChildren().add(r_couleur);
        this.getChildren().add(t_adv1);

        //AJOUT DES DIFFERENTS ELEMENTS

        RectangleTerrain();
        RectangleGare();
        RectangleCompagnies();
        RectangleCartePrison();

        //BOUTON
        Button bt_ok = new Button("revenir au jeu");

        bt_ok.setLayoutX(270);
        bt_ok.setLayoutY(530);

        bt_ok.setPrefSize(150, 10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                nouvelle_fenetre_menu.close();
            }
        });

        this.getChildren().add(bt_ok);
////////BLOCAGE REDUCTION

        nouvelle_fenetre_menu.setMinWidth(670);
        nouvelle_fenetre_menu.setMinHeight(630);

        nouvelle_fenetre_menu.setMaxWidth(670);
        nouvelle_fenetre_menu.setMaxHeight(630);

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        nouvelle_fenetre_menu.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

    }

    public void RectangleTerrain(){
        //Positionnement du panel
        zoneTerrain.setLayoutX(15);
        zoneTerrain.setLayoutY(85);

        //Ajout d'un label "TERRAIN"
        Label textTerrain = new Label("TERRAINS");
        textTerrain.setLayoutX(115);
        textTerrain.setLayoutY(10);
        textTerrain.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        //rectangle
        Rectangle rect_terrain = new Rectangle();
        rect_terrain.setHeight(410);
        rect_terrain.setWidth(305);
        rect_terrain.setX(0);
        rect_terrain.setY(0);

        //COULEUR ET CONTOUR
        rect_terrain.setFill(Color.TRANSPARENT);
        rect_terrain.setStroke(Color.BLACK);

        zoneTerrain.getChildren().add(textTerrain);
        zoneTerrain.getChildren().add(rect_terrain);

        if(automate.getListeJoueurs().get(numJoueur).getListePropietes().size()>0) {
            afficherTerrain(automate);
        }

        this.getChildren().add(zoneTerrain);
    }

    public void RectangleGare(){

        //position du panel
        zoneGare.setLayoutX(330);
        zoneGare.setLayoutY(85);

        //Ajout d'un label "GARE"
        Label textGare = new Label("GARES");
        textGare.setLayoutX(125);
        textGare.setLayoutY(10);
        textGare.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_gare  = new Rectangle();
        rect_gare.setWidth(305);
        rect_gare.setHeight(210);
        rect_gare.setX(0);
        rect_gare.setY(0);

        //COULEUR ET CONTOUR
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);

        zoneGare.getChildren().add(rect_gare);
        zoneGare.getChildren().add(textGare);


        if(automate.getListeJoueurs().get(numJoueur).getListePropietes().size()>0)
        {
            afficherGare( automate);
        }


        this.getChildren().add(zoneGare);
    }


    public void RectangleCompagnies(){

        //position du pane
        zoneCompagnie.setLayoutX(330);
        zoneCompagnie.setLayoutY(310);

        //Ajout d'un label "COMPAGNIES"
        Label textCompagnies = new Label("COMPAGNIES");
        textCompagnies.setLayoutX(95);
        textCompagnies.setLayoutY(10);
        textCompagnies.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_compagnie = new Rectangle();
        rect_compagnie.setHeight(130);
        rect_compagnie.setWidth(305);
        rect_compagnie.setX(0);
        rect_compagnie.setY(0);

        //COULEUR ET CONTOUR
        rect_compagnie.setFill(Color.TRANSPARENT);
        rect_compagnie.setStroke(Color.BLACK);

        zoneCompagnie.getChildren().add(textCompagnies);
        zoneCompagnie.getChildren().add(rect_compagnie);

        if(automate.getListeJoueurs().get(numJoueur).getListePropietes().size()>0)
        {
            afficherCompagnie(automate);
        }

        this.getChildren().add(zoneCompagnie);
    }

    public void RectangleCartePrison(){

        //Ajout d'un label "Vous êtes libéré de prison"
        Label textPrison = new Label("CARTE \"LIBERE DE PRISON\" :");
        textPrison.setLayoutX(400);
        textPrison.setLayoutY(460);
        textPrison.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        this.getChildren().add(textPrison);

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_cartePrison = new Rectangle();
        rect_cartePrison.setHeight(50);
        rect_cartePrison.setWidth(305);
        rect_cartePrison.setX(330);
        rect_cartePrison.setY(445);

        //COULEUR ET CONTOUR
        rect_cartePrison.setFill(Color.TRANSPARENT);
        rect_cartePrison.setStroke(Color.BLACK);
        this.getChildren().add(rect_cartePrison);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////AFFICHAGE DES POSSESSION
    public void afficherTerrain(Automate automate) {
        int y = 0;
        int j = 0 ; 
        for (int i = 0; i < automate.getListeJoueurs().get(numJoueur).getListePropietes().size(); i++) {
            if (automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i) instanceof Terrain) {
                Label terrain = new Label("" + automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i).toString() + "\n");
                terrain.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                terrain.setLayoutX(50);
                terrain.setLayoutY(40 + y);

                CouleurMétier s = ((Terrain) automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i)).getCouleur();
                Color couleurTerrain;
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

                //ajout Couleur du joueur
                Rectangle r_couleur = new Rectangle();
                r_couleur.setHeight(20);
                r_couleur.setWidth(20);
                r_couleur.setLayoutX(10);
                r_couleur.setLayoutY(37 + y);
                r_couleur.setStroke(Color.BLACK);
                r_couleur.setStrokeWidth(1);
                r_couleur.setFill(couleurTerrain);
                zoneTerrain.getChildren().add(r_couleur);

                Button bt_detail = new Button("DETAILS");
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setBackground(new Background(new BackgroundFill(Color.rgb(239,239,239), null, null)));
                bt_detail.setLayoutX(225);
                bt_detail.setLayoutY(37 + y);

                Terrain ter = (Terrain) automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i);

                boutonsTerrains.add(j, bt_detail);
                listeTerrainsLabel.add(terrain);
                listeCouleur.add(r_couleur);

                this.appuieBoutonTerrain(bt_detail, j);

                listeTerrains.add(ter);

                zoneTerrain.getChildren().add(terrain);
                zoneTerrain.getChildren().add(bt_detail);
                y += 30;
                j++ ;
            }


        }
    }

    private void appuieBoutonTerrain(Button bt_detail, int i) {
        bt_detail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fenetreDetailTerrain(fenetre_actuelle, automate, i);
            }
        });
    }

    public void afficherGare(Automate automate)
    {
        int y = 0 ;
        int j = 0 ;
        for(int i =0 ; i<automate.getListeJoueurs().get(numJoueur).getListePropietes().size() ; i++)
        {
            if(automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i) instanceof Gare){
                Label gare = new Label(""+automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i).toString()+"\n");
                gare.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                gare.setLayoutX(15);
                gare.setLayoutY(37+y);

                Button bt_detail = new Button("DETAILS") ;
                bt_detail.setBackground(new Background(new BackgroundFill(Color.rgb(239,239,239), null, null)));
                bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                bt_detail.setLayoutX(215);
                bt_detail.setLayoutY(33+y);

                boutonsGares.add(j,bt_detail);
                listeGaresLabel.add(gare);

                Gare gares = (Gare) automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i);

                this.appuieBoutonGare(bt_detail, j);


                zoneGare.getChildren().add(bt_detail);
                listeGares.add(gares);
                zoneGare.getChildren().add(gare);
                y+=30 ;
                j++;
            }



        }
    }




    public void afficherCompagnie(Automate automate)
    {

        int y = 0 ;
        int j = 0 ;
        for(int i =0 ; i<automate.getListeJoueurs().get(numJoueur).getListePropietes().size() ; i++) {
            if (automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i) instanceof ServicePublic) {
                {

                    Label compagnie = new Label("" + automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i).toString() + "\n");
                    compagnie.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
                    ServicePublic compa = (ServicePublic) automate.getListeJoueurs().get(numJoueur).getListePropietes().get(i);

                    compagnie.setLayoutX(15);
                    compagnie.setLayoutY(37 + y);

                    Button bt_detail = new Button("DETAILS");
                    bt_detail.setBackground(new Background(new BackgroundFill(Color.rgb(239,239,239), null, null)));
                    bt_detail.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
                    bt_detail.setLayoutX(215);
                    bt_detail.setLayoutY(33 + y);

                    boutonsCompagnie.add(j, bt_detail);
                    listeCompagniesLabel.add(compagnie);

                    this.appuieBoutonCompagnie(bt_detail, j);
                    listeCompagnies.add(compa);

                    zoneCompagnie.getChildren().add(compagnie);
                    zoneCompagnie.getChildren().add(bt_detail);
                    y += 30;
                    j++ ;
                }

            }

        }
    }

    public void appuieBoutonCompagnie(Button bt_detail, int i) {
        bt_detail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fenetreDetailCompagnie(fenetre_actuelle, automate, i);

            }
        });
    }




    /////////////////////////////////////////////////////////////////////////////////////////////////////////////EFFACEMENT DE POSSESSION
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

    public void fenetreDetailTerrain(Stage fenetre_actuelle, Automate automate, int numBouton)
    {
      //  jeu.fenetreNoire();

        Stage nouvelle_fenetre_detail = new Stage();
        DetailTerrain fenetreDetail = new DetailTerrain(automate,nouvelle_fenetre_detail, fenetre_actuelle, canvas, jeu.getPoss(), numBouton, this, false, pl, jeu);

        Scene nouvelle_scene = new  Scene(fenetreDetail,500,700);

        nouvelle_fenetre_detail.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_detail.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_detail.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_detail.show();
    }

    private void appuieBoutonGare(Button bt_detail, int i)
    {
        bt_detail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fenetreDetailGare(fenetre_actuelle, automate, i);
            }

        });

    }

    private void fenetreDetailGare(Stage fenetre_actuelle, Automate automate, int i)
    {
       // jeu.fenetreNoire();

        Stage nouvelle_fenetre_detail = new Stage();
        DetailGare fenetreDetail = new DetailGare(automate,nouvelle_fenetre_detail, fenetre_actuelle, canvas, jeu.getPoss(), i, this, false);

        Scene nouvelle_scene = new  Scene(fenetreDetail,500,700);

        nouvelle_fenetre_detail.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_detail.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_detail.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_detail.show();
    }

    private void fenetreDetailCompagnie(Stage fenetre_actuelle, Automate automate, int i)
    {
       // jeu.fenetreNoire();

        Stage nouvelle_fenetre_detail = new Stage();
        DetailCompagnie fenetreDetail = new DetailCompagnie(automate,nouvelle_fenetre_detail, fenetre_actuelle, canvas, jeu.getPoss(), i, this, false);

        Scene nouvelle_scene = new  Scene(fenetreDetail,500,700);

        nouvelle_fenetre_detail.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_detail.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_detail.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_detail.show();

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }


}
