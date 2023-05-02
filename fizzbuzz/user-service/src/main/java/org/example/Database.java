package org.example;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private Connection connection;

    public Database() {
        Properties props = new Properties();
        try (FileReader fr = new FileReader(".properties")) {
            props.load(fr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    public Database() {
            connection = DriverManager.getConnection()
        }
    }
}