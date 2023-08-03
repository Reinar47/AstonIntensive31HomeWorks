package hw2.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    private static Connection connection;

    public DBUtil(){
        this.connection = createConnection();
    }

    public static Connection createConnection(){
        int a = 1;
        try {
            Properties properties = new Properties();
            if (connection == null) {
                Reader reader = new FileReader("src/main/resources/db.properties");
                properties.load(reader);
            }

            return DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password")
            );
        } catch (IOException | SQLException e) {
            throw new RuntimeException("createConnection method exception");
        }


    }



}
