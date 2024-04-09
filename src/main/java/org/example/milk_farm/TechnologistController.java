package org.example.milk_farm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TechnologistController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Order;

    @FXML
    private Button Viewing;

    @FXML
    private Button ViewingOrders;

    @FXML
    void initialize() {
        Viewing.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewing.fxml"));
            try {
                Parent root = loader.load();
                Stage newStage = new Stage();
                newStage.setTitle("Сдачи");
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Order.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("order.fxml"));
            try {
                Parent root = loader.load();
                Stage newStage = new Stage();
                newStage.setTitle("Создание");
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ViewingOrders.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewing_orders.fxml"));
            try {
                Parent root = loader.load();
                Stage newStage = new Stage();
                newStage.setTitle("Заказы");
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}


