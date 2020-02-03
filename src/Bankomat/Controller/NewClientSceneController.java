package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.View.NewClientScene;

import javax.swing.*;

public class NewClientSceneController {
    private String input1;
    private String input2;
    private String input3;
    private String input4;
    private NewClientScene newClientScene;
    private Repository rep;
    private Main main;
    private Admin admin;

    public NewClientSceneController(NewClientScene newClientScene, Main main, Repository rep, Admin admin) {
        this.newClientScene = newClientScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        newClientScene.setUp();

        newClientScene.getBackB().setOnAction(actionEvent -> {
            changeToHubScene();
        });

        newClientScene.getCreateAccount().setOnAction(actionEvent -> {
            input1 = newClientScene.getFirstNameField().getText();
            input2 = newClientScene.getLastNameField().getText();
            input3 = newClientScene.getPinField().getText();
            input4 = newClientScene.getPersonalNumberField().getText();
            if (!input1.equalsIgnoreCase("") && !input2.equalsIgnoreCase("") && !input3.equalsIgnoreCase("")&& !input4.equalsIgnoreCase("")) {

                rep.createCustomer(input1,input2,Integer.parseInt(input3),input4);

                JOptionPane.showMessageDialog(null,"ny kund tillagd i systemet");
                changeToHubScene();
            }
        });

    }

    public String getInput() {
        return input1;
    }

    public void changeToHubScene() {
        main.goToAdminHubScene();
    }
}
