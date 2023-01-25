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

/**
 *
 * @author JAMES
 */

public class Controlador_VentaNew implements ActionListener{

    private NuevaVenta Nv;
    private CrudVenta CV;
    private Modelo_Venta MV;
    private Sistema St;
    
    public Controlador_VentaNew() {
    
    }

    Controlador_VentaNew(NuevaVenta Nv, CrudVenta CV, Modelo_Venta MV, Sistema St) {
        this.Nv = Nv;
        this.CV = CV;
        this.MV = MV;
        this.St = St;
        this.Nv.BtnVolverNV.addActionListener(this);
        this.Nv.jBttnClear.addActionListener(this);
        this.Nv.jButton8.addActionListener(this);
        //Buttons
    }

    void Iniciar() {
        this.Nv.setTitle("New Vents");
        this.Nv.setVisible(true);
        this.Nv.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.Nv.BtnVolverNV) {
            this.St.setVisible(true);
            this.Nv.dispose();
        }
    }
    
}
