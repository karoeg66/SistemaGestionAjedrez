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
    GestionPartida gestionPartida;
    int puntajeJugador1;
    int puntajeJugador2;
    Partida partida;

    public PantallaPartida(Jugador jugador1, Jugador jugador2) {
        partida = new Partida(jugador1, jugador2);
        this.gestionPartida = new GestionPartida(partida);
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

                obtenerResultado(cboxResultado.getSelectedItem().toString());
                obtenerPuntosJugador1(puntajeJugador1);
                obtenerPuntosJugador2(puntajeJugador2);
                gestionPartida.otorgarPuntos();
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
            if (campo.equals("JUGADOR 1")) {
                gestionPartida.resultadoJugador1 = Resultado.VICTORIA;
                gestionPartida.resultadoJugador2 = Resultado.DERROTA;
            } else if (campo.equals("JUGADOR 2")) {
                gestionPartida.resultadoJugador2 = Resultado.VICTORIA;
                gestionPartida.resultadoJugador1 = Resultado.DERROTA;
            } else if (campo.equals("EMPATE")) {
                gestionPartida.resultadoJugador1 = Resultado.EMPATE;
                gestionPartida.resultadoJugador2 = Resultado.EMPATE;
            }
        }
    }

    public void obtenerPuntosJugador1(int puntaje) {
        gestionPartida.partida.jugador1.setPuntaje(gestionPartida.partida.jugador1.getPuntaje() + puntaje);
    }

    public void obtenerPuntosJugador2(int puntaje) {
        gestionPartida.partida.jugador2.setPuntaje(gestionPartida.partida.jugador2.getPuntaje() + puntaje);
    }
}