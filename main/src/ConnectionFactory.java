package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
*  In this class, a connection to PostgreSQL database will be created
*
*/
public class ConnectionFactory {
    public static final String URL = "jdbc:postgresql://localhost:5432/restaurant_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
    /*
    *  Get a connection to database
    * @return Connection object
    *
    * */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection; // Return the connection
    }

    /*
    *  Print connection status
    * */
    public static void printConnectionMessage(){
        try(Connection connection = getConnection()){
            if (connection != null){
                System.out.println("Connection is successful");
            }else {
                System.out.println("Connection is not successful");
            }
        }catch (SQLException e) {
            System.err.println("Error checking connection status: " + e.getMessage());
        }
    }


}