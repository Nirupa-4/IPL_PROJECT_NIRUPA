package com.edutech.progressive.config;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnectionManager {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
        loadDriverIfProvided();
    }

    private DatabaseConnectionManager() { }

    private static void loadProperties() {
        // Load application.properties from classpath (src/main/resources)
        try (InputStream in = Thread.currentThread()
                                    .getContextClassLoader()
                                    .getResourceAsStream("application.properties")) {
            if (in == null) {
                throw new RuntimeException("application.properties not found on classpath");
            }
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    private static void loadDriverIfProvided() {
        String driver = properties.getProperty("db.driver");
        if (driver != null && !driver.isBlank()) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Database driver not found: " + driver, e);
            }
        }
    }

    public static Connection getConnection() {
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.username");
        String pass = properties.getProperty("db.password");

        if (url == null || user == null || pass == null) {
            throw new RuntimeException("Database configuration is missing in application.properties");
        }

        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to obtain DB connection", e);
        }
    }
}
