package com.example.andres.mundial.Model;

/**
 * Created by Andres on 7/5/2018.
 */

public class Partidos {
    private String resultadoEquipo1;
    private String resultadoEquipo2;
    private String equipo1;
    private String equipo2;


    public Partidos(String resultadoEquipo1, String resultadoEquipo2, String equipo1, String equipo2) {
        this.resultadoEquipo1 = resultadoEquipo1;
        this.resultadoEquipo2 = resultadoEquipo2;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public String getResultadoEquipo1() {
        return resultadoEquipo1;
    }

    public void setResultadoEquipo1(String resultadoEquipo1) {
        this.resultadoEquipo1 = resultadoEquipo1;
    }

    public String getResultadoEquipo2() {
        return resultadoEquipo2;
    }

    public void setResultadoEquipo2(String resultadoEquipo2) {
        this.resultadoEquipo2 = resultadoEquipo2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
}
