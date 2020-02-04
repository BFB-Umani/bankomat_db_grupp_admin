package Bankomat.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LoanHandlingScene {

    private VBox designLayout = new VBox();
    private Label clientHandlingLabel = new Label("Client handling");
    private Button paymentPlan = new Button("show payment Plan");
    private Button changePayment = new Button("update payment plan");
    private Button changeRent = new Button("update rate for loan");
    private Button backB = new Button("back");


    public void setUp() {
        designLayout.getChildren().add(clientHandlingLabel);
        designLayout.getChildren().add(backB);
        designLayout.getChildren().add(paymentPlan);


        GridPane buttonLayout = new GridPane();
        buttonLayout.add(changeRent,0,0);
        buttonLayout.add(changePayment,1,0);
        designLayout.getChildren().add(buttonLayout);

        clientHandlingLabel.setPrefSize(300,275);
        clientHandlingLabel.setMaxWidth(Double.MAX_VALUE);
        clientHandlingLabel.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        clientHandlingLabel.setId("titelText");

        changePayment.setPadding(new Insets(10));
        changeRent.setPadding(new Insets(10));

        changePayment.setMinSize(150,100);
        changeRent.setMinSize(150,100);

        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setVgap(10);
        buttonLayout.setHgap(10);
        buttonLayout.setId("buttonLayout");
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
}
