package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    
    public static String getPropertyString() {
        Properties properties = new Properties();
        String propertyFilePath = "D:\\java\\insuranceSystem\\src\\util\\db.properties";

        try (FileInputStream input = new FileInputStream(propertyFilePath)) {
            properties.load(input);

            
            String host = properties.getProperty("hostname");
            String dbName = properties.getProperty("dbname");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String port = properties.getProperty("port");
            String connStr="jdbc:mysql://" + host + ":" + port + "/" + dbName + "?user=" + username + "&password=" + password;
            System.out.println(connStr);
            return connStr;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + propertyFilePath);
        } catch (IOException e) {
            System.out.println("Error reading the property file");
            e.printStackTrace(); 
        }

        return null; 
    }
}