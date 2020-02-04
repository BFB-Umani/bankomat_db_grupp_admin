package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.Model.Loan;
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

public class LoanHandlingSceneController {

    private LoanHandlingScene loanHandlingScene;
    private Repository rep;
    private Main main;
    private Admin admin;

    private Label changeRateLabelAccount = new Label("Ange kontonummer");
    private Label changeRateLabelRate = new Label("Ange ny ränta");
    private Label updatePaymentPlanAccount = new Label("Ange konto för att byta betalningsplan på"); //update payment plan
    private Label updatePaymentPlanDate = new Label("Ange datum \"XXXX-XX-XX\"");

    private TextField changeRateTFAccount = new TextField();
    private TextField changeRateTFRate = new TextField();
    private TextField updatePaymentTFAccount = new TextField();
    private TextField updatePaymentTFDate = new TextField();

    private Button okB = new Button("OK");

    private String newDate;
    private int accountnumberChangeRate;
    private double rateChangeRate;

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
        HBox buttons = new HBox(okB);
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
        okB.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okB.setCursor(Cursor.HAND);

        okB.setOnAction(actionEvent -> {
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
        HBox hBox = new HBox(updatePaymentPlanAccount);
        HBox pinHbox = new HBox(updatePaymentPlanDate);
        HBox prNrArea = new HBox(updatePaymentTFAccount);
        HBox pinArea = new HBox(updatePaymentTFDate);
        HBox buttons = new HBox(okB);
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
        okB.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okB.setCursor(Cursor.HAND);

        okB.setOnAction(actionEvent -> {
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
