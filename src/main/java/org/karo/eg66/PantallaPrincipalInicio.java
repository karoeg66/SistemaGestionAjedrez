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

    public PantallaPrincipalInicio(JFrame frame,Inscripcion inscripcion, Interfaz1 interfaz1) {
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                if (!validarContraseña(password)) {
                    JOptionPane.showMessageDialog(null,"Contraseña invalida","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    interfazPrincipal = new InterfazPrincipal(inscripcion,interfaz1);
                    frame.setContentPane(interfazPrincipal.getPanelInterfazPrincipal());
                    frame.revalidate();
                    frame.repaint();
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
}
