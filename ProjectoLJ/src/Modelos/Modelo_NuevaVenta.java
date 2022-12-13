/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia Marbello
 */
public class Modelo_NuevaVenta {
    public int TxtCodigo;
    public String TxtDescripcion;
    public int TxtCantidad;
    public double TxtPrecio;
    public int TxtStock;
    public String TxtNombre;
    public int TxtID;

    public Modelo_NuevaVenta(int TxtCodigo, String TxtDescripcion, int TxtCantidad, double TxtPrecio, int TxtStock, String TxtNombre, int TxtID) {
        this.TxtCodigo = TxtCodigo;
        this.TxtDescripcion = TxtDescripcion;
        this.TxtCantidad = TxtCantidad;
        this.TxtPrecio = TxtPrecio;
        this.TxtStock = TxtStock;
        this.TxtNombre = TxtNombre;
        this.TxtID = TxtID;
    }
    
    public  Modelo_NuevaVenta(){}

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
     
}
