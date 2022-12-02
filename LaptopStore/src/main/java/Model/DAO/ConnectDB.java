package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    public static String urlDB = "jdbc:mysql://localhost:3306/laptopstore";
    public static String usernameDB = "root";
    public static String passwordDB = "";
    private Connection connection;

    public ConnectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(urlDB, usernameDB, passwordDB);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getAConnect() {
        return this.connection;
    }
}
