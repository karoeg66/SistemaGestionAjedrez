package org.karo.eg66;

public class NodoColaLevelOrder {
    NodoBST valor;
    NodoColaLevelOrder siguiente;
    public NodoColaLevelOrder(NodoBST valor){
        this.valor = valor;
        this.siguiente = null;
    }
}
