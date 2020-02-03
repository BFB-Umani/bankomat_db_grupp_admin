package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.View.ClientHandlingScene;

public class ClientHandlingSceneController {

    private ClientHandlingScene clientHandlingScene;
    private Repository rep;
    private Main main;
    private Admin admin;


    public ClientHandlingSceneController(ClientHandlingScene clientHandlingScene, Main main, Repository rep, Admin admin) {
        this.clientHandlingScene = clientHandlingScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        clientHandlingScene.setUp();

        clientHandlingScene.getBackB().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

        clientHandlingScene.getUpdateClient().setOnAction(actionEvent -> {

        });

        clientHandlingScene.getDeleteClient().setOnAction(actionEvent -> {

        });
    }

    public void changeToAdminHub() {
        main.goToAdminHubScene(admin);
    }
}
