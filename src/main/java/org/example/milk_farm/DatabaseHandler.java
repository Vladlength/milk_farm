package org.example.milk_farm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);


        return dbConnection;
    }

    public void SendOptions(Options options) {
        String insert = "INSERT INTO " + Const.OPT_TABLE + "(" +
                Const.OPT_VOLUME + "," + Const.OPT_KIND + "," +
                Const.OPT_NUM + "," + Const.OPT_PERS + "," +
                Const.OPT_DATE + ")" +
                "VALUES(?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setDouble(1, options.getVolume());
            prSt.setString(2, options.getAnimal_kind());
            prSt.setDouble(3, options.getAnimal_num());
            prSt.setInt(4, options.getPersonalNumber());
            prSt.setString(5, options.getDate());

            prSt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

//    public ResultSet getUser(Options user) {
//        ResultSet resSet = null;
//
//        String select = "SELECT * FROM " + Const.USER_TABLE +
//                "WHERE " + Const.USERS_PERS_NUM + "=? AND " +
//                Const.USERS_PASSWORD + "=?";
//
//        try {
//            PreparedStatement prSt = getDbConnection().prepareStatement(select);
//            prSt.setInt(1, user.getPersonalNumber());
//            prSt.setString(2, user.getPassword());
//
//            resSet = prSt.executeQuery();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//
//        }
//        return resSet;
//    }
}



