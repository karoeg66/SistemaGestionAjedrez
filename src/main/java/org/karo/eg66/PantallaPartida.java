package org.karo.eg66;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPartida {
    private JLabel lblResultadosPartida;
    private JComboBox cboxResultado;
    private JLabel lblPuntosCalidad;
    private JTextField txtPuntosJugador1;
    private JTextField txtPuntosJugador2;
    private JLabel lblJugador1;
    private JLabel lblJugador2;
    private JLabel lblGanador;
    private JButton btnAceptar;
    private JPanel panelPantallaPartida;
    private JLabel lblNombreJugador1;
    private JLabel lblNombreJugador2;
    GestionPartida gestionPartida;
    int puntajeJugador1;
    int puntajeJugador2;
    TorneoEstructuras torneo;
    InterfazPrincipal interfazPrincipal;

    public PantallaPartida(Partida partida, TorneoEstructuras torneo, InterfazPrincipal interfazPrincipal) {
        this.gestionPartida = new GestionPartida(partida);

        lblNombreJugador1.setText("Jugador 1: " + partida.getJugador1().getNombre());
        lblNombreJugador2.setText("Jugador 2: " + partida.getJugador2().getNombre());

        lblJugador1.setText(partida.getJugador1().getNombre());
        lblJugador2.setText(partida.getJugador2().getNombre());
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String textoPuntos1 = txtPuntosJugador1.getText().trim();
                String textoPuntos2 = txtPuntosJugador2.getText().trim();


                if (!comprobarNumeros(textoPuntos1) || !comprobarNumeros(textoPuntos2)) {
                    JOptionPane.showMessageDialog(null, "Error: Los puntos deben ser solo números enteros positivos.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                puntajeJugador1 = Integer.parseInt(textoPuntos1);
                puntajeJugador2 = Integer.parseInt(textoPuntos2);

                if (!comprobarCampo(cboxResultado.getSelectedItem().toString())){
                    JOptionPane.showMessageDialog(null,"Seleccione una opcion de ganador");
                    return;
                };
                obtenerResultado(cboxResultado.getSelectedItem().toString());
                obtenerPuntosJugador1(puntajeJugador1);
                obtenerPuntosJugador2(puntajeJugador2);
                gestionPartida.otorgarPuntos();
                Jugador j1 = partida.getJugador1();
                Jugador j2 = partida.getJugador2();

                torneo.arbol.delete(j1.getId());
                torneo.arbol.raiz = torneo.arbol.insert(torneo.arbol.raiz, j1);

                torneo.arbol.delete(j2.getId());
                torneo.arbol.raiz = torneo.arbol.insert(torneo.arbol.raiz, j2);

                partida.setTerminada(true);
                interfazPrincipal.mostrarInterfazCompleta();
            }
        });
    }

    public boolean comprobarNumeros(String texto) {
        if (texto == null || texto.isEmpty()) {
            return false;
        }
        return texto.matches("\\d+");
    }

    public boolean comprobarCampo(String campo) {
        return campo != null && !campo.trim().isEmpty();
    }

    public void obtenerResultado(String campo) {
        if (comprobarCampo(campo)) {
            Jugador jugador1 = gestionPartida.partida.getJugador1();
            Jugador jugador2 = gestionPartida.partida.getJugador2();

            if (campo.equals("JUGADOR 1")) {
                gestionPartida.resultadoJugador1 = Resultado.VICTORIA;
                gestionPartida.resultadoJugador2 = Resultado.DERROTA;
                jugador2.setDerrotas(jugador2.getDerrotas() + 1);

            } else if (campo.equals("JUGADOR 2")) {
                gestionPartida.resultadoJugador2 = Resultado.VICTORIA;
                gestionPartida.resultadoJugador1 = Resultado.DERROTA;
                jugador1.setDerrotas((jugador1.getDerrotas() + 1));
            } else if (campo.equals("EMPATE")) {
                gestionPartida.resultadoJugador1 = Resultado.EMPATE;
                gestionPartida.resultadoJugador2 = Resultado.EMPATE;
            }
        }
    }

    public void obtenerPuntosJugador1(int puntaje) {
        gestionPartida.partida.getJugador1().setPuntaje(gestionPartida.partida.getJugador1().getPuntaje() + puntaje);
    }

    public void obtenerPuntosJugador2(int puntaje) {
        gestionPartida.partida.getJugador2().setPuntaje(gestionPartida.partida.getJugador2().getPuntaje() + puntaje);
    }

    public JPanel getPanelPantallaPartida() {
        return  panelPantallaPartida;
    }

    public void setInterfazPrincipal(InterfazPrincipal interfazPrincipal) {
        this.interfazPrincipal = interfazPrincipal;
    }
}