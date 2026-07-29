package org.karo.eg66;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Partida implements Serializable {
    static int contador = 1;
    private int id;
    private LocalDate fecha;
    private Jugador jugador1;
    private Jugador jugador2;
    private String resultado;
    private boolean isTerminada;
    transient DateTimeFormatter formateador;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.id = contador++;
        this.fecha = LocalDate.now();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.isTerminada = false;
        this.resultado = "En proceso";
    }

    public String toString() {
        return "ID: " + id + "\n Fecha: " + fecha.format(getFormateador()) + "\n Jugador1: " + jugador1.toString() + "\nJugador2: " + jugador2.toString() + "\nResultado :"+ resultado + "\n --------------------------------------" + "\n" ;
    }

    private DateTimeFormatter getFormateador() {
        if (formateador == null) {
            formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        }
        return formateador;
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

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public boolean isTerminada() {
        return isTerminada;
    }
    public void setTerminada(boolean terminada) {
        isTerminada = terminada;
    }
}
