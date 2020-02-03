package Bankomat;

import Bankomat.Controller.*;
import Bankomat.Database.Repository;
import Bankomat.Model.Admin;
import Bankomat.Model.Client;
import Bankomat.View.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;
    private AdminLoginScene adminLoginScene;
    private AdminHubScene adminHubScene;
    private AccountHandlingScene accountHandlingScene;
    private ClientHandlingScene clientHandlingScene;
    private NewClientScene newClientScene;
    private LoanHandlingScene loanHandlingScene;
    private Admin admin = new Admin();
    private Repository rep = new Repository();
    private Client client;
    public Stage stage = new Stage();

    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Sookyung bank");
        stage.setResizable(false);
        adminLoginScene = new AdminLoginScene();
        adminHubScene = new AdminHubScene();
        accountHandlingScene = new AccountHandlingScene();
        clientHandlingScene = new ClientHandlingScene();
        newClientScene = new NewClientScene();
        loanHandlingScene = new LoanHandlingScene();


        scene = new Scene(adminLoginScene.getDesignLayout(),480,620);
        scene.getStylesheets().add(Main.class.getResource("Style.css").toExternalForm());
        stage.setScene(scene);

        AdminLoginSceneController adminLoginSceneController = new AdminLoginSceneController(adminLoginScene,this, rep, admin);
        adminLoginSceneController.start();

        AdminHubSceneController adminHubSceneController = new AdminHubSceneController(adminHubScene,this, rep, admin);
        adminHubSceneController.start();

        NewClientSceneController newClientSceneController = new NewClientSceneController(newClientScene,this, rep, admin);
        newClientSceneController.start();


        ClientHandlingSceneController clientHandlingSceneController = new ClientHandlingSceneController(clientHandlingScene,this, rep, admin);
        clientHandlingSceneController.start();

        AccountHandlingSceneController accountHandlingSceneController = new AccountHandlingSceneController(accountHandlingScene,this, rep, admin);
        accountHandlingSceneController.start();

        /*
        LoanHandlingSceneController loanHandlingSceneController = new LoanHandlingSceneController(loanHandlingScene,this, db, admin);
        loanHandlingSceneController.start();

        ta bort kommentarer när controller för dessa är fixade.
        */

        stage.setOnCloseRequest(t -> {
            stage.close();
            System.exit(0);
        });

        stage.show();
    }

    public void goToAdminLogin() {
        scene.setRoot(adminLoginScene.getDesignLayout());
    }

    public void goToAdminHubScene() {
        scene.setRoot(adminHubScene.getDesignLayout());
    }

    public void goToAccountHandlingScene() {
        scene.setRoot(accountHandlingScene.getDesignLayout());
    }

    public void goToNewClientScene() {
        scene.setRoot(newClientScene.getDesignLayout());
    }

    public void goToClientHandlingScene() {
        scene.setRoot(clientHandlingScene.getDesignLayout());
    }

    public void goToLoanHandlingScene() {
        scene.setRoot(loanHandlingScene.getDesignLayout());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
