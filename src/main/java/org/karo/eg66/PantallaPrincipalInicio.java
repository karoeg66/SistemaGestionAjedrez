package org.karo.eg66;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipalInicio {
    private JLabel lblTitulo;
    private JPasswordField passwordField;
    private JLabel lblContraseña;
    private JButton btnAceptar;
    private JPanel panelPantallaInicio;
    private static final String contraseña = "123";
    InterfazPrincipal interfazPrincipal;

    public PantallaPrincipalInicio() {
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                if (!validarContraseña(password)) {
                    JOptionPane.showMessageDialog(null,"Contraseña invalida","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    interfazPrincipal.mostrarMenuInicial();
                }
            }
        });
    }

    public boolean validarContraseña(String password) {
        if(comprobarCampo(password)) {
            if(password.equals(contraseña)){
                return true;
            }
        }
        return false;
    }

    public boolean comprobarCampo(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

    public JPanel getPanelPantallaInicio() {
        return panelPantallaInicio;
    }

    public void setInterfazPrincipal(InterfazPrincipal interfazPrincipal) {
        this.interfazPrincipal = interfazPrincipal;
    }
}
