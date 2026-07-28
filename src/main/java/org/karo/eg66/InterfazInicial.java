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


    public InterfazInicial(TorneoEstructuras torneo) {
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
    }

    public boolean comprobarCampo(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }


    public JPanel getPanelInterfaz1() {
        return panelInterfaz1;
    }
    public void setInterfazPrincipal(InterfazPrincipal interfazPrincipal) {
        this.interfazPrincipal = interfazPrincipal;
    }
}
