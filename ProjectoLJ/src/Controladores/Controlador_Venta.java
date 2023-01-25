/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.CrudVenta;
import Modelos.Modelo_Venta;
import Vista.Sistema;
import Vista.Ventas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JAMES
 */
public class Controlador_Venta implements ActionListener{

    private Ventas Vn;
    private CrudVenta CV;
    private Modelo_Venta MV;
    private Sistema St;

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.Vn.BtnVolverV) {
            this.St.setVisible(true);
            this.Vn.dispose();
        }
    }
    
}
