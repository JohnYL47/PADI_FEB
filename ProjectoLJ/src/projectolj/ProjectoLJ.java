/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectolj;

import Vista.*;
import Controladores.Controlador_Login;
import Modelos.CrudLogin;
import Modelos.Modelos_Login;
import Conexiones.Conexion;

/**
 *
 * @author Familia Marbello
 */
public class ProjectoLJ {

    public static void main(String[] args) {
        Registrar rg = new Registrar();
        CrudLogin cl = new CrudLogin();
        Modelos_Login ml = new Modelos_Login();
        Login vl = new Login();
        Conexion cn = new Conexion();
        Controlador_Login Marvel = new Controlador_Login(cl, vl, rg, ml);
        cn.getConexion();
        Marvel.iniciar();
    }
}
