package org.example.milk_farm;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SuccessController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CloseButton;

    @FXML
    void initialize() {
        CloseButton.setOnAction(event -> {
            Platform.exit();
        });

    }

}





