package org.karo.eg66;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inscripcion {
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JLabel lblNombre;
    private JLabel lblCedula;
    private JButton btnRegistrar;
    private JPanel panelInscripcion;
    Jugador jugador;
    TorneoEstructuras torneo;
    InterfazPrincipal interfazPrincipal;

    public Inscripcion(TorneoEstructuras torneo) {
        this.torneo = torneo;

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombre = txtNombre.getText().trim();
                String cedula = txtCedula.getText().trim();

                if (!comprobarCampo(nombre) || !comprobarCampo(cedula)) {
                    JOptionPane.showMessageDialog(null, "Error: Todos los campos son obligatorios.", "Campos vacíos", JOptionPane.WARNING_MESSAGE);
                    txtNombre.setText("");
                    txtCedula.setText("");
                    return;
                }


                if (!comprobarCedulaNumerica(cedula)) {
                    JOptionPane.showMessageDialog(null, "Error: La cedula debe contener unicamente numeros.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    txtNombre.setText("");
                    txtCedula.setText("");
                    return;
                }


                jugador = new Jugador(nombre, cedula);
                torneo.cola.enqueue(jugador);

                JOptionPane.showMessageDialog(null, "Jugador inscrito con exito en la cola");
                txtNombre.setText("");
                txtCedula.setText("");
                if (torneo.cola.hayDos()){
                    interfazPrincipal.mostrarInterfazCompleta();
                    return;
                }

                interfazPrincipal.mostrarMenuInicial();


            }
        });
    }

    public boolean comprobarCampo(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

    public boolean comprobarCedulaNumerica(String cedula) {
        return cedula.matches("\\d+");
    }

    public JPanel getPanelInscripcion() {
        return panelInscripcion;
    }
    public void setInterfazPrincipal(InterfazPrincipal interfazPrincipal) {
        this.interfazPrincipal = interfazPrincipal;
    }
}
