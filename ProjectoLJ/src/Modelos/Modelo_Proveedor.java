/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia Marbello
 */
public class Modelo_Proveedor {
    
    public int TxtRUT;
    public String TxtNombrePr;
    public int TxtTelefonoPr;
    public String TxtDireccionPr;
    public String TxtRazonPr;

    public Modelo_Proveedor(int TxtRUT, String TxtNombrePr, int TxtTelefonoPr, String TxtDireccionPr, String TxtRazonPr) {
        this.TxtRUT = TxtRUT;
        this.TxtNombrePr = TxtNombrePr;
        this.TxtTelefonoPr = TxtTelefonoPr;
        this.TxtDireccionPr = TxtDireccionPr;
        this.TxtRazonPr = TxtRazonPr;
    }
    public Modelo_Proveedor(){} 

    public int getTxtRUT() {
        return TxtRUT;
    }

    public void setTxtRUT(int TxtRUT) {
        this.TxtRUT = TxtRUT;
    }

    public String getTxtNombrePr() {
        return TxtNombrePr;
    }

    public void setTxtNombrePr(String TxtNombrePr) {
        this.TxtNombrePr = TxtNombrePr;
    }

    public int getTxtTelefonoPr() {
        return TxtTelefonoPr;
    }

    public void setTxtTelefonoPr(int TxtTelefonoPr) {
        this.TxtTelefonoPr = TxtTelefonoPr;
    }

    public String getTxtDireccionPr() {
        return TxtDireccionPr;
    }

    public void setTxtDireccionPr(String TxtDireccionPr) {
        this.TxtDireccionPr = TxtDireccionPr;
    }

    public String getTxtRazonPr() {
        return TxtRazonPr;
    }

    public void setTxtRazonPr(String TxtRazonPr) {
        this.TxtRazonPr = TxtRazonPr;
    }
}
