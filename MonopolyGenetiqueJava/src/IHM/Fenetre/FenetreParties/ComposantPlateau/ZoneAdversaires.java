package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.awt.*;

//CLASSE S'OCCUPANT DE LA PARTIE DES ADVERSAIRES DES JOUEURS
public class ZoneAdversaires extends Parent {

    private GraphicsDevice ecran = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice() ;


    public ZoneAdversaires(Automate automate)
    {
        //Ajout label adversaire
        Label adversaire = new Label("ADVERSAIRES");
        adversaire.setLayoutX(1100);
        adversaire.setLayoutY(225);
        adversaire.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        this.getChildren().add(adversaire);

        Pane zoneAdversaire = new Pane();

        int height = ecran.getDisplayMode().getHeight();
        int width = ecran.getDisplayMode().getWidth();

        zoneAdversaire.setLayoutX(630);
        zoneAdversaire.setLayoutY(120);
        Border border1 = new Border(
                new BorderStroke(Color.BLACK,
                        BorderStrokeStyle.SOLID,
                        CornerRadii.EMPTY,
                        new BorderWidths(2),
                        new Insets(0)));
        zoneAdversaire.setPrefSize(width*0.46,height*0.18);
        zoneAdversaire.setBorder(border1);

        zoneAdversaire.getChildren().add(adversaire);
        this.getChildren().add(zoneAdversaire);


        //Ajout adversaire 1 POUR SOLO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        for(int i=1;i<=automate.getNombreJoueur();i++) {
            if(i==1) {
                RectangleAdv1(automate);
            }
           /* else if(i==2)
            {
                RectangleAdv2();
            }*/
        }
    }

    public void RectangleAdv1(Automate automate)
    {
        //Dessin du premier rectangle
        Rectangle rect_adv = new Rectangle();
        rect_adv.setHeight(60);
        rect_adv.setWidth(300);
        rect_adv.setX(635);
        rect_adv.setY(125);
        rect_adv.setStroke(Color.BLACK);
        rect_adv.setStrokeWidth(1);
        rect_adv.setFill(Color.TRANSPARENT);
        this.getChildren().add(rect_adv);

        //Nom du joueur
        Label adv1 = new Label("JOUEUR "+automate.getListeJoueurs().get(1).getNom());
        adv1.setLayoutX(700);
        adv1.setLayoutY(130);
        this.getChildren().add(adv1);

        //ARGENT Joueur 2
        Label argent_adv1 = new Label("ARGENT : ");
        argent_adv1.setLayoutX(700);
        argent_adv1.setLayoutY(160);
        this.getChildren().add(argent_adv1);

        //BOUTON DETAILS
        Button adv_details = new Button("DETAILS");
        adv_details.setLayoutX(870);
        adv_details.setLayoutY(130);
        this.getChildren().add(adv_details);

        //ajout rectangle couleur
        Rectangle r_adv1_couleur = new Rectangle();
        r_adv1_couleur.setHeight(50);
        r_adv1_couleur.setWidth(50);
        r_adv1_couleur.setLayoutX(640);
        r_adv1_couleur.setLayoutY(130);
        r_adv1_couleur.setStroke(Color.BLACK);
        r_adv1_couleur.setStrokeWidth(1);
        r_adv1_couleur.setFill(automate.getListeJoueurs().get(1).getCouleur());
        this.getChildren().add(r_adv1_couleur);


    }

    public void RectangleAdv2(Automate automate)
    {
        //Dessin du premier rectangle
        Rectangle rect_adv = new Rectangle();
        rect_adv.setHeight(60);
        rect_adv.setWidth(300);
        rect_adv.setX(635);
        rect_adv.setY(190);
        rect_adv.setStroke(Color.BLACK);
        rect_adv.setStrokeWidth(1);
        rect_adv.setFill(Color.TRANSPARENT);
        this.getChildren().add(rect_adv);

        //Nom du joueur
        Label adv2 = new Label("JOUEUR "+automate.getListeJoueurs().get(2).getNom());
        adv2.setLayoutX(700);
        adv2.setLayoutY(195);
        this.getChildren().add(adv2);

        //ARGENT Joueur 2
        Label argent_adv2 = new Label("ARGENT : ");
        argent_adv2.setLayoutX(700);
        argent_adv2.setLayoutY(230);
        this.getChildren().add(argent_adv2);

        //BOUTON DETAILS
        Button adv_details = new Button("DETAILS");
        adv_details.setLayoutX(870);
        adv_details.setLayoutY(195);
        this.getChildren().add(adv_details);

        //ajout rectangle couleur
        Rectangle r_adv1_couleur = new Rectangle();
        r_adv1_couleur.setHeight(50);
        r_adv1_couleur.setWidth(50);
        r_adv1_couleur.setLayoutX(640);
        r_adv1_couleur.setLayoutY(195);
        r_adv1_couleur.setStroke(Color.BLACK);
        r_adv1_couleur.setStrokeWidth(1);
        r_adv1_couleur.setFill(automate.getListeJoueurs().get(2).getCouleur());
        this.getChildren().add(r_adv1_couleur);


    }

}
