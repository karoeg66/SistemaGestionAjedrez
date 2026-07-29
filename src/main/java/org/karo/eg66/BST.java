package org.karo.eg66;

import java.io.Serializable;

public class BST implements Serializable {
    NodoBST raiz;

    public BST(){
        this.raiz = null;
    }

    public NodoBST insert(NodoBST nodo, Jugador jugador){
        if(nodo == null){
            return new NodoBST(jugador);
        }
        if(jugador.getPuntaje() < nodo.jugador.getPuntaje()){
            nodo.izquierda = insert(nodo.izquierda, jugador);
        }
        else if(jugador.getPuntaje() > nodo.jugador.getPuntaje()){
            nodo.derecha = insert(nodo.derecha, jugador);
        }
        else{
            // Desempate
            if(jugador.getDerrotas() < nodo.jugador.getDerrotas()){
                nodo.izquierda = insert(nodo.izquierda, jugador);
            }
            else if(jugador.getDerrotas() > nodo.jugador.getDerrotas()){
                nodo.derecha = insert(nodo.derecha, jugador);
            }
            else{
                if(Integer.parseInt(jugador.getId()) < Integer.parseInt(nodo.jugador.getId())){
                    nodo.izquierda = insert(nodo.izquierda, jugador);
                }
                else{
                    nodo.derecha = insert(nodo.derecha, jugador);
                }
            }
        }
        return nodo;
    }

    public Jugador search(String id) {
        return searchRec(this.raiz, id);
    }

    private Jugador searchRec(NodoBST nodo, String id) {
        if (nodo == null) {
            return null;
        }
        if (nodo.jugador.getId().trim().equalsIgnoreCase(id.trim())) {
            return nodo.jugador;
        }
        Jugador enIzquierda = searchRec(nodo.izquierda, id);
        if(enIzquierda != null){
            return enIzquierda;
        }
        return searchRec(nodo.derecha, id);
    }

    public boolean existe(String id) {
        return search(id) != null;
    }


    public Jugador delete(String id) {
        Jugador j = search(id);
        if (j != null) {
            this.raiz = deleteRec(this.raiz, j.getId(), j.getPuntaje());
            return j;
        }
        return null;
    }

    private NodoBST deleteRec(NodoBST nodo, String id, int puntaje) {
        if (nodo == null) {
            return null;
        }

        int c;
        if (puntaje != nodo.jugador.getPuntaje()) {
            c = Integer.compare(puntaje, nodo.jugador.getPuntaje());
        } else {
            c = id.trim().compareToIgnoreCase(nodo.jugador.getId().trim());
        }

        if (c < 0) {
            nodo.izquierda = deleteRec(nodo.izquierda, id, puntaje);
        } else if (c > 0) {
            nodo.derecha = deleteRec(nodo.derecha, id, puntaje);
        } else {

            if (nodo.izquierda == null) return nodo.derecha;
            if (nodo.derecha == null) return nodo.izquierda;


            NodoBST sucesor = nodo.derecha;
            while (sucesor.izquierda != null) {
                sucesor = sucesor.izquierda;
            }


            nodo.jugador = sucesor.jugador;


            nodo.derecha = deleteRec(nodo.derecha, sucesor.jugador.getId(), sucesor.jugador.getPuntaje());
        }
        return nodo;
    }
    public void preOrder(NodoBST nodo){
        nodo.jugador.mostrarInfo();
        preOrder(nodo.izquierda);
        preOrder(nodo.derecha);
    }

    public void inOrder(NodoBST nodo){
        inOrder(nodo.izquierda);
        nodo.jugador.mostrarInfo();
        inOrder(nodo.derecha);
    }

    public void postOrder(NodoBST nodo){
        postOrder(nodo.izquierda);
        postOrder(nodo.derecha);
        nodo.jugador.mostrarInfo();
    }


}
