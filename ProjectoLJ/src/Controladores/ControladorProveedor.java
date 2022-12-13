/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.CrudProveedor;
import Modelos.Modelo_Proveedor;
import Vista.Proveedor;
import Vista.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Marbello
 */
public class ControladorProveedor implements ActionListener{

    private Proveedor V_Prov;
    private CrudProveedor C_Prov;
    private Modelo_Proveedor M_Prov;
    private Sistema Si;

    private int TxtRUT;
    private String TxtNombrePr;
    private int TxtTelefonoPr;
    private String TxtDireccionPr;
    private String TxtRazonPr;

    public ControladorProveedor(Proveedor V_Prov, CrudProveedor C_Prov, Modelo_Proveedor M_Prov, Sistema Si) {
        this.V_Prov = V_Prov;
        this.C_Prov = C_Prov;
        this.M_Prov = M_Prov;
        this.Si = Si;

        this.V_Prov.BtnGuardar.addActionListener( this);
        this.V_Prov.BtnActualizar.addActionListener( this);
        this.V_Prov.BtnBorrar.addActionListener(this);
        this.V_Prov.BtnMostrar.addActionListener( this);
        this.V_Prov.BtnVolverPr.addActionListener( this);
    }

    public void iniciar() {
        this.V_Prov.setTitle("Proveedor");
        this.V_Prov.setLocationRelativeTo(null);
        this.V_Prov.setVisible(true);
    }

    public void limpiar() {
        this.V_Prov.TxtRUT.setText(null);
        this.V_Prov.TxtNombrePr.setText(null);
        this.V_Prov.TxtTelefonoPr.setText(null);
        this.V_Prov.TxtDireccionPr.setText(null);
        this.V_Prov.TxtRazonPr.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.V_Prov.BtnGuardar) {

            int Cl_RUT = Integer.parseInt(this.V_Prov.TxtRUT.getText());
            String Cl_Nombre = this.V_Prov.TxtNombrePr.getText();
            int Cl_Telefono = Integer.parseInt(this.V_Prov.TxtTelefonoPr.getText());
            String Cl_Direccion = this.V_Prov.TxtDireccionPr.getText();
            String Cl_Razon = this.V_Prov.TxtRazonPr.getText();

            M_Prov.setTxtRUT(Cl_RUT);
            M_Prov.setTxtNombrePr(Cl_Nombre);
            M_Prov.setTxtTelefonoPr(Cl_Telefono);
            M_Prov.setTxtDireccionPr(Cl_Direccion);
            M_Prov.setTxtRazonPr(Cl_Razon);

            C_Prov.registrar(M_Prov);
            JOptionPane.showMessageDialog(null, "Guardado");
            limpiar();
        }

        if (e.getSource() == this.V_Prov.BtnActualizar) {

            int Cl_RUT = Integer.parseInt(this.V_Prov.TxtRUT.getText());
            String Cl_Nombre = this.V_Prov.TxtNombrePr.getText();
            int Cl_Telefono = Integer.parseInt(this.V_Prov.TxtTelefonoPr.getText());
            String Cl_Direccion = this.V_Prov.TxtDireccionPr.getText();
            String Cl_Razon = this.V_Prov.TxtRazonPr.getText();

            M_Prov.setTxtRUT(Cl_RUT);
            M_Prov.setTxtNombrePr(Cl_Nombre);
            M_Prov.setTxtTelefonoPr(Cl_Telefono);
            M_Prov.setTxtDireccionPr(Cl_Direccion);
            M_Prov.setTxtRazonPr(Cl_Razon);

            C_Prov.registrar(M_Prov);
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            limpiar();
        }

        if (e.getSource() == this.V_Prov.BtnBorrar) {

            int Cl_RUT = Integer.parseInt(this.V_Prov.TxtRUT.getText());
            String Cl_Nombre = this.V_Prov.TxtNombrePr.getText();
            int Cl_Telefono = Integer.parseInt(this.V_Prov.TxtTelefonoPr.getText());
            String Cl_Direccion = this.V_Prov.TxtDireccionPr.getText();
            String Cl_Razon = this.V_Prov.TxtRazonPr.getText();

            C_Prov.eliminar(M_Prov);
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            limpiar();
        }

        if (e.getSource() == this.V_Prov.BtnMostrar) {

            int Cl_RUT = Integer.parseInt(this.V_Prov.TxtRUT.getText());
            String Cl_Nombre = this.V_Prov.TxtNombrePr.getText();
            int Cl_Telefono = Integer.parseInt(this.V_Prov.TxtTelefonoPr.getText());
            String Cl_Direccion = this.V_Prov.TxtDireccionPr.getText();
            String Cl_Razon = this.V_Prov.TxtRazonPr.getText();

            M_Prov.setTxtRUT(Cl_RUT);
            if (C_Prov.buscar(M_Prov)) {
                this.V_Prov.TxtRUT.setText(String.valueOf(M_Prov.getTxtRUT()));
                this.V_Prov.TxtNombrePr.setText(String.valueOf(M_Prov.getTxtNombrePr()));
                this.V_Prov.TxtTelefonoPr.setText(String.valueOf(M_Prov.getTxtTelefonoPr()));
                this.V_Prov.TxtDireccionPr.setText(String.valueOf(M_Prov.getTxtDireccionPr()));
                this.V_Prov.TxtRazonPr.setText(String.valueOf(M_Prov.getTxtRazonPr()));
            }
        }
        if (e.getSource() == this.V_Prov.BtnVolverPr) {
            Si.setVisible(true);
            V_Prov.dispose();
        }
        if (e.getSource() == this.V_Prov.BtnLimpiarPr) {
            limpiar();
        }
    }
}
