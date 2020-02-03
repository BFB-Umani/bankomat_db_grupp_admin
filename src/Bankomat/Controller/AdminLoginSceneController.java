package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Model.Admin;
import Bankomat.Main;
import Bankomat.View.AdminLoginScene;

import javax.swing.*;

public class AdminLoginSceneController {
    private String personalnumber;
    private String pin;
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
          //  try {
                personalnumber = adminLoginScene.getNameField().getText();
                pin = (adminLoginScene.getPasswdField().getText());

                Admin admin = rep.getAdmin(personalnumber, pin);
                if (admin != null) {
                    main.goToAdminHubScene(admin);
                }
           // }

/*            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "PersonNr + PIN (HELTAL)"); // ändra
            }*/
        });

    }
}
