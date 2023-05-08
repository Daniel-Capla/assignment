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
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/users", "postgres", "password");
            System.out.println("Connected to the database!");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        try {
            FileReader sqlScript = new FileReader("C://Users//ZZ01O6693//Desktop//Dev Projects//On Top Projects//Bootiq//assignment//fizzbuzz//user-service//src//main//resources//.db-properties.sql");
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            System.out.println(sqlScript.toString());
            scriptRunner.runScript(sqlScript);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SUSERS (USER_ID, USER_GUID, USER_NAME) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, user.getUSER_ID());
            preparedStatement.setString(2, user.getUSER_GUID());
            preparedStatement.setString(3, user.getUSER_NAME());
            preparedStatement.executeUpdate();
    }

    public List<User> printAll() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SUSERS");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) { // Replace the for loop with a while loop
            User user = new User(
                    resultSet.getInt("USER_ID"),
                    resultSet.getString("USER_GUID"),
                    resultSet.getString("USER_NAME")
            );
            allUsers.add(user);
        }
        System.out.println(allUsers);
        return allUsers;
    }
}