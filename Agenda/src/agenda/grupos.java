/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import static agenda.Inicio.jtContacto;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ileana-sama
 */
public class grupos extends javax.swing.JFrame {

    /**
     * Creates new form grupos
     */
    public grupos() {
        initComponents();
        regresar.setIcon(setIcono("/imagenes/flecha.png", regresar));
        this.getContentPane().setBackground(Color.white);
              
        try{
            //FAMILIA
            DefaultTableModel modelo = new DefaultTableModel();
            jfamilia.setModel(modelo);
          
            //FAMILIA
            PreparedStatement pe= null;
            ResultSet rs = null;
            
            
            conexion cone = new conexion();
            Connection conex = cone.conectar();
            
            String sql1 = "select nombre, numero from contacto inner join grupoFamilia on idContacto = id_contacto";
            String sql2 = "select nombre, numero from contacto inner join grupoAmigos on idContacto = id_contacto";
            
            //FAMILIA
            pe = conex.prepareStatement(sql1);
            rs = pe.executeQuery();
            
           
            
            //FAMILIA
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas= rsmd.getColumnCount();
            
            //modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Numero");
            
          
            //modelo.addColumn("Apellido materno"); modelo.addColumn("Numero");
            //modelo.addColumn("Correo electronico");
            //modelo.addColumn("Cumpleaños");
            //modelo.addColumn("Sexo");
            //modelo.addColumn("Domicilio");
            
            //FAMILIA
            while (rs.next())
            {
                Object[] filas = new Object[cantidadColumnas];
               
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i] = rs.getObject(i+1);
                   
                }
                
                modelo.addRow(filas);
               
            }
            
        }catch(SQLException e)
        {
            System.err.println(e.toString());
        }
        
        
        //AMIGOS
        try{
            
            DefaultTableModel modelo1 = new DefaultTableModel();
            jamigos.setModel(modelo1);
            
            PreparedStatement pe1= null;
            ResultSet rs1 = null;
            
            
            conexion cone = new conexion();
            Connection conex = cone.conectar();
            
            String sql1 = "select nombre, numero from contacto inner join grupoAmigos on idContacto = id_contacto";
        
            pe1 = conex.prepareStatement(sql1);
            rs1 = pe1.executeQuery();
            
            ResultSetMetaData rsmd1 = rs1.getMetaData();
            int cantidadColumnas= rsmd1.getColumnCount();
            
            //modelo.addColumn("ID");
            modelo1.addColumn("Nombre");
            modelo1.addColumn("Numero");
            
          
            while (rs1.next())
            {
                Object[] filas = new Object[cantidadColumnas];
               
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i] = rs1.getObject(i+1);
                   
                }
                
                modelo1.addRow(filas);
            }
            
        }catch(SQLException e)
        {
            System.err.println(e.toString());
        }
        
        
        //TRABAJO
        try{
            
            DefaultTableModel modelo2 = new DefaultTableModel();
            jtrabajo.setModel(modelo2);
          
            PreparedStatement pe2= null;
            ResultSet rs2 = null;
            
            
            conexion cone = new conexion();
            Connection conex = cone.conectar();
            
            String sql2 = "select nombre, numero from contacto inner join grupoTrabajo on idContacto = id_contacto";
            
            pe2 = conex.prepareStatement(sql2);
            rs2 = pe2.executeQuery();
            
           
            ResultSetMetaData rsmd2 = rs2.getMetaData();
            int cantidadColumnas= rsmd2.getColumnCount();
            
            //modelo.addColumn("ID");
            modelo2.addColumn("Nombre");
            modelo2.addColumn("Numero");
            
          
            while (rs2.next())
            {
                Object[] filas = new Object[cantidadColumnas];
               
                for(int i=0; i<cantidadColumnas; i++)
                {
                    filas[i] = rs2.getObject(i+1);
                   
                }
                
                modelo2.addRow(filas);
            }
            
        }catch(SQLException e)
        {
            System.err.println(e.toString());
        }
        
    }
    
     public Icon setIcono(String url, JButton boton)
    {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        
        return icono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jfamilia = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jamigos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtrabajo = new javax.swing.JTable();
        regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Mis grupos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Familia");

        jfamilia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jfamilia);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Amigos");

        jamigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jamigos);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Trabajo");

        jtrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtrabajo);

        regresar.setBorder(null);
        regresar.setBorderPainted(false);
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regresarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                regresarMouseReleased(evt);
            }
        });
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Inicio nuevo = new Inicio();
        nuevo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void regresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMouseReleased
        regresar.setBackground(Color.white);
    }//GEN-LAST:event_regresarMouseReleased

    private void regresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMousePressed
        regresar.setBackground(new Color(183, 203, 191));
    }//GEN-LAST:event_regresarMousePressed

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
            java.util.logging.Logger.getLogger(grupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jamigos;
    private javax.swing.JTable jfamilia;
    private javax.swing.JTable jtrabajo;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
