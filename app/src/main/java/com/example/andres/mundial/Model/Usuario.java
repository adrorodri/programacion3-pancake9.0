package com.example.andres.mundial.Model;

/**
 * Created by Andres on 7/5/2018.
 */

public class Usuario {


    private String nombre;
    private int puntaje;
    private String id;


    public Usuario( String id, String nombre, int puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
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


}
