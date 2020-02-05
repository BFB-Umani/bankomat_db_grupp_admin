package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.Model.Loan;
import Bankomat.Model.LoanToCustomer;
import Bankomat.View.LoanHandlingScene;


import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;


public class LoanHandlingSceneController {

    private LoanHandlingScene lhs;
    private Repository rep;
    private Main main;
    private Admin admin;
    private String newDate;
    private String loanToCustomer = "pending:\n";
    private int accountnumberChangeRate;
    private int pendingLoanID;
    private int accepted;
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

        lhs.getAccDenLoan().setOnAction(actionEvent -> {
            pendingLoanBox();
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

    public void pendingLoanBox() {
        lhs.pendingLoanBox();
        lhs.getSeePendingLoan().setOnAction(actionEvent -> {
            List<LoanToCustomer> loanList = rep.getPendingLoans();
            List<String> outputLoanList = loanList.stream().map(l -> "Id: " + l.getId() + " Namn: " + l.getClient().getFirstName() + " " + l.getClient().getFirstName() +
                    " " + "PersNr: " + l.getClient().getPersonNr() + " Lånsumma: " + l.getLoan().getStartAmount() + " till den: " +
                    l.getLoan().getPaymentPlan()).collect(Collectors.toList());
            loanToCustomer = "";
            for(String s: outputLoanList) {
                loanToCustomer += s + "\n";
            }
            JOptionPane.showMessageDialog(null, loanToCustomer);
//            loanToCustomer = "pending:\n";
        });

        lhs.getAcceptB().setOnAction(actionEvent -> {
            pendingLoanID = Integer.parseInt(lhs.getPendingLoanTF().getText());
            accepted = 1;
            rep.acceptOrDenyLoans(pendingLoanID, accepted);
            lhs.getDialogStage().close();
        });

        lhs.getDenyB().setOnAction(actionEvent -> {
            pendingLoanID = Integer.parseInt(lhs.getPendingLoanTF().getText());
            accepted = 0;
            rep.acceptOrDenyLoans(pendingLoanID, accepted);
            lhs.getDialogStage().close();
        });

    }
}
