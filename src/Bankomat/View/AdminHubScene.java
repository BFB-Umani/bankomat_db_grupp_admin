package Bankomat.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AdminHubScene {

    private VBox designLayout = new VBox();
    private Label adminHub = new Label("Admin hub");
    private Button accountHandling = new Button("handle client \naccounts"); //skapa nytt konto, avsluta konto, sätt in pengar på konto, ändra räntesats på konto, visa historik för konto
    private Button newClient = new Button("add new \nclient"); // lägg till ny kund
    private Button clientHandling = new Button("handle client info"); // uppdatera kunduppgifter, radera kund
    private Button loanHandling = new Button("handle a clients loan"); // visa betalplan på lån, ändra betalningsplan för lån
    private Button logOut = new Button("Log Out");



    public void setUp() {
        designLayout.getChildren().add(adminHub);
        designLayout.getChildren().add(logOut);

        GridPane buttonLayout = new GridPane();
        buttonLayout.add(newClient,0,0);
        buttonLayout.add(accountHandling,1,0);
        buttonLayout.add(clientHandling,0,1);
        buttonLayout.add(loanHandling,1,1);
        designLayout.getChildren().add(buttonLayout);

        adminHub.setPrefSize(300,275);
        adminHub.setMaxWidth(Double.MAX_VALUE);
        adminHub.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        adminHub.setId("titelText");

        buttonLayout.setHgap(10);
        buttonLayout.setVgap(10);

        newClient.setMinSize(150,100);
        accountHandling.setMinSize(150,100);
        clientHandling.setMinSize(150,100);
        loanHandling.setMinSize(150,100);

        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setId("buttonLayout");
    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getAdminHub() {
        return adminHub;
    }

    public Button getAccountHandling() {
        return accountHandling;
    }

    public Button getClientHandling() {
        return clientHandling;
    }

    public Button getLoanHandling() {
        return loanHandling;
    }

    public Button getNewClient() {
        return newClient;
    }

    public Button getLogOut() {
        return logOut;
    }
}
