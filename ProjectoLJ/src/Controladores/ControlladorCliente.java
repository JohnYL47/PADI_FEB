/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.*;
import Modelos.*;
import Vista.Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia Marbello
 */
public class ControlladorCliente implements ActionListener {

    private Clientes Cl;
    private CrudCliente CCl;
    private Modelos_Clientes McL;
    private Sistema vm;

    private int TxtID;
    private String TxtNombre;
    private int TxtTelefono;
    private String TxtDireccion;
    private String TxtRazon;

    /*public ControlladorCliente (Sistema vm, int TxtID, String TxtNombre, int TxtTelefono, String TxtDireccion, String TxtRazon) {
        this.vm = vm;
        this.TxtID = TxtID;
        this.TxtNombre = TxtNombre;
        this.TxtTelefono = TxtTelefono;
        this.TxtDireccion = TxtDireccion;
        this.TxtRazon = TxtRazon;
    }*/

    ControlladorCliente(Clientes Cl, CrudCliente CCl, Modelos_Clientes McL, Sistema vm) {
        this.Cl = Cl;
        this.CCl = CCl;
        this.McL = McL;
        this.vm = vm;
        this.Cl.BtnGuardar.addActionListener(this);
        this.Cl.BtnActualizar.addActionListener(this);
        this.Cl.BtnBorrar.addActionListener(this);
        this.Cl.BtnMostrar.addActionListener(this);
        this.Cl.BtnLimpiar.addActionListener(this);
        this.Cl.BtnVolverC.addActionListener(this);
    }

    public void iniciar() {
        this.Cl.setTitle("Clientes");
        this.Cl.setLocationRelativeTo(null);
        this.Cl.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.Cl.BtnGuardar) {
            TxtID = Integer.parseInt(this.Cl.TxtID.getText());
            TxtNombre = this.Cl.TxtNombre.getText();
            TxtTelefono = Integer.parseInt(this.Cl.TxtTelefono.getText());
            TxtDireccion = this.Cl.TxtDireccion.getText();
            TxtRazon = this.Cl.TxtRazon.getText();
            
            McL.setTxtID(TxtID);
            McL.setTxtNombre(TxtNombre);
            McL.setTxtTelefono(TxtTelefono);
            McL.setTxtDireccion(TxtDireccion);
            McL.setTxtRazon(TxtRazon);

            CCl.registrar(McL);
            JOptionPane.showMessageDialog(null, "Guardado");
            limpiar();
        }

        if (e.getSource() == this.Cl.BtnActualizar) {
            TxtID = Integer.parseInt(this.Cl.TxtID.getText());
            TxtNombre = this.Cl.TxtNombre.getText();
            TxtTelefono = Integer.parseInt(this.Cl.TxtTelefono.getText());
            TxtDireccion = this.Cl.TxtDireccion.getText();
            TxtRazon = this.Cl.TxtRazon.getText();

            McL.setTxtID(TxtID);
            McL.setTxtNombre(TxtNombre);
            McL.setTxtTelefono(TxtTelefono);
            McL.setTxtDireccion(TxtDireccion);
            McL.setTxtRazon(TxtRazon);

            CCl.actualizar(McL);
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            limpiar();
        }

        if (e.getSource() == this.Cl.BtnBorrar) {
            TxtID = Integer.parseInt(this.Cl.TxtID.getText());
            TxtNombre = this.Cl.TxtNombre.getText();
            TxtTelefono = Integer.parseInt(this.Cl.TxtTelefono.getText());
            TxtDireccion = this.Cl.TxtDireccion.getText();
            TxtRazon = this.Cl.TxtRazon.getText();
            McL.setTxtID(TxtID);
            if (CCl.eliminar(McL)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }
        }

        if (e.getSource() == this.Cl.BtnMostrar) {
            TxtID = Integer.parseInt(this.Cl.TxtID.getText());
            TxtNombre = this.Cl.TxtNombre.getText();
            TxtTelefono = Integer.parseInt(this.Cl.TxtTelefono.getText());
            TxtDireccion = this.Cl.TxtDireccion.getText();
            TxtRazon = this.Cl.TxtRazon.getText();

            McL.setTxtID(TxtID);
            if (CCl.buscar(McL)) {
                this.Cl.TxtID.setText(String.valueOf(McL.getTxtID()));
                this.Cl.TxtNombre.setText(String.valueOf(McL.getTxtNombre()));
                this.Cl.TxtTelefono.setText(String.valueOf(McL.getTxtTelefono()));
                this.Cl.TxtDireccion.setText(String.valueOf(McL.getTxtDireccion()));
                this.Cl.TxtRazon.setText(String.valueOf(McL.getTxtRazon()));
            }
        }

        if (e.getSource() == this.Cl.BtnVolverC) {
            vm.setVisible(true);
            Cl.dispose();
        }

        if (e.getSource() == this.Cl.BtnLimpiar) {
            TxtID = Integer.parseInt(this.Cl.TxtID.getText());
            TxtNombre = this.Cl.TxtNombre.getText();
            TxtTelefono = Integer.parseInt(this.Cl.TxtTelefono.getText());
            TxtDireccion = this.Cl.TxtDireccion.getText();
            TxtRazon = this.Cl.TxtRazon.getText();
            limpiar();
        }

    }

    public void limpiar() {
        this.Cl.TxtID.setText("");
        this.Cl.TxtNombre.setText("");
        this.Cl.TxtTelefono.setText("");
        this.Cl.TxtDireccion.setText("");
        this.Cl.TxtRazon.setText("");
    }
}
