package org.karo.eg66;


public class NodoCola {
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
