/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author adminltg
 */
public class Conexion_SBO_LTG_PRUEBAS {
       public String db = "SBO_LTG_PRUEBAS";
    public String url = "jdbc:sqlserver://192.168.1.214\\SQLEXPRESS;databasename=SBO_LTG_PRUEBAS";
    public String user = "sa";
    public String pass = "web007";
    
    public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

           link = DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(Exception ex){

           JOptionPane.showMessageDialog(null, ex);

       }


       return link;

   }

}
