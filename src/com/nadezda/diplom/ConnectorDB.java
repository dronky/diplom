package com.nadezda.diplom;


import javafx.scene.control.Alert;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectorDB {
    private static Connection connection = null;
    //    public final static String url = "jdbc:mysql://localhost/shop";
    //Connection con = DriverManager.getConnection(connectionUrl);
    //public final static String url = "sqlserver://localhost:55654/Propusk";
    public final static String name = "Nadezda";
    public final static String password = "nadezdasolt95";
    String url = "jdbc:sqlserver://192.168.1.147:51613;" + "databaseName=Propusk;user=" + name + ";password=" + password + ";";

    public ConnectorDB() {

        try {
            //Загружаем драйвер
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url);
            System.out.println("Соединение установлено");


        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Connection Error");
            alert.setHeaderText(null);
            alert.setContentText("Can't connect to your Data Base!");

            alert.showAndWait();
        } finally {

        }

    }

    public void connect() {
        try {
            //Загружаем драйвер
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер подключен");
            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");


        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public boolean login(String username, String password) {
        Statement statement = null;
        boolean res = false;
        try {
            statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM users where name = '" + username + "'");
            while (result1.next()) {
                if (result1.getString("password").equals(password))
                    res = true;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return res;

    }

    public ResultSet statement(String stmt) {
        ResultSet result1 = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            result1 = statement.executeQuery(stmt);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result1;
    }

    private void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean close(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            Logger.getLogger(ConnectorDB.class.getName()).log(Level.SEVERE, "Соединение не было открыто");
            return false;

        }

    }
}
