package org.karo.eg66;

public class BST {
    NodoBST raiz;

    public BST(){
        this.raiz = null;
    }}
//
//    public NodoBST insert(NodoBST nodo, Jugador jugador){
//        if(nodo == null){
//            return new NodoBST(jugador);
//        }
//        if(jugador.getPuntaje() < nodo.jugador.getPuntaje()){
//            nodo.izquierda = insert(nodo.izquierda, jugador);
//        }
//        else if(jugador.getPuntaje() < nodo.jugador.getPuntaje()){
//            nodo.derecha = insert(nodo.derecha, jugador);
//        }
//        else{
//            //Desempate
//            if(jugador.getJugadasDestacadas() < nodo.jugador.getJugadasDestacadas()){
//                nodo.izquierda = insert(nodo.izquierda, jugador);
//            }
//            else{
//                nodo.derecha = insert(nodo.derecha, jugador);
//            }
//        }
//        return nodo;
//    }
//
//}
