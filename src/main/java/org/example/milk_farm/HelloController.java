package org.example.milk_farm;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EnterButton;

    @FXML
    private Button SignUp;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;


    @FXML
    void initialize() {

        EnterButton.setOnAction(actionEvent -> {
            String loginText = login_field.getText().trim();
            String paswordText = password_field.getText().trim();

            if (!loginText.equals("") && !paswordText.equals("")) {

                DatabaseHandler dbHandler = new DatabaseHandler();
                User user = new User();
                user.setPersonalNumber(Integer.valueOf(loginText));
                user.setPassword(paswordText);

                ResultSet result = dbHandler.getUser(user);

                System.out.println(result);

                ;

            } else {
                System.out.println("bad error man");
            }
        });


        SignUp.setOnAction(actionEvent -> {
            EnterButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SignUpUser.fxml"));

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
//            SignUp.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("home.fxml"));
//            try {
//                loader.load();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();


    }
}


