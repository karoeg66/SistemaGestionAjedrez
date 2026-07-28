package org.karo.eg66;

import java.time.LocalDate;

public class Partida {
    int contador = 1;
    int id;
    LocalDate fecha;
    Jugador jugador1;
    Jugador jugador2;
    String resultado;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.id = contador++;
        this.fecha = LocalDate.now();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }
}
