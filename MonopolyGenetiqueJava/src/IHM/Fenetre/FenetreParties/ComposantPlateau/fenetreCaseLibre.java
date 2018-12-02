package IHM.Fenetre.FenetreParties.ComposantPlateau;

//importation mise par Jérémy
import IHM.Fenetre.FentreMenuPrincipal.MenuJeu;
import Metier.Automate.Automate;
import Metier.Plateau.ListeProprietes.Proprietes;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

//PERMET DE PROPOSER QUE L'UTILISATEUR ACHETE LA CASE SI ELLE EST LIBRE
public class fenetreCaseLibre extends Parent {

   // Proprietes p ;
    Canvas canvas;

    public fenetreCaseLibre(Stage fenetre_actuelle, Canvas canvas, Automate automate, PlateauJeu plateauJeu, ZoneInfoJoueur zoneJoueur)
    {
        this.canvas=canvas;
        Label l = new Label("Vous êtes sur la case :\n"+plateauJeu.getListeCases().get(automate.getJoueurCourant().getPion().getCase().getPosition()).getType()+
                                    "\n\nElle n'appartient à personne.\n\nElle coûte "+((Proprietes)automate.getJoueurCourant().getPion().getCase()).getPrix()+" € ");
        l.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        l.setLayoutX(170);
        l.setLayoutY(50);

        l.setScaleX(2);
        l.setScaleY(2);

//////////////////////////////////////////////////////////////////////////BOUTON
        Button bt_acheter= new Button("ACHETER");

        bt_acheter.setLayoutX(50);
        bt_acheter.setLayoutY(210);

        bt_acheter.setPrefSize(150, 10);

        bt_acheter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                automate.evoluer("acheterPropriete"); //demamnde à l'automate d'acheter la propriété (bien entendu cela ne se fera pas si le joueur n'a pas assez d'argent)
                //pour ce qui est de tes demandes Emilie, je m'en occupe des que possible, Aurian

                //SI PAS ASSEZ D'ARGENT.. Je ne sais pas comment récupérer la propriété et son tarif.. Fonction coté métier pour joueurcourant : assezArgent ? qu'on puisse récupérer ?
              /*  if(automate.getJoueurCourant().getSolde()<p.getPrix())
                {
                    fenetreNoire();

                    Stage nouvelle_fenetre_PasAssezArgent= new Stage();
                    PasAssezArgent fenetre_PasAssezArgent = new PasAssezArgent(automate, nouvelle_fenetre_PasAssezArgent, canvas);

                    Scene nouvelle_scene = new Scene(fenetre_PasAssezArgent,320,370);

                    nouvelle_fenetre_PasAssezArgent.setScene(nouvelle_scene);

                    //PRECISER QU'IL S'AGIT D'UNE FENETRE MODALE
                    nouvelle_fenetre_PasAssezArgent.initModality(Modality.WINDOW_MODAL);
                    nouvelle_fenetre_PasAssezArgent.initOwner(fenetre_actuelle);
                    //on ferme la fenêtre
                    fenetre_actuelle.close();

                }else{*/
                    //on rend la bonne opacité à la fenêtre
                    detruireCanvas(canvas);

zoneJoueur.SupprimerJoueur();
zoneJoueur.genereInfosJoueur(automate);
                    //on ferme la fenêtre
                    fenetre_actuelle.close();

                }


            //}
        });

        Button bt_rien= new Button("NE RIEN FAIRE");

        bt_rien.setLayoutX(300);
        bt_rien.setLayoutY(210);

        bt_rien.setPrefSize(150, 10);

        bt_rien.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //on rend la bonne opacité à la fenêtre
                detruireCanvas(canvas);

                //on ferme la fenêtre
                fenetre_actuelle.close();
            }
        });

////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre_actuelle.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

/////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre_actuelle.setMinHeight(300);
        fenetre_actuelle.setMinWidth(500);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(500);

        /////////////////////////////////////////////////////////////////////////AJOUT
        this.getChildren().add(l);
        this.getChildren().add(bt_acheter);
        this.getChildren().add(bt_rien);


    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }

    public void fenetreNoire()
    {

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        canvas.setOpacity(0.5);
        gc.fillRect(0,0, 1600,1600);
        this.getChildren().add(canvas);
    }
}
