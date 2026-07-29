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

                    GestorArchivos.guardar(torneo, "torneo_completo.dat");


                    if (eliminado != null) {
                        JOptionPane.showMessageDialog(null,
                                "Jugador retirado con éxito del torneo:\n\n" +
                                        "Nombre: " + eliminado.getNombre() + "\n" +
                                        "ID: " + eliminado.getId(),
                                "Retiro Completado",
                                JOptionPane.INFORMATION_MESSAGE);
                        if (!torneo.cola.hayDos() && torneo.arbol.raiz == null
                                && torneo.lista == null && torneo.lista.isEmpty()) {
                            interfazPrincipal.mostrarMenuInicial();
                        }
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al retirar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
        btnRankingCompleto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ranking = torneo.arbol.mostrarRanking(torneo.arbol.raiz);
                JOptionPane.showMessageDialog(null, ranking, "Ranking de Jugadores", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnMostrarJugadoresSegunProfundidad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String arbol = torneo.arbol.levelOrder();
                JOptionPane.showMessageDialog(null, arbol, "Jugadores por nivel", JOptionPane.INFORMATION_MESSAGE);
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
