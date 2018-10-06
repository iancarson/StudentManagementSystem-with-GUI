package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String USERNAME="dbuser";
    private static final String PASSWORD="dbpassword";
    private static final String CONN="jdbc:sqlite://localhost/login";
    private static final String SQCONN="jdbc:sqlite:School.sqlite";
    public static Connection getConnection()
            throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch(NullPointerException ex)
        {
            ex.getMessage();
        }
        return null;
    }
}
