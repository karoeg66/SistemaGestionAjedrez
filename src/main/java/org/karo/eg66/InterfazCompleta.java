package org.karo.eg66;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCompleta {
    private JLabel lblTitle;
    private JButton btnFormarPartida;
    private JButton btnIngresarResultado;
    private JButton btnRetirarJugador;
    private JButton btnListaDeEspera;
    private JButton btnRankingCompleto;
    private JButton btnHistorialDePartidas;
    private JButton btnAnularPartida;
    private JButton btnMostrarJugadoresSegunProfundidad;
    private JButton btnInscribir;
    private JButton btnSalir;
    private JPanel panelInterfazCompleta;
    InterfazPrincipal interfazPrincipal;


    public InterfazCompleta(TorneoEstructuras torneo) {
        btnInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazPrincipal.mostrarInscripcion();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazPrincipal.mostrarInicioSesion();
            }
        });

        btnIngresarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (torneo.lista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay partidas creadas, Forme una partida");
                    return;
                }
                try {
                    String idPartida = JOptionPane.showInputDialog(null, "Ingrese ID de partida", "Resultado", JOptionPane.QUESTION_MESSAGE);
                    if (!comprobarCampo(idPartida)) {
                        JOptionPane.showMessageDialog(null, "Resultado no valido", "Resultado", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (torneo.lista.obtenerPartida(Integer.parseInt(idPartida)).isTerminada()) {
                        JOptionPane.showMessageDialog(null, "La partida ya tiene un resultado registrado", "Resultado", JOptionPane.WARNING_MESSAGE);
                        return;

                    }
                    if (!torneo.lista.buscarPartida(Integer.parseInt(idPartida))) {
                        JOptionPane.showMessageDialog(null, "Partida no encontrada", "Resultado", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    Partida partida = torneo.lista.obtenerPartida(Integer.parseInt(idPartida));
                    PantallaPartida pantallaPartida = new PantallaPartida(partida, torneo, interfazPrincipal);
                    interfazPrincipal.mostrarPantallaPartida(pantallaPartida);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un numero", "Formato invalido", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnFormarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!torneo.cola.hayDos()){
                    JOptionPane.showMessageDialog(null,"No hay suficientes jugadores", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                Partida partida = new Partida(torneo.cola.dequeue(),torneo.cola.dequeue());
                    torneo.lista.añadirAlFinal(partida);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Resultado", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnHistorialDePartidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(torneo.lista.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay partidas creadas", "Partidas", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                JOptionPane.showMessageDialog(null, torneo.lista.mostrarPartidas());

            }
        });
        btnListaDeEspera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,torneo.cola.mostrarCola());
            }
        });
    }

    public void setInterfazPrincipal(InterfazPrincipal interfazPrincipal) {
        this.interfazPrincipal = interfazPrincipal;
    }

    public JPanel getPanelInterfazCompleta() {
        return panelInterfazCompleta;
    }

    public boolean comprobarCampo(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

}
