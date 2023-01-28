/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.CrudProductos;
import Modelos.Combo;
import Modelos.*;
import Modelos.Modelo_Productos;
import Vista.Productos;
import Vista.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia Marbello
 */
public class ControladorProductos implements ActionListener {

    private Productos V_Pro;
    private CrudProveedor C_prov;
    private CrudProductos C_Prod;
    private Modelo_Productos M_Pro;
    private Sistema Si;
    private Combo Combo;

    private int TxtCodigoP;
    private String TxtDescripcion;
    private int TxtCantidad;
    private Double TxtPrecio;
    private String TxtProveedor;

    private int Pl_Codigo;
    private int Pl_Cantidad;
    private double Pl_Precio;
    private String Pl_Nombre;
    private String Pl_Proveedor;

    private DefaultTableModel modelo = new DefaultTableModel();

    public ControladorProductos(Productos V_Pro, CrudProductos C_Pro, Modelo_Productos M_Pro, Sistema Si) {
        this.V_Pro = V_Pro;
        this.C_Prod = C_Pro;
        this.M_Pro = M_Pro;
        this.Si = Si;

        this.V_Pro.BtnGuardar.addActionListener(this);
        this.V_Pro.BtnActualizar.addActionListener(this);
        this.V_Pro.BtnBorrar.addActionListener(this);
        this.V_Pro.BtnMostrar.addActionListener(this);
        this.V_Pro.BtnVolverP.addActionListener(this);
        this.V_Pro.jcboxProveedor.addActionListener(this);
    }

    public void iniciar() {
        this.V_Pro.setTitle("Productos");
        this.V_Pro.setLocationRelativeTo(null);
        this.V_Pro.setVisible(true);
        this.Si.dispose();
        listarProductos();
        llenarProveedor();

    }

