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
    PantallaPartida pantallaPartida;

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
                if (torneo.lista.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay partidas creadas, Forme una partida");
                    return;
                }
                String idPartida= JOptionPane.showInputDialog(null, "Ingrese resultado", "Resultado", JOptionPane.QUESTION_MESSAGE);

                if (!comprobarCampo(idPartida)) {
                    JOptionPane.showMessageDialog(null, "Resultado no valido", "Resultado", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (!torneo.lista.buscarPartida(Integer.parseInt(idPartida))){
                    JOptionPane.showMessageDialog(null, "Partida no encontrada", "Resultado", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Partida partida = torneo.lista.obtenerPartida(Integer.parseInt(idPartida));
                PantallaPartida pantallaPartida = new PantallaPartida(partida,torneo,interfazPrincipal);
                interfazPrincipal.mostrarPantallaPartida(pantallaPartida);
            }
        });
        btnFormarPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    JOptionPane.showMessageDialog(null, "No hay partidas creadas, Resultado");
                    return;
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
