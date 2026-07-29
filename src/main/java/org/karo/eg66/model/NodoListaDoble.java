package org.karo.eg66.model;

import java.io.Serializable;

public class NodoListaDoble implements Serializable {
    Partida partida;
    NodoListaDoble siguiente;
    NodoListaDoble anterior;

    public NodoListaDoble(Partida partida) {
        this.partida = partida;
        this.siguiente = null;
        this.anterior = null;
    }
}
