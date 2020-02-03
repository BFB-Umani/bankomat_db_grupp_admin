package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Model.Admin;
import Bankomat.Main;
import Bankomat.Model.Client;
import Bankomat.View.AdminLoginScene;

import javax.swing.*;

public class AdminLoginSceneController {
    private String personNr;
    private String password;
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
            personNr = adminLoginScene.getNameField().getText();
            password = adminLoginScene.getPasswdField().getText();

            try {
                personNr = adminLoginScene.getNameField().getText();
                password = adminLoginScene.getPasswdField().getText();
                Admin admin = rep.getAdmin(personNr, password);
                if(admin != null) {
                    changeToAdminHub();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "PersonNr + PIN (HELTAL)"); // ändra
            }



        });

    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }
}