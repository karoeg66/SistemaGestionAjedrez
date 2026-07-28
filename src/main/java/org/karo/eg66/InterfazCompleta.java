package org.karo.eg66;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

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

    public InterfazCompleta(Torneo torneo) {
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
                String idPartida= JOptionPane.showInputDialog(null, "Ingrese resultado", "Resultado", JOptionPane.QUESTION_MESSAGE);

                if (!comprobarCampo(idPartida)) {
                    JOptionPane.showMessageDialog(null, "Resultado no valido", "Resultado", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if ()
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
