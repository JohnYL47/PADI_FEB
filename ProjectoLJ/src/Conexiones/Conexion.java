/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Marbello
 */
public class Conexion {

    String base = "lamarbello";
    String URL = "jdbc:mysql://localhost:3306/" + base;
    String USER = "root";
    String CLAVE = "";

    public Connection getConexion() {
        Connection con = null;
        try {
            JOptionPane.showMessageDialog(null, "Loading...", "BD", JOptionPane.WARNING_MESSAGE);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, CLAVE);
            JOptionPane.showMessageDialog(null, "Conexion exitosa", "EXITO", JOptionPane.CLOSED_OPTION);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error");
        }
        return con;

    }
}
