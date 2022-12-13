/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author Familia Marbello
 */
public class Modelos_Login {
    public String TxtUsuario;
    public String TxtContraseña;

    public Modelos_Login(String TxtUsuario, String TxtContraseña) {
        this.TxtUsuario = TxtUsuario;
        this.TxtContraseña = TxtContraseña;
    }

    public Modelos_Login() {
    }

    public String getTxtUsuario() {
        return TxtUsuario;
    }

    public void setTxtUsuario(String TxtUsuario) {
        this.TxtUsuario = TxtUsuario;
    }

    public String getTxtContraseña() {
        return TxtContraseña;
    }

    public void setTxtContraseña(String TxtContraseña) {
        this.TxtContraseña = TxtContraseña;
    }
    
}
