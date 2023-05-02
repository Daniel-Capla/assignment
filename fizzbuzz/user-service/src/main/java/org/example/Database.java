package org.example;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private Connection connection;

    public Database() {
        //read properties dynamically directly from a file
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

        try {
            FileReader sqlScript = new FileReader("db-properties.sql");
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            scriptRunner.runScript(sqlScript);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}