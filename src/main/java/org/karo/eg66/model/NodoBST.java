package org.karo.eg66.model;

import java.io.Serializable;

public class NodoBST implements Serializable {
    Jugador jugador;
    NodoBST izquierda;
    NodoBST derecha;

    public NodoBST(Jugador jugador){
        this.jugador = jugador;
        this.izquierda = null;
        this.derecha = null;
    }
}
