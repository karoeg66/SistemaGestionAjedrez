package org.karo.eg66;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private String id;
    private int puntaje;
    private int derrotas;

    public Jugador(String nombre, String id){
        this.nombre = nombre;
        if(id.length() >= 8){
            this.id = id;
        }else{
            throw new RuntimeException("El id debe tener al menos 8 caracteres");
        }
        this.puntaje = 0;
        this.derrotas = 0;
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

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public String toString(){
        return "\nNombre: " + this.nombre + "\n" + "Id: " + this.id + "\n" ;
    }

    public void mostrarInfo(){
        System.out.println(nombre + "-" + puntaje);
    }

}
