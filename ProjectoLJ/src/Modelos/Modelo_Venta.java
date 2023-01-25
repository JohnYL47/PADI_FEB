/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia Marbello
 */
public class Modelo_Venta {
    public int TxtCodigo;
    public String TxtDescripcion;
    public int TxtCantidad;
    public double TxtPrecio;
    public int TxtStock;
    public String TxtNombre;
    public int TxtID;
    public String TxtCliente;
    public String TxtVendedor;
    public double Txttotal;
    public String Txtfecha;

    public Modelo_Venta(int TxtCodigo, String TxtDescripcion, int TxtCantidad, double TxtPrecio, int TxtStock, String TxtNombre, int TxtID, String TxtCliente, String TxtVendedor, int Txttotal, String Txtfecha) {
        this.TxtCodigo = TxtCodigo;
        this.TxtDescripcion = TxtDescripcion;
        this.TxtCantidad = TxtCantidad;
        this.TxtPrecio = TxtPrecio;
        this.TxtStock = TxtStock;
        this.TxtNombre = TxtNombre;
        this.TxtID = TxtID;
        this.TxtCliente = TxtCliente;
        this.TxtVendedor = TxtVendedor;
        this.Txttotal = Txttotal;
        this.Txtfecha = Txtfecha;
    }

    public Modelo_Venta() {
    }

    public int getTxtCodigo() {
        return TxtCodigo;
    }

    public void setTxtCodigo(int TxtCodigo) {
        this.TxtCodigo = TxtCodigo;
    }

    public String getTxtDescripcion() {
        return TxtDescripcion;
    }

    public void setTxtDescripcion(String TxtDescripcion) {
        this.TxtDescripcion = TxtDescripcion;
    }

    public int getTxtCantidad() {
        return TxtCantidad;
    }

    public void setTxtCantidad(int TxtCantidad) {
        this.TxtCantidad = TxtCantidad;
    }

    public double getTxtPrecio() {
        return TxtPrecio;
    }

    public void setTxtPrecio(double TxtPrecio) {
        this.TxtPrecio = TxtPrecio;
    }

    public int getTxtStock() {
        return TxtStock;
    }

    public void setTxtStock(int TxtStock) {
        this.TxtStock = TxtStock;
    }

    public String getTxtNombre() {
        return TxtNombre;
    }

    public void setTxtNombre(String TxtNombre) {
        this.TxtNombre = TxtNombre;
    }

    public int getTxtID() {
        return TxtID;
    }

    public void setTxtID(int TxtID) {
        this.TxtID = TxtID;
    }

    public String getTxtCliente() {
        return TxtCliente;
    }

    public void setTxtCliente(String TxtCliente) {
        this.TxtCliente = TxtCliente;
    }

    public String getTxtVendedor() {
        return TxtVendedor;
    }

    public void setTxtVendedor(String TxtVendedor) {
        this.TxtVendedor = TxtVendedor;
    }
    
    public double getTxttotal() {
        return Txttotal;
    }

    public void setTxttotal(double Txttotal) {
        this.Txttotal = Txttotal;
    }

    public String getTxtfecha() {
        return Txtfecha;
    }

    public void setTxtfecha(String Txtfecha) {
        this.Txtfecha = Txtfecha;
    }
}
