package org.karo.eg66;

public class NodoListaDoble {
    Partida partida;
    NodoListaDoble siguiente;
    NodoListaDoble anterior;

    public NodoListaDoble(Partida partida) {
        this.partida = partida;
        this.siguiente = null;
        this.anterior = null;
    }
}
