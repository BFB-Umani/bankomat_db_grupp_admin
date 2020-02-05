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

    private LoanHandlingScene lhs;
    private Repository rep;
    private Main main;
    private Admin admin;
    private String newDate;
    private int accountnumberChangeRate;
    private double rateChangeRate;

    public LoanHandlingSceneController(LoanHandlingScene loanHandlingScene, Main main, Repository rep, Admin admin) {
        this.lhs = loanHandlingScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        lhs.setUp();

        lhs.getBackB().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

        lhs.getPaymentPlan().setOnAction(actionEvent -> {
            Loan loan = rep.getPaymentPlan();
            JOptionPane.showMessageDialog(null, loan.getPaymentPlan());
        });

        lhs.getChangePayment().setOnAction(actionEvent -> {
            changeDateBox();

        });

        lhs.getChangeRent().setOnAction(actionEvent -> {
            changeRateBox();

        });
    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }

    public void changeRateBox() {
        lhs.changeRateBox();
        lhs.getOkB().setOnAction(actionEvent -> {
            accountnumberChangeRate = Integer.parseInt(lhs.getChangeRateTFAccount().getText());
            rateChangeRate = Double.parseDouble(lhs.getChangeRateTFRate().getText());
            rep.changeRateForLoan(accountnumberChangeRate, rateChangeRate);
            lhs.getDialogStage().close();
        });

    }

    public void changeDateBox() {
        lhs.changeDateBox();
        lhs.getOkB().setOnAction(actionEvent -> {
            accountnumberChangeRate = Integer.parseInt(lhs.getChangeRateTFAccount().getText());
            newDate = lhs.getChangeRateTFRate().getText();
            rep.changePaymentPlanForLoan(accountnumberChangeRate, newDate);
            lhs.getDialogStage().close();
        });

    }
}
