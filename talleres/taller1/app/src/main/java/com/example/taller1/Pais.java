package com.example.taller1;

import java.io.Serializable;

public class Pais implements Serializable {
    String capital;
    String nombre_pais;
    String nombre_pais_int;
    String sigla;

    public Pais(String capital, String nombre_pais, String nombre_pais_int, String sigla) {
        this.capital = capital;
        this.nombre_pais = nombre_pais;
        this.nombre_pais_int = nombre_pais_int;
        this.sigla = sigla;
    }

    public Pais(){

    }
    @Override
    public String toString() {
        return nombre_pais;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNombre_pais() {
        return nombre_pais;
    }

    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    public String getNombre_pais_int() {
        return nombre_pais_int;
    }

    public void setNombre_pais_int(String nombre_pais_int) {
        this.nombre_pais_int = nombre_pais_int;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
