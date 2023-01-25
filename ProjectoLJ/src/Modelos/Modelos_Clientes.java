/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia Marbello
 */
public class Modelos_Clientes {
    public int TxtID;
    public String TxtNombre;
    public int TxtTelefono;
    public String TxtDireccion;

    public Modelos_Clientes(int TxtID, String TxtNombre, int TxtTelefono, String TxtDireccion) {
        this.TxtID = TxtID;
        this.TxtNombre = TxtNombre;
        this.TxtTelefono = TxtTelefono;
        this.TxtDireccion = TxtDireccion;
    }
    
    public  Modelos_Clientes(){}

    public int getTxtID() {
        return TxtID;
    }

    public void setTxtID(int TxtID) {
        this.TxtID = TxtID;
    }

    public String getTxtNombre() {
        return TxtNombre;
    }

    public void setTxtNombre(String TxtNombre) {
        this.TxtNombre = TxtNombre;
    }

    public int getTxtTelefono() {
        return TxtTelefono;
    }

    public void setTxtTelefono(int TxtTelefono) {
        this.TxtTelefono = TxtTelefono;
    }

    public String getTxtDireccion() {
        return TxtDireccion;
    }

    public void setTxtDireccion(String TxtDireccion) {
        this.TxtDireccion = TxtDireccion;
    }
}