    public void limpiar() {
        this.V_Pro.TxtCodigoP.setText(null);
        this.V_Pro.TxtNombreP.setText(null);
        this.V_Pro.TxtCantidadP.setText(null);
        this.V_Pro.TxtPrecioP.setText(null);
        this.V_Pro.jcboxProveedor.setSelectedItem(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.V_Pro.BtnGuardar) {

            if (!"".equals(this.V_Pro.TxtCodigoP.getText()) || !"".equals(this.V_Pro.TxtNombreP.getText()) || !"".equals(this.V_Pro.jcboxProveedor.getSelectedItem()) || !"".equals(this.V_Pro.TxtCantidadP.getText()) || !"".equals(this.V_Pro.TxtPrecioP.getText())) {

                Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
                Pl_Nombre = this.V_Pro.TxtNombreP.getText();

                Combo itemP = (Combo) this.V_Pro.jcboxProveedor.getSelectedItem();

                Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
                Pl_Precio = Double.parseDouble(this.V_Pro.TxtPrecioP.getText());

                M_Pro.setTxtCodigoP(Pl_Codigo);
                M_Pro.setTxtNombreP(Pl_Nombre);

                M_Pro.setTxtProveedorP(itemP.getId());

                M_Pro.setTxtCantidadP(TxtCantidad);
                M_Pro.setTxtPrecioP(Pl_Precio);

                C_Prod.registrar(M_Pro);

                JOptionPane.showMessageDialog(null, "Productos Registrado");
                LimpiarTable();
                listarProductos();
                limpiar();
                this.V_Pro.jcboxProveedor.removeAllItems();
                llenarProveedor();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
            /*
            Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            Pl_Descripcion = this.V_Pro.TxtDescripcionP.getText();
            Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            Pl_Precio = Integer.parseInt(this.V_Pro.TxtPrecioP.getText());
            Pl_Proveedor = this.V_Pro.TxtProveedorP.getText();

            M_Pro.setTxtCodigoP(Pl_Codigo);
            M_Pro.setTxtDescripcionP(Pl_Descripcion);
            M_Pro.setTxtCantidadP(Pl_Cantidad);
            M_Pro.setTxtPrecioP(Pl_Precio);
            M_Pro.setTxtProveedorP(Pl_Proveedor);

            C_Pro.registrar(M_Pro);
            JOptionPane.showMessageDialog(null, "Guardado");
            limpiar();*/
        }

        if (e.getSource() == this.V_Pro.BtnActualizar) {

            Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            Pl_Nombre = this.V_Pro.TxtNombreP.getText();

            Combo itemP = (Combo) this.V_Pro.jcboxProveedor.getSelectedItem();

            Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            Pl_Precio = Double.parseDouble(this.V_Pro.TxtPrecioP.getText());

            M_Pro.setTxtCodigoP(Pl_Codigo);
            M_Pro.setTxtNombreP(Pl_Nombre);

            M_Pro.setTxtProveedorP(itemP.getId());

            M_Pro.setTxtCantidadP(TxtCantidad);
            M_Pro.setTxtPrecioP(Pl_Precio);

            C_Prod.actualizar(M_Pro);
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            limpiar();
        }

        if (e.getSource() == this.V_Pro.BtnBorrar) {
            Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            Pl_Nombre = this.V_Pro.TxtNombreP.getText();

            Combo itemP = (Combo) this.V_Pro.jcboxProveedor.getSelectedItem();

            Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            Pl_Precio = Double.parseDouble(this.V_Pro.TxtPrecioP.getText());

            M_Pro.setTxtCodigoP(Pl_Codigo);
            M_Pro.setTxtNombreP(Pl_Nombre);

            M_Pro.setTxtProveedorP(itemP.getId());

            M_Pro.setTxtCantidadP(TxtCantidad);
            M_Pro.setTxtPrecioP(Pl_Precio);
            
            C_Prod.eliminar(M_Pro);
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            limpiar();
        }

        if (e.getSource() == this.V_Pro.BtnMostrar) {

            Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            Pl_Nombre = this.V_Pro.TxtNombreP.getText();

            Combo itemP = (Combo) this.V_Pro.jcboxProveedor.getSelectedItem();

            Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            Pl_Precio = Double.parseDouble(this.V_Pro.TxtPrecioP.getText());

            M_Pro.setTxtCodigoP(Pl_Codigo);
            M_Pro.setTxtNombreP(Pl_Nombre);

            M_Pro.setTxtProveedorP(itemP.getId());

            M_Pro.setTxtCantidadP(TxtCantidad);
            M_Pro.setTxtPrecioP(Pl_Precio);
            if (C_Prod.buscar(M_Pro)) {

                this.V_Pro.TxtCodigoP.setText(String.valueOf(M_Pro.getTxtCodigoP()));
                this.V_Pro.TxtNombreP.setText(String.valueOf(M_Pro.getTxtNombreP()));
                this.V_Pro.TxtCantidadP.setText(String.valueOf(M_Pro.getTxtCantidadP()));
                this.V_Pro.TxtPrecioP.setText(String.valueOf(M_Pro.getTxtPrecioP()));
                //this.V_Pro.TxtProveedorP.setText(String.valueOf(M_Pro.getTxtProveedorP()));
            }
        }
        if (e.getSource() == this.V_Pro.BtnVolverP) {
            this.Si.setVisible(true);
            V_Pro.dispose();
            LimpiarTable();
        }
    }

    /*
    public void ListarProductos() {
        List<Productos> ListarPro = proDao.ListarProductos();
        modelo = (DefaultTableModel) TableProducto.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarPro.size(); i++) {
            ob[0] = ListarPro.get(i).getId();
            ob[1] = ListarPro.get(i).getCodigo();
            ob[2] = ListarPro.get(i).getNombre();
            ob[3] = ListarPro.get(i).getProveedorPro();
            ob[4] = ListarPro.get(i).getStock();
            ob[5] = ListarPro.get(i).getPrecio();
            modelo.addRow(ob);
        }
        TableProducto.setModel(modelo);

    }*/
    public void listarProductos() {
        List<Modelo_Productos> Listarpd = C_Prod.ListarProductos();
        modelo = (DefaultTableModel) this.V_Pro.jTableProd.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < Listarpd.size(); i++) {
            ob[0] = Listarpd.get(i).getTxtCodigoP();
            ob[1] = Listarpd.get(i).getTxtNombreP();
            ob[2] = Listarpd.get(i).getTxtProveedorP();
            ob[3] = Listarpd.get(i).getTxtCantidadP();
            ob[4] = Listarpd.get(i).getTxtPrecioP();
            modelo.addRow(ob);
        }
        this.V_Pro.jTableProd.setModel(modelo);
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void llenarProveedor() {
        List<Modelo_Proveedor> lista = C_prov.ListarProveedor();

        for (int i = 0; i < lista.size(); i++) {

            int id = lista.get(i).getTxtRUT();
            String nombre = lista.get(i).getTxtNombrePr();
            this.V_Pro.jcboxProveedor.addItem(new Combo(id, nombre));

        }
    }
}
