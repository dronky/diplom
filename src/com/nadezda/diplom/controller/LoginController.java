package com.nadezda.diplom.controller;

import com.nadezda.diplom.ConnectorDB;
import com.nadezda.diplom.tables.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Nadezda on 02.02.2017.
 */
public class LoginController {
    @FXML
    TextField tfLogin;
    @FXML
    PasswordField pfPassword;
    @FXML
    Button btnLogin;
    @FXML
    Label lbl1;

    public final static String SQL_SELECT_USR = "SELECT * FROM [dbo].[User]";

    public void btnClick(ActionEvent actionEvent) {
        select();
     /*   if (tfLogin.getText().equals("gayfish") && pfPassword.getText().equals("barabashka"))
            lbl1.setText("all ok");
        else
            lbl1.setText("Неправильный логин или пароль.");*/
    }
    public static PreparedStatement getPreparedStatement(String sqlQuery) {
        Connection connection;
        ConnectorDB c = new ConnectorDB();
        connection = c.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public static void select(){
        ArrayList<User> userList = new ArrayList<>();
        PreparedStatement statement = null;
        statement = getPreparedStatement(SQL_SELECT_USR);
        userList.clear();
        userList.addAll(getUserList(statement));
        System.out.println(userList.get(0).toString());
    }

//ПРОВЕРИТЬ НА ПУСТУЮ ТАБЛУ
    public static ArrayList<User> getUserList(PreparedStatement ps) {
        ArrayList<User> userList = new ArrayList<>();
        try {
            ResultSet rs = ps.executeQuery();
            HashSet<Integer> userIdSet = new HashSet<>();
            while (rs.next()) {
                int idUser = rs.getInt("us_id");
                if (userIdSet.add(idUser)) {
// parse all stuff
                    String sluzhba = rs.getString("us_sluzhba");
                    String name = rs.getString("us_name");
                    String dolj = rs.getString("us_dolj");
                    String tel = rs.getString("us_tel");
                    String login = rs.getString("us_login");
                    String pass = rs.getString("us_pass");
                    String roleId = rs.getString("us_id_Role");

                    userList.add(new User(
                            idUser,
                            sluzhba,
                            name,
                            dolj,
                            tel,
                            login,
                            pass,roleId));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
