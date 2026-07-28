package org.karo.eg66;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazInicial {
    private JLabel lblTitle;
    private JButton btnInscribir;
    private JPanel panelInterfaz1;
    private JButton btnRetirarJugador;
    private JButton btnRankingJugadores;
    InterfazPrincipal interfazPrincipal;


    public InterfazInicial() {
        btnRetirarJugador.setVisible(false);
        btnRankingJugadores.setVisible(false);
        btnInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazPrincipal.mostrarInscripcion();
                btnRankingJugadores.setVisible(true);
                btnRetirarJugador.setVisible(true);
            }
        });

    }

    public JPanel getPanelInterfaz1() {
        return panelInterfaz1;
    }
    public void setInterfazPrincipal(InterfazPrincipal interfazPrincipal) {
        this.interfazPrincipal = interfazPrincipal;
    }
}
