package Bankomat.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AccountHandlingScene {

    private VBox designLayout = new VBox();
    private Label accountHandlingLabel = new Label("Account Handling");
    private Button newAccount = new Button("create new \naccount"); // lägg till nytt konto
    private Button closeAccount = new Button("handle client info"); // avsluta konto
    private Button addFundsToAccount = new Button("add funds to client account"); // lägg till pengar på kund-konto
    private Button changeRate = new Button("change rate"); // ändra ränta på konto
    private Button accountHistory = new Button("History"); // visa konto-historik
    private Button backB = new Button("back");


    public void setUp() {
        designLayout.getChildren().add(accountHandlingLabel);
        designLayout.getChildren().add(backB);
        designLayout.getChildren().add(accountHistory);

        GridPane buttonLayout = new GridPane();
        buttonLayout.add(newAccount,1,0);
        buttonLayout.add(changeRate,0,0);
        buttonLayout.add(closeAccount,0,1);
        buttonLayout.add(addFundsToAccount,1,1);
        designLayout.getChildren().add(buttonLayout);

        accountHandlingLabel.setPrefSize(300,275);
        accountHandlingLabel.setMaxWidth(Double.MAX_VALUE);
        accountHandlingLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        accountHandlingLabel.setId("titelText");

        buttonLayout.setHgap(10);
        buttonLayout.setVgap(10);

        newAccount.setMinSize(150,100);
        changeRate.setMinSize(150,100);
        closeAccount.setMinSize(150,100);
        addFundsToAccount.setMinSize(150,100);

        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setId("buttonLayout");
    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getAccountHandlingLabel() {
        return accountHandlingLabel;
    }

    public Button getChangeRate() {
        return changeRate;
    }

    public Button getCloseAccount() {
        return closeAccount;
    }

    public Button getAddFunds() {
        return addFundsToAccount;
    }

    public Button getAccountHistory() {
        return accountHistory;
    }

    public Button getNewAccount() {
        return newAccount;
    }

    public Button getBackB() {
        return backB;
    }
}
