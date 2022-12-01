/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC DUNG
 */
public class DBConnect {
     private static String hostName = "localhost";//"TUANCACA\\SQLEXPRESS01";
    private static String account = "sa";
    private static String pass = "123456";
    private static String dbName = "PRO1014_IT17316_NHOM4";
    private static String connectionSQL = "jdbc:sqlserver://" + hostName + ":1433;databaseName=" + dbName;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection cnn;

    static {

      
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    static Connection openDBConnection() {

        try {
            return DriverManager.getConnection(connectionSQL, account, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
     return null;
    }
    public static void main(String[] args) {
        openDBConnection().toString();
    }

}
