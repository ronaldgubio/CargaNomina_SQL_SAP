/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author adminltg
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionSQL {
    
    public static void main(String[] args) {
        String connectionUrl =
                "jdbc:sqlserver://192.168.1.214\\SQLEXPRESS:1433;"
                        + "database=SBO_SL_PROD;"
                        + "user=sa;"
                        + "password=web007;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
           
            ///jdbc:sqlserver://192.168.1.214\SQLEXPRESS;databasename=SBO_SL_PROD
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
