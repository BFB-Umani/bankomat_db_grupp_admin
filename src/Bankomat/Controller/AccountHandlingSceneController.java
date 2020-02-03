package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.View.AccountHandlingScene;
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

public class AccountHandlingSceneController {
    private AccountHandlingScene accountHandlingScene;
    private Repository rep;
    private Main main;
    private Admin admin;
    private Label closeLabel = new Label("Ange kontonummer");
    private Label newAccountLabel = new Label("Ange kundnummer");
    private Label changeRateLabelAccount = new Label("Ange kontonummer");
    private Label changeRateLabelRate = new Label("Ange ny ränta");
    private Label addFundsLabelAccount = new Label("Ange konto att sätta in pengar på");
    private Label addFundsLabelAmount = new Label("Ange belopp");

    private TextField accountnumber = new TextField();
    private TextField createNewAccountTF = new TextField();
    private TextField changeRateTFAccount = new TextField();
    private TextField changeRateTFRate = new TextField();
    private TextField addFundsTFAccount = new TextField();
    private TextField addFundsTFAmount = new TextField();

    private Button okbutton = new Button("OK");
    private Button okbuttonnewaccount = new Button("OK");
    private Button okbuttonchangerate = new Button("OK");
    private Button okbuttonaddfunds = new Button("OK");

    private int accID;
    private int custID;
    private int accountnumberChangeRate;
    private double rateChangeRate;
    private int accountNumberInt;
    private int amount;


    public AccountHandlingSceneController(AccountHandlingScene accountHandlingScene, Main main, Repository rep, Admin admin) {
        this.accountHandlingScene = accountHandlingScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        accountHandlingScene.setUp();

        accountHandlingScene.getBackB().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

        accountHandlingScene.getAccountHistory().setOnAction(actionEvent -> {

        });

        accountHandlingScene.getNewAccount().setOnAction(actionEvent -> {
            newAccountBox();
        });

        accountHandlingScene.getCloseAccount().setOnAction(actionEvent -> {
            closeAccountBox();
        });

        accountHandlingScene.getChangeRate().setOnAction(actionEvent -> {
            changeRateBox();
        });

        accountHandlingScene.getAddFunds().setOnAction(actionEvent -> {
            addFundsToAccountBox();
        });

    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }

    public void closeAccountBox() {

        Stage dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(closeLabel);
        HBox prNrArea = new HBox(accountnumber);
        HBox buttons = new HBox(okbutton);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        closeLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        okbutton.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okbutton.setCursor(Cursor.HAND);

        okbutton.setOnAction(actionEvent -> {
            accID = Integer.parseInt(accountnumber.getText());
            rep.deleteAccount(accID);
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void newAccountBox() {
        Stage dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(newAccountLabel);
        HBox nrArea = new HBox(createNewAccountTF);
        HBox buttons = new HBox(okbuttonnewaccount);
        layout.getChildren().add(hBox);
        layout.getChildren().add(nrArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        closeLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        nrArea.setAlignment(Pos.CENTER);
        nrArea.setPadding(new Insets(15));
        okbutton.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okbutton.setCursor(Cursor.HAND);

        okbutton.setOnAction(actionEvent -> {
            custID = Integer.parseInt(createNewAccountTF.getText());
            rep.createAccount(custID);
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void changeRateBox() {
        Stage dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(changeRateLabelAccount);
        HBox pinHbox = new HBox(changeRateLabelRate);
        HBox prNrArea = new HBox(changeRateTFAccount);
        HBox pinArea = new HBox(changeRateTFRate);
        HBox buttons = new HBox(okbuttonchangerate);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(pinHbox);
        layout.getChildren().add(pinArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        changeRateLabelAccount.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        pinHbox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        pinArea.setAlignment(Pos.CENTER);
        pinArea.setPadding(new Insets(15));
        okbuttonchangerate.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okbuttonchangerate.setCursor(Cursor.HAND);

        okbuttonchangerate.setOnAction(actionEvent -> {
            accountnumberChangeRate = Integer.parseInt(changeRateTFAccount.getText());
            rateChangeRate = Double.parseDouble(changeRateTFRate.getText());
            rep.changeRateForAccount(accountnumberChangeRate, rateChangeRate);
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void addFundsToAccountBox(){
        Stage dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(addFundsLabelAccount);
        HBox pinHbox = new HBox(addFundsLabelAmount);
        HBox prNrArea = new HBox(addFundsTFAccount);
        HBox pinArea = new HBox(addFundsTFAmount);
        HBox buttons = new HBox(okbuttonaddfunds);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(pinHbox);
        layout.getChildren().add(pinArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        addFundsLabelAccount.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        pinHbox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        pinArea.setAlignment(Pos.CENTER);
        pinArea.setPadding(new Insets(15));
        okbuttonaddfunds.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okbuttonaddfunds.setCursor(Cursor.HAND);

        okbuttonaddfunds.setOnAction(actionEvent -> {
            accountNumberInt = Integer.parseInt(addFundsTFAccount.getText());
            amount = Integer.parseInt(addFundsTFAmount.getText());
            rep.depositIntoAccount(accountNumberInt, amount);
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


