package Bankomat.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class NewClientScene {

    private VBox designLayout = new VBox();
    private Label quizkampen = new Label("Create Account");
    private HBox firstNameArea = new HBox();
    private HBox lastNameArea = new HBox();
    private HBox pinArea = new HBox();
    private Label firstName = new Label("First Name:          ");
    private Label lastName = new Label("Last Name:    ");
    private Label pin = new Label("Pin-code:            ");
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField pinField = new TextField();
    private Button createAccount = new Button("Create Account");
    private Button backB = new Button("back");



    public void setUp() {
        designLayout.getChildren().add(quizkampen);
        designLayout.getChildren().add(backB);
        designLayout.getChildren().add(firstNameArea);
        designLayout.getChildren().add(lastNameArea);
        designLayout.getChildren().add(pinArea);

        firstNameArea.getChildren().add(firstName);
        firstNameArea.getChildren().add(firstNameField);
        lastNameArea.getChildren().add(lastName);
        lastNameArea.getChildren().add(lastNameField);
        pinArea.getChildren().add(pin);
        pinArea.getChildren().add(pinField);

        HBox buttonLayout = new HBox();
        buttonLayout.getChildren().add(createAccount);
        designLayout.getChildren().add(buttonLayout);

        quizkampen.setPrefSize(300,275);
        quizkampen.setMaxWidth(Double.MAX_VALUE);
        quizkampen.setAlignment(Pos.CENTER);
        designLayout.setId("background");
        quizkampen.setId("quizKampenText");

        firstNameArea.setAlignment(Pos.CENTER);
        lastNameArea.setAlignment(Pos.CENTER);
        pinArea.setAlignment(Pos.CENTER);

        firstNameArea.setPadding(new Insets(10));
        lastNameArea.setPadding(new Insets(10));
        pinArea.setPadding(new Insets(10));

        firstName.setId("nameText");
        lastName.setId("nameText");
        pin.setId("nameText");

        buttonLayout.setAlignment(Pos.CENTER);
        createAccount.setPrefSize(88,30);
        buttonLayout.setId("buttonLayout");
        createAccount.setMaxWidth(Double.MAX_VALUE);


    }


    public VBox getDesignLayout() {
        return designLayout;
    }

    public Label getQuizkampen() {
        return quizkampen;
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public TextField getPinField() {
        return pinField;
    }

    public Button getCreateAccount() {
        return createAccount;
    }

    public Button getBackB() {
        return backB;
    }
}
