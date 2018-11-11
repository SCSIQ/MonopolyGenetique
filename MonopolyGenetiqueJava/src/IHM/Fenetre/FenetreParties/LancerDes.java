package IHM.Fenetre.FenetreParties;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LancerDes extends Parent {

    public LancerDes(Stage primaryStage, Stage nouvelle_fenetre)
    {
        Label des = new Label("VOUS AVEZ OBTENU : ");

        des.setLayoutX(40);
        des.setLayoutY(20);
        des.setFont(Font.font("Verdana", FontWeight.BOLD, 16));

        Button bt_OK = new Button("OK") ;
        bt_OK.setLayoutX(130);
        bt_OK.setLayoutY(175);
        bt_OK.setPrefSize(50,10);

        this.getChildren().add(des) ;
        this.getChildren().add(bt_OK) ;

    }

}
