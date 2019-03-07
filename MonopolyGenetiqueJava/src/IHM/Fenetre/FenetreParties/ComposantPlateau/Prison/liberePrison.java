package IHM.Fenetre.FenetreParties.ComposantPlateau.Prison;

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

public class liberePrison extends Parent {

    public liberePrison(Stage fenetre_actuelle, Canvas canvas)
    {
        //BOUTONS
        Button bt_attention = new Button("FELICITATION");

        bt_attention.setLayoutY(10);
        bt_attention.setLayoutX(10);
        bt_attention.setPrefSize(475,10);
        bt_attention.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        bt_attention.setTextFill(Color.WHITE);
        bt_attention.setBackground(new Background(new BackgroundFill(Color.rgb(9,172,227), null, null)));
        bt_attention.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,null,null)));


        Button bt_ok= new Button("OK");
        bt_ok.setLayoutX(175);
        bt_ok.setLayoutY(200);
        bt_ok.setPrefSize(150, 10);


        //LABEL
        Label l_Libere = new Label("Vous êtes libéré de prison ! ");
        l_Libere.setFont(Font.font("Verdana", FontWeight.NORMAL, 19));
        l_Libere.setLayoutX(110);
        l_Libere.setLayoutY(110);
        l_Libere.setWrapText(true);
        l_Libere.setTextAlignment(TextAlignment.CENTER);

        //RECTANGLE
        Rectangle r_fond = new Rectangle();
        r_fond.setHeight(230);
        r_fond.setWidth(475);
        r_fond.setLayoutX(10);
        r_fond.setLayoutY(10);
        r_fond.setStroke(Color.BLACK);
        r_fond.setStrokeWidth(1);
        r_fond.setFill(Color.TRANSPARENT);

/////////ACTION
        bt_ok.setOnAction(new EventHandler<ActionEvent>() {
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
        fenetre_actuelle.setMinWidth(515);

        fenetre_actuelle.setMaxHeight(300);
        fenetre_actuelle.setMaxWidth(515);

/////////AJOUT
        this.getChildren().add(r_fond);
        this.getChildren().add(bt_attention);
        this.getChildren().add(l_Libere);
        this.getChildren().add(bt_ok);

    }

    public void detruireCanvas(Canvas canvas)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.PAPAYAWHIP);
        canvas.setOpacity(0.5);
        this.getChildren().add(canvas);
    }
}
