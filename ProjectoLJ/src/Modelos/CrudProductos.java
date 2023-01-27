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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Familia Marbello
 */
public class CrudProductos {

    PreparedStatement ps = null;
    Conexion cn = new Conexion();

    public boolean registrar(Modelo_Productos M_Pro) {

        /*
        public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }*/
        Connection con = cn.getConexion();
        String sql = "Insert into productos "
                + "(Codigo, Nombre, Proveedor, Stock, Precio) Values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Pro.getTxtCodigoP());
            ps.setString(2, M_Pro.getTxtNombreP());
            ps.setInt(3, M_Pro.getTxtProveedorP());
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
            ps.setString(1, M_Pro.getTxtNombreP());
            ps.setInt(2, M_Pro.getTxtProveedorP());
            ps.setInt(3, M_Pro.getTxtCantidadP());
            ps.setDouble(4, M_Pro.getTxtPrecioP());
            ps.setInt(5, M_Pro.getTxtCodigoP());
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
                M_Pro.setTxtNombreP(rs.getString("Nombre"));
                M_Pro.setTxtProveedorP(rs.getInt("Proveedor"));
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

    public List<Modelo_Productos> ListarProductos() {
        List<Modelo_Productos> Listaprod = new ArrayList();
        String sql = "SELECT * FROM productos";
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Modelo_Productos prod = new Modelo_Productos();
                prod.setTxtCodigoP(rs.getInt("Codigo"));
                prod.setTxtNombreP(rs.getString("Nombre"));
                prod.setTxtProveedorP(rs.getInt("Proveedor"));
                prod.setTxtCantidadP(rs.getInt("Stock"));
                prod.setTxtPrecioP(rs.getDouble("Precio"));
                Listaprod.add(prod);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listaprod;
    }
}
