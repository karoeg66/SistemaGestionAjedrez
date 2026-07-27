package org.karo.eg66;

public class NodoBST {
    Jugador jugador;
    NodoBST izquierda;
    NodoBST derecha;

    public NodoBST(Jugador jugador){
        this.jugador = jugador;
        this.izquierda = null;
        this.derecha = null;
    }
}
