package org.example.bean;

import java.io.Serializable;
import java.sql.*;

public class UserBean implements Serializable {

    private Long id = null;

    private String name = null;

    private String password = null;

    private boolean userLoggedIn = false;


    public UserBean() {
    }

    public boolean userLogin(String dbUrl) throws ClassNotFoundException, SQLException {

        Connection connection = null;

        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(dbUrl);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM forumusers WHERE name=? and password=?");

        preparedStatement.setString(1, name);

        preparedStatement.setString(2, password);


        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            userLoggedIn = true;
            id = rs.getLong("id");
        } else {
            userLoggedIn = false;
        }

        return userLoggedIn;
    }

    public void userLogout() {
        userLoggedIn = false;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }
}
