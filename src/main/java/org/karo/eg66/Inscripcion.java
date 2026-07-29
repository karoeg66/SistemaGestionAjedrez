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
                    limpiarCampos();
                    return;
                }

                if (!comprobarCedulaNumerica(cedula)) {
                    JOptionPane.showMessageDialog(null, "Error: La cédula debe contener únicamente números.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                    limpiarCampos();
                    return;
                }

                if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    JOptionPane.showMessageDialog(
                            null,
                            "El nombre solo puede contener letras.",
                            "Nombre inválido",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                if (cedula.length() < 8 || cedula.length() > 10) {
                    JOptionPane.showMessageDialog(null, "Error: La cédula debe tener entre 8 y 10 dígitos.", "Cédula inválida", JOptionPane.ERROR_MESSAGE);
                    txtCedula.setText("");
                    return;
                }


                if (torneo.arbol.search(cedula) != null) {
                    JOptionPane.showMessageDialog(null, "Error: Ya se encuentra inscrito un jugador con esa cédula.", "Cédula duplicada", JOptionPane.ERROR_MESSAGE);
                    limpiarCampos();
                    return;
                }
                if (torneo.arbol.existeNombre(nombre)) {
                    JOptionPane.showMessageDialog(null, "Error: Ya se encuentra inscrito un jugador con ese nombre.", "Nombre duplicada", JOptionPane.ERROR_MESSAGE);
                    limpiarCampos();
                    return;
                }

                Jugador nuevoJugador = new Jugador(nombre, cedula);

                torneo.cola.enqueue(nuevoJugador);
                torneo.arbol.raiz = torneo.arbol.insert(torneo.arbol.raiz, nuevoJugador);


                GestorArchivos.guardar(torneo, "torneo_completo.dat");

                JOptionPane.showMessageDialog(null, "Jugador " + nombre + " inscrito con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                interfazPrincipal.interfaz1.actualizarBotones();

                int cantidadEnCola = torneo.cola.getTamanio();
                boolean tienePartidas = (torneo.lista != null && !torneo.lista.isEmpty());

                if (cantidadEnCola >= 2 || tienePartidas) {
                    interfazPrincipal.mostrarInterfazCompleta();
                } else {
                    interfazPrincipal.mostrarMenuInicial();
                }
            }
        });
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCedula.setText("");
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