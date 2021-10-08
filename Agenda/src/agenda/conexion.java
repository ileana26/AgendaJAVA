/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ileana-sama
 */
public class conexion {
Connection conexion = null;
    
    public Connection conectar() 
    {
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/agenda","root","");
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
           
        }catch(Exception e)
        {
            System.out.println("Error");
            //JOptionPane.showMessageDialog(null, "Conexion no exitosa");
        }
    return conexion;
}
    
    public static void main (String [] args)
    {
        conexion co = new conexion();
        Statement st;
        ResultSet rs;
        
        try{
            st = co.conexion.createStatement();
            rs = st.executeQuery("Select idContacto, nombre from contacto");
            while (rs.next()){
                System.out.println(rs.getInt("idContacto") + " " + rs.getString("nombre")+ "\n");
            }
            co.conexion.close();
            
        }catch (Exception e)
        {
            
        }
        
    }
    }
