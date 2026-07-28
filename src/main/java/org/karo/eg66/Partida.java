package org.karo.eg66;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Partida {
    int contador = 1;
    int id;
    LocalDate fecha;
    Jugador jugador1;
    Jugador jugador2;
    String resultado;
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.id = contador++;
        this.fecha = LocalDate.now();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public String toString() {
        return "Fecha: " + fecha.format(formateador) + "\n Jugador1: " + jugador1 + "\nJugador2: " + jugador2 + "\n ----------------------------------" ;
    }
}
