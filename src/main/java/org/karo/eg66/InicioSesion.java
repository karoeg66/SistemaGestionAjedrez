package org.karo.eg66;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion {
    private JLabel lblTitulo;
    private JPasswordField passwordField;
    private JLabel lblContraseña;
    private JButton btnAceptar;
    private JPanel panelPantallaInicio;
    private static final String contraseña = "123";
    InterfazPrincipal interfazPrincipal;

    public InicioSesion() {
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                if (!validarContraseña(password)) {
                    JOptionPane.showMessageDialog(null,"Contraseña invalida","ERROR",JOptionPane.ERROR_MESSAGE);
                    passwordField.setText("");
                    return;
                }
                TorneoEstructuras torneo = interfazPrincipal.inscripcion.torneo;
                    if (interfazPrincipal.inscripcion.torneo.cola.huboDos() || interfazPrincipal.inscripcion.torneo.cola.hayDos() || torneo.arbol.raiz != null
                            || !torneo.lista.isEmpty()) {
                        interfazPrincipal.mostrarInterfazCompleta();
                        passwordField.setText("");
                        return;
                    }
                    interfazPrincipal.mostrarMenuInicial();
                    passwordField.setText("");
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
