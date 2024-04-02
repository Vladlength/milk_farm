package org.example.milk_farm;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SendButton;

    @FXML
    private TextField fat_content;

    @FXML
    private TextField id_animal;

    @FXML
    private TextField kind_animal;

    @FXML
    private TextField volume;

    @FXML
    void initialize() {
        System.out.println("hy man");

    }

}


