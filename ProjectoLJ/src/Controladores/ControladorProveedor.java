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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia Marbello
 */
public class ControladorProveedor implements ActionListener {

    private Proveedor V_Prov;
    private CrudProveedor C_Prov;
    private Modelo_Proveedor M_Prov;
    private Sistema Si;

    private int TxtRUT;
    private String TxtNombrePr;
    private int TxtTelefonoPr;
    private String TxtDireccionPr;

    private int Cl_RUT;
    private String Cl_Nombre;
    private int Cl_Telefono;
    private String Cl_Direccion;

    private DefaultTableModel modelo = new DefaultTableModel();

    public ControladorProveedor(Proveedor V_Prov, CrudProveedor C_Prov, Modelo_Proveedor M_Prov, Sistema Si) {
        this.V_Prov = V_Prov;
        this.C_Prov = C_Prov;
        this.M_Prov = M_Prov;
        this.Si = Si;

        this.V_Prov.BtnGuardar.addActionListener(this);
        this.V_Prov.BtnActualizar.addActionListener(this);
        this.V_Prov.BtnBorrar.addActionListener(this);
        this.V_Prov.BtnMostrar.addActionListener(this);
        this.V_Prov.BtnVolverPr.addActionListener(this);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * *
         * if (!"".equals(txtRucProveedor.getText()) ||
         * !"".equals(txtNombreproveedor.getText()) ||
         * !"".equals(txtTelefonoProveedor.getText()) ||
         * !"".equals(txtDireccionProveedor.getText())) {
         * pr.setRuc(txtRucProveedor.getText());
         * pr.setNombre(txtNombreproveedor.getText());
         * pr.setTelefono(txtTelefonoProveedor.getText());
         * pr.setDireccion(txtDireccionProveedor.getText());
         * PrDao.RegistrarProveedor(pr); JOptionPane.showMessageDialog(null,
         * "Proveedor Registrado"); LimpiarTable(); ListarProveedor();
         * LimpiarProveedor(); btnEditarProveedor.setEnabled(false);
         * btnEliminarProveedor.setEnabled(false);
         * btnguardarProveedor.setEnabled(true); } else {
         * JOptionPane.showMessageDialog(null, "Los campos esta vacios"); }
         */
        if (e.getSource() == this.V_Prov.BtnGuardar) {

            if (!"".equals(this.V_Prov.TxtRUT.getText()) || !"".equals(this.V_Prov.TxtNombrePr.getText()) || !"".equals(this.V_Prov.TxtTelefonoPr.getText()) || !"".equals(this.V_Prov.TxtDireccionPr.getText())) {

                Cl_RUT = Integer.parseInt(this.V_Prov.TxtRUT.getText());
                Cl_Nombre = this.V_Prov.TxtNombrePr.getText();
                Cl_Telefono = Integer.parseInt(this.V_Prov.TxtTelefonoPr.getText());
                Cl_Direccion = this.V_Prov.TxtDireccionPr.getText();

                M_Prov.setTxtRUT(Cl_RUT);
                M_Prov.setTxtNombrePr(Cl_Nombre);
                M_Prov.setTxtTelefonoPr(Cl_Telefono);
                M_Prov.setTxtDireccionPr(Cl_Direccion);

                C_Prov.registrar(M_Prov);
                JOptionPane.showMessageDialog(null, "Guardado");
                LimpiarTable();
                ListarProveedor();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }

        if (e.getSource() == this.V_Prov.BtnActualizar) {

            Cl_RUT = Integer.parseInt(this.V_Prov.TxtRUT.getText());
            Cl_Nombre = this.V_Prov.TxtNombrePr.getText();
            Cl_Telefono = Integer.parseInt(this.V_Prov.TxtTelefonoPr.getText());
            Cl_Direccion = this.V_Prov.TxtDireccionPr.getText();

            M_Prov.setTxtRUT(Cl_RUT);
            M_Prov.setTxtNombrePr(Cl_Nombre);
            M_Prov.setTxtTelefonoPr(Cl_Telefono);
            M_Prov.setTxtDireccionPr(Cl_Direccion);

            C_Prov.Actualizar(M_Prov);
            JOptionPane.showMessageDialog(null, "Registro Actualizado");
            LimpiarTable();
            ListarProveedor();
            limpiar();
        }

        if (e.getSource() == this.V_Prov.BtnBorrar) {

            if (!"".equals(this.V_Prov.TxtRUT.getText())) {
                int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminarlo?");
                if (pregunta == 0) {
                    int id = Integer.parseInt(this.V_Prov.TxtRUT.getText());
                    C_Prov.EliminarProveedor(id);
                    LimpiarTable();
                    ListarProveedor();
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }

        if (e.getSource() == this.V_Prov.BtnMostrar) {
            LimpiarTable();
            ListarProveedor();
        }
        if (e.getSource() == this.V_Prov.BtnVolverPr) {
            Si.setVisible(true);
            V_Prov.dispose();
            limpiar();
        }
    }

    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void ListarProveedor() {
        List<Modelo_Proveedor> ListarPr = C_Prov.ListarProveedor();
        modelo = (DefaultTableModel) this.V_Prov.jTableProveedor.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListarPr.size(); i++) {
            ob[0] = ListarPr.get(i).getTxtRUT();
            ob[1] = ListarPr.get(i).getTxtNombrePr();
            ob[2] = ListarPr.get(i).getTxtTelefonoPr();
            ob[3] = ListarPr.get(i).getTxtDireccionPr();
            modelo.addRow(ob);
        }
        this.V_Prov.jTableProveedor.setModel(modelo);

    }
}
