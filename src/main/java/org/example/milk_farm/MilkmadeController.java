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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MilkmadeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EnterButton;

    @FXML
    private Label Label;

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

            try {
                double animalVol = Double.parseDouble(volume.getText().trim());
                options.setVolume(animalVol);
            } catch (NumberFormatException e) {
                // Обработка некорректного ввода для поля animal_vol
                Label.setText("Ошибка: Некорректное значение для animal_vol");
                return;
            }

            String animal_kind = new String();
            if (goat.isSelected()) {
                animal_kind = "goat";
            } else if (cow.isSelected()) {
                animal_kind = "cow";
            }else {
                Label.setText("Ошибка: Не выбран вид животного");
                return;
            }
            System.out.println(animal_kind);

            options.setAnimal_kind(animal_kind);

            try {
                double animalNum = Double.parseDouble(animal_num.getText().trim());
                options.setAnimal_num(animalNum);
            } catch (NumberFormatException e) {
                // Обработка некорректного ввода для поля animal_num
                Label.setText("Ошибка: Некорректное значение для animal_num");
                return;
            }

            try {
                int personalNumber = Integer.parseInt(pers_num.getText().trim());
                options.setPersonalNumber(personalNumber);
            } catch (NumberFormatException e) {
                // Обработка некорректного ввода для поля pers_num
                Label.setText("Ошибка: Некорректное значение для pers_num");
                return;
            }

            options.setDate(date.getText().trim());

            dbHandler.SendOptions(options);
            System.out.println(1);

            // Закрываем текущее окно
            Stage currentStage = (Stage) EnterButton.getScene().getWindow();
            currentStage.close();

            // Создаем и отображаем новое окно
            FXMLLoader loader = new FXMLLoader(getClass().getResource("success.fxml"));
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
//            loader.setLocation(getClass().getResource("success.fxml"));
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


