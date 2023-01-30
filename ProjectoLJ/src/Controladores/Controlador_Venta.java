/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.CrudVenta;
import Modelos.*;
import Modelos.Modelo_Venta;
import Vista.Sistema;
import Vista.Ventas;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAMES
 */
public class Controlador_Venta implements ActionListener{

    private Ventas Vn;
    private CrudVenta CV;
    private Modelo_Venta MV;
    private Sistema St;
    // Cliente
    private CrudCliente CCl;
    private Clientes Cl;
    // proveedores
    private CrudProveedor C_prov;
    
    DefaultTableModel modelo = new DefaultTableModel();

    Controlador_Venta(Ventas Vn, CrudVenta CV, Modelo_Venta MV, Sistema St) {
        this.Vn = Vn;
        this.CV = CV;
        this.MV = MV;
        this.St = St;
        
        this.Vn.BtnVolverV.addActionListener(this);
    }

    void iniciar() {
        this.Vn.setTitle("Ventas");
        this.Vn.setVisible(true);
        this.Vn.setLocationRelativeTo(null);
        this.St.dispose();
        ListarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.Vn.BtnVolverV) {
            this.St.setVisible(true);
            this.Vn.dispose();
            LimpiarTable();
        }
        /***
         * Tomar Los precios de todos los [ Precios de productos ] y guardarlos en una variable.
         * y mostrarlo con *getTxttotal();*
         */
    }
    public void ListarTabla(){
        
        
        List<Modelos_Clientes> ListarCl = CCl.ListarCliente();
        List<Modelo_Productos> ListarPd = CCl.ListarCliente();
        List<Modelo_Proveedor> listaPr = C_prov.ListarProveedor();
        List<Modelo_Venta> listaVn = CV.Listarventas();

        /*        
        for (int i = 0; i < lista.size(); i++) {

            int id = lista.get(i).getTxtRUT();
            String nombre = lista.get(i).getTxtNombrePr();
            this.V_Pro.jcboxProveedor.addItem(new Combo(id, nombre));

        }*/
        modelo = (DefaultTableModel) this.Vn.jtbVentas.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getTxtID();
            ob[1] = ListarCl.get(i).getTxtNombre();
            ob[2] = ListarPd.get(i).getTxtNombreP();//
            ob[3] = listaPr.get(i).getTxtNombrePr();
            ob[4] = listaVn.get(i).getTxttotal();
            modelo.addRow(ob);
        }
        this.Cl.jTableclient.setModel(modelo);
    }
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
