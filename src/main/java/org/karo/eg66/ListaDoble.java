package org.karo.eg66;

import javax.swing.*;
import java.io.Serializable;

public class ListaDoble implements Serializable {
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

    public Partida eliminarPartida(int id) {
        if (isEmpty()) {
            return null;
        }
        NodoListaDoble puntero = cabeza;
        while (puntero != null) {
            if (puntero.partida.getId() == id) {
                Partida aux = puntero.partida;


                if (puntero == cabeza) {
                    cabeza = puntero.siguiente;
                    if (cabeza != null) {
                        cabeza.anterior = null;
                    } else {
                        ultimo = null;
                    }
                }

                else if (puntero == ultimo) {
                    ultimo = puntero.anterior;
                    ultimo.siguiente = null;
                }

                else {
                    puntero.anterior.siguiente = puntero.siguiente;
                    puntero.siguiente.anterior = puntero.anterior;
                }

                tamanio--;
                return aux;
            }

            puntero = puntero.siguiente;
        }

        return null;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public boolean buscarPartida(int id) {
        if (isEmpty()) {
            return false;
        }
        NodoListaDoble puntero = cabeza;
        while (puntero != null) {
            if (puntero.partida.getId() == id) {
                return true;
            }
            puntero = puntero.siguiente;
        }
        return false;
    }

    public Partida obtenerPartida(int id) {
        if (isEmpty()) {
            return null;
        }
        NodoListaDoble puntero = cabeza;
        while (puntero != null) {
            if (puntero.partida.getId() == id) {
                return puntero.partida;
            }
            puntero = puntero.siguiente;
        }
        return null;
    }

    public int obtenerMaxIdPartida() {
        int maxId = 0;
        NodoListaDoble actual = cabeza; // Ajusta 'cabeza' al nombre de tu primer nodo (ej: inicio, primero)

        while (actual != null) {
            if (actual.partida != null && actual.partida.getId() > maxId) {
                maxId = actual.partida.getId();
            }
            actual = actual.siguiente;
        }
        return maxId;
    }


    public String mostrarPartidas() {
        if (isEmpty()) {
            return "La lista esta vacia";
        }
        NodoListaDoble puntero = cabeza;
        String text = "";
        while (puntero != null) {
            text += puntero.partida.toString() ;
            puntero = puntero.siguiente;
            }
        return text;
        }
    }
