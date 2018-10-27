package IHM.Fenetre;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HumainVShumain extends Parent {

    public HumainVShumain(){

        StackPane secondaryLayout = new StackPane();

        Scene secondScene = new Scene(secondaryLayout, 500, 500);

        // nouvelle fenêtre
        Stage Humain = new Stage();
        Humain.setTitle("Humain VS Humain");
        Humain.setScene(secondScene);

        Humain.show();

    }

}
