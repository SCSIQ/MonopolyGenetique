package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.PossessionAdv;
import IHM.Fenetre.FenetreParties.ComposantPlateau.ZonePossessions;
import Metier.Automate.Automate;
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

public class DetailGare extends Parent {


    private Pane zoneInfos ;
    private int numBouton ;
    private ZonePossessions poss ;
    private PossessionAdv possAd ;

    public DetailGare(Automate automate, Stage fenetre_detail , Stage fenetre_avant, Canvas canvas, ZonePossessions poss, int numBouton, PossessionAdv possAd, boolean joueurCourant){

        this.numBouton = numBouton ;
        this.poss = poss ;
        this.possAd = possAd ;
        zoneInfos =new Pane() ;

        //si il s'agit d'une possession du joueur courant
        if(joueurCourant==true) {
            Label nomGare = new Label(poss.getListeGares().get(numBouton).toString().toUpperCase() + "");

            nomGare.setLayoutY(20);
            nomGare.setLayoutX(80);
            nomGare.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));

            gestion(automate, true);

            //RECTANGLE
            Rectangle r_couleur = new Rectangle();
            r_couleur.setHeight(50);
            r_couleur.setWidth(455);
            r_couleur.setLayoutX(10);
            r_couleur.setLayoutY(10);
            r_couleur.setStroke(Color.BLACK);
            r_couleur.setStrokeWidth(1);
            r_couleur.setFill(Color.TRANSPARENT);

            //BOUTON
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

            /////////TAILLE MIN ET MAX DE LA FENETRE
            fenetre_detail.setMinHeight(400);
            fenetre_detail.setMinWidth(500);

            fenetre_detail.setMaxHeight(400);
            fenetre_detail.setMaxWidth(500);

            //AJOUT
            this.getChildren().add(bt_ok);
            this.getChildren().add(r_couleur);
            this.getChildren().add(nomGare);

        } else {
            Label nomGare = new Label(possAd.getListeGares().get(numBouton).toString().toUpperCase() + "");

            nomGare.setLayoutY(20);
            nomGare.setLayoutX(80);
            nomGare.setFont(Font.font("Verdana", FontWeight.NORMAL, 24));

            gestion(automate, false);

            //RECTANGLE
            Rectangle r_couleur = new Rectangle();
            r_couleur.setHeight(50);
            r_couleur.setWidth(455);
            r_couleur.setLayoutX(10);
            r_couleur.setLayoutY(10);
            r_couleur.setStroke(Color.BLACK);
            r_couleur.setStrokeWidth(1);
            r_couleur.setFill(Color.TRANSPARENT);

            //BOUTON
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

            /////////TAILLE MIN ET MAX DE LA FENETRE
            fenetre_detail.setMinHeight(400);
            fenetre_detail.setMinWidth(500);

            fenetre_detail.setMaxHeight(400);
            fenetre_detail.setMaxWidth(500);

            //AJOUT
            this.getChildren().add(bt_ok);
            this.getChildren().add(r_couleur);
            this.getChildren().add(nomGare);
        }
        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_detail.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });



    }

    public void gestion(Automate automate, boolean joueurCourant){
        zoneInfos.setLayoutX(10);
        zoneInfos.setLayoutY(80);

        if(joueurCourant==true){
            Label gare = new Label("Votre loyer : \n\n"+
                    "   Si vous possédez 1 gare  : "+poss.getListeGares().get(numBouton).getLoyer()+" €\n"+
                    "   Si vous possédez 2 gares : "+poss.getListeGares().get(numBouton).getLoyer()*2+" €\n"+
                    "   Si vous possédez 3 gares : "+(poss.getListeGares().get(numBouton).getLoyer()*2)*2+" €\n"+
                    "   Si vous possédez 4 gares :  "+((poss.getListeGares().get(numBouton).getLoyer()*2)*2)*2+" €\n");

            gare.setLayoutX(20);
            gare.setLayoutY(20);

            gare.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

            zoneInfos.getChildren().add(gare);
        }else {
            Label gare = new Label("Le loyer que vous devrez payer\n\n"+
                    "   Si ce joueur possède 1 gare  : "+possAd.getListeGares().get(numBouton).getLoyer()+" €\n"+
                    "   Si ce joueur possède 2 gares : " +possAd.getListeGares().get(numBouton).getLoyer()*2+" €\n"+
                    "   Si ce joueur possède 3 gares : "+(possAd.getListeGares().get(numBouton).getLoyer()*2)*2+" €\n"+
                    "   Si ce joueur possède 4 gares : "+((possAd.getListeGares().get(numBouton).getLoyer()*2)*2)*2+" €"+
                    "\n\nCe joueur possède actuellement "+possAd.getListeGares().get(numBouton).getNbGaresPossedees()+" gares.");

            gare.setLayoutX(20);
            gare.setLayoutY(20);

            gare.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));

            zoneInfos.getChildren().add(gare);

        }

        //TAILLE DU RECTANGLE ET POSITION
        Rectangle rect_gare = new Rectangle();
        rect_gare.setFill(Color.TRANSPARENT);
        rect_gare.setStroke(Color.BLACK);
        rect_gare.setHeight(200);
        rect_gare.setWidth(455);
        rect_gare.setX(0);
        rect_gare.setY(0);

        zoneInfos.getChildren().add(rect_gare);
        this.getChildren().add(zoneInfos);
    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
