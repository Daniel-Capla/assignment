package org.example;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Database {
    private final Logger logger = LogManager.getLogger(Database.class);

    private Connection connection;

    public Database() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(setUpConnection().getProperty("url"), setUpConnection().getProperty("username"), setUpConnection().getProperty("password"));
            this.connection.setAutoCommit(true);
            System.out.println("Connected to the database!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileReader sqlScript = new FileReader("user-service//src//main//resources//.db-properties.sql");
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            System.out.println(sqlScript);
            scriptRunner.runScript(sqlScript);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Properties setUpConnection() {
        try {
            FileInputStream fis = new FileInputStream("user-service//src//main//resources//.connection-properties");
            Properties props = new Properties();
            props.load(fis);
            fis.close();
            return props;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO SUSERS (USER_ID, USER_GUID, USER_NAME) VALUES (?, ?, ?)");
        preparedStatement.setInt(1, user.getUSER_ID());
        preparedStatement.setString(2, user.getUSER_GUID());
        preparedStatement.setString(3, user.getUSER_NAME());
        preparedStatement.executeUpdate();
        connection.commit();
    }

    public List<User> printAll() throws SQLException {
        List<User> allUsers = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SUSERS");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("USER_ID"),
                    resultSet.getString("USER_GUID"),
                    resultSet.getString("USER_NAME")
            );
            allUsers.add(user);
        }
        if (!allUsers.isEmpty()) {
            allUsers.forEach(System.out::println);
        } else {
            logger.error("Table SUSERS is empty!");
        }
        return allUsers;
    }

    public void deleteAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM SUSERS");
        preparedStatement.executeUpdate();
        connection.commit();
    }
}
