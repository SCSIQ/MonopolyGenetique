package IHM.Fenetre.FenetreParties;

import IHM.Fenetre.FenetreParties.ComposantPlateau.FenetreGagne;
import Metier.Automate.Automate;
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

public class FenetreScore extends Parent {

    private Canvas canvas ;
    private Jeu jeu ;
    private Automate automate ;

    public FenetreScore(Stage fenetre, Canvas canvas, Jeu jeu, Automate automate)
    {
        //initialisation
        this.canvas = canvas ;
        this.jeu = jeu ;
        this.automate = automate ;

        //Label (avec bouton pour centrer le texte)
        Button bt_Score= new Button("SCORE");
        bt_Score.setLayoutY(10);
        bt_Score.setLayoutX(10);
        bt_Score.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_Score.setBackground(new Background(new BackgroundFill( Color.rgb(9,172,227),null, null)));
        bt_Score.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        bt_Score.setTextFill(Color.WHITE);
        bt_Score.setPrefSize(465,50);

        //RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(485);
        r_fond.setWidth(465);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        //Bouton
        Button bt_ok = new Button("OK");

        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(450);

        bt_ok.setPrefSize(150, 10);


        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);


                //on ferme la fenêtre
                fenetre.close();

                //spécifier le nombre de tour total, j'ai mis 21 par defaut
                if (automate.getNumTour() == automate.getNombreTourTotal())
                    fenetreGagne(jeu.getFenetrePropri());

            }
        });

        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre.setMinHeight(550);
        fenetre.setMinWidth(500);

        fenetre.setMaxHeight(550);
        fenetre.setMaxWidth(500);

        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        this.afficheJoueur();

        //Ajout
        this.getChildren().add(bt_Score);
        this.getChildren().add(r_fond) ;
        this.getChildren().add(bt_ok);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

    public void afficheJoueur()
    {
        int x=0 ;
        for (int i =0; i<automate.getListeJoueurs().size(); i++)
        {
            //Nom des joueurs
           Label l = new Label(automate.getListeJoueurs().get(i).getNom()) ;
           l.setFont(Font.font("Verdana", FontWeight.NORMAL, 22));
           l.setLayoutX(90);
           l.setLayoutY(120+x);

           //Rectangle de couleur
            Rectangle r_couleur = new Rectangle();
            r_couleur.setHeight(40);
            r_couleur.setWidth(40);
            r_couleur.setLayoutX(30);
            r_couleur.setLayoutY(115+x);
            r_couleur.setStroke(Color.BLACK);
            r_couleur.setStrokeWidth(1);
            r_couleur.setFill(automate.getListeJoueurs().get(i).getCouleur());

           //ajout
           this.getChildren().add(l);
           this.getChildren().add(r_couleur);


           x +=60 ;
        }

    }

    public void afficheScore(){
        
    }


    public void fenetreGagne(Stage fenetre_actuelle)
    {
        jeu.fenetreNoire();
        Stage nouvelle_fenetre_gagne = new Stage();
        FenetreGagne fenetreScore = new FenetreGagne(nouvelle_fenetre_gagne, automate, jeu);

        Scene nouvelle_scene = new  Scene(fenetreScore,500,600);

        nouvelle_fenetre_gagne.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_gagne.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_gagne.initOwner(fenetre_actuelle);

        nouvelle_fenetre_gagne.show();
    }

}
