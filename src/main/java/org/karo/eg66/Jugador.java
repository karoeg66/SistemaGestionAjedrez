package org.karo.eg66;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private String id;
    private int puntaje;

    public Jugador(String nombre, String id){
        this.nombre = nombre;
        if(id.length() >= 8){
            this.id = id;
        }
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\n" + "Id: " + this.id + "\n" ;
    }
}
