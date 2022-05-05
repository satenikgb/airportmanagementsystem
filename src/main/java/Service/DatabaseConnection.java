package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseConnection {

    DB_INSTANCE;
    private final String DRIVER_URL="com.mysql.cj.jdbc.Driver";
    private final String DATABASE_URL="jdbc:mysql://localhost:3306/airportms";
    private final String USER="root";
    private final String PASSWORD="root";


    public Connection createConnection() {
        //Connection con=null;
        try {
            Class.forName(DRIVER_URL);
            System.out.printf("driver load");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver dont loaded");
        }
        try {
            return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection is fail");
        }
        return null;
    }

}
