package bankomat.Controller;

import bankomat.Main;
import bankomat.Model.Admin;
import bankomat.Model.Database;
import bankomat.View.AdminHubScene;

public class AdminHubSceneController {
    private AdminHubScene adminHubScene;
    private Database database;
    private Main main;
    private Admin admin;


    public AdminHubSceneController(AdminHubScene adminHubScene, Main main, Database database, Admin admin) {
        this.adminHubScene = adminHubScene;
        this.main = main;
        this.database = database;
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
