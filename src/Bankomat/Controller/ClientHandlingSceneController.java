package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.View.ClientHandlingScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientHandlingSceneController {

    private ClientHandlingScene clientHandlingScene;
    private Repository rep;
    private Main main;
    private Admin admin;
    private Label orderLabel = new Label("skriv in personNummer för kund");
    private Label pinLabel = new Label("skriv in ny personnummer och ny pin-kod för kund");
    private TextField prsNrField = new TextField();
    private TextField pinField = new TextField();
    private Button ok = new Button("ok");
    private int pin;
    private int customerId;
    private String prsNr;


    public ClientHandlingSceneController(ClientHandlingScene clientHandlingScene, Main main, Repository rep, Admin admin) {
        this.clientHandlingScene = clientHandlingScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        clientHandlingScene.setUp();

        clientHandlingScene.getBackB().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

        clientHandlingScene.getUpdateClient().setOnAction(actionEvent -> {
            updateClientBox();
        });

        clientHandlingScene.getDeleteClient().setOnAction(actionEvent -> {
            deleteAccountBox();

        });
    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }

    public void deleteAccountBox() {

        Stage dialogStage = new Stage();
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

        ok.setOnAction(actionEvent -> {
            prsNr = prsNrField.getText();
            rep.deleteCustomer(prsNr);
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void updateClientBox() {

        Stage dialogStage = new Stage();
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

        ok.setOnAction(actionEvent -> {
            customerId = rep.getClient(prsNrField.getText()).getID();
            pin = Integer.parseInt(pinField.getText());
            rep.updateCustomer(customerId,pin);
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }
}
