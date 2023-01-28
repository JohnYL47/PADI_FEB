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
import Vista.Proveedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Familia Marbello
 */
public class CrudProveedor {

    PreparedStatement ps = null;
    Conexion cn = new Conexion();

    public boolean registrar(Modelo_Proveedor M_Prov) {

        Connection con = cn.getConexion();
        String sql = "Insert into proveedores"
                + "(ID, Nombre, Telefono, Direccion)Values(?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Prov.getTxtRUT());
            ps.setString(2, M_Prov.getTxtNombrePr());
            ps.setInt(3, M_Prov.getTxtTelefonoPr());
            ps.setString(4, M_Prov.getTxtDireccionPr());
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

    public boolean Actualizar(Modelo_Proveedor pr) {
        Connection con = cn.getConexion();
        String sql = "UPDATE proveedores SET Nombre=?, Telefono=?, Direccion=? WHERE ID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pr.getTxtNombrePr());
            ps.setInt(2, pr.getTxtTelefonoPr());
            ps.setString(3, pr.getTxtDireccionPr());
            ps.setInt(4, pr.getTxtRUT());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean EliminarProveedor(int id) {
        Connection con = cn.getConexion();
        String sql = "DELETE FROM proveedores WHERE ID = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean buscar(Modelo_Proveedor M_Prov) {
        PreparedStatement ps = null;
        Connection con = cn.getConexion();
        ResultSet rs = null;
        String sql = "select * from proveedores where ID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Prov.getTxtRUT());
            rs = ps.executeQuery();

            if (rs.next()) {
                M_Prov.setTxtRUT(Integer.parseInt(rs.getString("ID")));
                M_Prov.setTxtNombrePr(rs.getString("Nombre"));
                M_Prov.setTxtTelefonoPr(Integer.parseInt(rs.getString("Telefono")));
                M_Prov.setTxtDireccionPr(rs.getString("Direccion"));
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

    public List ListarProveedor() {
        List<Modelo_Proveedor> Lista = new ArrayList();
        Connection con;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM proveedores";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Modelo_Proveedor pr = new Modelo_Proveedor();
                pr.setTxtRUT(rs.getInt("ID"));
                pr.setTxtNombrePr(rs.getString("Nombre"));
                pr.setTxtTelefonoPr(Integer.parseInt(rs.getString("Telefono")));
                pr.setTxtDireccionPr(rs.getString("Direccion"));
                Lista.add(pr);
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Lista;
    }
}
