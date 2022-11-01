package com.jps.taller3.models;

public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String fotodeperfil;
    private String numerodeidentificacion;
    private Double latitud;
    private Double longitud;


    public Usuario(String nombre, String apellido, String correo, String fotodeperfil, String numerodeidentificacion, Double latitud, Double longitud) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fotodeperfil = fotodeperfil;
        this.numerodeidentificacion = numerodeidentificacion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFotodeperfil() {
        return fotodeperfil;
    }

    public void setFotodeperfil(String fotodeperfil) {
        this.fotodeperfil = fotodeperfil;
    }

    public String getNumerodeidentificacion() {
        return numerodeidentificacion;
    }

    public void setNumerodeidentificacion(String numerodeidentificacion) {
        this.numerodeidentificacion = numerodeidentificacion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
}
