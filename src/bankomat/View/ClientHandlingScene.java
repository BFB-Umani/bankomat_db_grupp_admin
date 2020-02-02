package bankomat.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ClientHandlingScene {

    private VBox designLayout = new VBox();
    private Label clientHandlingLabel = new Label("Admin hub");
    private Button newClient = new Button("create new client account"); // lägg till ny kund
    private Button accountHandling = new Button("handle a clients account"); //skapa nytt konto, avsluta konto, sätt in pengar på konto, ändra räntesats på konto, visa historik för konto
    private Button clientHandling = new Button("handle a clients info"); // uppdatera kunduppgifter, radera kund
    private Button loanHandling = new Button("handle a clients loan"); // visa betalplan på lån, ändra betalningsplan för lån
    private Button logOut = new Button("Log Out");


    public void setUp() {
        designLayout.getChildren().add(clientHandlingLabel);


        GridPane buttonLayout = new GridPane();
        buttonLayout.add(newClient,0,0);
        buttonLayout.add(accountHandling,1,0);
        buttonLayout.add(clientHandling,0,1);
        buttonLayout.add(loanHandling,1,1);
        designLayout.getChildren().add(buttonLayout);

        clientHandlingLabel.setPrefSize(300,275);
        clientHandlingLabel.setMaxWidth(Double.MAX_VALUE);
        clientHandlingLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        clientHandlingLabel.setId("titelText");

        newClient.setPadding(new Insets(10));
        accountHandling.setPadding(new Insets(10));
        clientHandling.setPadding(new Insets(10));
        loanHandling.setPadding(new Insets(10));

        newClient.setMinSize(100,100);
        accountHandling.setMinSize(100,100);
        clientHandling.setMinSize(100,100);
        loanHandling.setMinSize(100,100);

        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setId("buttonLayout");
    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getClientHandlingLabel() {
        return clientHandlingLabel;
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
