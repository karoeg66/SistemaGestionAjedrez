package org.karo.eg66;

public class ListaDoble {
    NodoListaDoble cabeza;
    NodoListaDoble ultimo;
    int tamanio;

    public void añadirAlFinal(Partida partida) {
        NodoListaDoble nuevo = new NodoListaDoble(partida);
        if (cabeza == null) {
            cabeza = nuevo;
            ultimo = nuevo;
        }
        else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        tamanio++;
    }
}
