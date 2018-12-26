package IHM.Fenetre.FenetreParties;

import Metier.Plateau.Cases;
import Metier.Plateau.ListeProprietes.ListeTerrains.CouleurMétier;
import Metier.Plateau.ListeProprietes.ListeTerrains.Terrain;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FenetreDevezAvoirTousTerrains extends Parent {

    //Attributs
    private Canvas canvas ;

    public FenetreDevezAvoirTousTerrains(Stage fenetre, Canvas canvas, Jeu jeu, Cases caseTerrain)
    {
        //Initialisation
        this.canvas=canvas;

        //Label (avec bouton pour centrer le texte)
        Button bt_TousTerrains= new Button("IMPOSSIBLE DE CONSTRUIRE");
        bt_TousTerrains.setLayoutY(10);
        bt_TousTerrains.setLayoutX(10);
        bt_TousTerrains.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        bt_TousTerrains.setTextFill(Color.WHITE);

        //COULEUR
        CouleurMétier s =((Terrain)caseTerrain).getCouleur();
        Color couleurTerrain ;
        switch(s){
            case Rose :   bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(189,91,163),null, null)));
                break ;
            case Vert: bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(28,137,6791,163),null, null)));
                 break ;
            case Orange: bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(234,157,34),null, null)));
                break ;
            case Jaune:  bt_TousTerrains.setBackground(new Background(new BackgroundFill(  Color.rgb(239,233,50),null, null)));
                break ;
            case Rouge:  bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(224,30,37),null, null)));
                break ;
            case Marron: bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(122,57,149),null, null)));
                break ;
            case BleuFonce:  bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(68,77,169),null, null)));
                break;
            case BleuCiel: bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(9,172,227),null, null)));
                break ;

            default :bt_TousTerrains.setBackground(new Background(new BackgroundFill( Color.rgb(255,255,255),null, null)));;
        }



        bt_TousTerrains.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        bt_TousTerrains.setPrefSize(475,50);

        //RECTANGLE

        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(235);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        // boutons OK
        Button bt_ok = new Button("REVENIR AU JEU");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);

        bt_ok.setPrefSize(150,10);

        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                fenetre.close();

            }
        });
        
        //Contenu de la fenêtre

        Label l_contenu = new Label("Vous devez avoir tous les terrains de cette couleur pour construire.");
        l_contenu.setLayoutX(100);
        l_contenu.setLayoutY(100);
        l_contenu.setMaxWidth(300);
        l_contenu.setWrapText(true);
        l_contenu.setTextAlignment(TextAlignment.CENTER);
        l_contenu.setFont(Font.font("Verdana", FontWeight.BOLD, 16));

        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
 /*       fenetre.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });*/

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre.setMinHeight(300);
        fenetre.setMinWidth(515);

        fenetre.setMaxHeight(300);
        fenetre.setMaxWidth(515);

        //ajout
        this.getChildren().add(bt_ok);
        this.getChildren().add(bt_TousTerrains);
        this.getChildren().add(r_fond);
        this.getChildren().add(l_contenu);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
