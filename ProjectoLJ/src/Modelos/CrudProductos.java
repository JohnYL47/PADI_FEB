/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexiones.Conexion;

/**
 *
 * @author Familia Marbello
 */
public class CrudProductos {
    PreparedStatement ps = null;
         Conexion cn = new Conexion();
    public boolean registrar(Modelo_Productos M_Pro) {
         
         Connection con = cn.getConexion();
         String sql = "Insert into productos"
                + "(Codigo, Nombre, Proveedor, Stock, Precio)Values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Pro.getTxtCodigoP());
            ps.setString(2, M_Pro.getTxtDescripcionP());
            ps.setString(3, M_Pro.getTxtProveedorP());
            ps.setInt(4, M_Pro.getTxtCantidadP());
            ps.setDouble(5, M_Pro.getTxtPrecioP());
            ps.execute();
            return true;
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

    public boolean actualizar(Modelo_Productos M_Pro) {
           PreparedStatement ps = null;
        Connection con = cn.getConexion();

        String sql = "update productos set Nombre =?, Proveedor=?, Stock=?, Precio=? "
                + "where Codigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Pro.getTxtCodigoP());
            ps.setString(2, M_Pro.getTxtDescripcionP());
            ps.setString(3, M_Pro.getTxtProveedorP());
            ps.setInt(4, M_Pro.getTxtCantidadP());
            ps.setDouble(5, M_Pro.getTxtPrecioP());
            ps.execute();
            return true;
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

    public boolean eliminar(Modelo_Productos M_Pro) {
          PreparedStatement ps = null;
        Connection con = cn.getConexion();
        String sql = "delete from productos where Codigo =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Pro.getTxtCodigoP());
            ps.execute();
            return true;
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

    public boolean buscar(Modelo_Productos M_Pro) {
          PreparedStatement ps = null;
        Connection con = cn.getConexion();
        ResultSet rs = null;
        String sql = "select * from productos where Codigo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Pro.getTxtCodigoP());
            rs = ps.executeQuery();

            if (rs.next()) {
                M_Pro.setTxtCodigoP(rs.getInt("Codigo"));
                M_Pro.setTxtDescripcionP(rs.getString("Nombre"));
                M_Pro.setTxtProveedorP(rs.getString("Proveedor"));
                M_Pro.setTxtCantidadP(rs.getInt("Stock"));
                M_Pro.setTxtPrecioP(rs.getInt("Stock"));
                return true;
            }
            return false;
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
}

