package org.example;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Database {
    private Connection connection;

    public Database() {
        //read properties dynamically directly from a file
        Properties props = new Properties();
        try (FileReader fr = new FileReader(".connection-properties")) {
            props.load(fr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader sqlScript = new FileReader("db-properties.sql");
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            scriptRunner.runScript(sqlScript);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SUSERS (USER_ID, USER_GUID, USER_NAME) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, user.getUSER_ID());
        preparedStatement.setInt(2, user.getUSER_GUID());
        preparedStatement.setString(3, user.getUSER_NAME());
    }

    public List<User> printAll() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SUSERS");
        ResultSet resultSet = preparedStatement.getResultSet();
        for (int i = 0; i < resultSet.getFetchSize(); i++) {
            allUsers.add((User) resultSet.getObject(i));
        }
        return allUsers;
    }
}