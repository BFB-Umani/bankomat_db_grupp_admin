package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.Model.Loan;
import Bankomat.View.ClientHandlingScene;
import Bankomat.View.LoanHandlingScene;
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

import javax.swing.*;
import java.util.Date;

public class LoanHandlingSceneController {

    private LoanHandlingScene loanHandlingScene;
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

    private Button okbuttonchangerate = new Button("OK");

    private int accID;
    private String newDate;
    private int accountnumberChangeRate;
    private double rateChangeRate;
    private int accountNumberInt;
    private int amount;


    public LoanHandlingSceneController(LoanHandlingScene loanHandlingScene, Main main, Repository rep, Admin admin) {
        this.loanHandlingScene = loanHandlingScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        loanHandlingScene.setUp();

        loanHandlingScene.getBackB().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

        loanHandlingScene.getPaymentPlan().setOnAction(actionEvent -> {
            Loan loan = rep.getPaymentPlan();
            JOptionPane.showMessageDialog(null, loan.getPaymentPlan());
        });

        loanHandlingScene.getChangePayment().setOnAction(actionEvent -> {
            changeDateBox();

        });

        loanHandlingScene.getChangeRent().setOnAction(actionEvent -> {
            changeRateBox();

        });
    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
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
            rep.changeRateForLoan(accountnumberChangeRate, rateChangeRate);
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void changeDateBox() {
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
            newDate = changeRateTFRate.getText();
            rep.changePaymentPlanForLoan(accountnumberChangeRate, newDate);
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
