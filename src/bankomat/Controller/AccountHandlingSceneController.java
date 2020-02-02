package bankomat.Controller;

import bankomat.Main;
import bankomat.Model.Admin;
import bankomat.Model.Database;
import bankomat.View.AccountHandlingScene;

public class AccountHandlingSceneController {
    private AccountHandlingScene accountHandlingScene;
    private Database database;
    private Main main;
    private Admin admin;


    public AccountHandlingSceneController(AccountHandlingScene accountHandlingScene, Main main, Database database, Admin admin) {
        this.accountHandlingScene = accountHandlingScene;
        this.main = main;
        this.database = database;
        this.admin = admin;
    }

    public void start() {
        accountHandlingScene.setUp();

        accountHandlingScene.getLogOut().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }
}
