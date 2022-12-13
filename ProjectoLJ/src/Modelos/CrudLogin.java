/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelos.*;

/**
 *
 * @author Familia Marbello
 */
public class CrudLogin extends Conexion {

    PreparedStatement ps = null;
    Connection con;
    ResultSet rs = null;
    Conexion cn = new Conexion();

    public boolean ingreso(Modelos_Login l) {

        String sql = "select * from usuarios where Usuario = ? and Contraseña = ? ";

        try {
            
            con= cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, l.getTxtUsuario());
            ps.setString(2, l.getTxtContraseña());
            rs = ps.executeQuery();
            return rs.next();
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean Registrar(Modelos_Login reg) {
        String sql = "INSERT INTO usuarios (Usuario, Contraseña) VALUES (?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getTxtUsuario());
            ps.setString(2, reg.getTxtContraseña());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

}
