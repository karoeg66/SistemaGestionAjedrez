package org.karo.eg66.model;


import java.io.Serializable;

public class Cola implements Serializable {
    private NodoCola cabeza;
    private NodoCola cola;
    private int tamanio;
    int contador = 0;

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
            throw new Exception("La cola está vacía");
        }
        Jugador aux = cabeza.getJugador();
        cabeza = cabeza.getSiguiente();
        tamanio--;

        if (cabeza == null){
            cola = null;
        }

        contador++;
        return aux;
    }

    public boolean isEmpty(){
        return cabeza == null || tamanio == 0;
    }
    public int getTamanio(){
        return tamanio;
    }

    public boolean hayDos(){
        if (tamanio >= 2){
            return true;
        }
        return false;
    }

    public boolean huboDos(){
        if (contador >= 2){
            return true;
        }
        return false;
    }

    public String mostrarCola(){
        if (isEmpty()){
            return "No hay jugadores en lista de espera";
        }
        NodoCola puntero = cabeza;
        String texto = "";
        while(puntero != null){
            texto += puntero.getJugador().toString();
            puntero = puntero.getSiguiente();
        }
        return texto;
    }

    public boolean buscar(int id){
        if (isEmpty()){
            return false;
        }
        NodoCola puntero = cabeza;
        while(puntero != null){
            if (Integer.parseInt(puntero.getJugador().getId()) == id){
                return true;
            }
            puntero = puntero.getSiguiente();
        }
        return false;
    }

    public Jugador eliminarJugador(int id) {
        if (isEmpty()) {
            return null;
        }


        if (Integer.parseInt(cabeza.getJugador().getId()) == id) {
            Jugador eliminado = cabeza.getJugador();
            cabeza = cabeza.getSiguiente();


            if (cabeza == null) {
                cola = null;
            }

            tamanio--;
            return eliminado;
        }


        NodoCola puntero = cabeza;

        while (puntero.getSiguiente() != null) {

            if (Integer.parseInt(puntero.getSiguiente().getJugador().getId()) == id) {
                Jugador eliminado = puntero.getSiguiente().getJugador();

                puntero.setSiguiente(puntero.getSiguiente().getSiguiente());

                if (puntero.getSiguiente() == null) {
                    cola = puntero;
                }

                tamanio--;
                return eliminado;
            }

            puntero = puntero.getSiguiente();
        }

        return null;
    }

    public NodoCola getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoCola cabeza) {
        this.cabeza = cabeza;
    }

    public NodoCola getCola() {
        return cola;
    }

    public void setCola(NodoCola cola) {
        this.cola = cola;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}
