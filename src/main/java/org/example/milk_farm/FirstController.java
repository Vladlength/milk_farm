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

public class FirstController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Milkmade;

    @FXML
    private Button Technologist;

    @FXML
    void initialize() {
        Milkmade.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("milkmade.fxml"));
            try {
                Parent root = loader.load();
                Stage newStage = new Stage();
                newStage.setTitle("Доярка");
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        Technologist.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("technologist.fxml"));
            try {
                Parent root = loader.load();
                Stage newStage = new Stage();
                newStage.setTitle("Технолог");
                newStage.setScene(new Scene(root));
                newStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
