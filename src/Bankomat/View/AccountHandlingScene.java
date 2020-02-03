package Bankomat.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AccountHandlingScene {

    private VBox designLayout = new VBox();
    private Label accountHandlingLabel = new Label("Account Handling");
    private Button newAccount = new Button("create new \nclient"); // lägg till nytt konto
    private Button closeAccount = new Button("handle client info"); // avsluta konto
    private Button addFundsToAccount = new Button("add funds to client account"); // lägg till pengar på kund-konto
    private Button changeRate = new Button("change rate"); // ändra ränta på konto
    private Button accountHistory = new Button("History"); // visa konto-historik
    private Button backB = new Button("back");


    public void setUp() {
        designLayout.getChildren().add(accountHandlingLabel);
        designLayout.getChildren().add(backB);

        GridPane buttonLayout = new GridPane();
        buttonLayout.add(newAccount,0,0);
        buttonLayout.add(changeRate,1,0);
        buttonLayout.add(closeAccount,0,1);
        buttonLayout.add(addFundsToAccount,1,1);
        buttonLayout.add(accountHistory, 2, 0);
        designLayout.getChildren().add(buttonLayout);

        accountHandlingLabel.setPrefSize(300,275);
        accountHandlingLabel.setMaxWidth(Double.MAX_VALUE);
        accountHandlingLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        accountHandlingLabel.setId("titelText");

        buttonLayout.setHgap(10);
        buttonLayout.setVgap(10);

        newAccount.setMinSize(100,100);
        changeRate.setMinSize(100,100);
        closeAccount.setMinSize(100,100);
        addFundsToAccount.setMinSize(100,100);

        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setId("buttonLayout");
    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getAccountHandlingLabel() {
        return accountHandlingLabel;
    }

    public Button getAccountHandling() {
        return changeRate;
    }

    public Button getClientHandling() {
        return closeAccount;
    }

    public Button getLoanHandling() {
        return addFundsToAccount;
    }

    public Button getNewClient() {
        return newAccount;
    }

    public Button getBackB() {
        return backB;
    }
}
