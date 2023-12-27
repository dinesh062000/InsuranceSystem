package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    private static Connection connection;

  

    public static Connection getConnection() {
        if (connection == null) {
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                System.out.println("Driver Loaded");

                
                String connectionString = DBPropertyUtil.getPropertyString();

                
                connection = DriverManager.getConnection(connectionString);
                System.out.println("Db connected Successfully!!");
//             
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
        return connection;
    }
}