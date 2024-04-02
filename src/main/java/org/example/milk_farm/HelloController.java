package org.example.milk_farm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private TextField animal_num;

    @FXML
    private CheckBox cow;

    @FXML
    private TextField date;

    @FXML
    private CheckBox goat;

    @FXML
    private TextField pers_num;

    @FXML
    private TextField volume;

    @FXML
    void initialize() {

        EnterButton.setOnAction(actionEvent -> {
            System.out.println("button");

            DatabaseHandler dbHandler = new DatabaseHandler();

            Options options = new Options();
            options.setVolume(volume.getText().trim());
            String animal_kind = new String();
            if (goat.isSelected()) {
                animal_kind = "goat";
            } else if (cow.isSelected()) {
                animal_kind = "cow";
            }
            System.out.println(animal_kind);

            options.setAnimal_kind(animal_kind);
            options.setAnimal_num(Double.valueOf(animal_num.getText().trim()));
            options.setPersonalNumber(Integer.valueOf(pers_num.getText().trim()));
            options.setDate(date.getText().trim());

            dbHandler.SendOptions(options);
            System.out.println(1);


                // Закрываем текущее окно
                Stage currentStage = (Stage) EnterButton.getScene().getWindow();
                currentStage.close();

                // Создаем и отображаем новое окно
                FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
                try {
                    Parent root = loader.load();
                    Stage newStage = new Stage();
                    newStage.setTitle("успех");
                    newStage.setScene(new Scene(root));
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


    }
}


//            ;


//    });


//;
//        SignUp.setOnAction(actionEvent -> {
//            EnterButton.getScene().getWindow().hide();
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("SignUpUser.fxml"));
//
//            Parent root = loader.getRoot();
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait();
//            try {
//                loader.load();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
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
//
//


