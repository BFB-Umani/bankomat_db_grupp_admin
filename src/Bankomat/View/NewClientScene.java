package Bankomat.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NewClientScene {

    private VBox designLayout = new VBox();
    private Label NewClientLabel = new Label("Admin hub");
    private Button logOut = new Button("Log Out");


    public void setUp() {
        designLayout.getChildren().add(NewClientLabel);


        HBox buttonLayout = new HBox();
        designLayout.getChildren().add(buttonLayout);

        NewClientLabel.setPrefSize(300,275);
        NewClientLabel.setMaxWidth(Double.MAX_VALUE);
        NewClientLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        NewClientLabel.setId("titelText");

        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setId("buttonLayout");
    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getNewClientLabel() {
        return NewClientLabel;
    }

    public Button getLogOut() {
        return logOut;
    }
}
