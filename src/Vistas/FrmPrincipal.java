/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Clases.Conexion_SBO_GF_PROD;
import Clases.Conexion_SBO_GMS_PROD;
import Clases.Conexion_SBO_GR_PROD;
import Clases.Conexion_SBO_LTG_PROD;
import Clases.Conexion_SBO_LTG_PRUEBAS;
import Clases.Conexion_SBO_SL_PROD;
import Logica.F_SBO_GF_PROD;
import Logica.F_SBO_GMS_PROD;
import Logica.F_SBO_GR_PROD;
import Logica.F_SBO_LTG_PROD;
//import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Logica.F_SBO_LTG_PRUEBAS;
import Logica.F_SBO_SL_PROD;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
//import java.awt.BorderLayout;
import java.awt.Image;
//import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author adminltg
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        cambio_nombre();

        setTitle("CARGA DE NOMINA LTG");
        setSize(1100, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//Evitamos que el programa finalice cuando la interfaz se cierre

    }

    DefaultTableModel model = new DefaultTableModel();//permite el acceso a todos los metos necesarios , anadir filas y comunmas y cambiar nombres 

    void cambio_nombre() {
        tablaListado = new JTable(model);
        jScrollPane1.setViewportView(tablaListado);
        tablaListado.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaListado.doLayout();

        //ASIGNAR EL NOMBRE A CADA COLUMNA 
        model.addColumn("ReferenceDate");
        model.addColumn("DueDate");
        model.addColumn("TaxDate");
        model.addColumn("Memo");
        model.addColumn("Origen");
        model.addColumn("Sincronizado");
        model.addColumn("Accion");
        model.addColumn("Idenificador");
        model.addColumn("Serie");
        model.addColumn("CreateDatePOS");
        model.addColumn("UpdateStatu");
        model.addColumn("Message");

        //CAMBIO DE TAMANIO DE COLUMNA A LA TABLA
        TableColumnModel columnModel = tablaListado.getColumnModel();

        columnModel.getColumn(3).setPreferredWidth(250);
        columnModel.getColumn(10).setPreferredWidth(300);
        columnModel.getColumn(11).setPreferredWidth(300);

    }

    void mostrarGF(String buscar) {

        try {
            DefaultTableModel modelo;
            F_SBO_GF_PROD func = new F_SBO_GF_PROD();
            modelo = func.mostrar(buscar);

            tablaListado.setModel(modelo);
            
             //CAMBIO DE TAMANIO DE COLUMNA A LA TABLA
            TableColumnModel columnModel = tablaListado.getColumnModel();
            columnModel.getColumn(3).setPreferredWidth(250);
            columnModel.getColumn(10).setPreferredWidth(300);
            columnModel.getColumn(11).setPreferredWidth(300);
            
            // ocultar_columna();
            //LblTotalRegistros.setText("TOTAL REGISTROS" + Integer.toString(func.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void mostrarGMS(String buscar) {

        try {
            DefaultTableModel modelo;
            F_SBO_GMS_PROD func = new F_SBO_GMS_PROD();
            modelo = func.mostrar(buscar);

            tablaListado.setModel(modelo);
            
             //CAMBIO DE TAMANIO DE COLUMNA A LA TABLA
            TableColumnModel columnModel = tablaListado.getColumnModel();
            columnModel.getColumn(3).setPreferredWidth(250);
            columnModel.getColumn(10).setPreferredWidth(300);
            columnModel.getColumn(11).setPreferredWidth(300);
            
            // ocultar_columna();
            //LblTotalRegistros.setText("TOTAL REGISTROS" + Integer.toString(func.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void mostrarGR(String buscar) {

        try {
            DefaultTableModel modelo;
            F_SBO_GR_PROD func = new F_SBO_GR_PROD();
            modelo = func.mostrar(buscar);

            tablaListado.setModel(modelo);

            //CAMBIO DE TAMANIO DE COLUMNA A LA TABLA
            TableColumnModel columnModel = tablaListado.getColumnModel();
            columnModel.getColumn(3).setPreferredWidth(250);
            columnModel.getColumn(10).setPreferredWidth(300);
            columnModel.getColumn(11).setPreferredWidth(300);

            // ocultar_columna();
            //LblTotalRegistros.setText("TOTAL REGISTROS" + Integer.toString(func.totalRegistros));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void mostrarLTG(String buscar) {

        try {
            DefaultTableModel modelo;
            F_SBO_LTG_PROD func = new F_SBO_LTG_PROD();
            modelo = func.mostrar(buscar);

            tablaListado.setModel(modelo);
            //CAMBIO DE TAMANIO DE COLUMNA A LA TABLA
            TableColumnModel columnModel = tablaListado.getColumnModel();

            columnModel.getColumn(3).setPreferredWidth(250);
            columnModel.getColumn(10).setPreferredWidth(300);
            columnModel.getColumn(11).setPreferredWidth(300);

            // ocultar_columna();
            //LblTotalRegistros.setText("TOTAL REGISTROS" + Integer.toString(func.totalRegistros));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void mostrarPruebas(String buscar) {

        try {
            DefaultTableModel modelo;
            F_SBO_LTG_PRUEBAS func = new F_SBO_LTG_PRUEBAS();
            modelo = func.mostrar(buscar);

            tablaListado.setModel(modelo);

            //CAMBIO DE TAMANIO DE COLUMNA A LA TABLA
            TableColumnModel columnModel = tablaListado.getColumnModel();

            columnModel.getColumn(3).setPreferredWidth(250);
            columnModel.getColumn(10).setPreferredWidth(300);
            columnModel.getColumn(11).setPreferredWidth(300);

            // ocultar_columna();
            //LblTotalRegistros.setText("TOTAL REGISTROS" + Integer.toString(func.totalRegistros));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    void mostrarSL(String buscar) {

        try {
            DefaultTableModel modelo;
            F_SBO_SL_PROD func = new F_SBO_SL_PROD();
            modelo = func.mostrar(buscar);

            tablaListado.setModel(modelo);
            
             //CAMBIO DE TAMANIO DE COLUMNA A LA TABLA
            TableColumnModel columnModel = tablaListado.getColumnModel();
            columnModel.getColumn(3).setPreferredWidth(250);
            columnModel.getColumn(10).setPreferredWidth(300);
            columnModel.getColumn(11).setPreferredWidth(300);
            
            // ocultar_columna();
            //LblTotalRegistros.setText("TOTAL REGISTROS" + Integer.toString(func.totalRegistros));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        btn_pruebas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CARGAR NOMINA - SAP");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        btn_pruebas.setText("Salir");
        btn_pruebas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pruebasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pruebas, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 40, 130, -1));

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ReferenceDate", "DueDate", "TaxDate", "Memo", "Sincronizado", "Origen", "Accion", "Idenificador", "Serie", "CreateDatePOS", "UpdateStatu", "Message                   "
            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1080, 290));

        jMenuBar1.setAutoscrolls(true);

        jMenu1.setText("Tablita");

        jMenuItem1.setText("TH_ASIENTONOMINALIQ_PRC");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("TH_ASIENTONOMINAPRO_PRC");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("TH_ASIENTONOMINAROL_PRC");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem20.setText("MOSTRAR DATOS");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem20);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("GRestaurants");

        jMenuItem7.setText("TH_ASIENTONOMINALIQ_PRC");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("TH_ASIENTONOMINAPRO_PRC");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("TH_ASIENTONOMINAROL_PRC");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem21.setText("MOSTAR DATOS");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem21);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Corporación ");

        jMenuItem10.setText("TH_ASIENTONOMINALIQ_PRC");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuItem11.setText("TH_ASIENTONOMINAPRO_PRC");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem11);

        jMenuItem12.setText("TH_ASIENTONOMINAROL_PRC");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem22.setText("MOSTRAR DATOS");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem22);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("G.Food");

        jMenuItem4.setText("TH_ASIENTONOMINALIQ_PRC");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("TH_ASIENTONOMINAPRO_PRC");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("TH_ASIENTONOMINAROL_PRC");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem23.setText("MOSTRAR DATOS");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem23);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("SimpleLife");

        jMenuItem13.setText("TH_ASIENTONOMINALIQ_PRC");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuItem14.setText("TH_ASIENTONOMINAPRO_PRC");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuItem15.setText("TH_ASIENTONOMINAROL_PRC");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem24.setText("MOSTRAR DATOS");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem24);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Pruebas");

        jMenuItem16.setText("TH_ASIENTONOMINALIQ_PRC");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem16);

        jMenuItem17.setText("TH_ASIENTONOMINAPRO_PRC");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem17);

        jMenuItem18.setText("TH_ASIENTONOMINAROL_PRC");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem18);

        jMenuItem19.setText("MOSTRAR DATOS");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_pruebasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pruebasActionPerformed

        this.dispose();
    }//GEN-LAST:event_btn_pruebasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_LTG_PROD SQL = new Conexion_SBO_LTG_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINALIQ_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de LIQUIDACION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:

        Conexion_SBO_LTG_PROD SQL = new Conexion_SBO_LTG_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAPRO_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de PROVICION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_LTG_PROD SQL = new Conexion_SBO_LTG_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAROL_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de ROLES exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:

        Conexion_SBO_GR_PROD SQL = new Conexion_SBO_GR_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {
                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAPRO_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de PROVICION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed

        Conexion_SBO_GR_PROD SQL = new Conexion_SBO_GR_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAROL_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de ROLES exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_GMS_PROD SQL = new Conexion_SBO_GMS_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINALIQ_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de LIQUIDACION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_GMS_PROD SQL = new Conexion_SBO_GMS_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {
                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAROL_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de ROLES exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_SL_PROD SQL = new Conexion_SBO_SL_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINALIQ_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de LIQUIDACION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }

    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:

        Conexion_SBO_SL_PROD SQL = new Conexion_SBO_SL_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {
                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAPRO_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de PROVICION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:

        Conexion_SBO_SL_PROD SQL = new Conexion_SBO_SL_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {
                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAROL_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de ROLES exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_GF_PROD SQL = new Conexion_SBO_GF_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINALIQ_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de LIQUIDACION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        Conexion_SBO_GF_PROD SQL = new Conexion_SBO_GF_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAPRO_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de PROVICION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_GF_PROD SQL = new Conexion_SBO_GF_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAROL_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de ROLES exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_GR_PROD SQL = new Conexion_SBO_GR_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINALIQ_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de LIQUIDACION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:

        Conexion_SBO_GMS_PROD SQL = new Conexion_SBO_GMS_PROD();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {
                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAPRO_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showConfirmDialog(null, "Carga de nomina de PROVICION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }
        }


    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        Conexion_SBO_LTG_PRUEBAS SQL = new Conexion_SBO_LTG_PRUEBAS();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {

                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINALIQ_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showMessageDialog(null, "Carga de nomina de LIQUIDACION exitosa!");

                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_LTG_PRUEBAS SQL = new Conexion_SBO_LTG_PRUEBAS();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {
                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAPRO_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showMessageDialog(null, "Carga de nomina de PROVISION exitosa!");
                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }
        }

    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        // TODO add your handling code here:
        Conexion_SBO_LTG_PRUEBAS SQL = new Conexion_SBO_LTG_PRUEBAS();

        java.sql.Connection cn = SQL.Conectar();

        if (cn != null) {

            try {
                CallableStatement cst3 = cn.prepareCall("{call dbo.TH_ASIENTONOMINAROL_PRC(?)}");
                cst3.registerOutParameter(1, java.sql.Types.VARCHAR);

                cst3.execute();
                String salida = cst3.getString(1);
                System.out.println("El valor de salida es: " + String.valueOf(salida));
                JOptionPane.showMessageDialog(null, "Carga de nomina de ROLES exitosa!");

                cn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);

                System.out.println("Error al conectar " + ex);

            }

        }


    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        // TODO add your handling code here:
        mostrarPruebas("");
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
        mostrarLTG("");
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        mostrarGR("");
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        mostrarGMS("");
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        mostrarGF("");
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        mostrarSL("");
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pruebas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaListado;
    // End of variables declaration//GEN-END:variables
}
