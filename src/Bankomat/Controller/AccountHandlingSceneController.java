package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.AccountHistory;
import Bankomat.Model.Admin;
import Bankomat.View.AccountHandlingScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AccountHandlingSceneController {
    private AccountHandlingScene ahs;
    private Repository rep;
    private Main main;
    private Admin admin;


    public AccountHandlingSceneController(AccountHandlingScene accountHandlingScene, Main main, Repository rep, Admin admin) {
        this.ahs = accountHandlingScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        ahs.setUp();

        ahs.getBackB().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

        ahs.getAccountHistory().setOnAction(actionEvent -> {

            changeHistoryBox();
        });

        ahs.getNewAccount().setOnAction(actionEvent -> {
            newAccountBox();
        });

        ahs.getCloseAccount().setOnAction(actionEvent -> {
            closeAccountBox();
        });

        ahs.getChangeRate().setOnAction(actionEvent -> {
            changeRateBox();
        });

        ahs.getAddFunds().setOnAction(actionEvent -> {
            addFundsToAccountBox();
        });

    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }


    private void changeHistoryBox() {
        ahs.changeHistoryBox();
        ahs.getOkbuttonhistory().setOnAction(actionEvent -> {
            int accId = Integer.parseInt(ahs.getAccHistNrText().getText());
            String s1 = ahs.getD1().getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String s2 = ahs.getD2().getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.println(s1 + " " + s2);
            List<AccountHistory> historyList = rep.getIntervalHistory(accId,
                    s1, s2);

            for(AccountHistory a: historyList) {
                System.out.println("Före: " +  a.getBalanceBefore() + " Uttag: " + a.getWithdraw() + " Efter: " +
                        a.getBalanceAfter() + " Datum:" + a.getDate());;
            }

            List<String> outputHist = historyList.stream().map(a ->"Före: " +  a.getBalanceBefore() + " Uttag: " + a.getWithdraw() + " Efter: " +
                    a.getBalanceAfter() + " Datum:" + a .getDate()).collect(Collectors.toList());
            ahs.showHistory(outputHist);
        });
    }

    public void closeAccountBox() {
        ahs.closeAccountBox();
        ahs.getOkbutton().setOnAction(actionEvent -> {
            int accID = Integer.parseInt(ahs.getAccountNumber().getText());
            rep.deleteAccount(accID);
            ahs.getDialogStage().close();
        });
    }

    public void newAccountBox() {
        ahs.newAccountBox();
        ahs.getOkButtonNewAccount().setOnAction(actionEvent -> {
            int custID = Integer.parseInt(ahs.getCreateNewAccountTF().getText());
            rep.createAccount(custID);
            ahs.getDialogStage().close();
        });

    }

    public void changeRateBox() {
        ahs.changeRateBox();
        ahs.getOkButtonChangeRate().setOnAction(actionEvent -> {
            int accountnumberChangeRate = Integer.parseInt(ahs.getChangeRateTFAccount().getText());
            double rateChangeRate = Double.parseDouble(ahs.getChangeRateTFRate().getText());
            rep.changeRateForAccount(accountnumberChangeRate, rateChangeRate);
            ahs.getDialogStage().close();
        });

    }



    public void addFundsToAccountBox(){
        ahs.addFundsToAccountBox();
        ahs.getOkButtonAddFunds().setOnAction(actionEvent -> {
            int accountNumberInt = Integer.parseInt(ahs.getAddFundsTFAccount().getText());
            int amount = Integer.parseInt(ahs.getAddFundsTFAmount().getText());
            rep.depositIntoAccount(accountNumberInt, amount);
            ahs.getDialogStage().close();
        });

    }

}


