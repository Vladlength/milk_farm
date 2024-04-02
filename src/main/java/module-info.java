module org.example.milk_farm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens org.example.milk_farm to javafx.fxml;
    exports org.example.milk_farm;
}