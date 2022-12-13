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
    public String TxtDescripcionP;
    public int TxtCantidadP;
    public double TxtPrecioP;
    public String TxtProveedorP;

    public Modelo_Productos(int TxtCodigoP, String TxtDescripcionP, int TxtCantidadP, double TxtPrecioP, String TxtProveedorP) {
        this.TxtCodigoP = TxtCodigoP;
        this.TxtDescripcionP = TxtDescripcionP;
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

    public String getTxtDescripcionP() {
        return TxtDescripcionP;
    }

    public void setTxtDescripcionP(String TxtDescripcionP) {
        this.TxtDescripcionP = TxtDescripcionP;
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

    public String getTxtProveedorP() {
        return TxtProveedorP;
    }

    public void setTxtProveedorP(String TxtProveedorP) {
        this.TxtProveedorP = TxtProveedorP;
    }
}
