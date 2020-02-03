package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.View.AdminHubScene;


public class AdminHubSceneController {
    private AdminHubScene adminHubScene;
    private Repository rep;
    private Main main;
    private Admin admin;

    public AdminHubSceneController(AdminHubScene adminHubScene, Main main, Repository rep, Admin admin) {
        this.adminHubScene = adminHubScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        adminHubScene.setUp();

        adminHubScene.getAccountHandling().setOnAction(actionEvent -> {
            changeToAccountHandling();
        });
        adminHubScene.getLoanHandling().setOnAction(actionEvent -> {
            changeToLoanHandling();
        });
        adminHubScene.getClientHandling().setOnAction(actionEvent -> {
            changeToClientHandling();
        });
        adminHubScene.getNewClient().setOnAction(actionEvent -> {
            changeToNewClient();
        });

        adminHubScene.getLogOut().setOnAction(actionEvent -> {
            changeToAdminLogin();
        });

    }

    public void changeToAdminLogin() {
        main.goToAdminLogin();
    }

    public void changeToAccountHandling() {
        main.goToAccountHandlingScene();
    }

    public void changeToLoanHandling() {
        main.goToLoanHandlingScene();
    }

    public void changeToClientHandling() {
        main.goToClientHandlingScene();
    }

    public void changeToNewClient() {
        main.goToNewClientScene();
    }
}
