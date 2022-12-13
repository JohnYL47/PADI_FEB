/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Familia Marbello
 */
public class Controlador_Sistema implements ActionListener {

    //CRUDS
    private CrudCliente CCl = new CrudCliente();
    private CrudProductos CPd = new CrudProductos();
    private CrudProveedor CPv = new CrudProveedor();
    //Modelos
    private Modelo_NuevaVenta MnV = new Modelo_NuevaVenta();
    private Modelo_Productos MpD = new Modelo_Productos();
    private Modelo_Proveedor MpV = new Modelo_Proveedor();
    private Modelos_Clientes McL = new Modelos_Clientes() ;
    //--------Jframe------------//
    private Clientes Cl = new Clientes();
    private NuevaVenta Nv = new NuevaVenta();
    private Productos Pd = new Productos();
    private Proveedor Pv = new Proveedor();
    private Ventas Vn = new Ventas();
    private Sistema Si = new Sistema();

    

    /*public Controlador_Sistema(Sistema st, CrudCliente CCl, CrudProductos CPd, CrudProveedor CPv, Modelos_Clientes McL, Modelo_Productos MpD, Modelo_Proveedor MpV, Modelo_NuevaVenta MnV) {
        this.CCl = CCl;
        this.CPd = CPd;
        this.CPv = CPv;
        this.McL = McL;
        this.MnV = MnV;
        this.MpD = MpD;
        this.MpV = MpV;
    }*/

    Controlador_Sistema(Sistema st) {
        this.Si = st;
        this.Si.BtnCliente.addActionListener(this);
        this.Si.BtnNuevaVenta.addActionListener(this);
        this.Si.BtnProducto.addActionListener(this);
        this.Si.BtnProveedor.addActionListener(this);
        this.Si.BtnVenta.addActionListener(this);
    }

    void iniciar() {
        this.Si.setTitle("Principal");
        this.Si.setVisible(true);
        this.Si.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        /* Navegar a otros Jframe en el Panel de Inicio */
        
        if (e.getSource() ==  this.Si.BtnNuevaVenta) {
            //Nueva Venta - Se necesita Controlador, Crud y Modelo
            //Controlador_newVenta CnV = new #(nv);
            //CnV.Iniciar();
            this.Nv.setVisible(true);
            Si.dispose();
            //No disponible
        }
        if (e.getSource() == this.Si.BtnCliente) {
            //Cliente - Relativamente hecho
            ControlladorCliente cc = new ControlladorCliente(Cl, CCl, McL, Si);
            cc.iniciar();
            //this.Cl.setVisible(true);
            Si.dispose();
        }
        if (e.getSource() == this.Si.BtnProducto) {
            //Producto
            ControladorProductos cpd = new ControladorProductos(Pd, CPd, MpD, Si);
            cpd.iniciar();
            Si.dispose();
        }
        if (e.getSource() == this.Si.BtnProveedor) {
            //Proveedor
            ControladorProveedor cpv = new ControladorProveedor(Pv, CPv, MpV, Si);
            cpv.iniciar();
            Si.dispose();
        }
        if (e.getSource() == this.Si.BtnVenta) {
            //Venta
            // Falta
            
            Si.dispose();
        }
    }

}
