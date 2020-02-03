package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.View.AccountHandlingScene;

public class AccountHandlingSceneController {
    private AccountHandlingScene accountHandlingScene;
    private Repository rep;
    private Main main;
    private Admin admin;


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

        });

        accountHandlingScene.getCloseAccount().setOnAction(actionEvent -> {

        });

        accountHandlingScene.getChangeRate().setOnAction(actionEvent -> {

        });

        accountHandlingScene.getAddFunds().setOnAction(actionEvent -> {

        });

    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }
}
