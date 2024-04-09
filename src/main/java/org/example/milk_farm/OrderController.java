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

public class OrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EnterButton;

    @FXML
    private Label Label;

    @FXML
    private CheckBox cow;

    @FXML
    private TextField date;

    @FXML
    private CheckBox goat;

    @FXML
    private TextField volume;

    @FXML
    void initialize() {


        EnterButton.setOnAction(actionEvent -> {


            DatabaseHandler dbHandler = new DatabaseHandler();

            Orders orders = new Orders();

            try {
                double animalVol = Double.parseDouble(volume.getText().trim());
                orders.setVolume(animalVol);
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
            } else {
                Label.setText("Ошибка: Не выбран вид животного");
                return;
            }

            orders.setAnimal_kind(animal_kind);



            orders.setDate(date.getText().trim());

            dbHandler.SendOrders(orders);

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

