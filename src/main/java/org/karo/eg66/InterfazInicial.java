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
    private JLabel lblInfo;
    InterfazPrincipal interfazPrincipal;
    TorneoEstructuras torneo;


    public InterfazInicial(TorneoEstructuras torneo) {
        this.torneo = torneo;
        actualizarBotones();
        btnInscribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazPrincipal.mostrarInscripcion();
            }
        });

        btnRetirarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (torneo.cola.isEmpty() && torneo.arbol.raiz == null) {
                    JOptionPane.showMessageDialog(null, "No hay jugadores registrados en el torneo.", "Atención", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    String idJugador = JOptionPane.showInputDialog(null, "Ingrese ID/Cédula del jugador a retirar:", "ID", JOptionPane.QUESTION_MESSAGE);

                    if (!comprobarCampo(idJugador)) {
                        JOptionPane.showMessageDialog(null, "ID inválido.", "ID", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    idJugador = idJugador.trim();


                    boolean existeEnArbol = torneo.arbol.existe(idJugador);
                    boolean existeEnCola = torneo.cola.buscar(Integer.parseInt(idJugador));

                    if (!existeEnArbol && !existeEnCola) {
                        JOptionPane.showMessageDialog(null, "Jugador no encontrado en el sistema.", "ERROR", JOptionPane.WARNING_MESSAGE);
                        return;
                    }


                    Jugador deCola = null;
                    if (existeEnCola) {
                        deCola = torneo.cola.eliminarJugador(Integer.parseInt(idJugador));
                    }


                    Jugador deArbol = null;
                    if (existeEnArbol) {
                        deArbol = torneo.arbol.delete(idJugador);
                    }


                    Jugador eliminado = (deArbol != null) ? deArbol : deCola;


                    if (eliminado != null) {
                        JOptionPane.showMessageDialog(null,
                                "Jugador retirado con éxito del torneo (eliminado del árbol y de la lista de espera):\n\n" +
                                        "Nombre: " + eliminado.getNombre() + "\n" +
                                        "ID: " + eliminado.getId(),
                                "Retiro Completado",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                   actualizarBotones();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al retirar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnRankingJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ranking = torneo.arbol.mostrarRanking();
                JOptionPane.showMessageDialog(null, ranking, "Ranking de Jugadores", JOptionPane.INFORMATION_MESSAGE);
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

    public void actualizarBotones() {
        boolean tieneJugadores = (torneo != null) && (torneo.cola.getTamanio() >= 1 || torneo.arbol.raiz != null);
        btnRetirarJugador.setVisible(tieneJugadores);
        btnRankingJugadores.setVisible(tieneJugadores);


        if (panelInterfaz1 != null) {
            panelInterfaz1.revalidate();
            panelInterfaz1.repaint();
        }
    }


}
