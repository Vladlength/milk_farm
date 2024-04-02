package org.example.milk_farm;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton;

    @FXML
    private TextField firstName;

    @FXML
    private TextField personalNumber;

    @FXML
    private TextField secondName;

    @FXML
    private TextField password;

    @FXML
    void initialize() {

        SendButton.setOnAction(actionEvent -> {
            signUpNewUser();
        });
    }
    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String first_Name = firstName.getText();
        String second_Name = secondName.getText();
        Integer personal_Number = Integer.valueOf(personalNumber.getText());
        String passw = password.getText();

        User user = new User(first_Name,
                second_Name,
                personal_Number,
                passw);

        dbHandler.signUpUser(user);
    }


}
