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

    public InterfazCompleta() {
        btnInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazPrincipal.mostrarInscripcion();
            }
        });
    }

    public void setInterfazPrincipal(InterfazPrincipal interfazPrincipal) {
        this.interfazPrincipal = interfazPrincipal;
    }

    public JPanel getPanelInterfazCompleta() {
        return panelInterfazCompleta;
    }
}
