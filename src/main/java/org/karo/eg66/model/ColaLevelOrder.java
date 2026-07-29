package org.karo.eg66.model;

public class ColaLevelOrder {
    NodoColaLevelOrder frente;
    NodoColaLevelOrder ultimo;
    public void enqueue(NodoBST nodoArbol) {
        NodoColaLevelOrder nuevoNodo = new NodoColaLevelOrder(nodoArbol);

        if (isEmpty()) {
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
    }

    public NodoBST dequeue() {
        if (isEmpty()) {
            return null;
        }
        NodoBST resultado = frente.valor;
        frente = frente.siguiente;

        if (frente == null) {
            ultimo = null;
        }

        return resultado;
    }

    public boolean isEmpty() {
        return frente == null;
    }
}
