package Bankomat.View;

import Bankomat.Model.AccountHistory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class AccountHandlingScene {

    private VBox designLayout = new VBox();
    private Label accountHandlingLabel = new Label("Account Handling");
    private Button newAccount = new Button("create new \naccount"); // lägg till nytt konto
    private Button closeAccount = new Button("Close account"); // avsluta konto
    private Button addFundsToAccount = new Button("add funds to client account"); // lägg till pengar på kund-konto
    private Button changeRate = new Button("change rate"); // ändra ränta på konto
    private Button accountHistory = new Button("History"); // visa konto-historik
    private Button backB = new Button("back");
    private Label closeLabel = new Label("Ange kontonummer");
    private Label newAccountLabel = new Label("Ange kundnummer");
    private Label changeRateLabelAccount = new Label("Ange kontonummer");
    private Label changeRateLabelRate = new Label("Ange ny ränta");
    private Label addFundsLabelAccount = new Label("Ange konto att sätta in pengar på");
    private Label addFundsLabelAmount = new Label("Ange belopp");

    private TextField accountNumber = new TextField();
    private TextField createNewAccountTF = new TextField();
    private TextField changeRateTFAccount = new TextField();

    private TextField changeRateTFRate = new TextField();

    private TextField addFundsTFAccount = new TextField();
    private TextField addFundsTFAmount = new TextField();
    private Button okbutton = new Button("OK");

    private Button okButtonNewAccount = new Button("OK");
    private Button okButtonChangeRate = new Button("OK");
    private Button okButtonAddFunds = new Button("OK");
    private Button okbuttonhistory = new Button("OK");
    private Button okhistory = new Button("OK");
    private int accID;

    private int custID;
    private int accountnumberChangeRate;
    private double rateChangeRate;
    private int accountNumberInt;
    private int amount;
    private Label firstDate = new Label("Ange första datumet: ");

    private Label secondDate = new Label("Ange andra datumet: ");
    private Label accHistNr = new Label("Ange kontonummer: ");
    DatePicker d1 = new DatePicker();
    DatePicker d2 = new DatePicker();
    private TextField accHistNrText = new TextField();
    private Label orderLabel = new Label();

    private Label historyLabel = new Label();

    Stage dialogStage;

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

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void showHistory(List<String> outputHist) {
        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(historyLabel);
        HBox buttons = new HBox(okhistory);
        layout.getChildren().add(hBox);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        orderLabel.setAlignment(Pos.CENTER);

        String outHistory = "";
        for(String s: outputHist) {
            outHistory += s + "\n";
        }
        historyLabel.setText(outHistory);


        hBox.setAlignment(Pos.CENTER);
        okhistory.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okhistory.setCursor(Cursor.HAND);

        okhistory.setOnAction(actionEvent -> {
            dialogStage.close();
        });

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void closeAccountBox() {

        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(closeLabel);
        HBox prNrArea = new HBox(accountNumber);
        HBox buttons = new HBox(okbutton);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        closeLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        okbutton.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okbutton.setCursor(Cursor.HAND);

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void newAccountBox() {
        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(newAccountLabel);
        HBox nrArea = new HBox(createNewAccountTF);
        HBox buttons = new HBox(okButtonNewAccount);
        layout.getChildren().add(hBox);
        layout.getChildren().add(nrArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        closeLabel.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        nrArea.setAlignment(Pos.CENTER);
        nrArea.setPadding(new Insets(15));
        okButtonNewAccount.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okButtonNewAccount.setCursor(Cursor.HAND);

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void changeHistoryBox() {
        dialogStage = new Stage();


        VBox layout = new VBox();
        HBox accHbox = new HBox(accHistNr);
        HBox accNrHbox = new HBox(accHistNrText);

        HBox hBox = new HBox(firstDate);
        HBox pinHbox = new HBox(secondDate);
        HBox prNrArea = new HBox(d1);
        HBox pinArea = new HBox(d2);
        HBox buttons = new HBox(okbuttonhistory);
        layout.getChildren().add(accHbox);
        layout.getChildren().add(accNrHbox);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(pinHbox);
        layout.getChildren().add(pinArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        firstDate.setAlignment(Pos.CENTER);
        accHbox.setAlignment(Pos.CENTER);
        accNrHbox.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        pinHbox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        pinArea.setAlignment(Pos.CENTER);
        pinArea.setPadding(new Insets(15));
        okbuttonhistory.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okbuttonhistory.setCursor(Cursor.HAND);

        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void changeRateBox() {
        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(changeRateLabelAccount);
        HBox pinHbox = new HBox(changeRateLabelRate);
        HBox prNrArea = new HBox(changeRateTFAccount);
        HBox pinArea = new HBox(changeRateTFRate);
        HBox buttons = new HBox(okButtonChangeRate);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(pinHbox);
        layout.getChildren().add(pinArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        changeRateLabelAccount.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        pinHbox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        pinArea.setAlignment(Pos.CENTER);
        pinArea.setPadding(new Insets(15));
        okButtonChangeRate.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okButtonChangeRate.setCursor(Cursor.HAND);
        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void addFundsToAccountBox(){
        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(addFundsLabelAccount);
        HBox pinHbox = new HBox(addFundsLabelAmount);
        HBox prNrArea = new HBox(addFundsTFAccount);
        HBox pinArea = new HBox(addFundsTFAmount);
        HBox buttons = new HBox(okButtonAddFunds);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(pinHbox);
        layout.getChildren().add(pinArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400,50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300,60);
        addFundsLabelAccount.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        pinHbox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        pinArea.setAlignment(Pos.CENTER);
        pinArea.setPadding(new Insets(15));
        okButtonAddFunds.setPrefSize(88,45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okButtonAddFunds.setCursor(Cursor.HAND);
        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
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

    public DatePicker getD1() {
        return d1;
    }

    public DatePicker getD2() {
        return d2;
    }

    public Button getAddFundsToAccount() {
        return addFundsToAccount;
    }

    public TextField getAccountNumber() {
        return accountNumber;
    }

    public TextField getCreateNewAccountTF() {
        return createNewAccountTF;
    }

    public TextField getChangeRateTFAccount() {
        return changeRateTFAccount;
    }

    public TextField getChangeRateTFRate() {
        return changeRateTFRate;
    }

    public TextField getAddFundsTFAccount() {
        return addFundsTFAccount;
    }

    public TextField getAddFundsTFAmount() {
        return addFundsTFAmount;
    }

    public Button getOkbutton() {
        return okbutton;
    }

    public Button getOkButtonNewAccount() {
        return okButtonNewAccount;
    }

    public Button getOkButtonChangeRate() {
        return okButtonChangeRate;
    }

    public Button getOkButtonAddFunds() {
        return okButtonAddFunds;
    }

    public Button getOkbuttonhistory() {
        return okbuttonhistory;
    }

    public Button getOkhistory() {
        return okhistory;
    }

    public TextField getAccHistNrText() {
        return accHistNrText;
    }

    public Button getBackB() {
        return backB;
    }
}
