package Bankomat.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoanHandlingScene {

    private VBox designLayout = new VBox();
    private Label clientHandlingLabel = new Label("Client handling");
    private Button paymentPlan = new Button("show payment Plan");
    private Button changePayment = new Button("update payment plan");
    private Button changeRent = new Button("update rate for loan");
    private Button accDenLoan = new Button("accept or deny loans");
    private Button backB = new Button("back");
    private Button seePendingLoan = new Button("see pending loans");
    private Label changeRateLabelAccount = new Label("Ange kontonummer");
    private Label changeRateLabelRate = new Label("Ange ny ränta");
    private Label updatePaymentPlanAccount = new Label("Ange konto för att byta betalningsplan på");
    private Label updatePaymentPlanDate = new Label("Ange datum \"XXXX-XX-XX\"");
    private Label pendingLoanID = new Label("Ange ID för lån du vill godkänna eller avslå");

    private TextField changeRateTFAccount = new TextField();
    private TextField changeRateTFRate = new TextField();
    private TextField updatePaymentTFAccount = new TextField();
    private TextField updatePaymentTFDate = new TextField();
    private TextField pendingLoanTF = new TextField();

    private Button okB = new Button("OK");
    private Button acceptB = new Button("godkänn");
    private Button denyB = new Button("avslå");
    private Stage dialogStage;

    public void setUp() {
        designLayout.getChildren().add(clientHandlingLabel);
        designLayout.getChildren().add(backB);
        designLayout.getChildren().add(paymentPlan);


        GridPane buttonLayout = new GridPane();
        buttonLayout.add(changeRent,0,0);
        buttonLayout.add(changePayment,1,0);
        buttonLayout.add(accDenLoan,0,1);
        designLayout.getChildren().add(buttonLayout);

        clientHandlingLabel.setPrefSize(300,275);
        clientHandlingLabel.setMaxWidth(Double.MAX_VALUE);
        clientHandlingLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        clientHandlingLabel.setId("titelText");

        changePayment.setPadding(new Insets(10));
        changeRent.setPadding(new Insets(10));
        accDenLoan.setPadding(new Insets(10));

        changePayment.setMinSize(150,100);
        changeRent.setMinSize(150,100);
        accDenLoan.setMinSize(150,100);

        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setVgap(10);
        buttonLayout.setHgap(10);
        buttonLayout.setId("buttonLayout");
    }

    public void changeRateBox() {
        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(changeRateLabelAccount);
        HBox pinHbox = new HBox(changeRateLabelRate);
        HBox prNrArea = new HBox(changeRateTFAccount);
        HBox pinArea = new HBox(changeRateTFRate);
        HBox buttons = new HBox(okB);
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
        okB.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okB.setCursor(Cursor.HAND);
        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void changeDateBox() {
        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(updatePaymentPlanAccount);
        HBox pinHbox = new HBox(updatePaymentPlanDate);
        HBox prNrArea = new HBox(updatePaymentTFAccount);
        HBox pinArea = new HBox(updatePaymentTFDate);
        HBox buttons = new HBox(okB);
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
        okB.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        okB.setCursor(Cursor.HAND);
        dialogStage.setResizable(false);
        dialogStage.setScene(new Scene(layout));
        dialogStage.show();
        dialogStage.setOnCloseRequest(t -> {
            dialogStage.close();
        });
    }

    public void pendingLoanBox() {
        dialogStage = new Stage();
        VBox layout = new VBox();
        HBox hBox = new HBox(pendingLoanID);
        HBox prNrArea = new HBox(pendingLoanTF);
        HBox buttons = new HBox(acceptB, denyB);
        HBox seePending = new HBox(seePendingLoan);
        layout.getChildren().add(seePending);
        layout.getChildren().add(hBox);
        layout.getChildren().add(prNrArea);
        layout.getChildren().add(buttons);
        layout.setMinSize(400, 50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        buttons.setMinSize(300, 60);
        pendingLoanID.setAlignment(Pos.CENTER);
        seePending.setAlignment(Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        prNrArea.setAlignment(Pos.CENTER);
        prNrArea.setPadding(new Insets(15));
        acceptB.setPrefSize(88, 45);
        denyB.setPrefSize(88, 45);
        buttons.setPadding(new Insets(15, 0, 10, 0));
        seePending.setPadding(new Insets(15, 0, 10, 0));
        acceptB.setCursor(Cursor.HAND);
        denyB.setCursor(Cursor.HAND);
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

    public Label getClientHandlingLabel() {
        return clientHandlingLabel;
    }

    public Button getPaymentPlan() {
        return paymentPlan;
    }

    public Button getChangePayment() {
        return changePayment;
    }

    public Button getChangeRent() {
        return changeRent;
    }

    public Button getBackB() {
        return backB;
    }

    public TextField getChangeRateTFAccount() {
        return changeRateTFAccount;
    }

    public TextField getChangeRateTFRate() {
        return changeRateTFRate;
    }

    public Button getOkB() {
        return okB;
    }

    public Button getAcceptB() {
        return acceptB;
    }

    public Button getDenyB() {
        return denyB;
    }

    public Button getAccDenLoan() {
        return accDenLoan;
    }

    public Button getSeePendingLoan() {
        return seePendingLoan;
    }

    public TextField getPendingLoanTF() {
        return pendingLoanTF;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }
}
