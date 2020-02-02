package bankomat;

import bankomat.Controller.*;
import bankomat.Model.Admin;
import bankomat.Model.Database;
import bankomat.View.*;
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
    private Database db = new Database();
    public Stage stage = new Stage();

    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Shoe Shop");
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

        AdminLoginSceneController adminLoginSceneController = new AdminLoginSceneController(adminLoginScene,this, db, admin);
        adminLoginSceneController.start();

        AdminHubSceneController adminHubSceneController = new AdminHubSceneController(adminHubScene,this, db, admin);
        adminHubSceneController.start();

        AccountHandlingSceneController accountHandlingSceneController = new AccountHandlingSceneController(accountHandlingScene,this, db, admin);
        accountHandlingSceneController.start();

        /*
        ClientHandlingSceneController clientHandlingSceneController = new ClientHandlingSceneController(clientHandlingScene,this, db, admin);
        clientHandlingSceneController.start();

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
}
