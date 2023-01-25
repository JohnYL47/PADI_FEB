/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.CrudProductos;
import Modelos.Modelo_Productos;
import Vista.Productos;
import Vista.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Marbello
 */
public class ControladorProductos implements ActionListener{

    private Productos V_Pro;
    private CrudProductos C_Pro;
    private Modelo_Productos M_Pro;
    private Sistema Si;

    private int TxtCodigoP;
    private String TxtDescripcion;
    private int TxtCantidad;
    private Double TxtPrecio;
    private String TxtProveedor;

    public ControladorProductos(Productos V_Pro, CrudProductos C_Pro, Modelo_Productos M_Pro, Sistema Si) {
        this.V_Pro = V_Pro;
        this.C_Pro = C_Pro;
        this.M_Pro = M_Pro;
        this.Si = Si;

        this.V_Pro.BtnGuardar.addActionListener(this);
        this.V_Pro.BtnActualizar.addActionListener(this);
        this.V_Pro.BtnBorrar.addActionListener(this);
        this.V_Pro.BtnMostrar.addActionListener(this);
        this.V_Pro.BtnLimpiar.addActionListener(this);
        this.V_Pro.BtnVolverP.addActionListener(this);
    }

    public void iniciar() {
        this.V_Pro.setTitle("Productos");
        this.V_Pro.setLocationRelativeTo(null);
        this.V_Pro.setVisible(true);

    }

    public void limpiar() {
        this.V_Pro.TxtCodigoP.setText(null);
        this.V_Pro.TxtDescripcionP.setText(null);
        this.V_Pro.TxtCantidadP.setText(null);
        this.V_Pro.TxtPrecioP.setText(null);
        this.V_Pro.TxtProveedorP.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.V_Pro.BtnGuardar) {
            int Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            String Pl_Descripcion = this.V_Pro.TxtDescripcionP.getText();
            int Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            int Pl_Precio = Integer.parseInt(this.V_Pro.TxtPrecioP.getText());
            String Pl_Proveedor = this.V_Pro.TxtProveedorP.getText();

            M_Pro.setTxtCodigoP(Pl_Codigo);
            M_Pro.setTxtDescripcionP(Pl_Descripcion);
            M_Pro.setTxtCantidadP(Pl_Cantidad);
            M_Pro.setTxtPrecioP(Pl_Precio);
            M_Pro.setTxtProveedorP(Pl_Proveedor);

            C_Pro.registrar(M_Pro);
            JOptionPane.showMessageDialog(null, "Guardado");
            limpiar();
        }

        if (e.getSource() == this.V_Pro.BtnActualizar) {
            int Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            String Pl_Descripcion = this.V_Pro.TxtDescripcionP.getText();
            int Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            int Pl_Precio = Integer.parseInt(this.V_Pro.TxtPrecioP.getText());
            String Pl_Proveedor = this.V_Pro.TxtProveedorP.getText();

            M_Pro.setTxtCodigoP(Pl_Codigo);
            M_Pro.setTxtDescripcionP(Pl_Descripcion);
            M_Pro.setTxtCantidadP(Pl_Cantidad);
            M_Pro.setTxtPrecioP(Pl_Precio);
            M_Pro.setTxtProveedorP(Pl_Proveedor);

            C_Pro.actualizar(M_Pro);
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            limpiar();
        }

        if (e.getSource() == this.V_Pro.BtnBorrar) {
            int Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            String Pl_Descripcion = this.V_Pro.TxtDescripcionP.getText();
            int Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            int Pl_Precio = Integer.parseInt(this.V_Pro.TxtPrecioP.getText());
            String Pl_Proveedor = this.V_Pro.TxtProveedorP.getText();

            M_Pro.setTxtCodigoP(Pl_Codigo);
            C_Pro.eliminar(M_Pro);
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            limpiar();
        }

        if (e.getSource() == this.V_Pro.BtnMostrar) {
            
            int Pl_Codigo = Integer.parseInt(this.V_Pro.TxtCodigoP.getText());
            String Pl_Descripcion = this.V_Pro.TxtDescripcionP.getText();
            int Pl_Cantidad = Integer.parseInt(this.V_Pro.TxtCantidadP.getText());
            int Pl_Precio = Integer.parseInt(this.V_Pro.TxtPrecioP.getText());
            String Pl_Proveedor = this.V_Pro.TxtProveedorP.getText();
            
            M_Pro.setTxtCodigoP(Pl_Codigo);
            //C_Pro.buscar(M_Pro);
            if (C_Pro.buscar(M_Pro)) {                

                this.V_Pro.TxtCodigoP.setText(String.valueOf(M_Pro.getTxtCodigoP()));
                this.V_Pro.TxtDescripcionP.setText(String.valueOf(M_Pro.getTxtDescripcionP()));
                this.V_Pro.TxtCantidadP.setText(String.valueOf(M_Pro.getTxtCantidadP()));
                this.V_Pro.TxtPrecioP.setText(String.valueOf(M_Pro.getTxtPrecioP()));
                this.V_Pro.TxtProveedorP.setText(String.valueOf(M_Pro.getTxtProveedorP()));
            }
        }
        if (e.getSource() == this.V_Pro.BtnVolverP) {
            this.Si.setVisible(true);
            V_Pro.dispose();
        }

        if (e.getSource() == this.V_Pro.BtnLimpiar) {
            limpiar();
        }
    }
}
