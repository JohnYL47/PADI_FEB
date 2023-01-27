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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia Marbello
 */
public class ControlladorCliente implements ActionListener {

    private Clientes Cl;
    private CrudCliente CCl;
    private Modelos_Clientes McL;
    private Sistema vm;

    private DefaultTableModel modelo = new DefaultTableModel();

    private int TxtID;
    private String TxtNombre;
    private int TxtTelefono;
    private String TxtDireccion;

    /***
    * public ControlladorCliente (Sistema vm, int TxtID, String TxtNombre, int TxtTelefono, String TxtDireccion, String TxtRazon) {
    *    this.vm = vm;
    *    this.TxtID = TxtID;
    *    this.TxtNombre = TxtNombre;
    *    this.TxtTelefono = TxtTelefono;
    *    this.TxtDireccion = TxtDireccion;
    *    this.TxtRazon = TxtRazon;
    *}
    */
    ControlladorCliente(Clientes Cl, CrudCliente CCl, Modelos_Clientes McL, Sistema vm) {
        this.Cl = Cl;
        this.CCl = CCl;
        this.McL = McL;
        this.vm = vm;
        this.Cl.BtnGuardar.addActionListener(this);
        this.Cl.BtnActualizar.addActionListener(this);
        this.Cl.BtnBorrar.addActionListener(this);
        this.Cl.BtnMostrar.addActionListener(this);
        this.Cl.BtnVolverC.addActionListener(this);
    }

    public void iniciar() {
        this.Cl.setTitle("Clientes");
        this.Cl.setLocationRelativeTo(null);
        this.Cl.setVisible(true);
        listarCliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.Cl.BtnGuardar) {
            if (this.Cl.TxtDireccion.getText().equals("") || this.Cl.TxtID.getText().equals("") || this.Cl.TxtNombre.getText().equals("") || this.Cl.TxtTelefono.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Todo los campos son requeridos");
            } else {
                TxtID = Integer.parseInt(this.Cl.TxtID.getText());
                TxtNombre = this.Cl.TxtNombre.getText();
                TxtTelefono = Integer.parseInt(this.Cl.TxtTelefono.getText());
                TxtDireccion = this.Cl.TxtDireccion.getText();

                McL.setTxtID(TxtID);
                McL.setTxtNombre(TxtNombre);
                McL.setTxtTelefono(TxtTelefono);
                McL.setTxtDireccion(TxtDireccion);

                CCl.registrar(McL);
                LimpiarTable();
                listarCliente();
                JOptionPane.showMessageDialog(null, "Guardado");
                limpiar();
            }
        }

        if (e.getSource() == this.Cl.BtnActualizar) {
            if ("".equals(this.Cl.TxtID.getText())) {
                JOptionPane.showMessageDialog(null, "seleccione una fila");
            } else {

                if (!"".equals(this.Cl.TxtNombre.getText()) || !"".equals(this.Cl.TxtTelefono.getText())) {
                    
                    TxtID = Integer.parseInt(this.Cl.TxtID.getText());
                    TxtNombre = this.Cl.TxtNombre.getText();
                    TxtTelefono = Integer.parseInt(this.Cl.TxtTelefono.getText());
                    TxtDireccion = this.Cl.TxtDireccion.getText();                    
                    
                    McL.setTxtNombre(TxtNombre);
                    McL.setTxtTelefono(TxtTelefono);
                    McL.setTxtDireccion(TxtDireccion);
                    McL.setTxtID(TxtID);

                    CCl.actualizar(McL);

                    JOptionPane.showMessageDialog(null, "Cliente Modificado");
                    limpiar();
                    LimpiarTable();
                    listarCliente();
                } else {
                    JOptionPane.showMessageDialog(null, "Los campos estan vacios");
                }
            }
        }

        if (e.getSource() == this.Cl.BtnBorrar) {
            if (!"".equals(this.Cl.TxtID.getText())) {
                int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminarlo?");
                if (pregunta == 0) {
                    int id = Integer.parseInt(this.Cl.TxtID.getText());
                    CCl.eliminar(id);
                    LimpiarTable();
                    listarCliente();
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese los datos");
            }
        }

        if (e.getSource() == this.Cl.BtnMostrar) {
            LimpiarTable();
            listarCliente();
        }

        if (e.getSource() == this.Cl.BtnVolverC) {
            vm.setVisible(true);
            Cl.dispose();
            LimpiarTable();
        }
    }

    public void limpiar() {
        this.Cl.TxtID.setText("");
        this.Cl.TxtNombre.setText("");
        this.Cl.TxtTelefono.setText("");
        this.Cl.TxtDireccion.setText("");
    }

    public void listarCliente() {
        List<Modelos_Clientes> ListarCl = CCl.ListarCliente();
        modelo = (DefaultTableModel) this.Cl.jTableclient.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListarCl.size(); i++) {
            ob[0] = ListarCl.get(i).getTxtID();
            ob[1] = ListarCl.get(i).getTxtNombre();
            ob[2] = ListarCl.get(i).getTxtTelefono();
            ob[3] = ListarCl.get(i).getTxtDireccion();
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
