package IHM.Fenetre.FenetreParties.ComposantPlateau.Cases;

import IHM.Fenetre.FenetreParties.FenetreFaillite_1;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.PlateauJeu;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneAdversaires;
import IHM.Fenetre.FenetreParties.ComposantPlateau.Zones_Jeu.ZoneInfoJoueur;
import IHM.Fenetre.FenetreParties.Jeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeTaxes.Taxes;
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


public class FenetreTaxe extends Parent {

    //ATTRIBUTS
    private Canvas canvas ;
    private ZoneInfoJoueur zoneJoueur ;
    private ZoneAdversaires zoneAd;

    public FenetreTaxe(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur, Jeu jeu, ZoneAdversaires zoneAd)
    {
        //INITIALISATION
        this.canvas = canvas ;
        this.zoneJoueur =zoneJoueur;
        this.zoneAd = zoneAd ;


        Button l = new Button(plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType());
        Label l_contenu = new Label("Vous devez payer "+((Taxes)automate.getJoueurCourant().getPion().getCase()).getPrixTaxe() +" € à la banque.");

        l.setPrefSize(475,50);
        l.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        l.setTextFill(Color.WHITE);
        l.setBackground(new Background(new BackgroundFill(Color.rgb(229,182,24), null, null)));
        l.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        l.setLayoutX(10);
        l.setLayoutY(10);
        l.setText(l.getText().toUpperCase());

        l_contenu.setLayoutY(100);
        l_contenu.setLayoutX(30);
        l_contenu.setFont(Font.font("Verdana", FontWeight.BOLD, 20));

        //RECTANGLE

        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(235);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        ////////////////////////////BOUTON
        //ACTION PAYER
        Button bt_payer= new Button("PAYER");

        bt_payer.setLayoutX(175);
        bt_payer.setLayoutY(200);

        bt_payer.setPrefSize(150, 10);

        bt_payer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on remet à jour l'argent du joueur courant
                zoneJoueur.SupprimerJoueur();
                zoneJoueur.genereInfosJoueur(automate);

                //Met à jour les adversaires :
                zoneAd.SupprimerAdversaire();
                zoneAd.genererAdversaire(automate, fenetre_actuelle);

                //on ferme la fenêtre
                fenetre_actuelle.close();

                // si le joueur n'a pas assez d'argent, il perd
                if(automate.getJoueurCourant().getSolde()< ((Taxes)automate.getJoueurCourant().getPion().getCase()).getPrixTaxe())
                {
                    fenetreFaillite(fenetre_actuelle, automate,  zoneJoueur, zoneAd) ;
                }

            }
        });

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(520);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(520);

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
    @Override
    public void handle(WindowEvent event) {
        event.consume();
    }
});



//////////////////////AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(l_contenu);
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

    public void fenetreFaillite(Stage fenetre_actuelle, Automate automate,  ZoneInfoJoueur zoneJoueur, ZoneAdversaires zoneAd)
    {
        //jeu.fenetreNoire();

        Stage nouvelle_fenetre_faillite = new Stage();

        FenetreFaillite_1 fenetreFaillite= new FenetreFaillite_1(nouvelle_fenetre_faillite,canvas, automate, zoneJoueur, zoneAd);

        Scene nouvelle_scene = new  Scene(fenetreFaillite,650,550);

        nouvelle_fenetre_faillite.setScene(nouvelle_scene);

        //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
        nouvelle_fenetre_faillite.initModality(Modality.WINDOW_MODAL);
        nouvelle_fenetre_faillite.initOwner(fenetre_actuelle);

        //POSITION DE LA FENETRE
        nouvelle_fenetre_faillite.show();
    }
}
