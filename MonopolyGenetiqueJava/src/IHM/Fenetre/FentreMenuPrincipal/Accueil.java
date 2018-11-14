package IHM.Fenetre.FentreMenuPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;


public class Accueil extends Parent {
    Solo solo_fenetre;
    HumainVShumain humain_fenetre ;


    public Accueil(Stage primaryStage){
            //image
        URL logo = getClass().getResource("logo.png");
        Image image = new Image(logo.toExternalForm());
        ImageView imageView = new ImageView(image);
            //boutons
        Button solo = new Button("SOLO") ;
        Button HumainVShumain = new Button("HUMAIN VS HUMAIN");
        Button iaVSia = new Button("IA VS IA");
        Button quitter = new Button("QUITTER");

        //POSITION DES BOUTONS
        solo.setLayoutX(25);
        solo.setLayoutY(200);

        HumainVShumain.setLayoutX(25);
        HumainVShumain.setLayoutY(260);

        iaVSia.setLayoutX(25);
        iaVSia.setLayoutY(320);

        quitter.setLayoutX(25);
        quitter.setLayoutY(395);

        //TAILLE DES BOUTONS
        solo.setPrefSize(300,30);
        HumainVShumain.setPrefSize(300,30);
        iaVSia.setPrefSize(300,30);
        quitter.setPrefSize(300,30);

        //TAILLE DE L'IMAGE
        imageView.setFitWidth(300);
        imageView.setLayoutX(25);
        imageView.setPreserveRatio(true);

        //ACTION : SI ON APPUIE SUR SOLO
        solo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //création d'une fenetre solo, d'une nouvelle fenêtre et nouvelle scene avec les dimensions
                Stage nouvelle_fenetre = new Stage();
                Solo solo_fenetre = new Solo(primaryStage, nouvelle_fenetre);
                Scene nouvelle_scene = new Scene(solo_fenetre,620,380);

                nouvelle_fenetre.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre
                nouvelle_fenetre.show();

                //FERMETURE DE LA FENETRE ACCUEIL
                primaryStage.close() ;
            }
        });

        //ACTION : SI ON APPUIE SUR HumainVShumain
        HumainVShumain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //création d'une fenetre solo, d'une nouvelle fenêtre et nouvelle scene avec les dimensions
                Stage nouvelle_fenetre = new Stage();
                HumainVShumain humain_fenetre = new HumainVShumain(primaryStage, nouvelle_fenetre );
                Scene nouvelle_scene = new Scene(humain_fenetre,520,300);

                nouvelle_fenetre.setScene(nouvelle_scene);
                //on montre la nouvelle fenêtre et on ferme l'ancienne
                nouvelle_fenetre.show();
                primaryStage.close() ;
            }
        });

        //ACTION : SI ON APPUIE SUR iaVSia
        iaVSia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage nouvelle_fenetre = new Stage();
                IaVSia MenuIa = new IaVSia(primaryStage, nouvelle_fenetre) ;
                Scene nouvelle_scene = new Scene(MenuIa,520,300);

                nouvelle_fenetre.setScene(nouvelle_scene);
                nouvelle_fenetre.show();
                primaryStage.close();
            }
        });

        //ACTION : SI ON APPUIE SUR QUITTER
        quitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });


////////BLOQUAGE DE REDUCTION DE LA FENETRE
        primaryStage.setMinWidth(210);
        primaryStage.setMinHeight(330);


        // AJOUT A L'ECRAN
        this.getChildren().add(imageView);
        this.getChildren().add(solo);
        this.getChildren().add(HumainVShumain);
        this.getChildren().add(iaVSia);
        this.getChildren().add(quitter);
    }



}


