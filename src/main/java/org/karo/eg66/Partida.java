package org.karo.eg66;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Partida {
    static int contador = 1;
    private int id;
    private LocalDate fecha;
    private Jugador jugador1;
    private Jugador jugador2;
    private String resultado;
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.id = contador++;
        this.fecha = LocalDate.now();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public String toString() {
        return "ID: " + id + "\n Fecha: " + fecha.format(formateador) + "\n Jugador1: " + jugador1.toString() + "\nJugador2: " + jugador2.toString() + "\nResultado :"+ resultado + "\n ----------------------------------" ;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public String getResultado() {
        return resultado;
    }
}
