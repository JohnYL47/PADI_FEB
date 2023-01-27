/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia Marbello
 */
public class Modelo_Productos {
    
    public int TxtCodigoP;
    public String TxtNombreP;
    public int TxtCantidadP;
    public double TxtPrecioP;
    public int TxtProveedorP;

    public Modelo_Productos(int TxtCodigoP, String TxtNombreP, int TxtCantidadP, double TxtPrecioP, int TxtProveedorP) {
        this.TxtCodigoP = TxtCodigoP;
        this.TxtNombreP = TxtNombreP;
        this.TxtCantidadP = TxtCantidadP;
        this.TxtPrecioP = TxtPrecioP;
        this.TxtProveedorP = TxtProveedorP;
    }
    
    public Modelo_Productos(){}

    public int getTxtCodigoP() {
        return TxtCodigoP;
    }

    public void setTxtCodigoP(int TxtCodigoP) {
        this.TxtCodigoP = TxtCodigoP;
    }

    public String getTxtNombreP() {
        return TxtNombreP;
    }

    public void setTxtNombreP(String TxtNombreP) {
        this.TxtNombreP = TxtNombreP;
    }

    public int getTxtCantidadP() {
        return TxtCantidadP;
    }

    public void setTxtCantidadP(int TxtCantidadP) {
        this.TxtCantidadP = TxtCantidadP;
    }

    public double getTxtPrecioP() {
        return TxtPrecioP;
    }

    public void setTxtPrecioP(double TxtPrecioP) {
        this.TxtPrecioP = TxtPrecioP;
    }

    public int getTxtProveedorP() {
        return TxtProveedorP;
    }

    public void setTxtProveedorP(int TxtProveedorP) {
        this.TxtProveedorP = TxtProveedorP;
    }
}
