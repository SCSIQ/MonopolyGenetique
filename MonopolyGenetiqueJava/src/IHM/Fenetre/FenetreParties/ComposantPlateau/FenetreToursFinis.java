package IHM.Fenetre.FenetreParties.ComposantPlateau;

import Metier.Automate.Automate;
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

public class FenetreToursFinis extends Parent {

    //ATTRIBUTS
    private Canvas canvas ;

    public FenetreToursFinis(Stage fenetre, Canvas canvas, Automate automate)
    {
        //Initaialisation
        this.canvas = canvas ;

        /////////////////////LABEL
        Button bt_fin = new Button("FIN DE PARTIE");
        bt_fin.setLayoutY(10);
        bt_fin.setLayoutX(10);
        bt_fin.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_fin.setTextFill(Color.WHITE);
        bt_fin.setBackground(new Background(new BackgroundFill( Color.rgb(9,172,227),null, null)));
        bt_fin.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));
        bt_fin.setPrefSize(475,50);

        ////////////////////////RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(235);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

        /////////////////////////////////////CONTENU
        Label l_contenu = new Label("Vous avez joué les "+automate.getNumTour()+" tours.\nLa partie est finie.");
        l_contenu.setLayoutX(130);
        l_contenu.setLayoutY(100);
        l_contenu.setMaxWidth(300);
        l_contenu.setWrapText(true);
        l_contenu.setTextAlignment(TextAlignment.CENTER);
        l_contenu.setFont(Font.font("Verdana", FontWeight.NORMAL, 16));


        ///////////////////Bouton voir les scores
        Button bt_score = new Button("Voir les scores");
        bt_score.setLayoutX(175);
        bt_score.setLayoutY(200);

        bt_score.setPrefSize(150,10);

        bt_score.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                detruireCanvas(canvas);

                fenetre.close();

            }
        });

        ////////EMPECHE LA FENETRE D'ETRE FERMEE TANT QUE L'USER NE CLIQUE PAS SUR UN BOUTON
        fenetre.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                event.consume();
            }
        });

        /////////TAILLE MIN ET MAX DE LA FENETRE
        fenetre.setMinHeight(300);
        fenetre.setMinWidth(515);

        fenetre.setMaxHeight(300);
        fenetre.setMaxWidth(515);


        /////////////AJOUT
        this.getChildren().add(bt_fin);
        this.getChildren().add(r_fond);
        this.getChildren().add(l_contenu);
        this.getChildren().add(bt_score);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
