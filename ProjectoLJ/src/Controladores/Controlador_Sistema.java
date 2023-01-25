 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.*;
import Vista.*;
import Controladores.*;
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
    private CrudVenta CV = new CrudVenta();
    //Modelos
    private Modelo_Venta MV = new Modelo_Venta();
    private Modelo_Productos MpD = new Modelo_Productos();
    private Modelo_Proveedor MpV = new Modelo_Proveedor();
    private Modelos_Clientes McL = new Modelos_Clientes() ;
    //--------Jframe------------//
    private Clientes Cl = new Clientes();
    private NuevaVenta Nv = new NuevaVenta();
    private Productos Pd = new Productos();
    private Proveedor Pv = new Proveedor();
    private Ventas Vn = new Ventas();
    private Sistema St = new Sistema();

    

    /*public Controlador_Sistema(Sistema st, CrudCliente CCl, CrudProductos CPd, CrudProveedor CPv, Modelos_Clientes McL, Modelo_Productos MpD, Modelo_Proveedor MpV, Modelo_NuevaVenta MnV) {
        this.CCl = CCl;
        this.CPd = CPd;
        this.CPv = CPv;
        this.McL = McL;
        this.MnV = MnV;
        this.MpD = MpD;
        this.MpV = MpV;
    }*/

    Controlador_Sistema(Sistema St) {
        this.St = St;
        this.St.BtnCliente.addActionListener(this);
        this.St.BtnNuevaVenta.addActionListener(this);
        this.St.BtnProducto.addActionListener(this);
        this.St.BtnProveedor.addActionListener(this);
        this.St.BtnVenta.addActionListener(this);
    }

    void iniciar() {
        this.St.setTitle("Principal");
        this.St.setVisible(true);
        this.St.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        /* Navegar a otros Jframe en el Panel de Inicio */
        
        if (e.getSource() ==  this.St.BtnNuevaVenta) {
            //New Venta -- Incompleto
            Controlador_VentaNew CVnew = new Controlador_VentaNew(Nv, CV, MV, St);
            CVnew.Iniciar();
            St.dispose();
        }
        if (e.getSource() == this.St.BtnCliente) {
            // Terminado.
            ControlladorCliente cc = new ControlladorCliente(Cl, CCl, McL, St);
            cc.iniciar();
            St.dispose();
        }
        if (e.getSource() == this.St.BtnProducto) {
            //Producto -- "Incompleto"
            ControladorProductos cpd = new ControladorProductos(Pd, CPd, MpD, St);
            cpd.iniciar();
            St.dispose();
        }
        if (e.getSource() == this.St.BtnProveedor) {
            //Proveedor -- No revisado
            ControladorProveedor cpv = new ControladorProveedor(Pv, CPv, MpV, St);
            cpv.iniciar();
            St.dispose();
        }
        if (e.getSource() == this.St.BtnVenta) {
            //Venta -- No revisado
            Controlador_Venta cv = new Controlador_Venta(Vn, CV, MV, St);
            cv.iniciar();
            // Falta
            this.Vn.setVisible(true);
            St.dispose();
        }
    }

}
