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
            //Desempate
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


    public boolean search(String id) {
        return searchRec(this.raiz, id);
    }

    private boolean searchRec(NodoBST nodo, String id) {
        if (nodo == null) {
            return false;
        }
        if (nodo.jugador.getId().trim().equalsIgnoreCase(id.trim())) {
            return true;
        }

        return searchRec(nodo.izquierda, id) || searchRec(nodo.derecha, id);
    }
//    public NodoBST delete(NodoBST nodo, String id){
//
//    }

}
