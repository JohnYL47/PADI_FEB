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

/**
 *
 * @author Familia Marbello
 */
public class CrudCliente {

    private Connection con;
    private Conexion coon = new Conexion();
    

    public boolean registrar(Modelos_Clientes M_Cli) {
        PreparedStatement ps = null;
        con  = coon.getConexion();
        String sql = "Insert into clientes"
                + "(ID, Nombre, Telefono, Direccion, `Razon social`)Values(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Cli.getTxtID());
            ps.setString(2, M_Cli.getTxtNombre());
            ps.setInt(3, M_Cli.getTxtTelefono());
            ps.setString(4, M_Cli.getTxtDireccion());
            ps.setString(5, M_Cli.getTxtRazon());
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

    public boolean actualizar(Modelos_Clientes M_Cli) {
        PreparedStatement ps = null;
        Connection con = coon.getConexion();

        String sql = "update clientes set Nombre =?, Telefono=?, Direccion=?, `Razon social`=? "
                + "where ID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Cli.getTxtID());
            ps.setString(2, M_Cli.getTxtNombre());
            ps.setInt(3, M_Cli.getTxtTelefono());
            ps.setString(4, M_Cli.getTxtDireccion());
            ps.setString(5, M_Cli.getTxtRazon());
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

    public boolean eliminar(Modelos_Clientes M_Cli) {

        PreparedStatement ps = null;
        Connection con = coon.getConexion();
        String sql = "delete from clientes where ID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Cli.getTxtID());
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

    public boolean buscar(Modelos_Clientes M_Cli) {

        Connection con = coon.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from clientes where ID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, M_Cli.getTxtID());
            rs = ps.executeQuery();

            if (rs.next()) {
                M_Cli.setTxtID(Integer.parseInt(rs.getString("ID")));
                M_Cli.setTxtNombre(rs.getString("Nombre"));
                M_Cli.setTxtTelefono(Integer.parseInt(rs.getString("Telefono")));
                M_Cli.setTxtDireccion(rs.getString("Direccion"));
                M_Cli.setTxtRazon(rs.getString("`Razon social`"));
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
