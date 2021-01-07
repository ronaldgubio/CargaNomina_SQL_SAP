/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Clases.Conexion_SBO_GF_PROD;
import Clases.Conexion_SBO_LTG_PRUEBAS;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adminltg
 */
public class F_SBO_GF_PROD {
    
    
    private Conexion_SBO_GF_PROD sqlServer = new Conexion_SBO_GF_PROD();
    private Connection cn = sqlServer.Conectar();
    private String sSQL = "";
    public Integer totalRegistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;       
        

        String[] nomina = { "ReferenceDate","DueDate" ,"TaxDate","Memo","Origen","Sincronizado","Accion","Identificador","Series","CreateDatePOS","UpdateStatus","Message"};

        String[] registro = new String[12];

        totalRegistros = 0;
        modelo = new DefaultTableModel(null, nomina);
        sSQL = "select * from ojdt aa where aa.Sincronizado='N'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("ReferenceDate");
                registro[1] = rs.getString("DueDate");
                registro[2] = rs.getString("TaxDate");
                registro[3] = rs.getString("Memo");
                registro[4] = rs.getString("Origen");
                registro[5] = rs.getString("Sincronizado");
                registro[6] = rs.getString("Accion");
                registro[7] = rs.getString("Identificador");
                registro[8] = rs.getString("Series");
                registro[9] = rs.getString("CreateDatePOS");
                registro[10] = rs.getString("UpdateStatus");
                registro[10] = rs.getString("Message");
                
                totalRegistros = totalRegistros + 1;
                modelo.addRow(registro);
                
                
            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //JOptionPane.showConfirmDialog(null,e);
            return null;
        }

    }


    
}
