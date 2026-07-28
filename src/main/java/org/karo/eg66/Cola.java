package org.karo.eg66;


public class Cola {
    private NodoCola cabeza;
    private NodoCola cola;
    private int tamanio;

    public Cola(){
        this.cabeza = null;
        this.cola = null;
        this.tamanio = 0;
    }

    public void enqueue(Jugador jugador) {
        NodoCola nuevo = new NodoCola(jugador);
        if(isEmpty()){
            cabeza = nuevo;
            cola = nuevo;
        }
        else{
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        tamanio++;
    }

    public Jugador dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("La cola esta vacia");
        }
        Jugador aux = cabeza.getJugador();
        cabeza = cabeza.getSiguiente();
        if (isEmpty()){
            cola = null;
        }
        tamanio--;
        return aux;
    }

    public boolean isEmpty(){
        if(cabeza == null){
            return true;
        }
        return false;
    }

    public int getTamanio(){
        return tamanio;
    }

    public boolean hayDos(){
        if (getTamanio() >= 2){
            return true;
        }
        return false;
    }

}
