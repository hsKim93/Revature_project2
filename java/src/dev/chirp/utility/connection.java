package dev.chirp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    public static Connection createConnection() {
        try {
            String dbURL = String.format(
                    "jdbc:postgresql://%s:%s/%s?user=%s&password=%s",
                    System.getenv("HOST"),
                    System.getenv("PORT"),
                    System.getenv("DB"),
                    System.getenv("USER"),
                    System.getenv("PASSWORD")
            );
            return DriverManager.getConnection(dbURL);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;

        }
    }
}

