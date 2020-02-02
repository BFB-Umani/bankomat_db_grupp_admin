package bankomat.Model;

import bankomat.Controller.AdminLoginSceneController;
import bankomat.View.AdminLoginScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;
    private AdminLoginScene adminLoginScene;
    private Admin admin = new Admin();
    private Database db = new Database();
    public Stage stage = new Stage();

    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Shoe Shop");
        stage.setResizable(false);
        adminLoginScene = new AdminLoginScene();

        scene = new Scene(adminLoginScene.getDesignLayout(),480,620);
        scene.getStylesheets().add(Main.class.getResource("Style.css").toExternalForm());
        stage.setScene(scene);

        AdminLoginSceneController adminLoginSceneController = new AdminLoginSceneController(adminLoginScene,this, db, admin);
        adminLoginSceneController.start();

        stage.setOnCloseRequest(t -> {
            stage.close();
            System.exit(0);
        });

        stage.show();
    }

    public void goToAdminLogin() {
        scene.setRoot(adminLoginScene.getDesignLayout());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
