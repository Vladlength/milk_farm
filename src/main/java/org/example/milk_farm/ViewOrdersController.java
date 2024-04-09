package org.example.milk_farm;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewOrdersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label Label1;

    @FXML
    private Label Label2;

    @FXML
    private Label Label3;

    @FXML
    void initialize() {

        // Выполнение SELECT-запроса и вывод результатов на экран
        try {
            DatabaseHandler dbHandler = new DatabaseHandler();
            Connection connection = null;
            try {
                connection = dbHandler.getDbConnection();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            Statement statement = connection.createStatement();
            String query = "SELECT * FROM orders";
            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder labelText1 = new StringBuilder();
            StringBuilder labelText2 = new StringBuilder();
            StringBuilder labelText3 = new StringBuilder();

            labelText3.append("Дата").append("\n\n");
            labelText2.append("Вид животного").append("\n\n");
            labelText1.append("Объем сырья").append("\n\n");




            while (resultSet.next()) {
                // Получите значения столбцов из результирующего набора
                String column1Value = resultSet.getString(Const.ORD_VOLUME);
                String column2Value = resultSet.getString(Const.ORD_KIND);
                String column3Value = resultSet.getString(Const.ORD_DATE);


                labelText1.append(column1Value).append(" | ").append("\n");
                labelText2.append(column2Value).append(" | ").append("\n");
                labelText3.append(column3Value).append("\n");



            }
            Label1.setText(String.valueOf(labelText1));
            Label2.setText(String.valueOf(labelText2));
            Label3.setText(String.valueOf(labelText3));


            // Закройте ресурсы JDBC
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

