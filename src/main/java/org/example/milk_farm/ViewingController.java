package org.example.milk_farm;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewingController {

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
    private Label Label4;

    @FXML
    private Label Label5;

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
            String query = "SELECT * FROM options";
            ResultSet resultSet = statement.executeQuery(query);

            StringBuilder labelText1 = new StringBuilder();
            StringBuilder labelText2 = new StringBuilder();
            StringBuilder labelText3 = new StringBuilder();
            StringBuilder labelText4 = new StringBuilder();
            StringBuilder labelText5 = new StringBuilder();

            labelText1.append("Дата").append("\n\n");
            labelText2.append("Личный номер").append("\n\n");
            labelText3.append("Номер животного").append("\n\n");
            labelText4.append("Вид животного").append("\n\n");
            labelText5.append("Объем сырья").append("\n\n");


            while (resultSet.next()) {
                // Получите значения столбцов из результирующего набора
                String column1Value = resultSet.getString(Const.OPT_DATE);
                String column2Value = resultSet.getString(Const.OPT_PERS);
                String column3Value = resultSet.getString(Const.OPT_NUM);
                String column4Value = resultSet.getString(Const.OPT_KIND);
                String column5Value = resultSet.getString(Const.OPT_VOLUME);


                labelText1.append(column1Value).append(" | ").append("\n");
                labelText2.append(column2Value).append(" | ").append("\n");
                labelText3.append(column3Value).append(" | ").append("\n");
                labelText4.append(column4Value).append(" | ").append("\n");
                labelText5.append(column5Value).append("\n");


            }
            Label1.setText(String.valueOf(labelText1));
            Label2.setText(String.valueOf(labelText2));
            Label3.setText(String.valueOf(labelText3));
            Label4.setText(String.valueOf(labelText4));
            Label5.setText(String.valueOf(labelText5));
//
//            labelText.append("Column 1: ").append(column1Value).append("\n")
//                    .append("Column 2: ").append(column2Value).append("\n");
//            // и так далее для остальных столбцов
//        }
//
//        // Установите текст в Label
//        Label.setText(labelText.toString());

            // Закройте ресурсы JDBC
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

