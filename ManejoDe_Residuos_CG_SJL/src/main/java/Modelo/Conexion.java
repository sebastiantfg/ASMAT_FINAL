package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion 
{
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String database = "dbtaller";
    public static String hostname = "localhost";
    public static String port = "3306";
    public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=true&requireSSL=false";
    public static String username = "root";
    public static String password = "";

    public static Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            
        }

        return conn;
    }
}
