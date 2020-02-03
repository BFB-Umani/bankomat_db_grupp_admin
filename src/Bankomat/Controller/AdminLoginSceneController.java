package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Model.Admin;
import Bankomat.Main;
import Bankomat.View.AdminLoginScene;

public class AdminLoginSceneController {
    private String input1;
    private String input2;
    private AdminLoginScene adminLoginScene;
    private Repository rep;
    private Main main;
    private Admin admin;


    public AdminLoginSceneController(AdminLoginScene adminLoginScene, Main main, Repository rep, Admin admin) {
        this.adminLoginScene = adminLoginScene;
        this.main = main;
        this.rep = rep;
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