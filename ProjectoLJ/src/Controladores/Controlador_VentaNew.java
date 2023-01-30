/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vista.*;
import Modelos.*;
import Controladores.Controlador_Sistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAMES
 */

public class Controlador_VentaNew implements ActionListener{

    private NuevaVenta Nv;
    private CrudVenta CV;
    private Modelo_Venta MV;
    private Sistema St;
    
    private DefaultTableModel modelo = new DefaultTableModel();
    
    public Controlador_VentaNew() {
    
    }

    Controlador_VentaNew(NuevaVenta Nv, CrudVenta CV, Modelo_Venta MV, Sistema St) {
        this.Nv = Nv;
        this.CV = CV;
        this.MV = MV;
        this.St = St;
        this.Nv.BtnVolverNV.addActionListener(this);
        this.Nv.jBttnClear.addActionListener(this);
        this.Nv.btnGuardar.addActionListener(this);
        //Buttons
    }

    void Iniciar() {
        this.Nv.setTitle("New Vents");
        this.Nv.setVisible(true);
        this.Nv.setLocationRelativeTo(null);
        ListarNewvent();        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Nv.BtnVolverNV) {
            this.St.setVisible(true);
            this.Nv.dispose();
            LimpiarTable();
        }
    }
    public void ListarNewvent() {
        List<Modelo_Venta> ListarVn = CV.Listarventas();
        modelo = (DefaultTableModel) this.Nv.jTbnewVenta.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListarVn.size(); i++) {
            ob[0] = ListarVn.get(i).getTxtCodigo();
            ob[1] = ListarVn.get(i).getTxtDescripcion();
            ob[2] = ListarVn.get(i).getTxtCantidad();
            ob[3] = ListarVn.get(i).getTxtPrecio();
            ob[4] = ListarVn.get(i).getTxttotal();
            modelo.addRow(ob);
        }
        this.Nv.jTbnewVenta.setModel(modelo);

    }
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
}
