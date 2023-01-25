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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Familia Marbello
 */
public class CrudCliente {

    private Connection conect;
    private Conexion coon = new Conexion();
    

    public boolean registrar(Modelos_Clientes M_Cli) {
        PreparedStatement ps = null;
        conect  = coon.getConexion();
        String sql = "Insert into clientes"
                + "(ID, Nombre, Telefono, Direccion)Values(?,?,?,?)";
        try {
            ps = conect.prepareStatement(sql);
            ps.setInt(1, M_Cli.getTxtID());
            ps.setString(2, M_Cli.getTxtNombre());
            ps.setInt(3, M_Cli.getTxtTelefono());
            ps.setString(4, M_Cli.getTxtDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                conect.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean actualizar(Modelos_Clientes M_Cli) {
        PreparedStatement ps = null;
        Connection con = coon.getConexion();

        String sql = "update clientes set Nombre =?, Telefono=?, Direccion=? "
                + "where ID=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, M_Cli.getTxtNombre());
            ps.setInt(2, M_Cli.getTxtTelefono());
            ps.setString(3, M_Cli.getTxtDireccion());
            ps.setInt(4, M_Cli.getTxtID());
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

    public boolean eliminar(int id){
        Connection con = coon.getConexion();
        PreparedStatement ps = null;
        String sql = "DELETE FROM clientes WHERE ID = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
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
    public List ListarCliente(){
       List<Modelos_Clientes> ListaCl = new ArrayList();
       String sql = "SELECT * FROM clientes";
       Connection con;
       PreparedStatement ps = null;
       ResultSet rs = null;
       try {
           con = coon.getConexion();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {               
               Modelos_Clientes cl = new Modelos_Clientes();
               cl.setTxtID(rs.getInt("id"));
               cl.setTxtNombre(rs.getString("nombre"));
               cl.setTxtTelefono(rs.getInt("telefono"));
               cl.setTxtDireccion(rs.getString("direccion"));
               ListaCl.add(cl);
           }
       } catch (SQLException e) {
           System.out.println(e.toString());
       }
       return ListaCl;
   }
}
