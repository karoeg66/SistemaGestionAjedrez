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
                    if (!torneo.lista.buscarPartida(Integer.parseInt(idPartida))) {
                        JOptionPane.showMessageDialog(null, "Partida no encontrada", "Resultado", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (torneo.lista.obtenerPartida(Integer.parseInt(idPartida)).isTerminada()) {
                        JOptionPane.showMessageDialog(null, "La partida ya tiene un resultado registrado", "Resultado", JOptionPane.WARNING_MESSAGE);
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
                    JOptionPane.showMessageDialog(null,
                            "Partida # " + partida.getId() + " creada con éxito:\n" +
                                    partida.getJugador1().getNombre() + " vs " + partida.getJugador2().getNombre(),
                            "Partida Formada", JOptionPane.INFORMATION_MESSAGE);                } catch (Exception ex) {
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
        btnRetirarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (torneo.cola.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "La lista de espera está vacía.", "Atención", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    String idJugador = JOptionPane.showInputDialog(null, "Ingrese ID de jugador", "ID", JOptionPane.QUESTION_MESSAGE);
                    if (!comprobarCampo(idJugador)) {
                        JOptionPane.showMessageDialog(null, "ID invalido", "ID", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if(!torneo.cola.buscar(Integer.parseInt(idJugador))){
                        JOptionPane.showMessageDialog(null, "Jugador no encontrado", "ERROR", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Jugador eliminado:" + torneo.cola.eliminarJugador(Integer.parseInt(idJugador)).toString());

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        btnAnularPartida.addActionListener(new ActionListener() {
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
                    if (!torneo.lista.buscarPartida(Integer.parseInt(idPartida))) {
                        JOptionPane.showMessageDialog(null, "Partida no encontrada", "Resultado", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Partida anulada: " + torneo.lista.eliminarPartida(Integer.parseInt(idPartida)).toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
                }
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
