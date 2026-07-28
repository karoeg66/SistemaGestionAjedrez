package org.karo.eg66;

public class BST {
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

    public boolean search(NodoBST nodo, String id){
        if(nodo == null) return false;
        if(id == nodo.jugador.getId()) return true;
        return search(nodo.izquierda, id) || search(nodo.derecha, id);
    }

}
