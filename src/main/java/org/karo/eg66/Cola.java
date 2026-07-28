package org.karo.eg66;


public class Cola {
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
            throw new Exception("La cola esta vacia");
        }
        Jugador aux = cabeza.getJugador();
        cabeza = cabeza.getSiguiente();
        if (isEmpty()){
            cola = null;
        }
        tamanio--;
        contador++;
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
                Jugador eliminado = puntero.getJugador();

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
}
