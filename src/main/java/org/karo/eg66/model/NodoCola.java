package org.karo.eg66.model;


import java.io.Serializable;

public class NodoCola implements Serializable {
    private Jugador jugador;
    private NodoCola siguiente;

    public NodoCola(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }

    public Jugador getJugador() {
        return jugador;
    }
    public NodoCola getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
