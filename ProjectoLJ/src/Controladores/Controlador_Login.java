package Controladores;

import Modelos.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_Login implements ActionListener {

    private CrudLogin cl;
    private Login vl;
    private Registrar rg;
    private Modelos_Login ml;

    private String TxtUsuario;
    private String TxtContraseña;
    private String TxtNameRg;
    private String TxtPassRg;

    public Controlador_Login(CrudLogin cl, Login vl, Registrar rg, Modelos_Login ml) {
        this.cl = cl;
        this.vl = vl;
        this.rg = rg;
        this.ml = ml;
        this.vl.BtnIniciar.addActionListener(this);
        this.vl.BtnRegistrar.addActionListener(this);
        this.rg.BtnRgIngresar.addActionListener(this);
        this.rg.BtnRgVolver.addActionListener(this);
    }

    public void iniciar() {
        this.vl.setVisible(true);
        this.vl.setTitle("Login");
        this.vl.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
     
        if (e.getSource() == this.vl.BtnIniciar) {
            this.TxtUsuario = this.vl.TxtUsuario.getText();
            this.TxtContraseña = this.vl.TxtContraseña.getText();

            if (this.TxtUsuario.isEmpty() || this.TxtContraseña.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe colocar el usuario o la contraseña");
            } else {
                ml.setTxtUsuario(TxtUsuario);
                ml.setTxtContraseña(TxtContraseña);
                cl.ingreso(ml);
                limpiar();
            }

            Sistema st = new Sistema();
            Controlador_Sistema cs = new Controlador_Sistema(st);
            cs.iniciar();
            this.vl.dispose();
        }
        
        if (e.getSource() == this.vl.BtnRegistrar) {
            this.rg.setVisible(true);
            this.rg.setLocationRelativeTo(null);
            vl.dispose();
        }

        if (e.getSource() == this.rg.BtnRgIngresar) {
            this.TxtNameRg = this.rg.TxtRegistroname.getText();
            this.TxtPassRg = this.rg.TxtRegistroPass.getText();

            if (this.TxtNameRg.isEmpty() || this.TxtPassRg.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe colocar el usuario o la contraseña");
            } else {
                ml.setTxtUsuario(TxtNameRg);
                ml.setTxtContraseña(TxtPassRg);
                cl.Registrar(ml);
                limpiar();
            }
        }
        if (e.getSource() == this.rg.BtnRgVolver) {
            this.vl.setVisible(true);
            rg.dispose();
        }
    }

    private void limpiar() {
        this.vl.TxtUsuario.setText("");
        this.vl.TxtContraseña.setText("");
        this.rg.TxtRegistroname.setText("");
        this.rg.TxtRegistroPass.setText("");
    }
}
