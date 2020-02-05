package Bankomat.Controller;

import Bankomat.Database.Repository;
import Bankomat.Main;
import Bankomat.Model.Admin;
import Bankomat.View.ClientHandlingScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientHandlingSceneController {

    private ClientHandlingScene chs;
    private Repository rep;
    private Main main;
    private Admin admin;
    private int pin;
    private int customerId;
    private String prsNr;


    public ClientHandlingSceneController(ClientHandlingScene clientHandlingScene, Main main, Repository rep, Admin admin) {
        this.chs = clientHandlingScene;
        this.main = main;
        this.rep = rep;
        this.admin = admin;
    }

    public void start() {
        chs.setUp();

        chs.getBackB().setOnAction(actionEvent -> {
            changeToAdminHub();
        });

        chs.getUpdateClient().setOnAction(actionEvent -> {
            updateClientBox();
        });

        chs.getDeleteClient().setOnAction(actionEvent -> {
            deleteAccountBox();

        });
    }

    public void changeToAdminHub() {
        main.goToAdminHubScene();
    }

    public void deleteAccountBox() {
        chs.deleteAccountBox();
        chs.getOk().setOnAction(actionEvent -> {
            prsNr = chs.getPrsNrField().getText();
            rep.deleteCustomer(prsNr);
            chs.getDialogStage().close();
        });

    }

    public void updateClientBox() {
        chs.updateClientBox();
        chs.getOk().setOnAction(actionEvent -> {
            try {
                customerId = rep.getClient(chs.getPrsNrField().getText()).getID();
                pin = Integer.parseInt(chs.getPinField().getText());
            }catch (Exception e) {
                e.printStackTrace();
            }
            rep.updateCustomer(customerId,pin);
            chs.getDialogStage().close();
        });

    }
}
