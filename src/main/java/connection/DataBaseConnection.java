package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    public Connection connection;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pessoa?useTimezone=true&serverTimezone=UTC", "root", "");
            System.out.println("connect");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            connection.close();
            System.out.println("disconnect");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
