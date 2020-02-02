package bankomat.Controller;

import bankomat.Model.Admin;
import bankomat.Model.Database;
import bankomat.Main;
import bankomat.View.AdminLoginScene;

public class AdminLoginSceneController {
    private String input1;
    private String input2;
    private AdminLoginScene adminLoginScene;
    private Database database;
    private Main main;
    private Admin admin;


    public AdminLoginSceneController(AdminLoginScene adminLoginScene, Main main, Database database, Admin admin) {
        this.adminLoginScene = adminLoginScene;
        this.main = main;
        this.database = database;
        this.admin = admin;
    }

    public void start() {
        adminLoginScene.setUp();

        adminLoginScene.getLoginButton().setOnAction(actionEvent -> {
            input1 = adminLoginScene.getNameField().getText();
            input2 = adminLoginScene.getPasswdField().getText();

            // kod för inlogg.

            changeToAdminHub();

        });

    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }
}