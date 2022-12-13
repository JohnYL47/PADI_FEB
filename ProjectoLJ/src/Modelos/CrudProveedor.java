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
public class CrudProveedor {
    PreparedStatement ps = null;
         Conexion cn = new Conexion();
public boolean registrar(Modelo_Proveedor M_Prov) {
         
         Connection con = cn.getConexion();
         String sql = "Insert into proveedores"
                + "(ID, Nombre, Telefono, Direccion, `Razon social`)Values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Prov.getTxtRUT());
            ps.setString(2, M_Prov.getTxtNombrePr());
            ps.setInt(3, M_Prov.getTxtTelefonoPr());
            ps.setString(4, M_Prov.getTxtDireccionPr());
            ps.setString(5, M_Prov.getTxtRazonPr());
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

    public boolean actualizar(Modelo_Proveedor M_Prov) {
           PreparedStatement ps = null;
        Connection con = cn.getConexion();

        String sql = "update proveedores set Nombre =?, Telefono=?, Direccion=?, `Razon social`=? "
                + "where RUT=?";
        try {
            ps = con.prepareStatement(sql);
             ps.setInt(1, M_Prov.getTxtRUT());
            ps.setString(2, M_Prov.getTxtNombrePr());
            ps.setInt(3, M_Prov.getTxtTelefonoPr());
            ps.setString(4, M_Prov.getTxtDireccionPr());
            ps.setString(5, M_Prov.getTxtRazonPr());
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

    public boolean eliminar(Modelo_Proveedor M_Prov) {
          PreparedStatement ps = null;
        Connection con = cn.getConexion();
        String sql = "delete from proveedores where ID =?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Prov.getTxtRUT());
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
                M_Prov.setTxtRazonPr(rs.getString("`Razon social`"));
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

