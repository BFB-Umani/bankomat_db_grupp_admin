package Bankomat.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientHandlingScene {

    private VBox designLayout = new VBox();
    private Label clientHandlingLabel = new Label("Client handling");
    private Button updateClient = new Button("update clients info");
    private Button deleteClient = new Button("delete a client");
    private Button backB = new Button("back");

    private Label orderLabel = new Label("skriv in personNummer för kund");
    private Label pinLabel = new Label("skriv in ny personnummer och ny pin-kod för kund");
    private TextField prsNrField = new TextField();
    private TextField pinField = new TextField();
    private Button ok = new Button("ok");
    private Stage dialogStage;

    public TextField getPrsNrField() {
        return prsNrField;
    }

    public TextField getPinField() {
        return pinField;
    }

    public Button getOk() {
        return ok;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setUp() {
        designLayout.getChildren().add(clientHandlingLabel);
        designLayout.getChildren().add(backB);


        GridPane buttonLayout = new GridPane();
        buttonLayout.add(deleteClient,0,0);
        buttonLayout.add(updateClient,1,0);
        designLayout.getChildren().add(buttonLayout);

        clientHandlingLabel.setPrefSize(300,275);
        clientHandlingLabel.setMaxWidth(Double.MAX_VALUE);
        clientHandlingLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        clientHandlingLabel.setId("titelText");

        deleteClient.setPadding(new Insets(10));
        updateClient.setPadding(new Insets(10));

        deleteClient.setMinSize(150,100);
        updateClient.setMinSize(150,100);


        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setVgap(10);
        buttonLayout.setHgap(10);
        buttonLayout.setId("buttonLayout");
    }

    public void deleteAccountBox() {

        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(orderLabel);
        HBox prNrArea = new HBox(prsNrField);
        HBox buttons = new HBox(ok);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        orderLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        ok.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        ok.setCursor(Cursor.HAND);
        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }
    public void updateClientBox() {

        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(orderLabel);
        HBox pinHbox = new HBox(pinLabel);
        HBox prNrArea = new HBox(prsNrField);
        HBox pinArea = new HBox(pinField);
        HBox buttons = new HBox(ok);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(pinHbox);
        layout.getChildren().add(pinArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        orderLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        pinHbox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        pinArea.setAlignment(Pos.CENTER);
        pinArea.setPadding(new Insets(15));
        ok.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        ok.setCursor(Cursor.HAND);
        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
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
