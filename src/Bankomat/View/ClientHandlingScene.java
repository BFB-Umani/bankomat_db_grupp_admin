package Bankomat.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ClientHandlingScene {

    private VBox designLayout = new VBox();
    private Label clientHandlingLabel = new Label("Client handling");
    private Button updateClient = new Button("update clients info");
    private Button deleteClient = new Button("delete a client");
    private Button backB = new Button("back");


    public void setUp() {
        designLayout.getChildren().add(clientHandlingLabel);


        GridPane buttonLayout = new GridPane();
        buttonLayout.add(deleteClient,0,0);
        buttonLayout.add(updateClient,0,1);
        designLayout.getChildren().add(buttonLayout);

        clientHandlingLabel.setPrefSize(300,275);
        clientHandlingLabel.setMaxWidth(Double.MAX_VALUE);
        clientHandlingLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        clientHandlingLabel.setId("titelText");

        deleteClient.setPadding(new Insets(10));
        updateClient.setPadding(new Insets(10));

        deleteClient.setMinSize(100,100);
        updateClient.setMinSize(100,100);


        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setId("buttonLayout");
    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getClientHandlingLabel() {
        return clientHandlingLabel;
    }

    public Button getUpdateClient() {
        return updateClient;
    }

    public Button getDeleteClient() {
        return deleteClient;
    }

    public Button getBackB() {
        return backB;
    }
}
